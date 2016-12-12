package com.example.imul.absenkuybaru;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CekAbsensiTgl extends AppCompatActivity {
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_absensi_tgl);
        Button btnCekAbsenTgl = (Button) findViewById(R.id.btnCekAbsenTgl);
        final EditText inputTgl = (EditText) findViewById(R.id.inputTgl);
        final TextView txtAbsenTgl = (TextView) findViewById(R.id.txtAbsenTgl);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();
        txtAbsenTgl.setMovementMethod(new ScrollingMovementMethod());

        btnCekAbsenTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tgl = inputTgl.getText().toString();
                Cursor c = loginDatabaseAdapter.getJumlah(tgl);
                if(c.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "Error, nothing found", Toast.LENGTH_SHORT).show();
                    txtAbsenTgl.setText("Not found");
                    return;
                }

                StringBuffer sb1 = new StringBuffer();

                while (c.moveToNext()) {
                    sb1.append("ID Absen : " + c.getString(0) + "\n");
                    sb1.append("Nama : " + c.getString(1) +"\n");
                    sb1.append("NRP : " + c.getString(2) +"\n");
                    sb1.append("KYU : " + c.getString(3) +"\n");
                    sb1.append("Status : " + c.getString(4) +"\n");
                    sb1.append("Waktu Absen : " + c.getString(5) +"\n");

                    txtAbsenTgl.setText(sb1);

                }
            }
        });
    }
}
