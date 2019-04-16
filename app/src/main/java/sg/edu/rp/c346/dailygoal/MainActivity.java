package sg.edu.rp.c346.dailygoal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        RadioGroup RG1 = findViewById(R.id.RadioGrp1);
        RadioGroup RG2 = findViewById(R.id.RadioGrp2);
        RadioGroup RG3 = findViewById(R.id.RadioGrp3);

        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg1 = findViewById(R.id.RadioGrp1);

                int selectedButtonId = rg1.getCheckedRadioButtonId();

                RadioButton rb1 =findViewById(selectedButtonId);

                RadioGroup rg2 = findViewById(R.id.RadioGrp2);

                int selectedButtonId2 = rg2.getCheckedRadioButtonId();

                RadioButton rb2 =findViewById(selectedButtonId2);

                RadioGroup rg3 = findViewById(R.id.RadioGrp3);

                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                RadioButton rb3 =findViewById(selectedButtonId);

                EditText et1 = findViewById(R.id.editTextReflect);




                String[] info = {rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString(),et1.getText().toString()};

                Intent i = new Intent(MainActivity.this,Summary.class);

                i.putExtra("info",info);

                startActivity(i);

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

            SharedPreferences.Editor prefEdits = prefs.edit();

            prefEdits.putInt("s1",selectedButtonId);
                prefEdits.putInt("s2",selectedButtonId2);
                prefEdits.putInt("s3",selectedButtonId3);
                prefEdits.putString("reflect",et1.getText().toString());
                prefEdits.commit();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        int s1 = pref.getInt("s1", -1);
        int s2 = pref.getInt("s2", -1);
        int s3 = pref.getInt("s3", -1);
        String reflect = pref.getString("reflect", "");

        RadioButton Rb1 = findViewById(R.id.radioButtonYes);
        RadioButton Rb2 = findViewById(R.id.radioButtonNo);
        RadioButton Rb3 = findViewById(R.id.radioButtonYes2);
        RadioButton Rb4 = findViewById(R.id.radioButtonNo2);
        RadioButton Rb5 = findViewById(R.id.radioButtonYes3);
        RadioButton Rb6 = findViewById(R.id.radioButtonNo3);

        EditText et1 = findViewById(R.id.editTextReflect);
        if (s1 != -1) {
            if (s1 > 0) {
                Rb1.setChecked(true);
            } else {
                Rb2.setChecked(true);
            }
        }
            if (s2 != -1) {
                if (s2 > 0) {
                    Rb3.setChecked(true);
                } else {
                    Rb4.setChecked(true);
                }
            }
            if (s3 != -1) {
                if (s3 > 0) {
                    Rb5.setChecked(true);
                } else {
                    Rb6.setChecked(true);
                }
            }
            et1.setText(reflect);
        }
    }
