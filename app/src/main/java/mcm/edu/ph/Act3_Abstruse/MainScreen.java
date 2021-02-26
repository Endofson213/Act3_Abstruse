package mcm.edu.ph.Act3_Abstruse;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainScreen extends AppCompatActivity {
    private Button button;
    MediaPlayer startButton;
    MediaPlayer bg;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.main_screen);
        button = (Button) findViewById(R.id.playButton);

        bg = MediaPlayer.create(MainScreen.this, R.raw.startmusicbg);
        bg.start();

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startButton = MediaPlayer.create(MainScreen.this, R.raw.click);
                startButton.start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        switch (v.getId()) {
                            case R.id.playButton:
                                Intent Start = new Intent(MainScreen.this, MainScreen2.class);
                                startActivity(Start);
                                break;
                        }
                    }
                }, 600);
            }
        });
    }
}