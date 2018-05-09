package com.programacion3.hypegeeks.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class DBController extends SQLiteOpenHelper {

    public DBController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Usuarios (_id INTEGER PRIMARY KEY AUTOINCREMENT, Usuario TEXT, Telefono INTEGER, Email TEXT,Punto TEXT, Password TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE Album (_id INTEGER PRIMARY KEY AUTOINCREMENT, Numero INTEGER, Pais TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE Figuritas (_id INTEGER PRIMARY KEY AUTOINCREMENT, Numero INTEGER, Usuario TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuarios;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Album;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Figuritas;");
        onCreate(sqLiteDatabase);
    }

    public boolean insertPersona(String username, String email, String password,String punto, int telefono) {

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Usuario", username);
            contentValues.put("Telefono", telefono);
            contentValues.put("Email", email);
            contentValues.put("Punto", punto);
            contentValues.put("Password", password);

            getWritableDatabase().insertOrThrow("Usuarios", null, contentValues);

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
   // public  boolean insertAlbum(String pais,int numero){
       // try {
            //ContentValues contentValues = new ContentValues();
           // contentValues.put("Numero", numero);
            //contentValues.put("Pais", pais);

          //  getWritableDatabase().insertOrThrow("Usuarios", null, contentValues);

        //} catch (SQLException e) {
         //   return false;
       // }

      //  return true;
    //}

    public List<DatosLogIn> selectUsuarioPassword() {
        List<DatosLogIn> usuarioList = new LinkedList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT Usuario,Password FROM Usuarios", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                usuarioList.add(new DatosLogIn(
                        cursor.getString(1),
                        cursor.getString(2)));
            }
        }
        return usuarioList;
    }

    public boolean updatePersona(String nombre, String apellido, String codigoUpb) {
        try {
            getWritableDatabase().execSQL("UPDATE Personas SET Nombre = '" + nombre + "', Apellido = '" + apellido + "' WHERE CodigoUpb = " + codigoUpb);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deletePersona(String codigoUpb) {
        try {
            getWritableDatabase().delete("Personas", "CodigoUpb = " + codigoUpb, null);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
