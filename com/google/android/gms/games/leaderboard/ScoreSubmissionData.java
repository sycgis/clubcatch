package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.ep.C0336a;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.gu;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] IH;
    private String Gh;
    private String IJ;
    private HashMap<Integer, Result> Jp;
    private int yJ;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return ep.m717e(this).m716a("RawScore", Long.valueOf(this.rawScore)).m716a("FormattedScore", this.formattedScore).m716a("ScoreTag", this.scoreTag).m716a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    static {
        IH = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.yJ = dataHolder.getStatusCode();
        this.Jp = new HashMap();
        int count = dataHolder.getCount();
        er.m727x(count == 3);
        for (int i = 0; i < count; i++) {
            int I = dataHolder.m1541I(i);
            if (i == 0) {
                this.IJ = dataHolder.getString("leaderboardId", i, I);
                this.Gh = dataHolder.getString("playerId", i, I);
            }
            if (dataHolder.getBoolean("hasResult", i, I)) {
                m367a(new Result(dataHolder.getLong("rawScore", i, I), dataHolder.getString("formattedScore", i, I), dataHolder.getString("scoreTag", i, I), dataHolder.getBoolean("newBest", i, I)), dataHolder.getInteger("timeSpan", i, I));
            }
        }
    }

    private void m367a(Result result, int i) {
        this.Jp.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.IJ;
    }

    public String getPlayerId() {
        return this.Gh;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.Jp.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        C0336a a = ep.m717e(this).m716a("PlayerId", this.Gh).m716a("StatusCode", Integer.valueOf(this.yJ));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.Jp.get(Integer.valueOf(i));
            a.m716a("TimesSpan", gu.aW(i));
            a.m716a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
