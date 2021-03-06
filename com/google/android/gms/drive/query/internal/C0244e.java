package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.e */
public class C0244e implements Creator<InFilter> {
    static void m347a(InFilter inFilter, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, inFilter.wj);
        C0212b.m234a(parcel, 1, inFilter.EP, i, false);
        C0212b.m226D(parcel, p);
    }

    public InFilter[] aK(int i) {
        return new InFilter[i];
    }

    public InFilter af(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    metadataBundle = (MetadataBundle) C0211a.m191a(parcel, n, MetadataBundle.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new InFilter(i, metadataBundle);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return af(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aK(x0);
    }
}
