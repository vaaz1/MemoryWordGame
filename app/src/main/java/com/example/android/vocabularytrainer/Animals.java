package com.example.android.vocabularytrainer;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Vera on 14.01.2018.
 */

public class Animals extends AppCompatActivity {
    String text_titel, text_lang_one, text_lang_two;
    TextView l_one, l_two, titel;
    int[] strings_lang_one, strings_lang_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_vocabulary);

        // carry over languages chosen by user
        Intent intent = getIntent();
        text_lang_one = intent.getStringExtra("lang_one");
        text_lang_two = intent.getStringExtra("lang_two");

        // display chosen languages and category title
        l_one = findViewById(R.id.lang_one);
        l_two = findViewById(R.id.lang_two);
        titel = findViewById(R.id.title);

        l_one.setText(text_lang_one);
        l_two.setText(text_lang_two);
        titel.setText("Animals"); // would it be better to carry it over from the categories activity as intent?
        text_titel = "Animals";

        // array of image resouces
        final int[] images = {R.drawable.bird, R.drawable.cat, R.drawable.chicken, R.drawable.cow, R.drawable.dog, R.drawable.duck, R.drawable.guineapig,
                R.drawable.hamster, R.drawable.horse, R.drawable.pig, R.drawable.rabbit, R.drawable.sheep};


        switch (text_lang_one) { // sets the string resource according to the selected language one
            case "English":
                int[] string_list_eng = {R.string.bird, R.string.cat, R.string.chicken, R.string.cow, R.string.dog, R.string.duck, R.string.guineapig,
                        R.string.hamster, R.string.horse, R.string.pig, R.string.rabbit, R.string.sheep};
                strings_lang_one = string_list_eng;
                //strings_lang_one=setLocale(Locale.ENGLISH);
                break;
            case "German":
                int[] string_list_ger = {R.string.bird_ger, R.string.cat_ger, R.string.chicken_ger, R.string.cow_ger, R.string.dog_ger, R.string.duck_ger, R.string.guineapig_ger,
                        R.string.hamster_ger, R.string.horse_ger, R.string.pig_ger, R.string.rabbit_ger, R.string.sheep_ger};
                strings_lang_one = string_list_ger;
                //strings_lang_one=setLocale(Locale.GERMAN);
                break;
            case "Hebrew":
                int[] string_list_heb = {R.string.bird, R.string.cat, R.string.chicken, R.string.cow, R.string.dog, R.string.duck, R.string.guineapig,
                        R.string.hamster, R.string.horse, R.string.pig, R.string.rabbit, R.string.sheep};
                strings_lang_one = string_list_heb;
                //strings_lang_one=setLocale(Locale.ENGLISH);
                break;
            case "Spanish":
                int[] string_list_esp = {R.string.bird, R.string.cat, R.string.chicken, R.string.cow, R.string.dog, R.string.duck, R.string.guineapig,
                        R.string.hamster, R.string.horse, R.string.pig, R.string.rabbit, R.string.sheep};
                strings_lang_one = string_list_esp;
                //strings_lang_one=setLocale(Locale.ENGLISH);
                break;
            default:
                break;
        }


        switch (text_lang_two) { // sets the string resource according to the selected language two
            case "English":
                int[] string_list_eng = {R.string.bird, R.string.cat, R.string.chicken, R.string.cow, R.string.dog, R.string.duck, R.string.guineapig,
                        R.string.hamster, R.string.horse, R.string.pig, R.string.rabbit, R.string.sheep};
                strings_lang_two = string_list_eng;
                //strings_lang_two=setLocale(Locale.ENGLISH);
                break;
            case "German":
                int[] string_list_ger = {R.string.bird_ger, R.string.cat_ger, R.string.chicken_ger, R.string.cow_ger, R.string.dog_ger, R.string.duck_ger, R.string.guineapig_ger,
                        R.string.hamster_ger, R.string.horse_ger, R.string.pig_ger, R.string.rabbit_ger, R.string.sheep_ger};
                strings_lang_two = string_list_ger;
                //strings_lang_two=setLocale(Locale.GERMAN);
                break;
            case "Hebrew":
                int[] string_list_heb = {R.string.bird, R.string.cat, R.string.chicken, R.string.cow, R.string.dog, R.string.duck, R.string.guineapig,
                        R.string.hamster, R.string.horse, R.string.pig, R.string.rabbit, R.string.sheep};
                strings_lang_two = string_list_heb;
                //strings_lang_tow=setLocale(Locale.ENGLISH);
                break;
            case "Spanish":
                int[] string_list_esp = {R.string.bird, R.string.cat, R.string.chicken, R.string.cow, R.string.dog, R.string.duck, R.string.guineapig,
                        R.string.hamster, R.string.horse, R.string.pig, R.string.rabbit, R.string.sheep};
                strings_lang_two = string_list_esp;
                //strings_lang_two=setLocale(Locale.ENGLISH);
                break;
            default:
                break;
        }

        // array of words in language one
        final ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < strings_lang_one.length; i++) {
            words.add(getResources().getString(strings_lang_one[i]));
        }

        // place words in the listView - need to add also words in language two!
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        final ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // on button click start the memory game, pass over title, languages, images and vocab strings
        Button start = findViewById(R.id.start_game); // starts the game and hands over category specifics
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animalsIntent = new Intent(Animals.this, GameFunctions.class);
                animalsIntent.putExtra("titel", text_titel);
                animalsIntent.putExtra("lang_one", text_lang_one);
                animalsIntent.putExtra("lang_two", text_lang_two);
                animalsIntent.putExtra("img_list", images);
                animalsIntent.putExtra("str_list_one", strings_lang_one);
                animalsIntent.putExtra("str_list_two", strings_lang_two);
                startActivity(animalsIntent);
            }
        });


    }


}

