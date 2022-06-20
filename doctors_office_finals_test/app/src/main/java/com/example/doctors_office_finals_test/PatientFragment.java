package com.example.doctors_office_finals_test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.doctors_office_finals_test.adapters.PatientAdapter;
import com.example.doctors_office_finals_test.listeners.OnPatientListener;
import com.example.doctors_office_finals_test.models.Patient;

import java.util.List;

public class PatientFragment extends DialogFragment  implements View.OnClickListener{

    private static final String PATIENT = "PATIENT";

    private Patient patient;

    EditText insurance;

    //test
    OnPatientListener listener;


    public PatientFragment() {
        // Required empty public constructor
    }

    public static PatientFragment newInstance(Patient patient2) {
        PatientFragment fragment = new PatientFragment();
        Bundle args = new Bundle();
        args.putParcelable(PATIENT, patient2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            patient = getArguments().getParcelable(PATIENT);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnPatientListener) {
            listener = (OnPatientListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView name = view.findViewById(R.id.textView4);
        TextView age = view.findViewById(R.id.textView5);
        TextView symptoms = view.findViewById(R.id.textView6);
        insurance = view.findViewById(R.id.editInsurance);
        Button check = view.findViewById(R.id.button);

        name.setText(patient.getName());
        age.setText(patient.getAge());
        symptoms.setText(patient.getFirstSymptom());
        for (String s : patient.getSymptoms()){
            symptoms.append(", " + s);
        }

       check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onPatientDelete(patient);
        dismiss();
    }
}