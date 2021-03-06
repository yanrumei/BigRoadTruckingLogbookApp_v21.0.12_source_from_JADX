package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzab;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    Map<String, String> f10213a = new HashMap();

    public ProductAction(String str) {
        m16578a("&pa", str);
    }

    void m16578a(String str, String str2) {
        zzab.zzb((Object) str, (Object) "Name should be non-null");
        this.f10213a.put(str, str2);
    }

    public Map<String, String> build() {
        return new HashMap(this.f10213a);
    }

    public ProductAction setCheckoutOptions(String str) {
        m16578a("&col", str);
        return this;
    }

    public ProductAction setCheckoutStep(int i) {
        m16578a("&cos", Integer.toString(i));
        return this;
    }

    public ProductAction setProductActionList(String str) {
        m16578a("&pal", str);
        return this;
    }

    public ProductAction setProductListSource(String str) {
        m16578a("&pls", str);
        return this;
    }

    public ProductAction setTransactionAffiliation(String str) {
        m16578a("&ta", str);
        return this;
    }

    public ProductAction setTransactionCouponCode(String str) {
        m16578a("&tcc", str);
        return this;
    }

    public ProductAction setTransactionId(String str) {
        m16578a("&ti", str);
        return this;
    }

    public ProductAction setTransactionRevenue(double d) {
        m16578a("&tr", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionShipping(double d) {
        m16578a("&ts", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionTax(double d) {
        m16578a("&tt", Double.toString(d));
        return this;
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f10213a.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                hashMap.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return zzg.zzao(hashMap);
    }
}
