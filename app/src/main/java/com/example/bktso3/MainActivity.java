package com.example.bktso3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AnhXa(){
        listView = findViewById(R.id.languageLV);
    }
    public void InitialDatabase(){
        CreateOrOpenDatabase();
        CreateLanguageTable();
        CreateExampleTable();
        InsertDataToLanguageTable("1","Huy Cận","","5 sao");
        InsertDataToLanguageTable("2","Mạc Ngôn", "", "5 sao");
        InsertDataToExampleTable("1","Quê tôi","1");
        InsertDataToExampleTable("2", "Làng quê Sương", "1");
        InsertDataToExampleTable("3","Vườn hoa mùa thu","2");
    }
    public void CreateOrOpenDatabase(){
        database = openOrCreateDatabase("QuanLyNgonNgu.db",MODE_PRIVATE,null);
        if(database == null)
            System.out.println("CreateOrOpenDatabase false");
        else
            System.out.println("CreateOrOpenDatabase true");

    }
    public void CreateLanguageTable(){
        String sql =    "Create table Language(" +
                "   id TEXT PRIMARY KEY," +
                "   name TEXT," +
                "   moTa TEXT," +
                "   sao TEXT" +
                ")";
        database.execSQL(sql);
        if(sql == null)
            System.out.println("CreateLanguageTable false");
        else
            System.out.println("CreateLanguageTable true");
    }
    public void CreateExampleTable(){
        String sql =    "Create table Example(" +
                "   idEx TEXT PRIMARY KEY," +
                "   example TEXT," +
                "   idL TEXT not null constraint FK_EX_idL references Language(id) on delete cascade on update cascade" +
                ")";
        database.execSQL(sql);
        if(sql == null)
            System.out.println("CreateExampleTable false");
        else
            System.out.println("CreateExampleTable true");

    }
    public void InsertDataToLanguageTable(String id, String name,String moTa, String sao){
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("moTa", moTa);
        values.put("sao", sao);

        database.insert("Language",null, values );
        if(values == null)
            System.out.println("InsertDataToLanguageTable false");
        else
            System.out.println("InsertDataToLanguageTable true");
    }

    public void InsertDataToExampleTable(String idEx, String example, String idL){
        ContentValues values = new ContentValues();
        values.put("idEx", idEx);
        values.put("example", example);
        values.put("idL", idL);
        database.insert("Example",null, values);
        if(values == null)
            System.out.println("InsertDataToExampleTable false");
        else
            System.out.println("InsertDataToExampleTable true");
    }

    public void SetData(){
        Cursor cursor = database.query("Example",null, "idL = ? and example = ?", new String[]{"1","No Pain No Gain"},null,null,null);
        cursor.moveToFirst();
        String data = "";
        while (cursor.isAfterLast()==false){
            data += cursor.getString(0) + cursor.getString(1);
            cursor.moveToNext();
        }
        System.out.println(data);
    }
}