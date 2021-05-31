package com.e17cn2.anti_covid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.e17cn2.anti_covid.model.Declaration;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDeclaration extends SQLiteOpenHelper {

    private static final String DB_NAME = "AnticovidDB.db";
    private static final int DB_VERSION = 1;

    public SQLiteDeclaration(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE declarations(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "arrivalDate TEXT," +
                "returnDate TEXT," +
                "destination TEXT," +
                "noiDi TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addDeclaration(Declaration declaration){
        String sql = "INSERT INTO declarations(arrivalDate,returnDate,destination,noiDi) VALUES(?,?,?,?)";
        String[] args = {declaration.getArrivalDate(),declaration.getReturnDate(),declaration.getDestination(), declaration.getNoiDi()};
        SQLiteDatabase statement = getWritableDatabase();
        statement.execSQL(sql, args);
    }

    public List<Declaration> getAllDeclaration(){
        List<Declaration> declarations = new ArrayList<>();
        SQLiteDatabase statement = getReadableDatabase();
        Cursor resultSet = statement.query("declarations", null, null, null, null, null, null);
        while (resultSet != null && resultSet.moveToNext()){
            int id = resultSet.getInt(0);
            String arrivalDate = resultSet.getString(1);
            String returnDate = resultSet.getString(2);
            String destination = resultSet.getString(3);
            String noiDi = resultSet.getString(4);
            declarations.add(new Declaration(id,noiDi,arrivalDate,returnDate,destination));
        }
        return declarations;
    }

//    public Declaration getOrderById(int id){
//        String whereClause = "id = ?";
//        String[] whereArgs = {String.valueOf(id)};
//        SQLiteDatabase statement = getReadableDatabase();
//        Cursor resultSet = statement.query("orders", null, whereClause, whereArgs, null, null, null);
//        if (resultSet.moveToNext()){
//            String name = resultSet.getString(1);
//            double price = resultSet.getDouble(2);
//            int quantity = resultSet.getInt(3);
//            String dateOrders = resultSet.getString(4);
//
//            return new Order(id, name,price, quantity,dateOrders);
//        }
//        return null;
//    }
//
//    public int update(Order order){
//        ContentValues values = new ContentValues();
//        values.put("itemName", order.getItemName());
//        values.put("price", order.getPrice());
//        values.put("quantity", order.getQuantity());
//        values.put("dateOrder", order.getDateOrder());
//        String whereClause = "id = ?";
//        String[] whereArgs = {String.valueOf(order.getId())};
//        SQLiteDatabase statement = getWritableDatabase();
//        return statement.update("orders", values, whereClause, whereArgs);
//    }
//
//    public int deleteById(int id){
//        String whereClause = "id = ?";
//        String[] whereArgs = {String.valueOf(id)};
//        SQLiteDatabase statement = getWritableDatabase();
//        return statement.delete("orders", whereClause, whereArgs);
//    }

    public List<Declaration> getListDeclarationByName(String textSearch){
        List<Declaration> declarations = new ArrayList<>();
        String whereClause = "destination LIKE ?";
        String[] whereArgs = {"%" + textSearch + "%"};
        SQLiteDatabase statement = getReadableDatabase();
        Cursor cursor = statement.query("declarations", null, whereClause, whereArgs, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String arrivalDate = cursor.getString(1);
            String returnDate = cursor.getString(2);
            String destination = cursor.getString(3);
            String noiDi = cursor.getString(4);


            declarations.add(new Declaration(id,noiDi,arrivalDate,returnDate,destination));
        }
        cursor.close();
        return declarations;
    }

}
