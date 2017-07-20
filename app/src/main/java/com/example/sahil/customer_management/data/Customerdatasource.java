package com.example.sahil.customer_management.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SAHIL on 04-07-2017.
 */
public class Customerdatasource {
    private Leaddbhelper leaddbhelper;
    Context c;
    ContentValues contentValues = new ContentValues();
    public Customerdatasource(Context context)
    {
        leaddbhelper = new Leaddbhelper(context);
        c=context;
    }

    public void updatesales(Lead lead, long sales)
    {
        SQLiteDatabase db = leaddbhelper.getWritableDatabase();
        contentValues.put(dbschema.Leadentry.Coulumn_total_sales,sales);
        db.update(dbschema.Leadentry.Table_name, contentValues, "_ID = " + dbschema.Leadentry._ID, null);
    }

    public void SaveLead(Lead lead)
    {
        SQLiteDatabase db = leaddbhelper.getWritableDatabase();

        contentValues.put(dbschema.Leadentry.Coulumn_name,lead.getName());
        contentValues.put(dbschema.Leadentry.Coulumn_address,lead.getAddress());
        contentValues.put(dbschema.Leadentry.Coulumn_phone,lead.getPhone());
        contentValues.put(dbschema.Leadentry.Coulumn_email,lead.getEmail());
        contentValues.put(dbschema.Leadentry.Coulumn_description,lead.getDescription());
        contentValues.put(dbschema.Leadentry.Coulumn_dob,lead.getDob());
        db.insert(dbschema.Leadentry.Table_name,null,contentValues);
        db.close();
    }
    public List<Lead> GetLead()
    {
        List<Lead> leads = new ArrayList<>();
        SQLiteDatabase db = leaddbhelper.getReadableDatabase();
        String[] projection = {
                dbschema.Leadentry._ID,
                dbschema.Leadentry.Coulumn_name,
                dbschema.Leadentry.Coulumn_company,
                dbschema.Leadentry.Coulumn_email,
                dbschema.Leadentry.Coulumn_phone,
                dbschema.Leadentry.Coulumn_address,
                dbschema.Leadentry.Coulumn_description,
                dbschema.Leadentry.Coulumn_dob
        };
        Cursor cursor = db.query(dbschema.Leadentry.Table_name,projection,null,null,null,null,"_ID DESC");
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                Long id = cursor.getLong(cursor.getColumnIndexOrThrow(dbschema.Leadentry._ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_name));
                String company = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_company));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_email));
                String address = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_address));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_phone));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_description));
                String dob = cursor.getString(cursor.getColumnIndexOrThrow(dbschema.Leadentry.Coulumn_dob));
                Lead lead = new Lead( dob, id ,name,email,phone,address,company,description);
                leads.add(lead);
            }
        }
        if (cursor!=null)
        {
            cursor.close();
        }
        db.close();
        return leads;
    }
    public void DeleteLead(long id)
    {

    }

}