package com.example.fragment_example.model.medicationModule;

public class Medication {
    private String name;
    private float dosage;
    private String measurement;
    private int frequency;


    public Medication(String name, float dosage, String measurement, int frequency) {
        this.name = name;
        this.dosage = dosage;
        this.measurement = measurement;
        this.frequency = frequency;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDosage()
    {
        return this.dosage;
    }
    public void setDosage(float dosage) {
        this.dosage = dosage;
    }
    public String getMeasurement() {
        return this.measurement;
    }
    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
    public int getFrequency() {
        return this.frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
