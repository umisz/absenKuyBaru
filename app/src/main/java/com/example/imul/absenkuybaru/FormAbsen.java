package com.example.imul.absenkuybaru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormAbsen extends AppCompatActivity {

    EditText inputNama, inputKyu, inputTgl;
    Button btnAbsen;
    MyDBHandler myDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formabsen);

        inputNama = (EditText) findViewById(R.id.namaAng);
        inputKyu = (EditText) findViewById(R.id.kyu);
        inputTgl = (EditText) findViewById(R.id.tglAbsen);
        btnAbsen = (Button) findViewById(R.id.btnAbsen);
        myDBHandler = new MyDBHandler(this, null, null,1);


        btnAbsen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String namaAng = inputNama.getText().toString();
                String kyu = inputKyu.getText().toString();
                String tglAbsen = inputTgl.getText().toString();
                System.out.println(namaAng);
                System.out.println(kyu);
                System.out.println(tglAbsen);
                if(!namaAng.equals("") && !kyu.equals("") && !tglAbsen.equals("")) {
                    //METHOD YG INI GAK BISA DIAPA2IN (GAK NGARUH) KALO DITEKAN
                    Absen absen = new Absen(namaAng, kyu, tglAbsen);
                    myDBHandler.addProduct(absen);
                    Toast.makeText(getApplicationContext(), "Absensi berhasil", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
