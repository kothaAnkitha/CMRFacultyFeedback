package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class SemiShow extends AppCompatActivity {
    private Firebase mref;
    private TextView textView12,textView9,textView28;
    private Button button4,button5;
    private TextView textView7;
    float i;
    int c=0;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_show);
        button5=(Button)findViewById(R.id.button5);
        textView12=(TextView)findViewById(R.id.textView12);
        button4=(Button)findViewById(R.id.button4);
        textView9=(TextView)findViewById(R.id.textView9);


        textView28=(TextView)findViewById(R.id.textView28);
        textView7=(TextView)findViewById(R.id.textView7);
        button4.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SemiShow.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setTitle("select date");
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
               String date=year+"-"+month+"-"+dayOfMonth;
                textView7.setText(date);
            }
        };
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  final String date=textView7.getText().toString();
                mref=new Firebase("https://cmrfacultyfeedback.firebaseio.com/").child("facultydetails");

                mref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final String date=textView7.getText().toString();

                        float total = 0;
                        String sub;
                        String semrate, topic = null, name = null;
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            sub = dataSnapshot1.getKey();
                            if (sub.equals(date)) {
                                for (DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren()) {
                                    name = dataSnapshot2.child("Name of the Guest Faculty:").getValue().toString();

                                    topic = dataSnapshot2.child("Lecture Topic:").getValue().toString();
                                    c++;

                                    semrate = dataSnapshot2.child("Overall rating of the guest lecture").getValue().toString();
                                    total = total + Float.valueOf(semrate);
                                }

                            }
                        }


                            Toast.makeText(SemiShow.this, c + "", Toast.LENGTH_SHORT).show();

                            button5.setVisibility(View.INVISIBLE);
                            i = ((total / (c * 5)) * 100);
                            textView12.setText(i + "%");
                            textView9.setText(name);
                            textView28.setText(topic);
/*
                       float total = 0;
                        String chdate, semrate,topic = null,name = null;
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                           name=dataSnapshot1.child("Name of the Guest Faculty:").getValue().toString();
                            topic=dataSnapshot1.child("Lecture Topic:").getValue().toString();
                            semrate = dataSnapshot1.child("Overall rating of the guest lecture").getValue().toString();
                            chdate = dataSnapshot1.child("Select Date").getValue().toString();
                            if (chdate.equals(date)) {
                                c++;
                                total = total + Float.parseFloat(semrate);
                            }
                        }
                        button5.setVisibility(View.INVISIBLE);
                        i = ((total / (c * 5)) * 100);
                        Toast.makeText(SemiShow.this, "The number of students gave the feedback are "+c, Toast.LENGTH_SHORT).show();
                        textView12.setText(i + "%");
                        textView9.setText(name);
                        textView28.setText(topic);
                       // counttext.setText(c);*/
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }

        });
    }
    }
