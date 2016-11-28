package com.example.imul.absenkuybaru;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends Login {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        final TextView txtNama = (TextView) findViewById(R.id.txtNama);
        final TextView txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        final Button btnLanjut = (Button) findViewById(R.id.btnLanjut);
    }
}
