package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class LabRating extends AppCompatActivity {
    private Firebase mref;
    private Button submits;
    private String years,subjects,sections;
    private RatingBar r1,r2,r3,r4,r5;
    private TextView t1,t2,t3,t4,t5;
    float total=0;
    int i=0;
    float a[]=new float[5];
    String b[]=new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_rating);
        setTitle("Lab Rating");
       Firebase.setAndroidContext(this);
        mref = new Firebase("https://cmrfacultyfeedback.firebaseio.com/");
        submits=(Button)findViewById(R.id.button2);
        r1=(RatingBar)findViewById(R.id.r1);
        t1=(TextView)findViewById(R.id.t1);
        r2=(RatingBar)findViewById(R.id.r2);
        t2=(TextView)findViewById(R.id.t2);
        r3=(RatingBar)findViewById(R.id.r3);
        t3=(TextView)findViewById(R.id.t3);
        r4=(RatingBar)findViewById(R.id.r4);
        t4=(TextView)findViewById(R.id.t4);
        r5=(RatingBar)findViewById(R.id.r5);
        t5=(TextView)findViewById(R.id.t5);
        submits.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                b[0]=t1.getText().toString();
                b[1]=t2.getText().toString();
                b[2]=t3.getText().toString();
                b[3]=t4.getText().toString();
                b[4]=t5.getText().toString();
                a[0]=r1.getRating();
                a[1]=r2.getRating();
                a[2]=r3.getRating();
                a[3]=r4.getRating();
                a[4]=r5.getRating();
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
                String rollnumber = getIntent().getExtras().getString("roll");
                for(i=0;i<5;i++)
                {
                    Firebase mchi = mref.child(years).child(sections).child(subjects).child(rollnumber).child(b[i]);
                    mchi.setValue(a[i]);
                }
                for (i=0;i<5;i++)
                {
                    total=total+a[i];
                }
                Firebase mchi = mref.child(years).child(sections).child(subjects).child(rollnumber).child("total");
                mchi.setValue(total);
                Toast.makeText(LabRating.this, "Rating Submitted", Toast.LENGTH_SHORT).show();
                Intent c=new Intent(LabRating.this,Conclusion.class);
                startActivity(c);
                finish();
            }
        });
    }
}
