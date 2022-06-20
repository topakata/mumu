package com.example.doctors_office_finals_test.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctors_office_finals_test.R;
import com.example.doctors_office_finals_test.listeners.OnPatientClickListener;
import com.example.doctors_office_finals_test.models.Patient;

import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientHolder> {
    private List<Patient> patients;
    OnPatientClickListener listener;

    public PatientAdapter(OnPatientClickListener listener, List<Patient> patients) {
        this.patients = patients;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PatientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_holder, parent, false);
        return new PatientHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientHolder holder, int position) {
        Patient patient = patients.get(position);
        holder.setName(patient.getName());
        holder.setAge(patient.getAge());
        holder.setFirstSymptom(patient.getFirstSymptom());

        holder.setOnClick(listener, patient);

        if (position == 0){
            holder.setColor(Color.YELLOW);
        }
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void delete(Patient patient) {
        patients.remove(patient);
        notifyDataSetChanged();
        //notifyItemRemoved(0);
    }

    public List<Patient> getAll() {
        return patients;
    }
}
