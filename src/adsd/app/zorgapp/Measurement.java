package adsd.app.zorgapp;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Measurement {

    private double weight;
    private String time;
    private LocalDate date;


    public Measurement(LocalDate date, double weight){
       this.date = date;
       this.weight = weight;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setMeasureWeight(double weight){
        this.weight = weight;
    }

    public double getMeasureWeight(){
        return this.weight;
    }

    public LocalDate getDate(){
        return this.date;
    }


}
