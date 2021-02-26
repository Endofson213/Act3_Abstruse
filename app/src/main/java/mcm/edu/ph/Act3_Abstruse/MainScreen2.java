package mcm.edu.ph.Act3_Abstruse;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainScreen2 extends AppCompatActivity {
    private Button button;
    MediaPlayer startButton;

    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.main_screen2);
        button = (Button) findViewById(R.id.btnBattle);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startButton = MediaPlayer.create(MainScreen2.this, R.raw.click);
                startButton.start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        switch (v.getId()) {
                            case R.id.btnBattle:
                                Intent Start = new Intent( MainScreen2.this, MainActivity.class);
                                startActivity(Start);
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                break;
                        }
                    }
                },600);

            }
        });

    }
}