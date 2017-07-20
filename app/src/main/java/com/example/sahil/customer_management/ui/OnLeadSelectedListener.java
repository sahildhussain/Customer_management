package com.example.sahil.customer_management.ui;

import android.widget.Toast;

import com.example.sahil.customer_management.data.Lead;

/**
 * Created by SAHIL on 19-07-2017.
 */
public interface OnLeadSelectedListener {

    void onleadselected(Lead lead);
    void onsalesadded(Lead lead);
}
