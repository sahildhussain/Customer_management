package com.example.sahil.customer_management.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahil.customer_management.R;
import com.example.sahil.customer_management.data.Customerdatasource;
import com.example.sahil.customer_management.data.Lead;

import java.util.Calendar;


public class input_lead extends Activity {

    private Customerdatasource customerdatasource;
    private EditText editname;
    private EditText editcompany;
    private EditText editmail;
    private EditText editphone;
    private EditText editaddress;
    private EditText editdob;
    private EditText editdescription;
    int day,month,birthyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_lead);

        customerdatasource=new Customerdatasource(this);
        editname = (EditText) findViewById(R.id.edit_name);
        editaddress = (EditText) findViewById(R.id.edit_address);
        editcompany = (EditText) findViewById(R.id.edit_company);
        editmail = (EditText) findViewById(R.id.edit_email);
        editdob =(EditText) findViewById(R.id.edit_dob);
        editphone = (EditText) findViewById(R.id.edit_phone);
        editdescription = (EditText) findViewById(R.id.editdescription);
        editdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar dob = Calendar.getInstance();
                day = dob.get(Calendar.DAY_OF_MONTH);
                month = dob.get(Calendar.MONTH);
                birthyear = dob.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(input_lead.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        day = dayOfMonth;
                        birthyear = year;
                        month = monthOfYear+1;
                        if (day<10){
                            if(month<10)
                            editdob.setText("0"+day+"/0"+month+"/"+year);
                            else
                                editdob.setText("0"+day+"/"+month+"/"+year);
                        }
                        else
                        {
                            if(month<10)
                                editdob.setText(day+"/0"+month+"/"+year);
                            else
                                editdob.setText(day+"/"+month+"/"+year);
                        }
                    }
                },birthyear,month,day);
                datePickerDialog.setTitle("Date Of Birth");
                datePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_input_lead, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.done:
                try {
                    savedata();
                    setResult(RESULT_OK);
                    finish();
                    Toast.makeText(this,"finish()",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void savedata()
    {
        String name = editname.getText().toString();
        String email = editmail.getText().toString();
        String address = editaddress.getText().toString();
        String phone = editphone.getText().toString();
        String company = editcompany.getText().toString();
        String description = editdescription.getText().toString();
        String dob = editdob.getText().toString();
        Lead lead = new Lead(dob,name,email,phone,address,company,description);
        customerdatasource.SaveLead(lead);
        Toast.makeText(this,"Lead Added",Toast.LENGTH_SHORT).show();
    }
}
