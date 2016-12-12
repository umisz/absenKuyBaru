package com.example.imul.absenkuybaru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CekAbsen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_absen);

        Button btnNrp = (Button) findViewById(R.id.btnNrp);
        Button btnTgl = (Button) findViewById(R.id.btnTgl);

        btnNrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(CekAbsen.this, CekAbsensiNRP.class);
                startActivity(a);
            }
        });

        btnTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(CekAbsen.this, CekAbsensiTgl.class);
                startActivity(b);
            }
        });
    }
}
