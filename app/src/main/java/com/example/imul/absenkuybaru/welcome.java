package com.example.imul.absenkuybaru;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {


    LoginDataBaseAdapter loginDatabaseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        loginDatabaseAdapter = new LoginDataBaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();



        final TextView txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        final Button btnLanjut = (Button) findViewById(R.id.btnLanjut);
        final TextView txtNama = (TextView) findViewById(R.id.txtNama);
        txtNama.setText(loginDatabaseAdapter.getUsername());

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "Ntaps";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });


    }
}
