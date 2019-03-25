package com.example.gt.musyrif;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.Bindable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;

public class DetailSiswaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtSiswa, txtClass;
    String[] siswa;
    CheckBox mandi, makan, gantiBaju, seragam, sholat, merapihkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_siswa);
        Intent intent = getIntent();
        txtSiswa = findViewById(R.id.txtNamaS);
        txtSiswa.setText(intent.getStringExtra("nama"));
        mandi = (CheckBox) findViewById(R.id.mandi);
        makan = (CheckBox) findViewById(R.id.makan);
        gantiBaju = (CheckBox) findViewById(R.id.gantiBaju);
        seragam = (CheckBox) findViewById(R.id.seragam);
        sholat = (CheckBox) findViewById(R.id.sholat);
        merapihkan = (CheckBox)findViewById(R.id.merapihkan);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        if (preferences.getBoolean("checkbox1", false) == true) {
            mandi.setChecked(true);
        } else {
            mandi.setChecked(false);

        }
        mandi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mandi.isChecked()) {
                    editor.putBoolean("checkbox1", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox1", false);
                    editor.apply();
                }
            }
        });


        if (preferences.getBoolean("checkbox2", false) == true) {
            makan.setChecked(true);
        } else {
            makan.setChecked(false);

        }
        makan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (makan.isChecked()) {
                    editor.putBoolean("checkbox2", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox2", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox3", false) == true) {
            gantiBaju.setChecked(true);
        } else {
            gantiBaju.setChecked(false);

        }
        gantiBaju.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (gantiBaju.isChecked()) {
                    editor.putBoolean("checkbox3", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox3", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox4", false) == true) {
            seragam.setChecked(true);
        } else {
            seragam.setChecked(false);

        }
        seragam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (seragam.isChecked()) {
                    editor.putBoolean("checkbox4", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox4", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox5", false) == true) {
            sholat.setChecked(true);
        } else {
            sholat.setChecked(false);

        }
        sholat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sholat.isChecked()) {
                    editor.putBoolean("checkbox5", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox5", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox6", false) == true) {
             merapihkan.setChecked(true);
        } else {
            merapihkan.setChecked(false);

        }
        merapihkan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (merapihkan.isChecked()) {
                    editor.putBoolean("checkbox6", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox6", false);
                    editor.apply();
                }
            }
        });
    }




    public void resetAll(View view) {
        if (makan.isChecked()) {
            makan.setChecked(false);
        }
        if (mandi.isChecked()) {
            mandi.setChecked(false);
        }
        if (gantiBaju.isChecked()) {
            gantiBaju.setChecked(false);
        }
        if (seragam.isChecked()) {
            seragam.setChecked(false);
        }
        if (sholat.isChecked()) {
            sholat.setChecked(false);
        }
        if (merapihkan.isChecked()) {
            merapihkan.setChecked(false);
        }
    }

    public void onBack(View view) {
        onBackPressed();
    }

    @Override
    public void onClick(View v) {

    }
}
