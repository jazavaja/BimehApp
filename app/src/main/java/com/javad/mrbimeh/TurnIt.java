package com.javad.mrbimeh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.ei.Ease;
import com.daasuu.ei.EasingInterpolator;

import de.hdodenhof.circleimageview.CircleImageView;
import java.util.Random;

public class TurnIt extends AppCompatActivity {

    TextView score, totalScore;
    int num = 12;
    int deg = (360 / num);
    Integer[] degrees = new Integer[]{Integer.valueOf(this.deg),
            Integer.valueOf(this.deg * 2), Integer.valueOf(this.deg * 3),
            Integer.valueOf(this.deg * 4), Integer.valueOf(this.deg * 5),
            Integer.valueOf(this.deg * 6), Integer.valueOf(this.deg * 7),
            Integer.valueOf(this.deg * 8), Integer.valueOf(this.deg * 9),
            Integer.valueOf(this.deg * 10), Integer.valueOf(this.deg * 11)};
    int rounded;
    CircleImageView turn;
    CircleImageView turnit;

    /* renamed from: com.javad.mrbimeh.TurnIt$1 */
    class C03621 extends AnimatorListenerAdapter {

        /* renamed from: com.javad.mrbimeh.TurnIt$1$1 */
        class C03611 implements Runnable {

            /* renamed from: com.javad.mrbimeh.TurnIt$1$1$1 */
            class C03601 extends AnimatorListenerAdapter {
                C03601() {
                }

                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    TurnIt.this.turnit.setEnabled(true);
                }
            }

            C03611() {
            }

            public void run() {
                TurnIt.this.rounded = 0;
                TurnIt.this.turn.animate().rotation((float) TurnIt.this.rounded)
                        .setDuration(10).setInterpolator(new EasingInterpolator(Ease.QUAD_OUT))
                        .setListener(new C03601()).start();
            }
        }

        C03621() {
        }

        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            TurnIt.this.turnit.setEnabled(true);
            score.setText(" امتیاز: "+rounded);
            new Handler().postDelayed(new C03611(), 5000);
        }
    }

    /* renamed from: com.javad.mrbimeh.TurnIt$2 */
    class C03632 extends AnimatorListenerAdapter {
        C03632() {
        }

        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            TurnIt.this.turnit.setEnabled(true);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_turn_it);
        this.turn = (CircleImageView) findViewById(R.id.turn);
        this.turnit = (CircleImageView) findViewById(R.id.turnit);
        this.score = (TextView) findViewById(R.id.score);
        this.totalScore = (TextView) findViewById(R.id.total_score);



    }

    void random() {
        this.turnit.setEnabled(false);
        this.rounded = this.degrees[new Random().nextInt(this.num)].intValue() + 1440;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.rounded);
        stringBuilder.append("");
//        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();

        this.turn.animate().rotation((float) this.rounded).setDuration(5000).setInterpolator(new EasingInterpolator(Ease.QUAD_OUT)).setListener(new C03621()).start();
    }

    public void btn_turnit(View view) {
        if (this.rounded == 0) {
            random();
        }
    }

    public void btn_go_zero(View view) {
        this.rounded = 0;
        this.turn.animate().rotation((float) this.rounded).setDuration(10)
                .setInterpolator(new EasingInterpolator(Ease.QUAD_OUT)).
                setListener(new C03632()).start();
    }

}
