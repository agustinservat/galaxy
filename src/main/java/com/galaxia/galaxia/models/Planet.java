package com.galaxia.galaxia.models;

import static java.lang.Math.*;

public class Planet {

    private String name;
    private Integer distance;
    private Integer degreesPerDay;
    private boolean clockwise;

    public Planet(String name, Integer distance, Integer degreesPerDay, boolean clockwise) {
        this.name = name;
        this.distance = distance;
        this.degreesPerDay = degreesPerDay;
        this.clockwise = clockwise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDegrees() {
        return degreesPerDay;
    }

    public void setDegrees(Integer degreesPerDay) {
        this.degreesPerDay = degreesPerDay;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }

    //Con coordenadas polares calculo la posicion del planeta
    public Point getPoint(double days){
        //Calculo los grados con modulo 360 para quitar las vueltas y quedarme con los grados entre 0 y 360
        double degrees = (this.degreesPerDay * days) % 360;

        if(clockwise){
            degrees = degrees * (-1);
        }
        double x = this.distance * cos(toRadians(degrees));
        double y = this.distance * sin(toRadians(degrees));

        return new Point(x,y);
    }

}
