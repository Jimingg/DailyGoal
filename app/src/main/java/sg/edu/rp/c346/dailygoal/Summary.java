package sg.edu.rp.c346.dailygoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);
        Intent i = getIntent();

        String[] info = i.getStringArrayExtra("info");
        TextView tv1 = findViewById(R.id.Textview21);
        tv1.setText("Read up on materials before class : " + info[0] + "\n \n Arrive on time so as not to miss important part of the lesson:" + info[1] + "\n \n Attempt the problem myself?:" + info[2] +"\n  \n Reflection:"  + info[3] );
    }
}
