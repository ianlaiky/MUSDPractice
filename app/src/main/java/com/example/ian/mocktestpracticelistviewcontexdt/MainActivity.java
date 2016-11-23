package com.example.ian.mocktestpracticelistviewcontexdt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.ArrayAdapter.createFromResource;

public class MainActivity extends AppCompatActivity {

    ListView li;
    ArrayAdapter<CharSequence> arr;
    ArrayAdapter<CharSequence> spArr;
    Menu myMenu;
    Button btn;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Listview set
        li = (ListView) findViewById(R.id.listt);
        //Spinner set
        sp = (Spinner) findViewById(R.id.spinner);

        //context menu assign to button
        btn = (Button) findViewById(R.id.btn);
        registerForContextMenu(btn);
        //end


        //Listview
        arr = createFromResource(this, R.array.lis, android.R.layout.simple_spinner_dropdown_item);
        li.setAdapter(arr);


        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), li.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //end Listview


        //Spinner
        spArr = createFromResource(this, R.array.spin, android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(spArr);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), sp.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //end spinner


    }

    //option menu
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu) {
        if (menu.getItemId() == R.id.t1) {
            this.myMenu.setGroupVisible(R.id.testt, false);


            Toast.makeText(getApplicationContext(), menu.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (menu.getItemId() == R.id.t2) {

            this.myMenu.setGroupVisible(R.id.testt, true);
            Toast.makeText(getApplicationContext(), menu.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (menu.getItemId() == R.id.s1) {
            Toast.makeText(getApplicationContext(), menu.getTitle(), Toast.LENGTH_SHORT).show();

        } else if (menu.getItemId() == R.id.s2) {
            Toast.makeText(getApplicationContext(), menu.getTitle(), Toast.LENGTH_SHORT).show();


        }else if(menu.getItemId()==R.id.quit){
            finish();
        }
        return true;
    }

    //end options

    //context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Action 1");
        menu.add(0, v.getId(), 0, "Action 2");
        menu.add(0, v.getId(), 0, "Action 3");
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Action 1") {
            Toast.makeText(this, "Action 1 invoked", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Action 2") {
            Toast.makeText(this, "Action 2 invoked", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Action 3") {
            Toast.makeText(this, "Action 3 invoked", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    //end context


}
