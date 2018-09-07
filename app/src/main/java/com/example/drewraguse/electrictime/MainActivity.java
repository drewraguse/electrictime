package com.example.drewraguse.electrictime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;
import android.text.Editable;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public ProgressBar mProgressbar1;
    public ProgressBar mcircleBar1;
    public TextView mtext1;
    public TextView walk_miles_1;
    public TextView mText1_2;


    public ProgressBar mProgressbar2;
    public ProgressBar mcircleBar2;
    public TextView mtext2;
    public TextView boosted_miles_2;
    public TextView mText2_3;


    public ProgressBar mProgressbar3;
    public ProgressBar mcircleBar3;
    public TextView mtext3;
    public TextView evolve_miles_3;
    public TextView mText3_4;


    public ProgressBar mProgressbar4;
    public ProgressBar mcircleBar4;
    public TextView mtext4;
    public TextView segway_miles_4;
    public TextView mText4_5;

    public ProgressBar mProgressbar5;
    public ProgressBar mcircleBar5;
    public TextView mtext5;
    public TextView hoverboard_miles_5;
    public TextView mText5_6;


    public EditText mEditText;
    public android.widget.Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressbar1 = findViewById(R.id.progressbar1);
        mcircleBar1 = findViewById(R.id.circlebar1);
        mcircleBar1.setRotation(180);
        mtext1 = findViewById(R.id.text1);
        walk_miles_1 = findViewById(R.id.walking_miles);
        mText1_2 = findViewById(R.id.text1_2);




        mProgressbar2 = findViewById(R.id.progressbar2);
        mcircleBar2 = findViewById(R.id.circlebar2);
        mcircleBar2.setRotation(180);
        mtext2 = findViewById(R.id.text2);
        boosted_miles_2 = findViewById(R.id.boosted_miles);
        mText2_3 = findViewById(R.id.text2_3);




        mProgressbar3 = findViewById(R.id.progressbar3);
        mcircleBar3 = findViewById(R.id.circlebar3);
        mcircleBar3.setRotation(180);
        mtext3 = findViewById(R.id.text3);
        evolve_miles_3 = findViewById(R.id.evolve_miles);
        mText3_4 = findViewById(R.id.text3_4);




        mProgressbar4 = findViewById(R.id.progressbar4);
        mcircleBar4 = findViewById(R.id.circlebar4);
        mcircleBar4.setRotation(180);
        mtext4 = findViewById(R.id.text4);
        segway_miles_4 = findViewById(R.id.segway_miles);
        mText4_5 = findViewById(R.id.text4_5);




        mProgressbar5 = findViewById(R.id.progressbar5);
        mcircleBar5 = findViewById(R.id.circlebar5);
        mcircleBar5.setRotation(180);
        mtext5 = findViewById(R.id.text5);
        hoverboard_miles_5 = findViewById(R.id.hoverboard_miles);
        mText5_6 = findViewById(R.id.text5_6);




        mEditText = findViewById(R.id.editText1);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable text) {
                text.append(" miles");

                /** if (Integer.parseInt(text.toString()) == 1) {
                    text.append(" mile");
                } else {
                    text.append(" miles");
                } */
            }
        });


        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transportation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        final Button mLoadButton = findViewById(R.id.loadbutton);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String spinner_text = spinner.getSelectedItem().toString();
                String value = mEditText.getText().toString();
                int num = Integer.parseInt(value);
                int mins_for_miles = (int) converter.edit_value(Integer.parseInt(value), spinner_text);

                int walk_mins = (int) converter.walk_miles(Integer.parseInt(value));
                int walk_miles = (int) Math.round((mins_for_miles*3.1)/60.0);
                mProgressbar1.setProgress(Math.round(100*walk_miles/31));
                mcircleBar1.setProgress(converter.max_mins(walk_mins));
                mtext1.setText("" + Math.round(walk_mins) + "");
                walk_miles_1.setText("" + walk_miles + " miles");
                mText1_2.setText("to walk " + num + " miles");


                int boost_mins = (int) converter.boosted_miles(Integer.parseInt(value));
                int boost_miles = (int) Math.round((mins_for_miles*18)/60.0);
                mProgressbar2.setProgress(Math.round(100*boost_miles/31));
                mcircleBar2.setProgress(converter.max_mins(boost_mins));
                mtext2.setText("" + Math.round(boost_mins) + "");
                boosted_miles_2.setText("" + boost_miles + " miles");
                mText2_3.setText("to Boosted Board \n" + num + " miles");


                int evolve_mins = (int) converter.evolve_miles(Integer.parseInt(value));
                int evolve_miles = (int) Math.round((mins_for_miles*26)/60.0);
                mProgressbar3.setProgress(Math.round(100*evolve_miles/31));
                mcircleBar3.setProgress(converter.max_mins(boost_mins));
                mtext3.setText("" + Math.round(evolve_mins) + "");
                evolve_miles_3.setText("" + evolve_miles + " miles");
                mText3_4.setText("to Skateboard \n" + num + " miles");


                int segway_mins = (int) converter.segway_miles(Integer.parseInt(value));
                int segway_miles = (int) Math.round((mins_for_miles*12.5)/60.0);
                mProgressbar4.setProgress(Math.round(100*segway_miles/31));
                mcircleBar4.setProgress(converter.max_mins(segway_mins));
                mtext4.setText("" + Math.round(segway_mins) + "");
                segway_miles_4.setText("" + segway_miles + " miles");
                mText4_5.setText("to Segway \n" + num + " miles");


                int hoverboard_mins = (int) converter.hoverboard_miles(Integer.parseInt(value));
                int hoverboard_miles = (int) Math.round((mins_for_miles*8)/60.0);
                mProgressbar5.setProgress(Math.round(100*hoverboard_miles/31));
                mcircleBar5.setProgress(converter.max_mins(hoverboard_mins));
                mtext5.setText("" + Math.round(hoverboard_mins) + "");
                hoverboard_miles_5.setText("" + hoverboard_miles + " miles");
                mText5_6.setText("to Hoverboard \n" + num + " miles");



            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
