package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.zzd.zza;
import java.lang.reflect.Field;

public final class zze<T> extends zza {
    private final T f10950a;

    private zze(T t) {
        this.f10950a = t;
    }

    public static <T> zzd zzac(T t) {
        return new zze(t);
    }

    public static <T> T zzad(zzd com_google_android_gms_dynamic_zzd) {
        if (com_google_android_gms_dynamic_zzd instanceof zze) {
            return ((zze) com_google_android_gms_dynamic_zzd).f10950a;
        }
        IBinder asBinder = com_google_android_gms_dynamic_zzd.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
