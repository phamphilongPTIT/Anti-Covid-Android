package com.e17cn2.anti_covid;

import com.e17cn2.anti_covid.model.Declaration;

import retrofit2.http.GET;

public interface CallApi {

    @GET("/api/v1/declarations/")
    Declaration getQrcode();

}
