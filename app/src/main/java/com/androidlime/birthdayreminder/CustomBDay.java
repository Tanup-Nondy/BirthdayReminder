package com.androidlime.birthdayreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomBDay extends AppCompatActivity {
    private EditText et;
    private Button up;
    private Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_bday);
        et=(EditText)findViewById(R.id.editText);
        del=(Button)findViewById(R.id.delete);
        up=(Button)findViewById(R.id.update);
        final DataBase ob=new DataBase(getApplicationContext());
        final int pos=getIntent().getIntExtra("key",999);
        et.setText(ob.getDay(pos+3));
        et.setSelection(et.getText().length());
        up.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ob.Update(pos+3,et.getText().toString());
                        Toast.makeText(getApplicationContext(),"Birthday Updated Successfully",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        del.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ob.Delete(et.getText().toString());
                        Toast.makeText(getApplicationContext(),"Birthday Deleted Successfully",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
