package adsd.app.zorgapp;

import java.time.*;

public class Measurement {

    private double weight;
    private String time;
    private LocalDate date;


    public Measurement(LocalDate date, String time, double weight){
       this.date = date;
       this.time = time;
       this.weight = weight;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setMeasureWeight(double weight){
        this.weight = weight;
    }

    public double getMeasureWeight(){
        return this.weight;
    }

    public String getTime(){
        return this.time;
    }

    public LocalDate getDate(){
        return this.date;
    }



}
