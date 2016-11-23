package com.example.ian.mocktestpracticelistviewcontexdt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.ArrayAdapter.createFromResource;

public class MainActivity extends AppCompatActivity {

    ListView li;
    ArrayAdapter<CharSequence> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li = (ListView) findViewById(R.id.listt);

        arr = createFromResource(this, R.array.lis, android.R.layout.simple_spinner_dropdown_item);
        li.setAdapter(arr);


        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), li.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
