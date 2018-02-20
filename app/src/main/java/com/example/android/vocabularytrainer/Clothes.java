package com.example.android.vocabularytrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Vera on 26.01.2018.
 */

public class Clothes extends AppCompatActivity {
    String text_titel, text_lang_one, text_lang_two;
    TextView l_one, l_two, titel;
    int[] strings_lang_one, strings_lang_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_vocabulary);

        Intent intent = getIntent();
        text_lang_one = intent.getStringExtra("lang_one");
        text_lang_two = intent.getStringExtra("lang_two");

        l_one = findViewById(R.id.lang_one);
        l_two = findViewById(R.id.lang_two);
        titel = findViewById(R.id.title);

        l_one.setText(text_lang_one);
        l_two.setText(text_lang_two);
        titel.setText("Clothes");
        text_titel = "Clothes";

        final int[] images = {R.drawable.trouseres, R.drawable.bra, R.drawable.socks, R.drawable.skirt, R.drawable.shorts, R.drawable.coat, R.drawable.dress,
                R.drawable.shirt, R.drawable.pullover, R.drawable.pyjama, R.drawable.panties, R.drawable.jacket};


        switch (text_lang_one) { // sets the string resoucre according to the selected language
            case "English":
                int[] string_list_eng = {R.string.trousers, R.string.bra, R.string.socks, R.string.skirt, R.string.shorts, R.string.coat, R.string.dress,
                        R.string.shirt, R.string.pullover, R.string.pyjama, R.string.panties, R.string.jacket};
                strings_lang_one = string_list_eng;
                //strings_lang_one=setLocale(Locale.ENGLISH);
                break;
            case "German":
                int[] string_list_ger = {R.string.trousers_ger, R.string.bra_ger, R.string.socks_ger, R.string.skirt_ger, R.string.shorts_ger, R.string.coat_ger, R.string.dress_ger,
                        R.string.shirt_ger, R.string.pullover_ger, R.string.pyjama_ger, R.string.panties_ger, R.string.jacket_ger};
                strings_lang_one = string_list_ger;
                //strings_lang_one=setLocale(Locale.GERMAN);
                break;
            case "Hebrew":
                int[] string_list_heb = {R.string.trousers, R.string.bra, R.string.socks, R.string.skirt, R.string.shorts, R.string.coat, R.string.dress,
                        R.string.shirt, R.string.pullover, R.string.pyjama, R.string.panties, R.string.jacket};
                strings_lang_one = string_list_heb;
                //strings_lang_one=setLocale(Locale.ENGLISH);
                break;
            case "Spanish":
                int[] string_list_esp = {R.string.trousers, R.string.bra, R.string.socks, R.string.skirt, R.string.shorts, R.string.coat, R.string.dress,
                        R.string.shirt, R.string.pullover, R.string.pyjama, R.string.panties, R.string.jacket};
                strings_lang_one = string_list_esp;
                //strings_lang_one=setLocale(Locale.ENGLISH);
                break;
            default:
                break;
        }


        switch (text_lang_two) { // sets the string resoucre according to the selected language
            case "English":
                int[] string_list_eng = {R.string.trousers, R.string.bra, R.string.socks, R.string.skirt, R.string.shorts, R.string.coat, R.string.dress,
                        R.string.shirt, R.string.pullover, R.string.pyjama, R.string.panties, R.string.jacket};
                strings_lang_two = string_list_eng;
                //strings_lang_two=setLocale(Locale.ENGLISH);
                break;
            case "German":
                int[] string_list_ger = {R.string.trousers_ger, R.string.bra_ger, R.string.socks_ger, R.string.skirt_ger, R.string.shorts_ger, R.string.coat_ger, R.string.dress_ger,
                        R.string.shirt_ger, R.string.pullover_ger, R.string.pyjama_ger, R.string.panties_ger, R.string.jacket_ger};
                strings_lang_two = string_list_ger;
                //strings_lang_two=setLocale(Locale.GERMAN);
                break;
            case "Hebrew":
                int[] string_list_heb = {R.string.trousers, R.string.bra, R.string.socks, R.string.skirt, R.string.shorts, R.string.coat, R.string.dress,
                        R.string.shirt, R.string.pullover, R.string.pyjama, R.string.panties, R.string.jacket};
                strings_lang_two = string_list_heb;
                //strings_lang_tow=setLocale(Locale.ENGLISH);
                break;
            case "Spanish":
                int[] string_list_esp = {R.string.trousers, R.string.bra, R.string.socks, R.string.skirt, R.string.shorts, R.string.coat, R.string.dress,
                        R.string.shirt, R.string.pullover, R.string.pyjama, R.string.panties, R.string.jacket};
                strings_lang_two = string_list_esp;
                //strings_lang_two=setLocale(Locale.ENGLISH);
                break;
            default:
                break;
        }


        Button start = findViewById(R.id.start_game); // starts the game and hands over category specifics
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameIntent = new Intent(Clothes.this, GameFunctions.class);
                gameIntent.putExtra("titel", text_titel);
                gameIntent.putExtra("lang_one", text_lang_one);
                gameIntent.putExtra("lang_two", text_lang_two);
                gameIntent.putExtra("img_list", images);
                gameIntent.putExtra("str_list_one", strings_lang_one);
                gameIntent.putExtra("str_list_two", strings_lang_two);
                startActivity(gameIntent);
            }
        });


    }


}
