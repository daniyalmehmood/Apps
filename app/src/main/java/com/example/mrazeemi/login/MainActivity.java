package com.example.mrazeemi.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText name;
    private EditText pass;
    private TextView info;
    private Button btn;
    int   counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            name = (EditText)findViewById(R.id.etname);
            pass = (EditText)findViewById(R.id.etpass);
            btn = (Button)findViewById(R.id.btn);
            info =(TextView)findViewById(R.id.text);
            info.setText("No. of attempts: " +String.valueOf(counter));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),pass.getText().toString());
            }
        });

    }

    private void validate(String UserName, String Password){
        if((UserName.equals("admin") ) && (Password.equals("1234"))){
            Intent i= new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
        }
        else{
            counter --;
            info.setText("No of Attempts remaining: " +String.valueOf(counter));
            if (counter== 0) {
                btn.setEnabled(false);
            }

        }
    }


}
