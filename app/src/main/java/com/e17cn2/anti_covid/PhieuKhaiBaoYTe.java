package com.e17cn2.anti_covid;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

public class PhieuKhaiBaoYTe extends AppCompatActivity implements TextWatcher {
    private SQLiteDeclaration sqLiteDeclaration;
    private EditText txtPhone, txtNgayDi, txtNgayVe;
    private CheckBox cbSendKBYT;
    private AutoCompleteTextView txtDestination, txtNoiDi;
    private String[] list;
    private Button btSend;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kbyt);
        init();
        btSend.setEnabled(false);
        sqLiteDeclaration = new SQLiteDeclaration(this);
        txtNoiDi.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list));
        txtNoiDi.addTextChangedListener(this);
        txtDestination.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list));
        txtDestination.addTextChangedListener(this);


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
                        String phone = txtPhone.getText().toString();
                        String txtDateDi = txtNgayDi.getText().toString();
                        String txtDateVe = txtNgayVe.getText().toString();
                        String noiDen = txtDestination.getText().toString();
                        String noiDi = txtNoiDi.getText().toString();
                        Declaration declaration = new Declaration(phone,noiDi,txtDateDi, txtDateVe, noiDen);
                        sqLiteDeclaration.addDeclaration(declaration);
                    }catch (NumberFormatException e){
                        System.out.println(e + "");
                    }
                }
            }
        });
    }

    @SuppressLint("WrongViewCast")
    public void init(){

        txtPhone = findViewById(R.id.txtPhone);
        txtNgayDi = findViewById(R.id.txtNgayDi);
        txtNgayVe = findViewById(R.id.txtNgayVe);
        list=getResources().getStringArray(R.array.auto);
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
