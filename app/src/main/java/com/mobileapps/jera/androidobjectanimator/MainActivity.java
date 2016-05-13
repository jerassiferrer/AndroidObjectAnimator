package com.mobileapps.jera.androidobjectanimator;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAnimation (View view){

        float dest =0;
        ImageView aniView = (ImageView) findViewById(R.id.imageView1);

        switch (view.getId()){

            case R.id.btn1:
                dest =360;
                ObjectAnimator animation1 = ObjectAnimator.ofFloat(aniView,"rotation", dest );
                animation1.setDuration(3000);
                animation1.start();
                break;

            case R.id.btn2:
                dest= 100;
                ObjectAnimator animation2 = ObjectAnimator.ofFloat(aniView, "x", dest);
                animation2.setDuration(3000);
                animation2.start();
                break;

            case R.id.btn3:
                dest=0;
                ObjectAnimator animation3 = ObjectAnimator.ofFloat(aniView,"alpha",dest);
                animation3.setDuration(3000);
                animation3.start();
                break;


            case R.id.btn4:
                // fade out
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(aniView, "alpha",
                        0f);
                fadeOut.setDuration(2000);
                //move
                ObjectAnimator mover = ObjectAnimator.ofFloat(aniView,
                        "translationX", -500f, 0f);
                mover.setDuration(2000);
                // fade in
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(aniView, "alpha",
                        0f, 1f);
                fadeIn.setDuration(2000);
                // use all animations
                AnimatorSet animatorSet = new AnimatorSet();

                animatorSet.play(mover).with(fadeIn).after(fadeOut);
                animatorSet.start();
                break;


            case R.id.btn5:
                ObjectAnimator moveAnim = ObjectAnimator.ofFloat(aniView, "Y", 1000);
                moveAnim.setDuration(2000);
                moveAnim.setInterpolator(new BounceInterpolator());
                moveAnim.start();
                break;

            case R.id.btn6:
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(aniView, "scaleX", 1.0f, 2.0f)
                                .setDuration(2000),
                        ObjectAnimator.ofFloat(aniView, "scaleY", 1.0f, 2.0f)
                                .setDuration(2000),
                        ObjectAnimator.ofObject(aniView, "backgroundColor", new ArgbEvaluator(),
          /*Red*/0xFFFF8080, /*Blue*/0xFF8080FF)
                                .setDuration(2000)
                );
                set.start();
                break;


            default:
                break;
        }

    }

}
