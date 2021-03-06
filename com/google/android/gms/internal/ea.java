package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.location.DetectedActivity;

public final class ea extends Drawable implements Callback {
    private boolean AO;
    private int AS;
    private long AT;
    private int AU;
    private int AV;
    private int AW;
    private int AX;
    private int AY;
    private boolean AZ;
    private C0327b Ba;
    private Drawable Bb;
    private Drawable Bc;
    private boolean Bd;
    private boolean Be;
    private boolean Bf;
    private int Bg;

    /* renamed from: com.google.android.gms.internal.ea.a */
    private static final class C0326a extends Drawable {
        private static final C0326a Bh;
        private static final C0325a Bi;

        /* renamed from: com.google.android.gms.internal.ea.a.a */
        private static final class C0325a extends ConstantState {
            private C0325a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0326a.Bh;
            }
        }

        static {
            Bh = new C0326a();
            Bi = new C0325a();
        }

        private C0326a() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return Bi;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.ea.b */
    static final class C0327b extends ConstantState {
        int Bj;
        int Bk;

        C0327b(C0327b c0327b) {
            if (c0327b != null) {
                this.Bj = c0327b.Bj;
                this.Bk = c0327b.Bk;
            }
        }

        public int getChangingConfigurations() {
            return this.Bj;
        }

        public Drawable newDrawable() {
            return new ea(this);
        }
    }

    public ea(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = C0326a.Bh;
        }
        this.Bb = drawable;
        drawable.setCallback(this);
        C0327b c0327b = this.Ba;
        c0327b.Bk |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = C0326a.Bh;
        }
        this.Bc = drawable2;
        drawable2.setCallback(this);
        c0327b = this.Ba;
        c0327b.Bk |= drawable2.getChangingConfigurations();
    }

    ea(C0327b c0327b) {
        this.AS = 0;
        this.AW = MotionEventCompat.ACTION_MASK;
        this.AY = 0;
        this.AO = true;
        this.Ba = new C0327b(c0327b);
    }

    public boolean canConstantState() {
        if (!this.Bd) {
            boolean z = (this.Bb.getConstantState() == null || this.Bc.getConstantState() == null) ? false : true;
            this.Be = z;
            this.Bd = true;
        }
        return this.Be;
    }

    public Drawable dO() {
        return this.Bc;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.AS) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                this.AT = SystemClock.uptimeMillis();
                this.AS = 2;
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                if (this.AT >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.AT)) / ((float) this.AX);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.AS = 0;
                    }
                    float min = Math.min(uptimeMillis, 1.0f);
                    this.AY = (int) ((min * ((float) (this.AV - this.AU))) + ((float) this.AU));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.AY;
        boolean z = this.AO;
        Drawable drawable = this.Bb;
        Drawable drawable2 = this.Bc;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.AW) {
                drawable2.setAlpha(this.AW);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.AW - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.AW);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.AW);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.Ba.Bj) | this.Ba.Bk;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.Ba.Bj = getChangingConfigurations();
        return this.Ba;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.Bb.getIntrinsicHeight(), this.Bc.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.Bb.getIntrinsicWidth(), this.Bc.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.Bf) {
            this.Bg = Drawable.resolveOpacity(this.Bb.getOpacity(), this.Bc.getOpacity());
            this.Bf = true;
        }
        return this.Bg;
    }

    public void invalidateDrawable(Drawable who) {
        if (fr.eJ()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.AZ && super.mutate() == this) {
            if (canConstantState()) {
                this.Bb.mutate();
                this.Bc.mutate();
                this.AZ = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.Bb.setBounds(bounds);
        this.Bc.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (fr.eJ()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.AY == this.AW) {
            this.AY = alpha;
        }
        this.AW = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.Bb.setColorFilter(cf);
        this.Bc.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.AU = 0;
        this.AV = this.AW;
        this.AY = 0;
        this.AX = durationMillis;
        this.AS = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (fr.eJ()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }
}
