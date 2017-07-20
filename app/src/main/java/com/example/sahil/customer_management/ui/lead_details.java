package com.example.sahil.customer_management.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sahil.customer_management.R;
import com.example.sahil.customer_management.data.Lead;

public class lead_details extends Activity {

    public static final String KEY= "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_details);
        try {
            Lead lead = getIntent().getParcelableExtra(KEY);
            TextView idView = (TextView) findViewById(R.id.lead_details_id);
            TextView nameView = (TextView) findViewById(R.id.lead_details_name);
            TextView companyView = (TextView) findViewById(R.id.lead_details_company);
            TextView emailView = (TextView) findViewById(R.id.lead_details_email);
            TextView phoneView = (TextView) findViewById(R.id.lead_details_phone);
            TextView dobView = (TextView) findViewById(R.id.lead_details_dob);
            TextView descriptionView = (TextView) findViewById(R.id.lead_details_description);


            idView.setText(String.valueOf(lead.getTotal_sales()) );
            nameView.setText(lead.getName());
            emailView.setText(lead.getEmail());
            companyView.setText(lead.getCompany());
            phoneView.setText(lead.getPhone());
            descriptionView.setText(lead.getDescription());
            dobView.setText(lead.getDob());
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }
}
