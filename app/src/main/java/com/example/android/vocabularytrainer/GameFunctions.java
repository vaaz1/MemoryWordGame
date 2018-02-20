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
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
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


public class GameFunctions extends AppCompatActivity implements View.OnClickListener {

    private static final int NUM_ROWS = 3; // set layout on create?
    private static final int NUM_COLS = 8;
    int tag1 = 0;
    int tag2 = 0;
    int ImageResource1, ImageResource2, TextResource1, TextResource2;
    int button1Id, button2Id;
    //memory cards as buttons
    Button one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve,
            one2, two2, three2, four2, five2, six2, seven2, eight2, nine2, ten2, eleven2, twelve2,
            reset;
    //array for the buttons
    Button buttonsArrayTwo[] = new Button[12];
    Button buttonsArrayOne[] = new Button[12];
    //arrray for the images
    int[] cardsArray1 = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112};
    int[] cardsArray2 = {201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212};
    //actual images
    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110, image111, image112,
            image201, image202, image203, image204, image205, image206, image207, image208, image209, image210, image211, image212;
    int string101, string102, string103, string104, string105, string106, string107, string108, string109, string110, string111, string112,
            string201, string202, string203, string204, string205, string206, string207, string208, string209, string210, string211, string212;
    TextView titel, tv_l_one, tv_l_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);

        //populateButtons();

        // set title according to category and languages chosen by user
        titel = findViewById(R.id.titel); // category as titel
        tv_l_one = findViewById(R.id.tv_l_one); // language one textView
        tv_l_two = findViewById(R.id.tv_l_two); // language two textView

        Intent intent = getIntent();
        String titel_text = intent.getStringExtra("titel");
        String lang_one = intent.getStringExtra("lang_one");
        String lang_two = intent.getStringExtra("lang_two");

        titel.setText(titel_text);
        tv_l_one.setText(lang_one);
        tv_l_two.setText(lang_two);

        // assign buttons to views and set onClickListener to all
        one = findViewById(R.id.l1_1);
        one.setOnClickListener(this); // calling onClick() method
        two = findViewById(R.id.l1_2);
        two.setOnClickListener(this);
        three = findViewById(R.id.l1_3);
        three.setOnClickListener(this);
        four = findViewById(R.id.l1_4);
        four.setOnClickListener(this); // calling onClick() method
        five = findViewById(R.id.l1_5);
        five.setOnClickListener(this);
        six = findViewById(R.id.l1_6);
        six.setOnClickListener(this);
        seven = findViewById(R.id.l1_7);
        seven.setOnClickListener(this); // calling onClick() method
        eight = findViewById(R.id.l1_8);
        eight.setOnClickListener(this);
        nine = findViewById(R.id.l1_9);
        nine.setOnClickListener(this);
        ten = findViewById(R.id.l1_10);
        ten.setOnClickListener(this); // calling onClick() method
        eleven = findViewById(R.id.l1_11);
        eleven.setOnClickListener(this);
        twelve = findViewById(R.id.l1_12);
        twelve.setOnClickListener(this);

        one2 = findViewById(R.id.l2_1);
        one2.setOnClickListener(this); // calling onClick() method
        two2 = findViewById(R.id.l2_2);
        two2.setOnClickListener(this);
        three2 = findViewById(R.id.l2_3);
        three2.setOnClickListener(this);
        four2 = findViewById(R.id.l2_4);
        four2.setOnClickListener(this); // calling onClick() method
        five2 = findViewById(R.id.l2_5);
        five2.setOnClickListener(this);
        six2 = findViewById(R.id.l2_6);
        six2.setOnClickListener(this);
        seven2 = findViewById(R.id.l2_7);
        seven2.setOnClickListener(this); // calling onClick() method
        eight2 = findViewById(R.id.l2_8);
        eight2.setOnClickListener(this);
        nine2 = findViewById(R.id.l2_9);
        nine2.setOnClickListener(this);
        ten2 = findViewById(R.id.l2_10);
        ten2.setOnClickListener(this); // calling onClick() method
        eleven2 = findViewById(R.id.l2_11);
        eleven2.setOnClickListener(this);
        twelve2 = findViewById(R.id.l2_12);
        twelve2.setOnClickListener(this);

        // populate buttonsArray with buttons for language one
        buttonsArrayOne[0] = one;
        buttonsArrayOne[1] = two;
        buttonsArrayOne[2] = three;
        buttonsArrayOne[3] = four;
        buttonsArrayOne[4] = five;
        buttonsArrayOne[5] = six;
        buttonsArrayOne[6] = seven;
        buttonsArrayOne[7] = eight;
        buttonsArrayOne[8] = nine;
        buttonsArrayOne[9] = ten;
        buttonsArrayOne[10] = eleven;
        buttonsArrayOne[11] = twelve;

        // populate buttonsArray with buttons for language two
        buttonsArrayTwo[0] = one2;
        buttonsArrayTwo[1] = two2;
        buttonsArrayTwo[2] = three2;
        buttonsArrayTwo[3] = four2;
        buttonsArrayTwo[4] = five2;
        buttonsArrayTwo[5] = six2;
        buttonsArrayTwo[6] = seven2;
        buttonsArrayTwo[7] = eight2;
        buttonsArrayTwo[8] = nine2;
        buttonsArrayTwo[9] = ten2;
        buttonsArrayTwo[10] = eleven2;
        buttonsArrayTwo[11] = twelve2;

        // set button tags (random)
        setTagsToButtons(buttonsArrayOne);
        setTagsToButtons(buttonsArrayTwo);

        // set front of memory card contents
        frontOfCardsResources();

        // assign rest button
        reset = findViewById(R.id.reset_button);
        reset.setOnClickListener(this);

    } // end of OnCreate

//    private void populateButtons(){
//        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
//        for(int row=0; row<NUM_ROWS; row++){
//            TableRow tableRow = new TableRow(this);
//            tableRow.setLayoutParams(new TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT,1.0f
//            ));
//            table.addView(tableRow);
//            for(int col=0; col<NUM_COLS; col++){
//                Button button = new Button(this);
//                button.setLayoutParams(new TableRow.LayoutParams(
//                        TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT,1.0f
//                ));
//                tableRow.addView(button);
//            }
//        }
//    }

    //Sets random tags to the buttons
    public void setTagsToButtons(Button[] buttonsArray) {
        String[] tagArray = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        for (int i = 0; i <= 11; i++) {
            //int tagArray[] = new int[12];
            Random r = new Random();
            int rand = r.nextInt(13 - 1) + 1;
            if (!Arrays.asList(tagArray).contains(Integer.toString(rand))) {
                tagArray[i] = Integer.toString(rand);
                buttonsArray[i].setTag(rand);
            } else {
                i--;
            }
        }
    }

    // initialize memory card contents according to category
    private void frontOfCardsResources() {
        Intent intent = getIntent();
        int[] images = intent.getIntArrayExtra("img_list");
        image101 = images[0];
        image102 = images[1];
        image103 = images[2];
        image104 = images[3];
        image105 = images[4];
        image106 = images[5];
        image107 = images[6];
        image108 = images[7];
        image109 = images[8];
        image110 = images[9];
        image111 = images[10];
        image112 = images[11];

        image201 = images[0];
        image202 = images[1];
        image203 = images[2];
        image204 = images[3];
        image205 = images[4];
        image206 = images[5];
        image207 = images[6];
        image208 = images[7];
        image209 = images[8];
        image210 = images[9];
        image211 = images[10];
        image212 = images[11];

        int[] strings_one = intent.getIntArrayExtra("str_list_one");
        string101 = strings_one[0];
        string102 = strings_one[1];
        string103 = strings_one[2];
        string104 = strings_one[3];
        string105 = strings_one[4];
        string106 = strings_one[5];
        string107 = strings_one[6];
        string108 = strings_one[7];
        string109 = strings_one[8];
        string110 = strings_one[9];
        string111 = strings_one[10];
        string112 = strings_one[11];

        int[] strings_two = intent.getIntArrayExtra("str_list_two");
        string201 = strings_two[0];
        string202 = strings_two[1];
        string203 = strings_two[2];
        string204 = strings_two[3];
        string205 = strings_two[4];
        string206 = strings_two[5];
        string207 = strings_two[6];
        string208 = strings_two[7];
        string209 = strings_two[8];
        string210 = strings_two[9];
        string211 = strings_two[10];
        string212 = strings_two[11];
    }

    @Override
    public void onClick(View v) {
        // handling onClick Events for memory card button clicks
        // get button and tag, set image and content, turn card, evaluate if a card of the other language is opened
        switch (v.getId()) {

            case R.id.l1_1:
                // code for button when user clicks buttonOne.
                Button one = findViewById(R.id.l1_1);
                tag1 = (int) one.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                //ImageResource1 = R.drawable.cat;
                //setLocale(Locale.GERMAN);
                //TextResource1 = R.string.cat;
                button1Id = R.id.l1_1;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) { // check if a memory card of the other language is open
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_2:
                Button two = findViewById(R.id.l1_2);
                tag1 = (int) two.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_2;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_3:
                Button three = findViewById(R.id.l1_3);
                tag1 = (int) three.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_3;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_4:
                Button four = findViewById(R.id.l1_4);
                tag1 = (int) four.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_4;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_5:
                Button five = findViewById(R.id.l1_5);
                tag1 = (int) five.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_5;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_6:
                Button six = findViewById(R.id.l1_6);
                tag1 = (int) six.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_6;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_7:
                Button seven = findViewById(R.id.l1_7);
                tag1 = (int) seven.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_7;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_8:
                Button eight = findViewById(R.id.l1_8);
                tag1 = (int) eight.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_8;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_9:
                Button nine = findViewById(R.id.l1_9);
                tag1 = (int) nine.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_9;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_10:
                Button ten = findViewById(R.id.l1_10);
                tag1 = (int) ten.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_10;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_11:
                Button eleven = findViewById(R.id.l1_11);
                tag1 = (int) eleven.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_11;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l1_12:
                Button twelve = findViewById(R.id.l1_12);
                tag1 = (int) twelve.getTag();
                ImageResource1 = setImageOne(tag1);
                TextResource1 = setTextLangOne(tag1);
                button1Id = R.id.l1_12;
                TurnL1(button1Id, ImageResource1, TextResource1);
                if (tag2 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            //-------------------------

            case R.id.l2_1:
                // code for button when user clicks buttonOne.
                Button one2 = findViewById(R.id.l2_1);
                tag2 = (int) one2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_1;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_2:
                Button two2 = findViewById(R.id.l2_2);
                tag2 = (int) two2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_2;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_3:
                Button three2 = findViewById(R.id.l2_3);
                tag2 = (int) three2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_3;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_4:
                Button four2 = findViewById(R.id.l2_4);
                tag2 = (int) four2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_4;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_5:
                Button five2 = findViewById(R.id.l2_5);
                tag2 = (int) five2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_5;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_6:
                Button six2 = findViewById(R.id.l2_6);
                tag2 = (int) six2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_6;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_7:
                Button seven2 = findViewById(R.id.l2_7);
                tag2 = (int) seven2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_7;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_8:
                Button eight2 = findViewById(R.id.l2_8);
                tag2 = (int) eight2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_8;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_9:
                Button nine2 = findViewById(R.id.l2_9);
                tag2 = (int) nine2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_9;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_10:
                Button ten2 = findViewById(R.id.l2_10);
                tag2 = (int) ten2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_10;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_11:
                Button eleven2 = findViewById(R.id.l2_11);
                tag2 = (int) eleven2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_11;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.l2_12:
                Button twelve2 = findViewById(R.id.l2_12);
                tag2 = (int) twelve2.getTag();
                ImageResource2 = setImageTwo(tag2);
                TextResource2 = setTextLangTwo(tag2);
                button2Id = R.id.l2_12;
                TurnL1(button2Id, ImageResource2, TextResource2);
                if (tag1 != 0) {
                    Evaluate(tag1, tag2, button1Id, button2Id);
                }
                break;

            case R.id.reset_button: // close all memory card
                for (int i = 0; i <= 11; i++) {
                    buttonsArrayOne[i].setBackgroundResource(R.drawable.square);
                    buttonsArrayOne[i].setText("");
                    buttonsArrayOne[i].setClickable(true);
                    buttonsArrayTwo[i].setBackgroundResource(R.drawable.square);
                    buttonsArrayTwo[i].setText("");
                    buttonsArrayTwo[i].setClickable(true);
                    tag1 = 0;
                    tag2 = 0;
                }
                break;

            default:
                break;
        }

    }

    // setting the image for the memory card according to its tag
    public int setImageOne(int card) {
        switch (cardsArray1[card - 1]) {
            case 101:
                return image101;
            case 102:
                return image102;
            case 103:
                return image103;
            case 104:
                return image104;
            case 105:
                return image105;
            case 106:
                return image106;
            case 107:
                return image107;
            case 108:
                return image108;
            case 109:
                return image109;
            case 110:
                return image110;
            case 111:
                return image111;
            case 112:
                return image112;

            default:
                return R.drawable.square;
        }
    }

    // setting the image for the memory card according to its tag
    public int setImageTwo(int card) {
        switch (cardsArray2[card - 1]) {
            case 201:
                return image201;
            case 202:
                return image202;
            case 203:
                return image203;
            case 204:
                return image204;
            case 205:
                return image205;
            case 206:
                return image206;
            case 207:
                return image207;
            case 208:
                return image208;
            case 209:
                return image209;
            case 210:
                return image210;
            case 211:
                return image211;
            case 212:
                return image212;
            default:
                return R.drawable.square;
        }
    }

    // setting the word for the memory card according to its tag
    public int setTextLangOne(int card) {
        switch (cardsArray1[card - 1]) {
            case 101:
                return string101;
            case 102:
                return string102;
            case 103:
                return string103;
            case 104:
                return string104;
            case 105:
                return string105;
            case 106:
                return string106;
            case 107:
                return string107;
            case 108:
                return string108;
            case 109:
                return string109;
            case 110:
                return string110;
            case 111:
                return string111;
            case 112:
                return string112;
            default:
                return R.string.pig;
        }
    }

    // setting the word for the memory card according to its tag
    public int setTextLangTwo(int card) {
        switch (cardsArray2[card - 1]) {
            case 201:
                return string201;
            case 202:
                return string202;
            case 203:
                return string203;
            case 204:
                return string204;
            case 205:
                return string205;
            case 206:
                return string206;
            case 207:
                return string207;
            case 208:
                return string208;
            case 209:
                return string209;
            case 210:
                return string210;
            case 211:
                return string211;
            case 212:
                return string212;
            default:
                return R.string.pig;
        }
    }

    // compare tags of two memory cards to check the match
    public void Evaluate(int imgno1, int imgno2, final int oneId, final int twoId) {

        // memory cards match, they cannot be clicked again
        if (imgno1 == imgno2) {
            Toast.makeText(this, "You are correct!", Toast.LENGTH_SHORT).show();
            Button button1 = findViewById(oneId);
            button1.setClickable(false);
            Button button2 = findViewById(twoId);
            button2.setClickable(false);
        }
        // memory cards don't match, turn them back around
        else {
            Toast.makeText(this, "This was wrong. Try again!", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button one = findViewById(oneId);
                    Button two = findViewById(twoId);
                    one.setBackgroundResource(R.drawable.square);
                    one.setText("");
                    two.setBackgroundResource(R.drawable.square);
                    two.setText("");
                }
            }, 2000);

        }
        tag1 = 0;
        tag2 = 0;
    }

    // set the content of the memory card when turned around
    public void TurnL1(final int buttonId, final int ImageResource, final int TextResource) {

        Button buttonL1 = findViewById(buttonId);
        buttonL1.setBackgroundResource(ImageResource);
        String word = getString(TextResource);
        buttonL1.setText(word);

    }

    public void setLocale(Locale desiredLocale) {
        Resources res = getResources();
        Configuration conf = res.getConfiguration();
        Locale savedLocale = conf.locale;
        conf.locale = desiredLocale; // whatever you want here
        res.updateConfiguration(conf, null); // second arg null means don't change

        // retrieve resources from desired locale
        //String str = res.getString(id);

        // restore original locale
        //conf.locale = savedLocale;
        //res.updateConfiguration(conf, null);
    }

}

// disable user input when 2 cards are open
// adjust language by configuration of locale
// create a class memorycard with properties locale for language, tag for reference, viewId
