package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult> {
    private final Object f12887a = new Object();
    private Queue<zzf<TResult>> f12888b;
    private boolean f12889c;

    zzg() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.tasks.Task<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.f12887a;
        monitor-enter(r1);
        r0 = r2.f12888b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f12889c;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.f12889c = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.f12887a;
        monitor-enter(r1);
        r0 = r2.f12888b;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.google.android.gms.tasks.zzf) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.f12889c = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.onComplete(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzg.zza(com.google.android.gms.tasks.Task):void");
    }

    public void zza(zzf<TResult> com_google_android_gms_tasks_zzf_TResult) {
        synchronized (this.f12887a) {
            if (this.f12888b == null) {
                this.f12888b = new ArrayDeque();
            }
            this.f12888b.add(com_google_android_gms_tasks_zzf_TResult);
        }
    }
}
