package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class zzq<T extends zzp> extends zzc {
    zza<T> f10277a;

    public interface zza<U extends zzp> {
        U zzabb();

        void zzc(String str, int i);

        void zzg(String str, boolean z);

        void zzp(String str, String str2);

        void zzq(String str, String str2);
    }

    public zzq(zzf com_google_android_gms_analytics_internal_zzf, zza<T> com_google_android_gms_analytics_internal_zzq_zza_T) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.f10277a = com_google_android_gms_analytics_internal_zzq_zza_T;
    }

    private T m16632a(XmlResourceParser xmlResourceParser) {
        Object trim;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    Object attributeValue;
                    if (toLowerCase.equals("screenname")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            this.f10277a.zzp(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim2 == null)) {
                            this.f10277a.zzq(attributeValue, trim2);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.f10277a.zzg(attributeValue, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                zzc("Error parsing bool configuration value", trim, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.f10277a.zzc(attributeValue, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                zzc("Error parsing int configuration value", trim, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            zze("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            zze("Error parsing tracker configuration file", e4);
        }
        return this.f10277a.zzabb();
    }

    public T zzbx(int i) {
        try {
            return m16632a(zzyu().zzzi().getResources().getXml(i));
        } catch (NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
