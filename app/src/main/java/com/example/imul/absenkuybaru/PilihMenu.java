package com.example.imul.absenkuybaru;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class PilihMenu extends Activity {
    LoginDatabaseAdapter loginDatabaseAdapter;
    LoginBaru loginBaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

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
                Intent b = new Intent(PilihMenu.this, CekAbsen.class);
                startActivity(b);
            }
        });
    }
}
