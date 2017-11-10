package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class Rating extends AppCompatActivity {
    private Firebase mref;
    private TextView text2, text1, text3, text4, text5, text6, text7, text8, text9, text10;
    private RatingBar r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    private String years,subjects,sections;
    private Button b1;
    float a[] = new float[10];
    String b[] = new String[10];
    float total = 0;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setTitle("Rating");

        Firebase.setAndroidContext(this);
        mref=new Firebase("https://cmrfacultyfeedback.firebaseio.com/");
        years = String.valueOf(YearActivity.getYear());
        int year=YearActivity.getId();

        if(year==4){
            subjects = String.valueOf(Fourthyearsubjects.getSubject());
        }else if(year==3 ||year == 5 ){
            subjects = String.valueOf(Thirdyearsubjects.getSubject());
        }else if(year==2||year == 6) {
            subjects = String.valueOf(Secondyearsubjects.getSubject());
        }else{
            subjects = String.valueOf(Firstyearsubjects.getSubject());

        }
        sections = String.valueOf(Section.getSection());
        final String rollnumber = getIntent().getExtras().getString("roll");
        r1 = (RatingBar) findViewById(R.id.r1);
        text1 = (TextView) findViewById(R.id.test1);
        b1 = (Button) findViewById(R.id.b1);
        text2 = (TextView) findViewById(R.id.text2);
        r2 = (RatingBar) findViewById(R.id.r2);
        text3 = (TextView) findViewById(R.id.text3);
        r3 = (RatingBar) findViewById(R.id.r3);
        text4 = (TextView) findViewById(R.id.text4);
        r4 = (RatingBar) findViewById(R.id.r4);
        text5 = (TextView) findViewById(R.id.text5);
        r5 = (RatingBar) findViewById(R.id.r5);
        text6 = (TextView) findViewById(R.id.text6);
        r6 = (RatingBar) findViewById(R.id.r6);
        text7 = (TextView) findViewById(R.id.text7);
        r7 = (RatingBar) findViewById(R.id.r7);
        text8 = (TextView) findViewById(R.id.text8);
        r8 = (RatingBar) findViewById(R.id.r8);
        text9 = (TextView) findViewById(R.id.text9);
        r9 = (RatingBar) findViewById(R.id.r9);
        text10 = (TextView) findViewById(R.id.text10);
        r10 = (RatingBar) findViewById(R.id.r10);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                b[0] = text1.getText().toString();
                b[1] = text2.getText().toString();
                b[2] = text3.getText().toString();
                b[3] = text4.getText().toString();
                b[4] = text5.getText().toString();
                b[5] = text6.getText().toString();
                b[6] = text7.getText().toString();
                b[7] = text8.getText().toString();
                b[8] = text9.getText().toString();
                b[9] = text10.getText().toString();
                a[0] = r1.getRating();
                a[1] = r2.getRating();
                a[2] = r3.getRating();
                a[3] = r4.getRating();
                a[4] = r5.getRating();
                a[5] = r6.getRating();
                a[6] = r7.getRating();
                a[7] = r8.getRating();
                a[8] = r9.getRating();
                a[9] = r10.getRating();


                for (i = 0; i < 10; i++) {
                    Firebase mchi = mref.child(years).child(sections).child(subjects).child(rollnumber).child(b[i]);
                    mchi.setValue(a[i]);
                }
                for (i = 0; i < 10; i++) {
                    total = total + a[i];
                }
                Firebase mchi = mref.child(years).child(sections).child(subjects).child(rollnumber).child("total");
                mchi.setValue(total);
                Intent s = new Intent(Rating.this, Conclusion.class);
                startActivity(s);
                finish();
            }
        });
    }
}
