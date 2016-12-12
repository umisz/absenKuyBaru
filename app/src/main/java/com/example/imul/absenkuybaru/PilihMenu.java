package com.example.imul.absenkuybaru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PilihMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_menu);

        Button formAbsensi = (Button) findViewById(R.id.formAbsensi);
        Button cekAbsen = (Button) findViewById(R.id.cekAbsen);

        formAbsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(PilihMenu.this, FormAbsen.class);
                startActivity(a);
            }
        });

        cekAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(PilihMenu.this, CekAbsensi.class);
                startActivity(b);
            }
        });
    }
}
