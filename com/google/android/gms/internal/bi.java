package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.bg.C0650a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bi<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0650a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mR;
    private final NETWORK_EXTRAS mS;

    public bi(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.mR = mediationAdapter;
        this.mS = network_extras;
    }

    private SERVER_PARAMETERS m2450a(String str, int i, String str2) throws RemoteException {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Map hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
                Map map = hashMap;
            } catch (Throwable th) {
                da.m564b("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            Object hashMap2 = new HashMap(0);
        }
        Class serverParametersType = this.mR.getServerParametersType();
        SERVER_PARAMETERS server_parameters = null;
        if (serverParametersType != null) {
            SERVER_PARAMETERS server_parameters2 = (MediationServerParameters) serverParametersType.newInstance();
            server_parameters2.load(map);
            server_parameters = server_parameters2;
        }
        if (server_parameters instanceof AdMobServerParameters) {
            AdMobServerParameters adMobServerParameters = (AdMobServerParameters) server_parameters;
            adMobServerParameters.adJson = str2;
            adMobServerParameters.tagForChildDirectedTreatment = i;
        }
        return server_parameters;
    }

    public void m2451a(C0251b c0251b, ab abVar, C0739z c0739z, String str, bh bhVar) throws RemoteException {
        m2452a(c0251b, abVar, c0739z, str, null, bhVar);
    }

    public void m2452a(C0251b c0251b, ab abVar, C0739z c0739z, String str, String str2, bh bhVar) throws RemoteException {
        if (this.mR instanceof MediationBannerAdapter) {
            da.m566s("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.mR).requestBannerAd(new bj(bhVar), (Activity) C0916c.m2414b(c0251b), m2450a(str, c0739z.tagForChildDirectedTreatment, str2), bk.m446b(abVar), bk.m447e(c0739z), this.mS);
            } catch (Throwable th) {
                da.m564b("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m570w("MediationAdapter is not a MediationBannerAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m2453a(C0251b c0251b, C0739z c0739z, String str, bh bhVar) throws RemoteException {
        m2454a(c0251b, c0739z, str, null, bhVar);
    }

    public void m2454a(C0251b c0251b, C0739z c0739z, String str, String str2, bh bhVar) throws RemoteException {
        if (this.mR instanceof MediationInterstitialAdapter) {
            da.m566s("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.mR).requestInterstitialAd(new bj(bhVar), (Activity) C0916c.m2414b(c0251b), m2450a(str, c0739z.tagForChildDirectedTreatment, str2), bk.m447e(c0739z), this.mS);
            } catch (Throwable th) {
                da.m564b("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m570w("MediationAdapter is not a MediationInterstitialAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.mR.destroy();
        } catch (Throwable th) {
            da.m564b("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0251b getView() throws RemoteException {
        if (this.mR instanceof MediationBannerAdapter) {
            try {
                return C0916c.m2415h(((MediationBannerAdapter) this.mR).getBannerView());
            } catch (Throwable th) {
                da.m564b("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m570w("MediationAdapter is not a MediationBannerAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.mR instanceof MediationInterstitialAdapter) {
            da.m566s("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.mR).showInterstitial();
            } catch (Throwable th) {
                da.m564b("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m570w("MediationAdapter is not a MediationInterstitialAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
