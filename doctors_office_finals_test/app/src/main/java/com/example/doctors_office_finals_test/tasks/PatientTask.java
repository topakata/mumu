package com.example.doctors_office_finals_test.tasks;

import android.os.Handler;
import android.os.SystemClock;

import com.example.doctors_office_finals_test.listeners.OnPatientListener;
import com.example.doctors_office_finals_test.models.Patient;

import java.util.List;

public class PatientTask implements Runnable{
    private Handler handler;
    private List<Patient> patientList;
    private OnPatientListener listener;

    public PatientTask(Handler handler, List<Patient> patientList, OnPatientListener listener) {
        this.handler = handler;
        this.patientList = patientList;
        this.listener = listener;
    }

    @Override
    public void run() {
        SystemClock.sleep(5000);
        Patient patient = patientList.get(0);
        listener.onPatientDelete(patient);
        handler.post(this);
    }
}
