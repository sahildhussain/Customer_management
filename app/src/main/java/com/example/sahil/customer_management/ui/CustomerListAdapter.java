package com.example.sahil.customer_management.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.*;
import android.widget.Toast;

import com.example.sahil.customer_management.R;
import com.example.sahil.customer_management.data.Lead;
import java.util.List;
/**
 * Created by SAHIL on 14-07-2017.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.VHCustomer> {

    private List<Lead> leads;
    private OnLeadSelectedListener onLeadSelectedListener;

    public CustomerListAdapter(List<Lead> leads,OnLeadSelectedListener onLeadSelectedListener)
    {
        this.leads=leads;
        this.onLeadSelectedListener = onLeadSelectedListener;
    }

    @Override
    public VHCustomer onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHCustomer(LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(VHCustomer holder, int position) {
        final Lead lead = leads.get(position);
        holder.name.setText(lead.getName());
        holder.sales.setText(lead.getCompany());

        holder.addsales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLeadSelectedListener.onsalesadded(lead);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLeadSelectedListener.onleadselected(lead);
            }
        });
    }


    @Override
    public int getItemCount() {
        return leads.size();
    }

    public void setLeads(List<Lead> leads)
    {
        this.leads=leads;
        notifyDataSetChanged();
    }

    static class VHCustomer extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView sales;
        ImageButton addsales;
        VHCustomer(View itemView)
        {
            super(itemView);
            addsales = (ImageButton) itemView.findViewById(R.id.addsales);
            name = (TextView) itemView.findViewById(R.id.list_row_name);
            sales = (TextView) itemView.findViewById(R.id.list_row_sales);
        }
    }
}
