package com.example.doctors_office_finals_test.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctors_office_finals_test.R;
import com.example.doctors_office_finals_test.listeners.OnPatientClickListener;
import com.example.doctors_office_finals_test.models.Patient;

public class PatientHolder extends RecyclerView.ViewHolder {
    private TextView name, age, firstSymptom;
    public PatientHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView);
        age = itemView.findViewById(R.id.textView2);
        firstSymptom = itemView.findViewById(R.id.textView3);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setAge(String age) {
        this.age.setText(age);
    }

    public void setFirstSymptom(String firstSymptom) {
        this.firstSymptom.setText(firstSymptom);
    }

    public void setOnClick(OnPatientClickListener listener, Patient patient){
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPatientClick(patient);
            }
        });
    }

    public void setColor(int yellow) {
        this.itemView.setBackgroundColor(yellow);
    }
}
