package com.androidlime.birthdayreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etn;
    private EditText etb;
    private Button btnv;
    private Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etn=(EditText)findViewById(R.id.etn);
        etb=(EditText)findViewById(R.id.etb);
        btns=(Button)findViewById(R.id.btns);
        btnv=(Button)findViewById(R.id.btnv);
        final DataBase ob=new DataBase(getApplicationContext());
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name=etn.getText().toString();
                        String day=etb.getText().toString();
                        ob.Insert(name,day);
                        Toast.makeText(getApplicationContext(),"Birthday Added Successfully",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        btnv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),ViewAll.class);
                        startActivity(i);
                    }
                }
        );
    }
}
