package com.androidlime.birthdayreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewAll extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        lv=(ListView)findViewById(R.id.lv);
        DataBase ob=new DataBase(getApplicationContext());
        String[] data=ob.show();
        lv.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.listview,R.id.tv,data));
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i=new Intent(getApplicationContext(),CustomBDay.class);
                        i.putExtra("key",position);
                        startActivity(i);
                    }
                }
        );
    }
}
