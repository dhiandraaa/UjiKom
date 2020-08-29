package com.dcd.ujikom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSensor,btnLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvOutputNama = findViewById(R.id.tv_output_nama);
        btnSensor = findViewById(R.id.btn_sensor);
        btnLoc = findViewById(R.id.btn_location);

        Intent getNama = getIntent();
        String selamatDatang = getString(R.string.selamat_datang) + getNama.getStringExtra("nama");;
        tvOutputNama.setText(selamatDatang);
        btnSensor.setOnClickListener(this);
        btnLoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sensor :
                Intent sensor = new Intent(MainActivity.this, MobileSensorActivity.class);
                String sensorText = btnSensor.getText().toString();
                sensor.putExtra("sensor", sensorText);
                startActivity(sensor);
                break;
            case R.id.btn_location :
                Intent loc = new Intent(MainActivity.this, LocationActivity.class);
                startActivity(loc);
                break;
        }
    }
}