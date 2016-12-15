package com.example.imul.absenkuybaru;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FormAbsen extends Activity {

    EditText inputNama, inputTgl, inputNRP;
    private Button btnAbsen;
    private Spinner spinnerKyu;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.formabsen);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

        inputNama = (EditText) findViewById(R.id.namaAng);
        inputNRP = (EditText) findViewById(R.id.nrp);
        btnAbsen = (Button) findViewById(R.id.btnAbsen);
        spinnerKyu = (Spinner) findViewById(R.id.spinnerKyu);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);



        btnAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaAng = inputNama.getText().toString();
                String nrp = inputNRP.getText().toString();
                String kyu = spinnerKyu.getSelectedItem().toString();


                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                String status = radioButton.getText().toString();

                System.out.println(namaAng);
                System.out.println(kyu);
                System.out.println(nrp);
                System.out.println(status);


                if (!namaAng.equals("") && !nrp.equals("") && !kyu.equals("") && !status.equals("")) {
                    Absen absen = new Absen(namaAng, nrp, kyu, status);
                    loginDatabaseAdapter.createAbsen(absen);
                    Toast.makeText(getApplicationContext(), "Absensi berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
