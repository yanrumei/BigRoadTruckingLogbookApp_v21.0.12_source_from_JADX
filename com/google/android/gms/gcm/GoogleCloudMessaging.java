package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    public static int Zm = 5000000;
    public static int Zn = 6500000;
    public static int Zo = 7000000;
    static GoogleCloudMessaging f10989a;
    private static final AtomicInteger f10990f = new AtomicInteger(1);
    final Messenger f10991b = new Messenger(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ GoogleCloudMessaging f10988a;

        public void handleMessage(Message message) {
            if (message == null || !(message.obj instanceof Intent)) {
                Log.w(GoogleCloudMessaging.INSTANCE_ID_SCOPE, "Dropping invalid message");
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                this.f10988a.f10995g.add(intent);
            } else if (!this.f10988a.m17065b(intent)) {
                intent.setPackage(this.f10988a.f10992c.getPackageName());
                this.f10988a.f10992c.sendBroadcast(intent);
            }
        }
    });
    private Context f10992c;
    private PendingIntent f10993d;
    private Map<String, Handler> f10994e = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue<Intent> f10995g = new LinkedBlockingQueue();

    static String m17058a(Intent intent, String str) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private String m17059a(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return InstanceID.getInstance(this.f10992c).zzbly().zzi("", str, INSTANCE_ID_SCOPE);
    }

    private void m17061a(String str, String str2, long j, int i, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        String zzdd = zzdd(this.f10992c);
        if (zzdd == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        m17069a(intent);
        intent.setPackage(zzdd);
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        intent.putExtra("google.from", m17059a(str));
        if (zzdd.contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String zzdd2 : bundle.keySet()) {
                Object obj = bundle.get(zzdd2);
                if (obj instanceof String) {
                    String str3 = "gcm.";
                    zzdd2 = String.valueOf(zzdd2);
                    bundle2.putString(zzdd2.length() != 0 ? str3.concat(zzdd2) : new String(str3), (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            InstanceID.getInstance(this.f10992c).zzc(INSTANCE_ID_SCOPE, "upstream", bundle2);
            return;
        }
        this.f10992c.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    private String m17064b() {
        String valueOf = String.valueOf("google.rpc");
        String valueOf2 = String.valueOf(String.valueOf(f10990f.getAndIncrement()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private boolean m17065b(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.f10994e.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (f10989a == null) {
                f10989a = new GoogleCloudMessaging();
                f10989a.f10992c = context.getApplicationContext();
            }
            googleCloudMessaging = f10989a;
        }
        return googleCloudMessaging;
    }

    public static String zzdd(Context context) {
        return zzc.zzdi(context);
    }

    public static int zzde(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String zzdd = zzdd(context);
        if (zzdd != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(zzdd, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return -1;
    }

    @Deprecated
    Intent m17066a(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (zzde(this.f10992c) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzdd(this.f10992c));
            m17069a(intent);
            intent.putExtra("google.message_id", m17064b());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.f10991b);
            this.f10992c.startService(intent);
            try {
                return (Intent) this.f10995g.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    String m17067a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    synchronized void m17068a() {
        if (this.f10993d != null) {
            this.f10993d.cancel();
            this.f10993d = null;
        }
    }

    synchronized void m17069a(Intent intent) {
        if (this.f10993d == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f10993d = PendingIntent.getBroadcast(this.f10992c, 0, intent2, 0);
        }
        intent.putExtra("app", this.f10993d);
    }

    public void close() {
        f10989a = null;
        zza.f11023a = null;
        m17068a();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    @Deprecated
    public synchronized String register(String... strArr) {
        String zzdd;
        zzdd = zzdd(this.f10992c);
        if (zzdd == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String a = m17067a(strArr);
        Bundle bundle = new Bundle();
        if (zzdd.contains(".gsf")) {
            bundle.putString("legacy.sender", a);
            zzdd = InstanceID.getInstance(this.f10992c).getToken(a, INSTANCE_ID_SCOPE, bundle);
        } else {
            bundle.putString("sender", a);
            zzdd = m17058a(m17066a(bundle), "registration_id");
        }
        return zzdd;
    }

    public void send(String str, String str2, long j, Bundle bundle) {
        m17061a(str, str2, j, -1, bundle);
    }

    public void send(String str, String str2, Bundle bundle) {
        send(str, str2, -1, bundle);
    }

    @Deprecated
    public synchronized void unregister() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        InstanceID.getInstance(this.f10992c).deleteInstanceID();
    }
}
