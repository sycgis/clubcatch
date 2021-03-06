package com.google.android.gms.location;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.ep;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.location.b */
public class C0742b implements SafeParcelable {
    public static final C0369c CREATOR;
    int Lh;
    int Li;
    long Lj;
    private final int wj;

    static {
        CREATOR = new C0369c();
    }

    C0742b(int i, int i2, int i3, long j) {
        this.wj = i;
        this.Lh = i2;
        this.Li = i3;
        this.Lj = j;
    }

    private String bk(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "STATUS_SUCCESSFUL";
            case DetectedActivity.ON_FOOT /*2*/:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case DetectedActivity.STILL /*3*/:
                return "STATUS_NO_INFO_IN_DATABASE";
            case DetectedActivity.UNKNOWN /*4*/:
                return "STATUS_INVALID_SCAN";
            case DetectedActivity.TILTING /*5*/:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C0742b)) {
            return false;
        }
        C0742b c0742b = (C0742b) other;
        return this.Lh == c0742b.Lh && this.Li == c0742b.Li && this.Lj == c0742b.Lj;
    }

    int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return ep.hashCode(Integer.valueOf(this.Lh), Integer.valueOf(this.Li), Long.valueOf(this.Lj));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(bk(this.Lh));
        stringBuilder.append(", wifi status: ").append(bk(this.Li));
        stringBuilder.append(", elapsed realtime ns: ").append(this.Lj);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0369c.m1118a(this, parcel, flags);
    }
}
