package com.example.dotatimers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HeroSelection extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_selection);

        listView = (ListView) findViewById(R.id.listView);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Button selectHeroes = (Button) findViewById(R.id.selectHeroesBtn);

        ArrayList<String> heroList = new ArrayList<>();
        heroList.add("Abaddon");
        heroList.add("Alchemist");
        heroList.add("Axe");
        heroList.add("Beastmaster");
        heroList.add("Brewmaster");
        heroList.add("Centaur Warrunner");
        heroList.add("Chaos Knight");
        heroList.add("Clockwerk");
        heroList.add("Dawnbreaker");
        heroList.add("Doom");
        heroList.add("Dragon Knight");
        heroList.add("Earth Spirit");
        heroList.add("Earth Shaker");
        heroList.add("Elder Titan");
        heroList.add("IO");
        heroList.add("Kunkka");
        heroList.add("Legion Commander");
        heroList.add("Lifestealer");
        heroList.add("Lycan");
        heroList.add("Magnus");
        heroList.add("Marci");
        heroList.add("Mars");
        heroList.add("Night Stalker");
        heroList.add("Omni Knight");
        heroList.add("Phoenix");
        heroList.add("Primal Beast");
        heroList.add("Sand King");
        heroList.add("Snapfire");
        heroList.add("Spirit Breaker");
        heroList.add("Sven");
        heroList.add("Tidehunter");
        heroList.add("Treant Protector");
        heroList.add("Underlord");
        heroList.add("Undying");
        heroList.add("Wraith King");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, heroList);
        listView.setAdapter(arrayAdapter);

        selectHeroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heroes[] = new String[5];
                String hero = "Heroes:";
                int timers[] = new int[5];

                int counter = 0;
                for (int i = 0; i < listView.getCount(); i++) {
                    if (listView.isItemChecked(i)) {
                        heroes[counter] = listView.getItemAtPosition(i).toString();
                        hero += listView.getItemAtPosition(i).toString();
                        counter++;
                    }
                }
                Bundle b = new Bundle();
                b.putStringArray("heroKey", heroes);
                b.putString("heros", hero);
                Intent i = new Intent(HeroSelection.this, MainActivity.class);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}