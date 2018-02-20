package com.example.android.vocabularytrainer;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;


public class Categories extends AppCompatActivity {

    String text_lang_one, text_lang_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_choice);

        // carry over chosen languages
        Intent intent = getIntent();
        text_lang_one = intent.getStringExtra("lang_one");
        text_lang_two = intent.getStringExtra("lang_two");

        // Array of available categories
        final String[] categories = new String[]{"Animals", "Clothes", "Accessories", "House",
                "Sports", "Furniture", "Food", "Numbers", "Buildings", "Transportation", "Instruments",
                "School", "Office", "Family", "Occupations", "Emotions", "Movements", "Positions",
                "Weather", "Technology", "Travelling"};

        // place categories inside the gridView positions
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        final GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(itemsAdapter);

        // on category click go to vocabulary overview screen
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        Intent animalsIntent = new Intent(Categories.this, Animals.class);
                        animalsIntent.putExtra("lang_one", text_lang_one);
                        animalsIntent.putExtra("lang_two", text_lang_two);
                        startActivity(animalsIntent);
                        break;
                    case 1:
                        Intent clothesIntent = new Intent(Categories.this, Clothes.class);
                        clothesIntent.putExtra("lang_one", text_lang_one);
                        clothesIntent.putExtra("lang_two", text_lang_two);
                        startActivity(clothesIntent);
                        break;
                    default:
                        Toast.makeText(Categories.this, "Category not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}