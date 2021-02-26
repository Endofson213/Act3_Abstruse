package mcm.edu.ph.Act3_Abstruse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Hero Hero = new Hero("Rain", 2500, 500,400,
            1100,15,25,10);
    Monster Monstergeng = new Monster("Link", 2500,400,1000);

    int turnNumber = 2;
    private Button button;
    public SoundPool soundPool;
    public int clicksound,heroSlash,enemySlash;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(3)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        }
        clicksound = soundPool.load(this, R.raw.click,1);
        heroSlash = soundPool.load(this, R.raw.first_slash_effect,1);
        enemySlash = soundPool.load(this, R.raw.enemyslash,1);


        button = (Button) findViewById(R.id.btnBattle);
        Button nextTurn = findViewById(R.id.btnNextTurn);
        TextView txtMonsName = findViewById(R.id.txtEnemy_name);
        TextView txtHeroName = findViewById(R.id.txtPlayer_name);
        TextView txtMonsHP = findViewById(R.id.txtEnemy_hp);
        TextView txtHeroHP = findViewById(R.id.txtPlayer_hp);
        TextView txtHeroDPT = findViewById(R.id.txtPlayerDPT);
        TextView txtMonsDPT = findViewById(R.id.txtEnemyDPT);

        txtHeroName.setText(Hero.unitName);
        txtMonsName.setText(Monstergeng.unitName);

        txtHeroHP.setText(String.valueOf(Hero.baseHP));
        txtMonsHP.setText(String.valueOf(Monstergeng.baseHP));

        txtHeroDPT.setText(Hero.minDPT+ " ~ "+ Hero.maxDPT);
        txtMonsDPT.setText(Monstergeng.minDPT+ " ~ "+ Monstergeng.maxDPT);

        nextTurn.setOnClickListener(this);
    }

    public void onClick(View v){

        soundPool.play(clicksound,1,1,0,0,1);


        Random randomizer = new Random();

        Button nextTurn =       findViewById(R.id.btnNextTurn);
        TextView txtMonsHP =    findViewById(R.id.txtEnemy_hp);
        TextView txtHeroHP =    findViewById(R.id.txtPlayer_hp);
        TextView txtCombatLog = findViewById(R.id.txtTurnLog);

        txtMonsHP.setText(String.valueOf(Monstergeng.baseHP));
        txtHeroHP.setText(String.valueOf(Hero.baseHP));

        int heroDPT = randomizer.nextInt(Hero.maxDPT - Hero.minDPT) + Hero.minDPT;
        int monsDPT = randomizer.nextInt(Monstergeng.maxDPT - Monstergeng.minDPT) + Monstergeng.minDPT;

        switch (v.getId()){
            case R.id.btnNextTurn:
                if(turnNumber%2 == 1){
                    Monstergeng.baseHP = Monstergeng.baseHP - heroDPT;
                    turnNumber++;

                    soundPool.play(heroSlash,1,1,0,0,1);

                    txtCombatLog.setText(String.valueOf((Hero.unitName))+" dealt " +heroDPT+ " damage to \n \n" +
                            String.valueOf((Monstergeng.unitName))+"!");
                    txtMonsHP.setText(String.valueOf(Monstergeng.baseHP));
                    nextTurn.setText("Enemy's Turn ("+turnNumber+ ")");

                    if (Monstergeng.baseHP < 0){
                        txtCombatLog.setText(String.valueOf((Monstergeng.unitName))+" lost "+heroDPT+" HP. "+
                                "Your hero \n \n"+ String.valueOf((Hero.unitName))+"\n \n was Victorious!");
                        Hero.baseHP = 2500;
                        Monstergeng.baseHP = 2500;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                 else if(turnNumber%2 != 1){
                    Hero.baseHP = Hero.baseHP - monsDPT;
                    turnNumber++;

                    soundPool.play(enemySlash,1,1,0,0,1);

                    txtCombatLog.setText(String.valueOf((Monstergeng.unitName))+" dealt " +monsDPT+ " damage to \n \n" +
                            String.valueOf((Hero.unitName))+"!");
                    txtHeroHP.setText(String.valueOf(Hero.baseHP));
                    nextTurn.setText("Player's Turn ("+turnNumber+ ")");
                     if (Hero.baseHP < 0){
                        txtCombatLog.setText(String.valueOf((Monstergeng.unitName))+" dealt "+monsDPT+ " damage to \n \n " +
                                String.valueOf((Hero.unitName))+
                                ". \n \n" +String.valueOf((Hero.unitName))+" Died ");
                        Hero.baseHP = 2500;
                        Monstergeng.baseHP = 2500;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                        Intent Restart = new Intent (MainActivity.this, MainScreen2.class);
                        startActivity(Restart);
                    }
                }
                break;
        }
    }
}