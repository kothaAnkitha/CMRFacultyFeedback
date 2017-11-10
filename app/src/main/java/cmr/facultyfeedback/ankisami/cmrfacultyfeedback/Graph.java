package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Graph extends AppCompatActivity {
    float b[] = new float[10];

    String name[]={"LP","CC","DP","DWDM","MC","IRS","DWDM LAB","LINUX LAB"};
    String second[]={"M-IV","DS through C++","MFCS","DLD","OOP through java","DS LAB","IT WORKSHOP","JAVA LAB","ES"};
    String third[]={"PPL","SE","CD","OS","OS LAB","CD LAB","CN","IPR"};
    String first[]={"M-I","EC","EP-I","PCE","EM","BEE","ENGLISH LAB","E WORKSHOP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piereport);
        Firebase.setAndroidContext(this);
        final String yr=getIntent().getExtras().getString("year");

        b[0]= Float.parseFloat(getIntent().getExtras().getString("percentage"));
        b[1]= Float.parseFloat(getIntent().getExtras().getString("cc"));
        b[2]= Float.parseFloat(getIntent().getExtras().getString("dp"));
        b[3]= Float.parseFloat(getIntent().getExtras().getString("dwdm"));
        b[4]= Float.parseFloat(getIntent().getExtras().getString("mc"));
        b[5]= Float.parseFloat(getIntent().getExtras().getString("irs"));
        b[6]= Float.parseFloat(getIntent().getExtras().getString("dl"));
        b[7]= Float.parseFloat(getIntent().getExtras().getString("ll"));
        if(yr.equals("II year")) {

            b[8] = Float.parseFloat(getIntent().getExtras().getString("opt"));
        }

        List<PieEntry> entry=new ArrayList<>();

       if(yr.equals("IV year")){
        for(int i=0;i<=7;i++) {
            entry.add(new PieEntry(b[i], name[i]));
          }
        }else{
            if(yr.equals("III year")){
                for(int i=0;i<=7;i++) {
                    entry.add(new PieEntry(b[i], third[i]));
                }
            }else{
                if(yr.equals("II year")){
                    for(int i=0;i<=8;i++) {
                        entry.add(new PieEntry(b[i], second[i]));
                    }
                }else{
                    if(yr.equals("I year")){
                        for(int i=0;i<=7;i++) {
                            entry.add(new PieEntry(b[i], first[i]));
                        }

                    }else{
                        Toast.makeText(Graph.this, "No Graph", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

      PieDataSet set=new PieDataSet(entry,"subjects");
        set.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData dta=new PieData(set);
        dta.setValueTextSize(35f);
        PieChart chart=(PieChart)findViewById(R.id.pie);
        chart.setData(dta);
        chart.setCenterTextSize(20);
        chart.setCenterTextSizePixels(20);
        chart.animateY(1000);
        chart.invalidate();
    }
}
