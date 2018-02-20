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


public class MainActivity extends AppCompatActivity {

    String text_lang_one, text_lang_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Spinner one for language that user is fluent in
        Spinner spinnerLangOne = findViewById(R.id.language_one_spinner);
        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLangOne.setAdapter(adapterOne);
        spinnerLangOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text_lang_one = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Set Spinner two for language that user wants to learn
        Spinner spinnerLangTwo = findViewById(R.id.language_two_spinner);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLangTwo.setAdapter(adapterTwo);
        spinnerLangTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text_lang_two = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // on Button click go to Categories screen, carry over the languages chosen
        Button next = findViewById(R.id.button_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoriesIntent = new Intent(MainActivity.this, Categories.class);
                categoriesIntent.putExtra("lang_one", text_lang_one);
                categoriesIntent.putExtra("lang_two", text_lang_two);
                startActivity(categoriesIntent);
            }
        });

    }

}

// disable user input when 2 cards are open
// adjust language by configuration of locale
// create a class memorycard with properties locale for language, tag for reference, viewId

