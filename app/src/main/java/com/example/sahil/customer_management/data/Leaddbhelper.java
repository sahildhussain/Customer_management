package com.example.sahil.customer_management.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sahil.customer_management.ui.MainActivity;

/**
 * Created by SAHIL on 16-07-2017.
 */
public class Leaddbhelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lead.db";
    private static final String COMMA_SEP = ",";
    Context c;
    private static final String Create_Table =
            "CREATE TABLE " + dbschema.Leadentry.Table_name+" ("+
                    dbschema.Leadentry._ID + " INTEGER PRIMARY KEY "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_name + " TEXT "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_company+ " CHAR(25) "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_phone+ " TEXT "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_email + " TEXT "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_dob + " DATE "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_address + " TEXT "+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_description + " TEXT"+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_positive_result+ " INTEGER"+ COMMA_SEP +
                    dbschema.Leadentry.Coulumn_zero_result+ " INTEGER"+ COMMA_SEP+
                    dbschema.Leadentry.Coulumn_total_sales+ " INTEGER);"
            ;
    private static final String Delete_Table =
            "DROP TABLE " + dbschema.Leadentry.Table_name;


    public Leaddbhelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Table);
        Toast.makeText(c,"Table Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Delete_Table);
        onCreate(db);
    }
}
