package cmr.facultyfeedback.ankisami.cmrfacultyfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLoginActivity extends AppCompatActivity {
    private Button button;
    private EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        setTitle("loginActivity");
        editText4=(EditText)findViewById(R.id.editText4);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et=editText4.getText().toString();
                if(TextUtils.isEmpty(et)){
                    editText4.setError("please fill the field");
                    return;

                }
                if(et.equals("srujanraju")){

                    Intent intent=new Intent(AdminLoginActivity.this,Select.class);
                    startActivity(intent);
                    finish();
                }else{
                    editText4.setError("Enter correct password");
                }

            }
        });

    }
}
