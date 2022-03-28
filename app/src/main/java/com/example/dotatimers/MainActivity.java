package com.example.dotatimers;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int counters[] = new int[5];
    public int timers[] = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton startTimer = (ImageButton) findViewById(R.id.heroImgOne);
        ImageButton startTimerTwo = (ImageButton) findViewById(R.id.heroImgTwo);
        ImageButton startTimerThree = (ImageButton) findViewById(R.id.heroImgThree);
        ImageButton startTimerFour = (ImageButton) findViewById(R.id.heroImgFour);
        ImageButton startTimerFive = (ImageButton) findViewById(R.id.heroImgFive);
        Button openList= (Button) findViewById(R.id.openListBtn);
        Button update = (Button) findViewById(R.id.updateBtn);
        TextView timerOne = (TextView) findViewById(R.id.heroOneTimer);
        TextView timerTwo = (TextView) findViewById(R.id.heroTwoTimer);
        TextView timerThree = (TextView) findViewById(R.id.heroThreeTimer);
        TextView timerFour = (TextView) findViewById(R.id.heroFourTimer);
        TextView timerFive = (TextView) findViewById(R.id.heroFiveTimer);
        TextView oneName = (TextView) findViewById(R.id.heroOneName);
        TextView twoName = (TextView) findViewById(R.id.heroTwoName);
        TextView threeName = (TextView) findViewById(R.id.heroThreeName);
        TextView fourName = (TextView) findViewById(R.id.heroFourName);
        TextView fiveName = (TextView) findViewById(R.id.heroFiveName);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = getIntent().getExtras();
                String heroes[] = b.getStringArray("heroKey");
                String hero = b.getString("heros");
                int imageIds[] = new int[5];

                int c = 0;
                while(c<5) {
                    if (hero.contains("Abaddon")) {
                        timers[c] = 40;
                        imageIds[c] = R.drawable.abaddon;
                        c++;
                    }
                    if (hero.contains("Alchemist")) {
                        timers[c] = 55;
                        imageIds[c] = R.drawable.alchemist;
                        c++;
                    }
                    if (hero.contains("Axe")) {
                        timers[c] = 70;
                        imageIds[c] = R.drawable.axe;
                        c++;
                    }
                    if (hero.contains("Beastmaster")) {
                        timers[c] = 60;
                        imageIds[c] = R.drawable.beastmaster;
                        c++;
                    }
                    if (hero.contains("Brewmaster")) {
                        timers[c] = 120;
                        imageIds[c] = R.drawable.brewmaster;
                        c++;
                    }
                    if (hero.contains("Centaur")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.centaur;
                        c++;
                    }
                    if (hero.contains("Chaos Knight")) {
                        timers[c] = 75;
                        imageIds[c] = R.drawable.chaosknight;
                        c++;
                    }
                    if (hero.contains("Clockwerk")) {
                        timers[c] = 30;
                        imageIds[c] = R.drawable.clockwerk;
                        c++;
                    }
                    if (hero.contains("Dawnbreaker")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.dawnbreaker;
                        c++;
                    }
                    if (hero.contains("Doom")) {
                        timers[c] = 145;
                        imageIds[c] = R.drawable.doom;
                        c++;
                    }
                    if (hero.contains("Dragon Knight")) {
                        timers[c] = 105;
                        imageIds[c] = R.drawable.dragonknight;
                        c++;
                    }
                    if (hero.contains("Earth Spirit")) {
                        timers[c] = 80;
                        //imageIds[c] = R.drawable.earthspirit;
                        c++;
                    }
                    if (hero.contains("Earth Shaker")) {
                        timers[c] = 110;
                        imageIds[c] = R.drawable.earthshaker;
                        c++;
                    }
                    if (hero.contains("Elder Titan")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.eldertitan;
                        c++;
                    }
                    if (hero.contains("IO")) {
                        timers[c] = 80;
                        imageIds[c] = R.drawable.io;
                        c++;
                    }
                    if (hero.contains("Kunkka")) {
                        timers[c] = 60;
                        imageIds[c] = R.drawable.kunkka;
                        c++;
                    }
                    if (hero.contains("Legion Commander")) {
                        timers[c] = 50;
                        imageIds[c] = R.drawable.legioncommander;
                        c++;
                    }
                    if (hero.contains("Lifestealer")) {
                        timers[c] = 50;
                        imageIds[c] = R.drawable.lifestealer;
                        c++;
                    }
                    if (hero.contains("Lycan")) {
                        timers[c] = 95;
                        imageIds[c] = R.drawable.lycan;
                        c++;
                    }
                    if (hero.contains("Magnus")) {
                        timers[c] = 130;
                        imageIds[c] = R.drawable.magnus;
                        c++;
                    }
                    if (hero.contains("Marci")) {
                        timers[c] = 70;
                        imageIds[c] = R.drawable.marci;
                        c++;
                    }
                    if (hero.contains("Mars")) {
                        timers[c] = 90;
                        imageIds[c] = R.drawable.mars;
                        c++;
                    }
                    if (hero.contains("Night Stalker")) {
                        timers[c] = 130;
                        imageIds[c] = R.drawable.nightstalker;
                        c++;
                    }
                    if (hero.contains("Omni Knight")) {
                        timers[c] = 120;
                        imageIds[c] = R.drawable.omniknight;
                        c++;
                    }
                    if (hero.contains("Phoenix")) {
                        timers[c] = 120;
                        imageIds[c] = R.drawable.phoenix;
                        c++;
                    }
                    if (hero.contains("Primal Beast")) {
                        timers[c] = 24;
                        imageIds[c] = R.drawable.primalbeast;
                        c++;
                    }
                    if (hero.contains("Sand King")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.sandking;
                        c++;
                    }
                    if (hero.contains("Snapfire")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.snapfire;
                        c++;
                    }
                    if (hero.contains("Spirit Breaker")) {
                        timers[c] = 50;
                        imageIds[c] = R.drawable.spiritbreaker;
                        c++;
                    }
                    if (hero.contains("Sven")) {
                        timers[c] = 110;
                        imageIds[c] = R.drawable.sven;
                        c++;
                    }
                    if (hero.contains("Tidehunter")) {
                        timers[c] = 150;
                        imageIds[c] = R.drawable.tidehunter;
                        c++;
                    }
                    if (hero.contains("Treant Protector")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.treant;
                        c++;
                    }
                    if (hero.contains("Underlord")) {
                        timers[c] = 100;
                        imageIds[c] = R.drawable.underlord;
                        c++;
                    }
                    if (hero.contains("Undying")) {
                        timers[c] = 125;
                        imageIds[c] = R.drawable.undying;
                        c++;
                    }
                    if (hero.contains("Wraith King")) {
                        timers[c] = 60;
                        imageIds[c] = R.drawable.wraithking;
                        c++;
                    }
                }
                oneName.setText(heroes[0]);
                twoName.setText(heroes[1]);
                threeName.setText(heroes[2]);
                fourName.setText(heroes[3]);
                fiveName.setText(heroes[4]);

                startTimer.setImageResource(imageIds[0]);
                startTimerTwo.setImageResource(imageIds[1]);
                startTimerThree.setImageResource(imageIds[2]);
                startTimerFour.setImageResource(imageIds[3]);
                startTimerFive.setImageResource(imageIds[4]);
            }
        });

        startTimer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counters[0] = 0;
                new CountDownTimer( timers[0]*1000, 1000){
                    public void onTick(long millisUntilFinished){
                        timerOne.setText(String.valueOf(counters[0]) + "/" + timers[0]);
                        counters[0]++;
                    }
                    public  void onFinish(){
                        timerOne.setText("COOLDOWN IS OVER");
                    }
                }.start();
            }
        });

        startTimerTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counters[1] = 0;
                new CountDownTimer( timers[1]*1000, 1000){
                    public void onTick(long millisUntilFinished){
                        timerTwo.setText(String.valueOf(counters[1]) + "/" + timers[1]);
                        counters[1]++;
                    }
                    public  void onFinish(){
                        timerTwo.setText("COOLDOWN IS OVER");
                    }
                }.start();
            }
        });

        startTimerThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counters[2] = 0;
                new CountDownTimer( timers[2]*1000, 1000){
                    public void onTick(long millisUntilFinished){
                        timerThree.setText(String.valueOf(counters[2]) + "/" + timers[2]);
                        counters[2]++;
                    }
                    public  void onFinish(){
                        timerThree.setText("COOLDOWN IS OVER");
                    }
                }.start();
            }
        });

        startTimerFour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counters[3] = 0;
                new CountDownTimer( timers[3]*1000, 1000){
                    public void onTick(long millisUntilFinished){
                        timerFour.setText(String.valueOf(counters[3]) + "/" + timers[3]);
                        counters[3]++;
                    }
                    public  void onFinish(){
                        timerFour.setText("COOLDOWN IS OVER");
                    }
                }.start();
            }
        });

        startTimerFive.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counters[4] = 0;
                new CountDownTimer( timers[4]*1000, 1000){
                    public void onTick(long millisUntilFinished){
                        timerFive.setText(String.valueOf(counters[4]) + "/" + timers[4]);
                        counters[4]++;
                    }
                    public  void onFinish(){
                        timerFive.setText("COOLDOWN IS OVER");
                    }
                }.start();
            }
        });

        openList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HeroSelection.class));
            }
        });
    }
}