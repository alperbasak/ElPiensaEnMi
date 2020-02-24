package com.example.elpiensaenmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    ImageView image;
    TextView textView;
    final int[] notThinkingImages = new int[5];
    final int[] thinkingImages = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        thinkingImages[0] = R.drawable.t1;
        thinkingImages[1] = R.drawable.t2;
        thinkingImages[2] = R.drawable.t3;
        thinkingImages[3] = R.drawable.t4;
        thinkingImages[4] = R.drawable.t5;

        notThinkingImages[0] = R.drawable.nt1;
        notThinkingImages[1] = R.drawable.nt2;
        notThinkingImages[2] = R.drawable.nt3;
        notThinkingImages[3] = R.drawable.nt4;
        notThinkingImages[4] = R.drawable.nt5;

        textView = findViewById(R.id.textView);
        blink(textView);

        image = findViewById(R.id.imageView1);
        clickAction();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }


    public void clickAction(){

        if(new Random().nextBoolean()){
            image.setImageResource(thinkingImages[(int)(Math.random()*5)]);
            textView.setText(R.string.thinking);
            textView.setTextSize(35);
        } else {
            image.setImageResource(notThinkingImages[(int)(Math.random()*5)]);
            textView.setText(R.string.notThinking);
        }
    }

    public void blink(View view){
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        view.startAnimation(animation1);
    }
}
