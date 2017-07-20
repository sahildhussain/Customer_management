package com.example.sahil.customer_management.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import com.example.sahil.customer_management.R;
import com.example.sahil.customer_management.data.Customerdatasource;
import com.example.sahil.customer_management.data.Lead;


public class lead_list extends Activity {
    RecyclerView recyclerView;
    CustomerListAdapter customerListAdapter;
    Customerdatasource customerdatasource;
    private List<Lead> leadList;
    int NODE_FINAL_INT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_list);
        try{
        ImageButton add_lead = (ImageButton) findViewById(R.id.add_button);
        add_lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addlead();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        customerdatasource = new Customerdatasource(this);
        leadList = customerdatasource.GetLead();
        customerListAdapter = new CustomerListAdapter(leadList, new OnLeadSelectedListener() {
            @Override
            public void onleadselected(Lead lead) {
                try{    Intent intent = new Intent(lead_list.this,lead_details.class);
                    intent.putExtra(lead_details.KEY,lead);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    Toast.makeText(lead_list.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onsalesadded(final Lead lead) {
            try {

                LayoutInflater li = LayoutInflater.from(lead_list.this);
                View promptsView = li.inflate(R.layout.dialoguesales, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        lead_list.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.inputtext);
                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
                                        long total_sales;
                                        try {
                                            total_sales = Long.parseLong(userInput.getText().toString());
                                            lead.setTotal_sales(total_sales);
                                            customerdatasource.updatesales(lead, total_sales);
                                            Toast.makeText(lead_list.this, "Lead Updated", Toast.LENGTH_SHORT).show();
                                        } catch (Exception e) {
                                            Toast.makeText(lead_list.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
            }
        });


        recyclerView.setAdapter(customerListAdapter);
    }
    catch(Exception e)
    {
        Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
    }
    }

    private void addlead()
    {
        Intent intent = new Intent(this,input_lead.class);
        startActivityForResult(intent, NODE_FINAL_INT);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (RESULT_OK == resultCode) {
            if (NODE_FINAL_INT == requestCode)
                leadList = customerdatasource.GetLead();
            customerListAdapter.setLeads(leadList);
            recyclerView.smoothScrollToPosition(0);
        }
    }
}
