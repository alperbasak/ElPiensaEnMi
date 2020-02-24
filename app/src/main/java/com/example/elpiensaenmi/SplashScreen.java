package com.example.elpiensaenmi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class SplashScreen extends Activity {

    private Handler mHandler;

    private Runnable myRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Just create simple XML layout with i.e a single ImageView or a custom layout
        setContentView(R.layout.splash);
        VideoView videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.load2;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
        mHandler = new Handler();
        myRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

    }

    @Override
    public void onBackPressed() {
// Remove callback on back press
        if (mHandler != null && myRunnable != null) {
            mHandler.removeCallbacks(myRunnable);
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
// Remove callback on pause
        if (mHandler != null && myRunnable != null) {
            mHandler.removeCallbacks(myRunnable);
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
// Attach and start callback with delay on resume
        if (mHandler != null && myRunnable != null) {
            mHandler.postDelayed(myRunnable, (long) (Math.random() * 3 + 2) * 1000);
        }
        super.onResume();
    }
}
