package com.example.imul.absenkuybaru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FormAbsen extends AppCompatActivity {

    EditText inputNama, inputKyu, inputTgl, inputNRP;
    private Button btnAbsen;
    private Spinner spinnerKyu;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formabsen);


        inputNama = (EditText) findViewById(R.id.namaAng);
        inputTgl = (EditText) findViewById(R.id.tglAbsen);
        inputNRP = (EditText) findViewById(R.id.nrp);
        btnAbsen = (Button) findViewById(R.id.btnAbsen);
        spinnerKyu = (Spinner) findViewById(R.id.spinnerKyu);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);


        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();


        btnAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaAng = inputNama.getText().toString();
                String nrp = inputNRP.getText().toString();
                String kyu = spinnerKyu.getSelectedItem().toString();
                String tglAbsen = inputTgl.getText().toString();
                String radioBtn = radioButton.getText().toString();
                System.out.println(radioBtn);


                System.out.println(namaAng);
                System.out.println(tglAbsen);


                if (!namaAng.equals("") && !kyu.equals("") && !tglAbsen.equals("")) {

                    //loginDatabaseAdapter.addProduct(namaAng, nrp, kyu, radioBtn, tglAbsen);
                    Toast.makeText(getApplicationContext(), "Absensi berhasil"
                            + "\n Spinner Kyu : " + kyu + "\n Status : " + radioBtn, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
