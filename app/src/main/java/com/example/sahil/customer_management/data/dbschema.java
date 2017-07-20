package com.example.sahil.customer_management.data;

import android.provider.BaseColumns;

/**
 * Created by SAHIL on 16-07-2017.
 */
public class dbschema {
    private dbschema(){

    }
    public static final class Leadentry implements BaseColumns{ //basecolumn automatically adds ID
        public static final String Table_name="Lead";
        public static final String Coulumn_name="Name";
        public static final String Coulumn_company="Company";
        public static final String Coulumn_email="Email";
        public static final String Coulumn_phone="Phone";
        public static final String Coulumn_dob="DOB";
        public static final String Coulumn_address="Address";
        public static final String Coulumn_description="Description";
        public static final String Coulumn_positive_result= "Pos_Result";
        public static final String Coulumn_zero_result="Zero_Result";
        public static final String Coulumn_total_sales= "Total_Sales";

    }

    private static final class SalesEntry {
        public static final String Table_name="Sales";
        public static final String Coulumn_id = "Id";
        public static final String Coulumn_custid="Customer_Id";
        public static final String Coulumn_status="Status";
        public static final String Coulumn_amount="Amount";
    }

    private static final class EventsEntry {
        public static final String Table_name="Events";
        public static final String Coulumn_id = "Id";
        public static final String Coulumn_custid="Customer_Id";
        public static final String Coulumn_time="Date";
        public static final String Coulumn_about="About";
    }

}
