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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e17cn2.anti_covid.model.Declaration;

import java.util.Calendar;

public class PhieuKhaiBaoYTe extends AppCompatActivity {
    private SQLiteDeclaration sqLiteDeclaration;
    private EditText txtNgayDi, txtNgayVe, txtDestination, txtNoiDi;
    private CheckBox cbSendKBYT;
    private Button btSend;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kbyt);
        init();
        btSend.setEnabled(false);
        sqLiteDeclaration = new SQLiteDeclaration(this);

        txtNgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenNgayDi();
            }
        });

        txtNgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenNgayVe();
            }
        });

        cbSendKBYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbSendKBYT.isChecked()){
                    btSend.setEnabled(true);

                    try {
                        String txtDateDi = txtNgayDi.getText().toString();
                        String txtDateVe = txtNgayVe.getText().toString();
                        String noiDen = txtDestination.getText().toString();
                        String noiDi = txtNoiDi.getText().toString();
                        Declaration declaration = new Declaration(noiDi,txtDateDi, txtDateVe, noiDen);
                        sqLiteDeclaration.addDeclaration(declaration);
                    }catch (NumberFormatException e){
                        System.out.println(e + "");
                    }
                }
            }
        });
    }

    public void init(){
        txtNgayDi = findViewById(R.id.txtNgayDi);
        txtNgayVe = findViewById(R.id.txtNgayVe);
        txtNoiDi = findViewById(R.id.txtDiemDi);
        txtDestination = findViewById(R.id.txtDiemDen);
        cbSendKBYT = findViewById(R.id.cbXacNhan);
        btSend = findViewById(R.id.btGuiKBYT);

    }

    private void chosenNgayDi(){

        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtNgayDi.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void chosenNgayVe(){

        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtNgayVe.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
}
