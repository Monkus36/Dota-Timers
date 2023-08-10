package com.example.dotatimers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private List<Hero> heroes = new ArrayList<>();

    private ImageButton startTimerOne;
    private ImageButton startTimerTwo;
    private ImageButton startTimerThree;
    private ImageButton startTimerFour;
    private ImageButton startTimerFive;

    private TextView timerOne;
    private TextView timerTwo;
    private TextView timerThree;
    private TextView timerFour;
    private TextView timerFive;

    //hero names
    TextView oneName;
    TextView twoName;
    TextView threeName;
    TextView fourName;
    TextView fiveName;

    private Button openList;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        startTimerOne = findViewById(R.id.heroImgOne);
        startTimerTwo = findViewById(R.id.heroImgTwo);
        startTimerThree = findViewById(R.id.heroImgThree);
        startTimerFour = findViewById(R.id.heroImgFour);
        startTimerFive = findViewById(R.id.heroImgFive);

        timerOne = findViewById(R.id.heroOneTimer);
        timerTwo = findViewById(R.id.heroTwoTimer);
        timerThree = findViewById(R.id.heroThreeTimer);
        timerFour = findViewById(R.id.heroFourTimer);
        timerFive = findViewById(R.id.heroFiveTimer);

        oneName = (TextView) findViewById(R.id.heroOneName);
        twoName = (TextView) findViewById(R.id.heroTwoName);
        threeName = (TextView) findViewById(R.id.heroThreeName);
        fourName = (TextView) findViewById(R.id.heroFourName);
        fiveName = (TextView) findViewById(R.id.heroFiveName);


        openList = findViewById(R.id.openListBtn);
        update = findViewById(R.id.updateBtn);

        // Set click listeners
        openList.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, HeroSelection.class)));

        update.setOnClickListener(view -> updateHeroData());

        startTimerOne.setOnClickListener(view -> startHeroTimer(0));
        startTimerTwo.setOnClickListener(view -> startHeroTimer(1));
        startTimerThree.setOnClickListener(view -> startHeroTimer(2));
        startTimerFour.setOnClickListener(view -> startHeroTimer(3));
        startTimerFive.setOnClickListener(view -> startHeroTimer(4));
    }

    private void updateHeroData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String[] heroNames = bundle.getStringArray("heroKey");

            if (heroNames != null) {
                heroes.clear();
                for (String heroName : heroNames) {
                    Hero hero = createHero(heroName);
                    heroes.add(hero);
                }

                displayHeroData();
                updateHeroNames(heroNames);  // Add this line
            }
        }
    }

    private void updateHeroNames(String[] heroNames) {
        if (heroNames.length > 0) oneName.setText(heroNames[0]);
        if (heroNames.length > 1) twoName.setText(heroNames[1]);
        if (heroNames.length > 2) threeName.setText(heroNames[2]);
        if (heroNames.length > 3) fourName.setText(heroNames[3]);
        if (heroNames.length > 4) fiveName.setText(heroNames[4]);
    }


    private void displayHeroData() {
        timerOne.setText(getTimerText(0));
        timerTwo.setText(getTimerText(1));
        timerThree.setText(getTimerText(2));
        timerFour.setText(getTimerText(3));
        timerFive.setText(getTimerText(4));

        startTimerOne.setImageResource(getHeroImageId(0));
        startTimerTwo.setImageResource(getHeroImageId(1));
        startTimerThree.setImageResource(getHeroImageId(2));
        startTimerFour.setImageResource(getHeroImageId(3));
        startTimerFive.setImageResource(getHeroImageId(4));
    }

    private void startHeroTimer(int index) {
        Hero hero = heroes.get(index);

        new CountDownTimer(hero.getTimer() * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                hero.incrementCounter();
                updateTimerText(index);
            }

            public void onFinish() {
                updateTimerText(index);
                setCooldownOverText(index);
            }
        }.start();
    }

    private void setCooldownOverText(int index) {
        switch (index) {
            case 0:
                timerOne.setText("COOLDOWN IS OVER");
                break;
            case 1:
                timerTwo.setText("COOLDOWN IS OVER");
                break;
            case 2:
                timerThree.setText("COOLDOWN IS OVER");
                break;
            case 3:
                timerFour.setText("COOLDOWN IS OVER");
                break;
            case 4:
                timerFive.setText("COOLDOWN IS OVER");
                break;
        }
        playSound();
    }

    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.expiredtimer);
        mediaPlayer.setOnCompletionListener(mp -> mp.release()); // Release media player resources after sound is played
        mediaPlayer.start();
    }

    private String getTimerText(int index) {
        Hero hero = heroes.get(index);
        return hero.getCounter() + "/" + hero.getTimer();
    }

    private void updateTimerText(int index) {
        String timerText = getTimerText(index);
        switch (index) {
            case 0:
                timerOne.setText(timerText);
                break;
            case 1:
                timerTwo.setText(timerText);
                break;
            case 2:
                timerThree.setText(timerText);
                break;
            case 3:
                timerFour.setText(timerText);
                break;
            case 4:
                timerFive.setText(timerText);
                break;
        }
    }

    private int getHeroImageId(int index) {
        Hero hero = heroes.get(index);
        return hero.getImageId();
    }

    private Hero createHero(String heroName) {
        int timer = 0;
        int imageId = R.drawable.colored;

        switch (heroName) {
            case "Abaddon":
                timer = 40;
                imageId = R.drawable.abaddon;
                break;
            case "Alchemist":
                timer = 55;
                imageId = R.drawable.alchemist;
                break;
            case "Axe":
                timer = 70;
                imageId = R.drawable.axe;
                break;
            case "Beastmaster":
                timer = 60;
                imageId = R.drawable.beastmaster;
                break;
            case "Brewmaster":
                timer = 120;
                imageId = R.drawable.brewmaster;
                break;
            case "Centaur":
                timer = 100;
                imageId = R.drawable.centaur;
                break;
            case "Chaos Knight":
                timer = 75;
                imageId = R.drawable.chaosknight;
                break;
            case "Clockwerk":
                timer = 30;
                imageId = R.drawable.clockwerk;
                break;
            case "Dawnbreaker":
                timer = 100;
                imageId = R.drawable.dawnbreaker;
                break;
            case "Doom":
                timer = 145;
                imageId = R.drawable.doom;
                break;
            case "Dragon Knight":
                timer = 105;
                imageId = R.drawable.dragonknight;
                break;
            case "Earth Spirit":
                timer = 80;
                imageId = R.drawable.colored;
                break;
            case "Earth Shaker":
                timer = 110;
                imageId = R.drawable.earthshaker;
                break;
            case "Elder Titan":
                timer = 100;
                imageId = R.drawable.eldertitan;
                break;
            case "IO":
                timer = 80;
                imageId = R.drawable.io;
                break;
            case "Kunkka":
                timer = 60;
                imageId = R.drawable.kunkka;
                break;
            case "Legion Commander":
                timer = 50;
                imageId = R.drawable.legioncommander;
                break;
            case "Lifestealer":
                timer = 50;
                imageId = R.drawable.lifestealer;
                break;
            case "Lycan":
                timer = 95;
                imageId = R.drawable.lycan;
                break;
            case "Magnus":
                timer = 130;
                imageId = R.drawable.magnus;
                break;
            case "Marci":
                timer = 70;
                imageId = R.drawable.marci;
                break;
            case "Mars":
                timer = 90;
                imageId = R.drawable.mars;
                break;
            case "Night Stalker":
                timer = 130;
                imageId = R.drawable.nightstalker;
                break;
            case "Omni Knight":
                timer = 120;
                imageId = R.drawable.omniknight;
                break;
            case "Phoenix":
                timer = 120;
                imageId = R.drawable.phoenix;
                break;
            case "Primal Beast":
                timer = 24;
                imageId = R.drawable.primalbeast;
                break;
            case "Sand King":
                timer = 100;
                imageId = R.drawable.sandking;
                break;
            case "Snapfire":
                timer = 100;
                imageId = R.drawable.snapfire;
                break;
            case "Spirit Breaker":
                timer = 50;
                imageId = R.drawable.spiritbreaker;
                break;
            case "Sven":
                timer = 110;
                imageId = R.drawable.sven;
                break;
            case "Tidehunter":
                timer = 150;
                imageId = R.drawable.tidehunter;
                break;
            case "Treant Protector":
                timer = 100;
                imageId = R.drawable.treant;
                break;
            case "Underlord":
                timer = 100;
                imageId = R.drawable.underlord;
                break;
            case "Undying":
                timer = 125;
                imageId = R.drawable.undying;
                break;
            case "Wraith King":
                timer = 60;
                imageId = R.drawable.wraithking;
                break;
        }
        return new Hero(heroName, timer, imageId);
    }
}
