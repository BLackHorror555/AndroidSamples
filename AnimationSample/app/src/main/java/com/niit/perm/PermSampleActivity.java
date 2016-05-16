package com.niit.perm;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class PermSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button tweened = (Button) findViewById(R.id.tweenedButton);
        tweened.setOnClickListener(new OnClickListener() {
        	public void onClick(View view) {
        		startAnimation();
        	}
        });
        Button frame = (Button) findViewById(R.id.frameButton);
        frame.setOnClickListener(new OnClickListener() {
        	public void onClick(View view) {
        		startFrameAnimation();
        	}
        });
    }

    private void startAnimation() {
    	ImageView image = (ImageView) findViewById(R.id.startAnimation);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        image.startAnimation(hyperspaceJump);
    }
    private void startFrameAnimation() {
    	ImageView frameImage = (ImageView) findViewById(R.id.frameAnimation);
    	frameImage.setBackgroundResource(R.drawable.gallery);
    	AnimationDrawable frameAnimation = (AnimationDrawable) frameImage.getBackground();
    	frameAnimation.start();
    }
}