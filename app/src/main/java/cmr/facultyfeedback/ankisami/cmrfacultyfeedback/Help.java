package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().setTitle("HELP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
