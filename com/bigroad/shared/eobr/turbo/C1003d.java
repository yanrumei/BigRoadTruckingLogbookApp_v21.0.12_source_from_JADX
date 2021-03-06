package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.shared.eobr.turbo.logs.C1021r;
import com.bigroad.shared.eobr.turbo.logs.C1022b;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.C1026f;
import com.bigroad.shared.eobr.turbo.logs.C1027g;
import com.bigroad.shared.eobr.turbo.logs.C1028h;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.C1030j;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.C1032l;
import com.bigroad.shared.eobr.turbo.logs.C1033m;
import com.bigroad.shared.eobr.turbo.logs.C1034n;
import com.bigroad.shared.eobr.turbo.logs.C1035q;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.shared.eobr.turbo.logs.EngineHoursLogEntry;
import com.bigroad.shared.eobr.turbo.logs.LogworthyLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.PowerLogEntry;
import com.bigroad.shared.eobr.turbo.messages.C1038a;
import com.bigroad.shared.eobr.turbo.messages.C1039b;
import com.bigroad.shared.eobr.turbo.messages.C1040c;
import com.bigroad.shared.eobr.turbo.messages.C1041d;
import com.bigroad.shared.eobr.turbo.messages.C1042e;
import com.bigroad.shared.eobr.turbo.messages.C1043f;
import com.bigroad.shared.eobr.turbo.messages.C1044g;
import com.bigroad.shared.eobr.turbo.messages.C1045h;
import com.bigroad.shared.eobr.turbo.messages.C1046i;
import com.bigroad.shared.eobr.turbo.messages.C1047j;
import com.bigroad.shared.eobr.turbo.messages.C1048k;
import com.bigroad.shared.eobr.turbo.messages.C1050m;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.C1052o;
import com.bigroad.shared.eobr.turbo.messages.C1053p;
import com.bigroad.shared.eobr.turbo.messages.C1054q;
import com.bigroad.shared.eobr.turbo.messages.C1055r;
import com.bigroad.shared.eobr.turbo.messages.C1056s;
import com.bigroad.shared.eobr.turbo.messages.C1057t;
import com.bigroad.shared.eobr.turbo.messages.C1058u;
import com.bigroad.shared.eobr.turbo.messages.C1059v;
import com.bigroad.shared.eobr.turbo.messages.C1060w;
import com.bigroad.shared.eobr.turbo.messages.C1061x;
import com.bigroad.shared.eobr.turbo.messages.C1062y;
import com.bigroad.shared.eobr.turbo.messages.C1063z;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage;
import com.bigroad.shared.eobr.turbo.messages.TestLoopbackMessage;
import com.bigroad.shared.eobr.turbo.messages.TestRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.UsbStatusMessage;
import com.bigroad.shared.eobr.turbo.messages.aa;
import com.bigroad.shared.eobr.turbo.messages.ab;
import com.bigroad.shared.eobr.turbo.messages.ac;
import com.bigroad.shared.eobr.turbo.messages.ad;
import com.bigroad.shared.eobr.turbo.messages.ae;
import com.bigroad.shared.eobr.turbo.messages.af;
import com.bigroad.shared.eobr.turbo.messages.ag;
import com.bigroad.shared.eobr.turbo.messages.ah;
import com.bigroad.shared.eobr.turbo.messages.ai;
import com.bigroad.shared.eobr.turbo.messages.am;
import com.bigroad.shared.eobr.turbo.messages.an;
import java.util.HashMap;

public final class C1003d {
    private static final HashMap<Class<?>, int[]> f3142a = new HashMap();

    public static int m5135a(Class<?> cls) {
        int[] iArr = (int[]) f3142a.get(cls);
        if (iArr == null) {
            return -1;
        }
        return iArr[0];
    }

    static {
        f3142a.put(TestLoopbackMessage.class, new int[]{0, 657093978});
        f3142a.put(ai.class, new int[]{1, -518082160});
        f3142a.put(TurboResponseMessage.class, new int[]{2, -364142590});
        f3142a.put(C1039b.class, new int[]{3, 852035666});
        f3142a.put(C1040c.class, new int[]{4, -670944027});
        f3142a.put(C1055r.class, new int[]{5, 1310290893});
        f3142a.put(C1056s.class, new int[]{6, 313250567});
        f3142a.put(C1057t.class, new int[]{7, -1281907237});
        f3142a.put(aa.class, new int[]{8, -623864446});
        f3142a.put(ab.class, new int[]{9, 1823917485});
        f3142a.put(C1038a.class, new int[]{12, -250824099});
        f3142a.put(FirmwareUpdateRequestMessage.class, new int[]{13, -1547116978});
        f3142a.put(ad.class, new int[]{14, -1671588865});
        f3142a.put(C1052o.class, new int[]{15, 1923919259});
        f3142a.put(C1050m.class, new int[]{16, -310601750});
        f3142a.put(C1051n.class, new int[]{37, -610444225});
        f3142a.put(C1053p.class, new int[]{17, 454164923});
        f3142a.put(C1054q.class, new int[]{18, 2030421903});
        f3142a.put(C1042e.class, new int[]{22, 533346703});
        f3142a.put(C1058u.class, new int[]{23, 2135600105});
        f3142a.put(C1060w.class, new int[]{24, 1380906408});
        f3142a.put(UsbStatusMessage.class, new int[]{30, -2055028068});
        f3142a.put(SpeedometerMessage.class, new int[]{40, 392580201});
        f3142a.put(C1043f.class, new int[]{41, -360915162});
        f3142a.put(C1063z.class, new int[]{43, 2090632480});
        f3142a.put(C1041d.class, new int[]{45, 968579785});
        f3142a.put(am.class, new int[]{46, -1730578780});
        f3142a.put(an.class, new int[]{47, -573623646});
        f3142a.put(C1059v.class, new int[]{48, 2072131190});
        f3142a.put(C1061x.class, new int[]{49, -2013133864});
        f3142a.put(C1062y.class, new int[]{56, -441673933});
        f3142a.put(af.class, new int[]{50, -1274825095});
        f3142a.put(ag.class, new int[]{51, 2086866671});
        f3142a.put(C1045h.class, new int[]{52, -1447706033});
        f3142a.put(C1047j.class, new int[]{53, -1401039225});
        f3142a.put(C1046i.class, new int[]{54, 2042635426});
        f3142a.put(C1048k.class, new int[]{55, 1215040568});
        f3142a.put(C1044g.class, new int[]{58, -1043024521});
        f3142a.put(ac.class, new int[]{60, -789485693});
        f3142a.put(ae.class, new int[]{64, -1694145616});
        f3142a.put(TestRequestMessage.class, new int[]{66, -1616605322});
        f3142a.put(ah.class, new int[]{67, -817996641});
        f3142a.put(C1035q.class, new int[]{19, -565276184});
        f3142a.put(C1034n.class, new int[]{20, 262674293});
        f3142a.put(PowerLogEntry.class, new int[]{25, -2081163443});
        f3142a.put(C1026f.class, new int[]{26, -1606646157});
        f3142a.put(C1037t.class, new int[]{27, -1646279210});
        f3142a.put(C1020a.class, new int[]{28, -867318628});
        f3142a.put(C1033m.class, new int[]{29, 1044803660});
        f3142a.put(C1032l.class, new int[]{31, 266893576});
        f3142a.put(LogworthyLogEntry.class, new int[]{33, 797755797});
        f3142a.put(C1031k.class, new int[]{34, -191015355});
        f3142a.put(C1030j.class, new int[]{35, -2019951796});
        f3142a.put(MultiOdometerLogEntry.class, new int[]{38, 915029538});
        f3142a.put(C1036s.class, new int[]{39, 1793630682});
        f3142a.put(C1023c.class, new int[]{42, 461632022});
        f3142a.put(MobileClientSessionLogEntry.class, new int[]{44, 1703338727});
        f3142a.put(C1028h.class, new int[]{57, 1760698071});
        f3142a.put(C1025e.class, new int[]{59, 1154112229});
        f3142a.put(C1029i.class, new int[]{61, 1233164864});
        f3142a.put(C1027g.class, new int[]{62, 2101879704});
        f3142a.put(C1021r.class, new int[]{63, -253874820});
        f3142a.put(C1022b.class, new int[]{65, 929704089});
        f3142a.put(EngineHoursLogEntry.class, new int[]{68, -1143668038});
    }
}
