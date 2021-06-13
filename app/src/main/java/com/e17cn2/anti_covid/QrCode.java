package com.e17cn2.anti_covid;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class QrCode extends AppCompatActivity {

    private ImageView imgQrCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        init();
    }

    private void init(){
         imgQrCode = (ImageView) findViewById(R.id.imgQrCode);

        Glide.with(this).load("http://api.qrserver.com/v1/create-qr-code/?data=Nguyễn Văn Hoàng%0ASĐT:0989898989%0A" +
                "Mũi 1: Astrazeneca%0AMũi 1: Astrazeneca%0AĐịa điểm: Bệnh Viện 103&size=200x200").into(imgQrCode);
    }

}
