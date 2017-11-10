package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Seminar extends AppCompatActivity {
    private TextView tview1,tview2,tview0,tview3,tview4,tview5,tview6,trate,tdate;
    private EditText editText1,editText2;
    private Spinner spin,spin1,spin2,spin3,spin4;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    ArrayAdapter<CharSequence> adapter;
    private Button picDate, button3;
    private RatingBar rate;
    private Firebase mref;
    String b[] = new String[10];
    String a[] = new String[10];
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);
            Firebase.setAndroidContext(this);
        mref=new Firebase("https://cmrfacultyfeedback.firebaseio.com/facultydetails");

        tview1=(TextView)findViewById(R.id.tview1);
        editText1=(EditText)findViewById(R.id.editext1);
        tview2=(TextView)findViewById(R.id.tview2);
        editText2=(EditText)findViewById(R.id.editext2);
        picDate=(Button)findViewById(R.id.picDate);
        tdate=(TextView)findViewById(R.id.tdate);
        tview0=(TextView)findViewById(R.id.tview0);
        spin=(Spinner)findViewById(R.id.spin);
        tview3=(TextView)findViewById(R.id.tview3);
        spin1=(Spinner)findViewById(R.id.spin1);
        tview4=(TextView)findViewById(R.id.tview4);
        spin2=(Spinner)findViewById(R.id.spin2);
        tview5=(TextView)findViewById(R.id.tview5);
        spin3=(Spinner)findViewById(R.id.spin3);
        tview6=(TextView)findViewById(R.id.tview6);
        spin4=(Spinner)findViewById(R.id.spin4);
        trate=(TextView)findViewById(R.id.trate);
        rate=(RatingBar)findViewById(R.id.rate);
        button3=(Button)findViewById(R.id.button3);

        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(Seminar.this,
                R.array.yes_no,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                b[3]=(String) adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Seminar.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });
        spin1.setAdapter(adapter);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                b[4] =(String) adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Seminar.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });
        spin2.setAdapter(adapter);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                b[5]=(String) adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Seminar.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });
        spin3.setAdapter(adapter);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                b[6]=(String) adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Seminar.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });
        spin4.setAdapter(adapter);
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                b[7]=(String) adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Seminar.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });
button3.setOnClickListener(new android.view.View.OnClickListener() {
    @Override
    public void onClick(android.view.View view) {

                b[0] =editText1.getText().toString();
                b[1]=editText2.getText().toString();
                b[2]=tdate.getText().toString();
                b[8]= String.valueOf(rate.getRating());
                a[0]=tview1.getText().toString();
                a[1]=tview2.getText().toString();
                a[2]=picDate.getText().toString();
                a[3]=tview0.getText().toString();
                a[4]=tview3.getText().toString();
                a[5]=tview4.getText().toString();
                a[6]=tview5.getText().toString();
                a[7]=tview6.getText().toString();
                a[8]=trate.getText().toString();

                if(TextUtils.isEmpty(b[0])){

                    editText1.setError("please,fill the details");
                    return;
                }
                if(TextUtils.isEmpty(b[1])){

                    editText2.setError("please,fill the details");
                    return;
                }
                if(TextUtils.isEmpty(b[2])){

                    tdate.setError("please,select the date");
                    return;
                }
               String t=tdate.getText().toString();
                String id=mref.push().getKey();
                for (i = 0; i <= 8; i++) {

                    Firebase mchi = mref.child(t).child(id).child(a[i]);
                    mchi.setValue(b[i]);
                }
                Intent s = new Intent(Seminar.this, Conclusion.class);
                startActivity(s);
                finish();

            }
        });

picDate.setOnClickListener(new android.view.View.OnClickListener() {
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(android.view.View view) {

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Seminar.this,
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
                tdate.setText(date);
            }
        };


    }
    }

