package com.e17cn2.anti_covid;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PhieuKhaiBaoYTe extends AppCompatActivity {

    private EditText txtNgayDi, txtNgayVe;
    private CheckBox cbSendKBYT;
    private Button btSend;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kbyt);
        init();
        btSend.setEnabled(false);

        txtNgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenDay();
            }
        });

        txtNgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenDay();
            }
        });

        cbSendKBYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbSendKBYT.isChecked()){
                    btSend.setEnabled(true);
                }
            }
        });
    }

    public void init(){
        txtNgayDi = findViewById(R.id.txtNgayDi);
        txtNgayVe = findViewById(R.id.txtNgayVe);
        cbSendKBYT = findViewById(R.id.cbXacNhan);
        btSend = findViewById(R.id.btGuiKBYT);
    }

    private void chosenDay(){

        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtNgayDi.setText(dayOfMonth+"/"+month+"/"+year);
                txtNgayVe.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
}
