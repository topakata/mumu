package com.example.doctors_office_finals_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import com.example.doctors_office_finals_test.adapters.PatientAdapter;
import com.example.doctors_office_finals_test.generators.PatientGenerator;
import com.example.doctors_office_finals_test.listeners.OnPatientClickListener;
import com.example.doctors_office_finals_test.listeners.OnPatientListener;
import com.example.doctors_office_finals_test.models.Patient;
import com.example.doctors_office_finals_test.tasks.PatientTask;

public class PatientsActivity extends AppCompatActivity implements OnPatientClickListener, OnPatientListener {

    private RecyclerView recyclerView;
    private PatientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
        //System.out.println("I got here");

        adapter = new PatientAdapter(this, PatientGenerator.generate(25));
        recyclerView = findViewById(R.id.rv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        runTask();
    }

    private void runTask() {
        HandlerThread thread = new HandlerThread("thread");
        thread.start();
        Handler handler = new Handler(thread.getLooper());
        handler.post(new PatientTask(handler, adapter.getAll(), this));
    }

    @Override
    public void onPatientClick(Patient patient) {
        PatientFragment patientFragment = PatientFragment.newInstance(patient);
        patientFragment.show(getSupportFragmentManager(), "patient");
    }

    @Override
    public void onPatientDelete(Patient patient) {
        if(recyclerView != null) {
            if(adapter != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.delete(patient);
                    }
                });
            }
        }
    }
}