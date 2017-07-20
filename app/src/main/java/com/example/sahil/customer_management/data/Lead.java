package com.example.sahil.customer_management.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SAHIL on 04-07-2017.
 */
public class Lead implements Parcelable {
    private long id;
    private String name;
    private String company;
    private String email;
    private String address;
    private String dob;
    private String phone;
    private String description;
    private long postive_result,zero_result,total_sales;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public Lead(String dob ,long id, String name, String email, String phone, String address, String company,String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob=dob;
        this.address = address;
        this.company = company;
        this.description=description;
    }

    public Lead(String dob, String name, String email, String phone, String address, String company, String description) {
        this.name = name;
        this.dob=dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.company = company;
        this.description=description;
    }
    protected Lead(Parcel source)
    {
        id=source.readLong();
        name=source.readString();
        company=source.readString();
        email=source.readString();
        phone=source.readString();
        address=source.readString();
        description=source.readString();
        total_sales=source.readLong();
        postive_result=source.readLong();
        zero_result=source.readLong();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public long getPostive_result() {
        return postive_result;
    }

    public void setPostive_result(long postive_result) {
        this.postive_result = postive_result;
    }

    public long getZero_result() {
        return zero_result;
    }

    public void setZero_result(long zero_result) {
        this.zero_result = zero_result;
    }

    public long getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(long total_sales) {
        this.total_sales = total_sales;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Lead> CREATOR=new Creator<Lead>() {
        @Override
        public Lead createFromParcel(Parcel source) {
            return new Lead(source);
        }

        @Override
        public Lead[] newArray(int size) {
            return new Lead[size];
        }
    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeLong(total_sales);
        dest.writeLong(postive_result);
        dest.writeLong(zero_result);
    }
}
