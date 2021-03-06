package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.internal.ih;
import com.google.android.gms.panorama.Panorama.PanoramaResult;

public class PanoramaClient implements GooglePlayServicesClient {
    private final ih QB;

    public interface OnPanoramaInfoLoadedListener {
        void onPanoramaInfoLoaded(ConnectionResult connectionResult, Intent intent);
    }

    /* renamed from: com.google.android.gms.panorama.PanoramaClient.1 */
    class C08101 implements C0194c<PanoramaResult> {
        final /* synthetic */ OnPanoramaInfoLoadedListener QC;
        final /* synthetic */ PanoramaClient QD;

        C08101(PanoramaClient panoramaClient, OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            this.QD = panoramaClient;
            this.QC = onPanoramaInfoLoadedListener;
        }

        public void m2182a(PanoramaResult panoramaResult) {
            this.QC.onPanoramaInfoLoaded(panoramaResult.getStatus().dG(), panoramaResult.getViewerIntent());
        }

        public /* synthetic */ void m2183b(Object obj) {
            m2182a((PanoramaResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.panorama.PanoramaClient.2 */
    class C08112 implements C0194c<PanoramaResult> {
        final /* synthetic */ OnPanoramaInfoLoadedListener QC;
        final /* synthetic */ PanoramaClient QD;

        C08112(PanoramaClient panoramaClient, OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            this.QD = panoramaClient;
            this.QC = onPanoramaInfoLoadedListener;
        }

        public void m2184a(PanoramaResult panoramaResult) {
            this.QC.onPanoramaInfoLoaded(panoramaResult.getStatus().dG(), panoramaResult.getViewerIntent());
        }

        public /* synthetic */ void m2185b(Object obj) {
            m2184a((PanoramaResult) obj);
        }
    }

    public PanoramaClient(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
        this.QB = new ih(context, connectionCallbacks, connectionFailedListener);
    }

    public void connect() {
        this.QB.connect();
    }

    public void disconnect() {
        this.QB.disconnect();
    }

    public boolean isConnected() {
        return this.QB.isConnected();
    }

    public boolean isConnecting() {
        return this.QB.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.QB.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.QB.isConnectionFailedListenerRegistered(listener);
    }

    public void loadPanoramaInfo(OnPanoramaInfoLoadedListener listener, Uri uri) {
        this.QB.m2734a(new C08101(this, listener), uri, false);
    }

    public void loadPanoramaInfoAndGrantAccess(OnPanoramaInfoLoadedListener listener, Uri uri) {
        this.QB.m2734a(new C08112(this, listener), uri, true);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.QB.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.QB.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.QB.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.QB.unregisterConnectionFailedListener(listener);
    }
}
