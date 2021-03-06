package com.example.imul.absenkuybaru;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.Toast;


public class CekAbsensiNRP extends Activity {

    Button btnCekAbsenNrp;
    EditText etNRP;
    TextView txtNamaa;
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_absen_nrp);

        btnCekAbsenNrp = (Button) findViewById(R.id.btnCekAbsenNrp);
        etNRP = (EditText) findViewById(R.id.etNrp);
        txtNamaa = (TextView) findViewById(R.id.namaAbsensi);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

        btnCekAbsenNrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nrp = etNRP.getText().toString();
                Cursor c = loginDatabaseAdapter.getDetails(nrp);
                if(c.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "Error, nothing found", Toast.LENGTH_SHORT).show();
                    txtNamaa.setText("Not Found");
                    return;
                }

                StringBuffer sb1 = new StringBuffer();

                while (c.moveToNext()) {
                    sb1.append("ID Absen : " + c.getString(0) + "\n");
                    sb1.append("Nama : " + c.getString(1) +"\n");
                    sb1.append("NRP : " + c.getString(2) +"\n");
                    sb1.append("KYU : " + c.getString(3) +"\n");
                    sb1.append("Status : " + c.getString(4) +"\n");
                    sb1.append("Waktu Absen : " + c.getString(5) +"\n \n");

                    txtNamaa.setText(sb1);

                }

            }
        });

    }
}
