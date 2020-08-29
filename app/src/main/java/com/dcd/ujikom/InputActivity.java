package com.dcd.ujikom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final TextView tvInputNama = findViewById(R.id.tv_input_nama);
        Button btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tvInputNama.getText().toString();
                Intent sendNama = new Intent(InputActivity.this, MainActivity.class);
                sendNama.putExtra("nama", nama);
                startActivity(sendNama);
            }
        });
    }
}