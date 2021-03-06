package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;

public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    @LazyInit
    private transient Converter<B, A> reverse;

    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        protected C doForward(A a) {
            throw new AssertionError();
        }

        protected A doBackward(C c) {
            throw new AssertionError();
        }

        C correctedDoForward(A a) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a));
        }

        A correctedDoBackward(C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            if (this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        protected B doForward(A a) {
            return this.forwardFunction.apply(a);
        }

        protected A doBackward(B b) {
            return this.backwardFunction.apply(b);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            if (this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        protected T doForward(T t) {
            return t;
        }

        protected T doBackward(T t) {
            return t;
        }

        public IdentityConverter<T> reverse() {
            return this;
        }

        <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        public String toString() {
            return "Converter.identity()";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        protected A doForward(B b) {
            throw new AssertionError();
        }

        protected B doBackward(A a) {
            throw new AssertionError();
        }

        A correctedDoForward(B b) {
            return this.original.correctedDoBackward(b);
        }

        B correctedDoBackward(A a) {
            return this.original.correctedDoForward(a);
        }

        public Converter<A, B> reverse() {
            return this.original;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ReverseConverter)) {
                return false;
            }
            return this.original.equals(((ReverseConverter) obj).original);
        }

        public int hashCode() {
            return this.original.hashCode() ^ -1;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    protected abstract A doBackward(B b);

    protected abstract B doForward(A a);

    protected Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    @CanIgnoreReturnValue
    public final B convert(A a) {
        return correctedDoForward(a);
    }

    B correctedDoForward(A a) {
        if (this.handleNullAutomatically) {
            return a == null ? null : Preconditions.checkNotNull(doForward(a));
        } else {
            return doForward(a);
        }
    }

    A correctedDoBackward(B b) {
        if (this.handleNullAutomatically) {
            return b == null ? null : Preconditions.checkNotNull(doBackward(b));
        } else {
            return doBackward(b);
        }
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() {

            class C34811 implements Iterator<B> {
                private final Iterator<? extends A> fromIterator = iterable.iterator();

                C34811() {
                }

                public boolean hasNext() {
                    return this.fromIterator.hasNext();
                }

                public B next() {
                    return Converter.this.convert(this.fromIterator.next());
                }

                public void remove() {
                    this.fromIterator.remove();
                }
            }

            public Iterator<B> iterator() {
                return new C34811();
            }
        };
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        converter = new ReverseConverter(this);
        this.reverse = converter;
        return converter;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final B apply(A a) {
        return convert(a);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }
}
