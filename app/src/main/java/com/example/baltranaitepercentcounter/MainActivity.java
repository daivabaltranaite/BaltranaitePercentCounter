package com.example.baltranaitepercentcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView result;
    private TextView tipValue;
    private SeekBar seekBar;
    private TextView seekBarName;
    private TextView total;

    private void onChange() {
        String nuolaida = seekBar.getProgress() + "%";
        seekBarName.setText(nuolaida);
        String suma = input.getText().toString();
        double sumaSuNuolaida = Integer.parseInt(suma) * (100 - seekBar.getProgress()) / 100.0;
        result.setText("Įvesta suma: " + suma + "\n" + "Pritaikyta nuolaida: " + nuolaida + "\n Suma su nuolaida: " + sumaSuNuolaida);
        tipValue.setText(nuolaida);
        total.setText(Double.toString(sumaSuNuolaida));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        result = findViewById(R.id.result);
        tipValue = findViewById(R.id.tipValue);
        seekBar = findViewById(R.id.seekBar);
        total = findViewById(R.id.totalValue);
        seekBarName = findViewById(R.id.seekBarName);

        input.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onChange();
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                onChange();
            }
        });
    }
}
