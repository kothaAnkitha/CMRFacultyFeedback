package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    private Button bt;
    private TextView textView4,textView5,textView6 ;
    private Spinner yearspinner,sectionspinner;
    String y,sec,sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle("Details");

        bt=(Button)findViewById(R.id.button3);
        yearspinner=(Spinner)findViewById(R.id.yearspinner);
        sectionspinner=(Spinner)findViewById(R.id.sectionspinner);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(Details.this,
                R.array.yearspinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearspinner.setAdapter(adapter);
        yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                y=(String) adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Details.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });

        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(Details.this,
                R.array.sectionspinner,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectionspinner.setAdapter(adapter2);
        sectionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                sec=(String)adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Details.this,"Please select any subject",Toast.LENGTH_LONG).show();

            }
        });
bt.setOnClickListener(new android.view.View.OnClickListener() {
    @Override
    public void onClick(android.view.View view) {
        if (y.equals("IV year")) {
            Intent i = new Intent(Details.this, Report.class);
             i.putExtra("year",y);
             i.putExtra("section", sec);
            startActivity(i);
        } else {
            if (y.equals("III year")) {
                Intent i = new Intent(Details.this, Thirdyearreport.class);
                i.putExtra("year",y);
                i.putExtra("section", sec);
                startActivity(i);
            } else {
                if (y.equals("II year")) {
                    Intent i = new Intent(Details.this, Secondyearreport.class);
                    i.putExtra("year",y);
                    i.putExtra("section", sec);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Details.this, Firstyearreport.class);
                    i.putExtra("year",y);
                    i.putExtra("section", sec);
                    startActivity(i);
                }
            }

        }
    }
        });
    }
}
