package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Branch extends AppCompatActivity {

    private Button mcse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        setTitle("Branch");
        mcse=(Button)findViewById(R.id.cse);
        final String rollnum=getIntent().getExtras().getString("roll");
        mcse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Branch.this,YearActivity.class);
                mainIntent.putExtra("roll",rollnum);
                startActivity(mainIntent);
                finish();

            }
        });

    }
}
