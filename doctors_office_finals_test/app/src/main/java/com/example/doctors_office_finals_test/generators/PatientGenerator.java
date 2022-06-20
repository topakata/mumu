package com.example.doctors_office_finals_test.generators;

import com.example.doctors_office_finals_test.models.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientGenerator {

    private static final ArrayList<String> symptoms = new ArrayList<>();

    static{
        symptoms.add("headache");
        symptoms.add("stomachache");
        symptoms.add("cough");
        symptoms.add("bleeding");
        symptoms.add("loss of smell");
    }

    public static List<Patient> generate(int count){
        List<Patient> patients = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= count; i++){
            patients.add(new Patient(
                    "name" + i,
                    String.valueOf(i),
                    symptoms

            ));
        }
        return patients;
    }
}
