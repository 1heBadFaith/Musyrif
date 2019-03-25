package com.example.gt.musyrif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class JadwalKBMActivity extends AppCompatActivity {
    private MaterialSpinner spinkelas;
    private RecyclerView listjadwal;
    String[] jadwal, jam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_kbm);
        spinkelas = findViewById(R.id.spinKelas);
        listjadwal = findViewById(R.id.lvNamaKBM);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listjadwal.setLayoutManager(layoutManager);

        //ArrayList<String> siswa = new ArrayList<ytytbee                                                                                  >();
        ArrayAdapter<CharSequence> kelasAdapter = ArrayAdapter
                .createFromResource(this ,R.array.kelasblajar,
                        android.R.layout.simple_spinner_item);
        kelasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinkelas.setAdapter(kelasAdapter);
        spinkelas.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                switch (position) {
                    case 0 :
                        jadwal = getResources().getStringArray(R.array.jadwalkelas2);
                        jam = getResources().getStringArray(R.array.jamkelas2);
                        tampildata(jadwal);
                        break;

                    case 1 :
                        jadwal = getResources().getStringArray(R.array.jadwalkelasAA);
                        jam = getResources().getStringArray(R.array.jamkelasAA);
                        tampildata(jadwal);
                        break;

                    case 2:
                        jadwal = getResources().getStringArray(R.array.jadwalkelasUBK);
                        jam = getResources().getStringArray(R.array.jamkelasUBK);
                        tampildata(jadwal);
                        break;

                    case 3:
                        jadwal = getResources().getStringArray(R.array.jadwalkelasUBA);
                        jam = getResources().getStringArray(R.array.jamkelasUBA);
                        tampildata(jadwal);
                        break;

                }
            }
        });

        listjadwal.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {

                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)){
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
        JadwalAdapter Jadapter = new JadwalAdapter(data);
        listjadwal.setAdapter(Jadapter);
    }
}

