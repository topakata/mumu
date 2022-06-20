package com.example.doctors_office_finals_test.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Patient implements Parcelable {
    private String name;
    private String age;
    private List<String> symptoms;

    public Patient() {
    }

    public Patient(String name, String age, List<String> symptoms) {
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
    }

    protected Patient(Parcel in) {
        name = in.readString();
        age = in.readString();
        symptoms = in.createStringArrayList();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getFirstSymptom(){
        return symptoms.get(0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeStringList(symptoms);
    }
}
