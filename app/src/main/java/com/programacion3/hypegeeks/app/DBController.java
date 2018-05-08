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
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuarios;");
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

    public List<Usuario> selectAllPersonas() {
        List<Usuario> personList = new LinkedList<>();

        return personList;
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
