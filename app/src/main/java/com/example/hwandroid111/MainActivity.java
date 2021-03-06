package com.example.hwandroid111;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        initList();
    }

    private void initList() {
        ListView listView = findViewById(R.id.list_view);
        final List<DataItems> dataItemsList = new ArrayList<>();

        dataItemsList.add(new DataItems("Записная книжка", "Из задания № 2.2.1",
                R.drawable.note_background, false));
        dataItemsList.add(new DataItems("Календарь", "Из задания № 2.1.3",
                R.drawable.calendar_background, false));
        dataItemsList.add(new DataItems("Адресс", "Из задания № 2.1.2",
                R.drawable.address_background, false));
        dataItemsList.add(new DataItems("Настройки", "Из задания № 2.2.2",
                R.drawable.settings_background, false));

        final DataItemsAdapter dataItemsAdapter = new DataItemsAdapter(dataItemsList, this);
        listView.setAdapter(dataItemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(MainActivity.this, R.string.txtOpenNote, Toast.LENGTH_LONG).show();

                    Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
                    startActivity(intentNotes);



                } else if (position == 1) {
                    Toast.makeText(MainActivity.this, R.string.txtOpenAddress, Toast.LENGTH_LONG).show();

                    Intent intentAddress = new Intent(MainActivity.this, AddressActivity.class);
                    startActivity(intentAddress);



                } else if (position == 2) {
                    Toast.makeText(MainActivity.this, R.string.txtOpenCalendar, Toast.LENGTH_LONG).show();

                    Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intentCalendar);



                } else if (position == 3) {
                    Toast.makeText(MainActivity.this, R.string.txtOpenSettings, Toast.LENGTH_LONG).show();


                }
            }
        });
    }


}
