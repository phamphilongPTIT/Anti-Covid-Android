package com.e17cn2.anti_covid.model;

import com.google.gson.annotations.SerializedName;

public class Declaration {
    private int id;
    private String noiDi;
    @SerializedName("arrival_date") private String arrivalDate;
    @SerializedName("return_date") private String returnDate;
    private String destination;

    public Declaration(String  noiDi, String arrivalDate, String returnDate, String destination) {
        this.noiDi = noiDi;
        this.arrivalDate = arrivalDate;
        this.returnDate = returnDate;
        this.destination = destination;
    }

    public Declaration(int id, String noiDi, String arrivalDate, String returnDate, String destination) {
        this.id = id;
        this.noiDi = noiDi;
        this.arrivalDate = arrivalDate;
        this.returnDate = returnDate;
        this.destination = destination;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
