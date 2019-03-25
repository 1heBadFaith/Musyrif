package com.example.gt.musyrif;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import com.github.clans.fab.FloatingActionButton;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {
    private MaterialSpinner spinkelas;
    private RecyclerView listsiswa;
    String[] siswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.task);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TaskHome.class));
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.jadwal);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, JadwalKBMActivity.class));
            }
        });

        spinkelas = findViewById(R.id.spinKelas);
        listsiswa = findViewById(R.id.lvNamaSiswa);
        listsiswa.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listsiswa.setLayoutManager(layoutManager);

        //ArrayList<String> siswa = new ArrayList<ytytbee                                                                                  >();
        ArrayAdapter<CharSequence> kelasAdapter = ArrayAdapter
                .createFromResource(this, R.array.kelas,
                        android.R.layout.simple_spinner_item);
        kelasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinkelas.setAdapter(kelasAdapter);
        spinkelas.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                switch (position) {
                    case 0 :
                        siswa = getResources().getStringArray(R.array.kelas8);
                        tampildata(siswa);
                        break;

                    case 1 :
                        siswa = getResources().getStringArray(R.array.kelas7a);
                        tampildata(siswa);
                        break;

                    case 2:
                        siswa = getResources().getStringArray(R.array.kelas7b);
                        tampildata(siswa);
                        break;

                    case 3:
                        siswa = getResources().getStringArray(R.array.kelas7c);
                        tampildata(siswa);
                        break;

                    case 4:
                        siswa = getResources().getStringArray(R.array.kelas7d);
                        tampildata(siswa);
                        break;
                }
            }
        });

        listsiswa.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {

                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(child);
                    Intent myIntent = new Intent(MainActivity.this, DetailSiswaActivity.class);
                    myIntent.putExtra("nama", siswa[position]);
                    startActivity(myIntent);

                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }



    private void tampildata(String[] data) {
        KelasAdapter adapter = new KelasAdapter(data);
        listsiswa.setAdapter(adapter);
    }


}
