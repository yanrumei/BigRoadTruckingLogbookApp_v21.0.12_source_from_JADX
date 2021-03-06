package com.google.android.gms.internal;

public interface zzug {

    public static final class zza extends zzapv {
        private static volatile zza[] f11773a;
        public Boolean ana;
        public Boolean anb;
        public String name;

        public zza() {
            zzbvo();
        }

        public static zza[] zzbvn() {
            if (f11773a == null) {
                synchronized (zzapt.bjF) {
                    if (f11773a == null) {
                        f11773a = new zza[0];
                    }
                }
            }
            return f11773a;
        }

        protected int mo1813a() {
            int a = super.mo1813a();
            if (this.name != null) {
                a += zzapo.zzs(1, this.name);
            }
            if (this.ana != null) {
                a += zzapo.zzk(2, this.ana.booleanValue());
            }
            return this.anb != null ? a + zzapo.zzk(3, this.anb.booleanValue()) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzug_zza = (zza) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzug_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzug_zza.name)) {
                return false;
            }
            if (this.ana == null) {
                if (com_google_android_gms_internal_zzug_zza.ana != null) {
                    return false;
                }
            } else if (!this.ana.equals(com_google_android_gms_internal_zzug_zza.ana)) {
                return false;
            }
            return this.anb == null ? com_google_android_gms_internal_zzug_zza.anb == null : this.anb.equals(com_google_android_gms_internal_zzug_zza.anb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.ana == null ? 0 : this.ana.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.anb != null) {
                i = this.anb.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo com_google_android_gms_internal_zzapo) {
            if (this.name != null) {
                com_google_android_gms_internal_zzapo.zzr(1, this.name);
            }
            if (this.ana != null) {
                com_google_android_gms_internal_zzapo.zzj(2, this.ana.booleanValue());
            }
            if (this.anb != null) {
                com_google_android_gms_internal_zzapo.zzj(3, this.anb.booleanValue());
            }
            super.zza(com_google_android_gms_internal_zzapo);
        }

        public zza zzai(zzapn com_google_android_gms_internal_zzapn) {
            while (true) {
                int ah = com_google_android_gms_internal_zzapn.ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 16:
                        this.ana = Boolean.valueOf(com_google_android_gms_internal_zzapn.an());
                        continue;
                    case 24:
                        this.anb = Boolean.valueOf(com_google_android_gms_internal_zzapn.an());
                        continue;
                    default:
                        if (!zzapy.zzb(com_google_android_gms_internal_zzapn, ah)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public /* synthetic */ zzapv zzb(zzapn com_google_android_gms_internal_zzapn) {
            return zzai(com_google_android_gms_internal_zzapn);
        }

        public zza zzbvo() {
            this.name = null;
            this.ana = null;
            this.anb = null;
            this.b = -1;
            return this;
        }
    }

    public static final class zzb extends zzapv {
        public String aic;
        public Long anc;
        public Integer and;
        public zzc[] ane;
        public zza[] anf;
        public com.google.android.gms.internal.zzuf.zza[] ang;

        public zzb() {
            zzbvp();
        }

        protected int mo1813a() {
            int i;
            int i2 = 0;
            int a = super.mo1813a();
            if (this.anc != null) {
                a += zzapo.zze(1, this.anc.longValue());
            }
            if (this.aic != null) {
                a += zzapo.zzs(2, this.aic);
            }
            if (this.and != null) {
                a += zzapo.zzag(3, this.and.intValue());
            }
            if (this.ane != null && this.ane.length > 0) {
                i = a;
                for (zzapv com_google_android_gms_internal_zzapv : this.ane) {
                    if (com_google_android_gms_internal_zzapv != null) {
                        i += zzapo.zzc(4, com_google_android_gms_internal_zzapv);
                    }
                }
                a = i;
            }
            if (this.anf != null && this.anf.length > 0) {
                i = a;
                for (zzapv com_google_android_gms_internal_zzapv2 : this.anf) {
                    if (com_google_android_gms_internal_zzapv2 != null) {
                        i += zzapo.zzc(5, com_google_android_gms_internal_zzapv2);
                    }
                }
                a = i;
            }
            if (this.ang != null && this.ang.length > 0) {
                while (i2 < this.ang.length) {
                    zzapv com_google_android_gms_internal_zzapv3 = this.ang[i2];
                    if (com_google_android_gms_internal_zzapv3 != null) {
                        a += zzapo.zzc(6, com_google_android_gms_internal_zzapv3);
                    }
                    i2++;
                }
            }
            return a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzug_zzb = (zzb) obj;
            if (this.anc == null) {
                if (com_google_android_gms_internal_zzug_zzb.anc != null) {
                    return false;
                }
            } else if (!this.anc.equals(com_google_android_gms_internal_zzug_zzb.anc)) {
                return false;
            }
            if (this.aic == null) {
                if (com_google_android_gms_internal_zzug_zzb.aic != null) {
                    return false;
                }
            } else if (!this.aic.equals(com_google_android_gms_internal_zzug_zzb.aic)) {
                return false;
            }
            if (this.and == null) {
                if (com_google_android_gms_internal_zzug_zzb.and != null) {
                    return false;
                }
            } else if (!this.and.equals(com_google_android_gms_internal_zzug_zzb.and)) {
                return false;
            }
            return !zzapt.equals(this.ane, com_google_android_gms_internal_zzug_zzb.ane) ? false : !zzapt.equals(this.anf, com_google_android_gms_internal_zzug_zzb.anf) ? false : zzapt.equals(this.ang, com_google_android_gms_internal_zzug_zzb.ang);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aic == null ? 0 : this.aic.hashCode()) + (((this.anc == null ? 0 : this.anc.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.and != null) {
                i = this.and.hashCode();
            }
            return ((((((hashCode + i) * 31) + zzapt.hashCode(this.ane)) * 31) + zzapt.hashCode(this.anf)) * 31) + zzapt.hashCode(this.ang);
        }

        public void zza(zzapo com_google_android_gms_internal_zzapo) {
            int i = 0;
            if (this.anc != null) {
                com_google_android_gms_internal_zzapo.zzb(1, this.anc.longValue());
            }
            if (this.aic != null) {
                com_google_android_gms_internal_zzapo.zzr(2, this.aic);
            }
            if (this.and != null) {
                com_google_android_gms_internal_zzapo.zzae(3, this.and.intValue());
            }
            if (this.ane != null && this.ane.length > 0) {
                for (zzapv com_google_android_gms_internal_zzapv : this.ane) {
                    if (com_google_android_gms_internal_zzapv != null) {
                        com_google_android_gms_internal_zzapo.zza(4, com_google_android_gms_internal_zzapv);
                    }
                }
            }
            if (this.anf != null && this.anf.length > 0) {
                for (zzapv com_google_android_gms_internal_zzapv2 : this.anf) {
                    if (com_google_android_gms_internal_zzapv2 != null) {
                        com_google_android_gms_internal_zzapo.zza(5, com_google_android_gms_internal_zzapv2);
                    }
                }
            }
            if (this.ang != null && this.ang.length > 0) {
                while (i < this.ang.length) {
                    zzapv com_google_android_gms_internal_zzapv3 = this.ang[i];
                    if (com_google_android_gms_internal_zzapv3 != null) {
                        com_google_android_gms_internal_zzapo.zza(6, com_google_android_gms_internal_zzapv3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzapo);
        }

        public zzb zzaj(zzapn com_google_android_gms_internal_zzapn) {
            while (true) {
                int ah = com_google_android_gms_internal_zzapn.ah();
                int zzc;
                Object obj;
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.anc = Long.valueOf(com_google_android_gms_internal_zzapn.ak());
                        continue;
                    case 18:
                        this.aic = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 24:
                        this.and = Integer.valueOf(com_google_android_gms_internal_zzapn.al());
                        continue;
                    case 34:
                        zzc = zzapy.zzc(com_google_android_gms_internal_zzapn, 34);
                        ah = this.ane == null ? 0 : this.ane.length;
                        obj = new zzc[(zzc + ah)];
                        if (ah != 0) {
                            System.arraycopy(this.ane, 0, obj, 0, ah);
                        }
                        while (ah < obj.length - 1) {
                            obj[ah] = new zzc();
                            com_google_android_gms_internal_zzapn.zza(obj[ah]);
                            com_google_android_gms_internal_zzapn.ah();
                            ah++;
                        }
                        obj[ah] = new zzc();
                        com_google_android_gms_internal_zzapn.zza(obj[ah]);
                        this.ane = obj;
                        continue;
                    case 42:
                        zzc = zzapy.zzc(com_google_android_gms_internal_zzapn, 42);
                        ah = this.anf == null ? 0 : this.anf.length;
                        obj = new zza[(zzc + ah)];
                        if (ah != 0) {
                            System.arraycopy(this.anf, 0, obj, 0, ah);
                        }
                        while (ah < obj.length - 1) {
                            obj[ah] = new zza();
                            com_google_android_gms_internal_zzapn.zza(obj[ah]);
                            com_google_android_gms_internal_zzapn.ah();
                            ah++;
                        }
                        obj[ah] = new zza();
                        com_google_android_gms_internal_zzapn.zza(obj[ah]);
                        this.anf = obj;
                        continue;
                    case 50:
                        zzc = zzapy.zzc(com_google_android_gms_internal_zzapn, 50);
                        ah = this.ang == null ? 0 : this.ang.length;
                        obj = new com.google.android.gms.internal.zzuf.zza[(zzc + ah)];
                        if (ah != 0) {
                            System.arraycopy(this.ang, 0, obj, 0, ah);
                        }
                        while (ah < obj.length - 1) {
                            obj[ah] = new com.google.android.gms.internal.zzuf.zza();
                            com_google_android_gms_internal_zzapn.zza(obj[ah]);
                            com_google_android_gms_internal_zzapn.ah();
                            ah++;
                        }
                        obj[ah] = new com.google.android.gms.internal.zzuf.zza();
                        com_google_android_gms_internal_zzapn.zza(obj[ah]);
                        this.ang = obj;
                        continue;
                    default:
                        if (!zzapy.zzb(com_google_android_gms_internal_zzapn, ah)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public /* synthetic */ zzapv zzb(zzapn com_google_android_gms_internal_zzapn) {
            return zzaj(com_google_android_gms_internal_zzapn);
        }

        public zzb zzbvp() {
            this.anc = null;
            this.aic = null;
            this.and = null;
            this.ane = zzc.zzbvq();
            this.anf = zza.zzbvn();
            this.ang = com.google.android.gms.internal.zzuf.zza.zzbvd();
            this.b = -1;
            return this;
        }
    }

    public static final class zzc extends zzapv {
        private static volatile zzc[] f11774a;
        public String value;
        public String zzcb;

        public zzc() {
            zzbvr();
        }

        public static zzc[] zzbvq() {
            if (f11774a == null) {
                synchronized (zzapt.bjF) {
                    if (f11774a == null) {
                        f11774a = new zzc[0];
                    }
                }
            }
            return f11774a;
        }

        protected int mo1813a() {
            int a = super.mo1813a();
            if (this.zzcb != null) {
                a += zzapo.zzs(1, this.zzcb);
            }
            return this.value != null ? a + zzapo.zzs(2, this.value) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzug_zzc = (zzc) obj;
            if (this.zzcb == null) {
                if (com_google_android_gms_internal_zzug_zzc.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(com_google_android_gms_internal_zzug_zzc.zzcb)) {
                return false;
            }
            return this.value == null ? com_google_android_gms_internal_zzug_zzc.value == null : this.value.equals(com_google_android_gms_internal_zzug_zzc.value);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo com_google_android_gms_internal_zzapo) {
            if (this.zzcb != null) {
                com_google_android_gms_internal_zzapo.zzr(1, this.zzcb);
            }
            if (this.value != null) {
                com_google_android_gms_internal_zzapo.zzr(2, this.value);
            }
            super.zza(com_google_android_gms_internal_zzapo);
        }

        public zzc zzak(zzapn com_google_android_gms_internal_zzapn) {
            while (true) {
                int ah = com_google_android_gms_internal_zzapn.ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 18:
                        this.value = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    default:
                        if (!zzapy.zzb(com_google_android_gms_internal_zzapn, ah)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public /* synthetic */ zzapv zzb(zzapn com_google_android_gms_internal_zzapn) {
            return zzak(com_google_android_gms_internal_zzapn);
        }

        public zzc zzbvr() {
            this.zzcb = null;
            this.value = null;
            this.b = -1;
            return this;
        }
    }
}
