package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ILocationSourceDelegate extends IInterface {

    public static abstract class zza extends Binder implements ILocationSourceDelegate {

        private static class zza implements ILocationSourceDelegate {
            private IBinder f11968a;

            zza(IBinder iBinder) {
                this.f11968a = iBinder;
            }

            public void activate(zzp com_google_android_gms_maps_internal_zzp) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    obtain.writeStrongBinder(com_google_android_gms_maps_internal_zzp != null ? com_google_android_gms_maps_internal_zzp.asBinder() : null);
                    this.f11968a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11968a;
            }

            public void deactivate() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    this.f11968a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
        }

        public static ILocationSourceDelegate zzhk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ILocationSourceDelegate)) ? new zza(iBinder) : (ILocationSourceDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    activate(com.google.android.gms.maps.internal.zzp.zza.zzhy(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    deactivate();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void activate(zzp com_google_android_gms_maps_internal_zzp);

    void deactivate();
}
