package com.example.myanimalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.myanimalapp.AnimalDatabaseContract.COLUMN_ID;
import static com.example.myanimalapp.AnimalDatabaseContract.COLUMN_NAME;
import static com.example.myanimalapp.AnimalDatabaseContract.COLUMN_SOUND;
import static com.example.myanimalapp.AnimalDatabaseContract.COLUMN_TYPE;
import static com.example.myanimalapp.AnimalDatabaseContract.DATABASE_NAME;
import static com.example.myanimalapp.AnimalDatabaseContract.DATABASE_VERSION;
import static com.example.myanimalapp.AnimalDatabaseContract.TABLE_NAME;
import static com.example.myanimalapp.AnimalDatabaseContract.getWhereClauseById;

public class AnimalDatabaseHelper extends SQLiteOpenHelper {


    public AnimalDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(AnimalDatabaseContract.createQuery());


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long InsertAnimalIntoDatabase(@NonNull Animal animal) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_TYPE, animal.getType());
        contentValues.put(COLUMN_NAME, animal.getName());
        contentValues.put(COLUMN_SOUND, animal.getSound());

        return writableDatabase.insert(TABLE_NAME, null, contentValues);
    }
    public ArrayList<Animal> getAllAnimalsFromDatabse() {
        ArrayList<Animal> returnAnimalList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery
                (AnimalDatabaseContract.getAllAnimalsQuery(),null);

        if(cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String sound = cursor.getString(cursor.getColumnIndex(COLUMN_SOUND));

                returnAnimalList.add(new Animal(type, name, sound, id));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return returnAnimalList;

    }
public Animal getAnimalById(int id) {
    SQLiteDatabase readableDatabase = this.getReadableDatabase();

    Animal returnAnimal = new Animal();

    Cursor cursor = readableDatabase.rawQuery
            (AnimalDatabaseContract.getOneAnimalById(id), null);

    if (cursor.moveToFirst()) {
        int idFromDB = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
        String type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE));
        String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
        String sound = cursor.getString(cursor.getColumnIndex(COLUMN_SOUND));

        returnAnimal = new Animal(type, name, sound, idFromDB);

    }

    cursor.close();

    return returnAnimal;
}

public long updateAnimalInDatabase(@NonNull Animal newAnimalInfo) {
SQLiteDatabase writableDatabase = this.getWritableDatabase();
ContentValues contentValues = new ContentValues();

contentValues.put(COLUMN_TYPE, newAnimalInfo.getType());
contentValues.put(COLUMN_NAME, newAnimalInfo.getType());
contentValues.put(COLUMN_SOUND, newAnimalInfo.getSound());

return writableDatabase.update(TABLE_NAME, contentValues,
        getWhereClauseById(), new String[]{String.valueOf(newAnimalInfo.getId())});

 }

}

