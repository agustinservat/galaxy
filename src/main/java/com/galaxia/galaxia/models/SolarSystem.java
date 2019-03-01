package com.galaxia.galaxia.models;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    private List<Planet> planets;
    private Point sunPosition;
    private static double perimeter = 0;

    public SolarSystem(List<Planet> planets) {
        this.planets = planets;
        this.sunPosition = new Point(0,0);
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        planets = planets;
    }

    public Point getSunPosition() {
        return sunPosition;
    }

    public static double getPerimeter() {
        return perimeter;
    }

    public String getWeather(Integer days) {
        List<Point> points = new ArrayList<Point>();
        for(int i=0; i<planets.size(); i++){
            points.add(planets.get(i).getPoint(days));
        }
        String result = "Normal";
        if(isLine(points.get(0), points.get(1), points.get(2)) && checkOrigin(points.get(0), points.get(1))){
            result = "Sequia";
        } else if(isLine(points.get(0), points.get(1), points.get(2))){
            result = "Presion y temperatura";
        } else if(pointInTriangle(sunPosition, points.get(0), points.get(1), points.get(2))){
            result = "Lluvia";
            if(perimeter < getPerimeterTriangle(points.get(0), points.get(1), points.get(2))){
                perimeter = getPerimeterTriangle(points.get(0), points.get(1), points.get(2));
//                System.out.println("El perimetro es: " + perimeter + "El dia es: " + days);
            }
        }

        return result;
    }

    public double sign (Point p1, Point p2, Point p3) {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    public boolean pointInTriangle (Point pt, Point v1, Point v2, Point v3){
        double d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(pt, v1, v2);
        d2 = sign(pt, v2, v3);
        d3 = sign(pt, v3, v1);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }

    public double getPerimeterTriangle(Point p1, Point p2, Point p3) {
        return p1.distanceTo(p2) + p1.distanceTo(p3) + p2.distanceTo(p3);
    }

    public boolean isLine(Point p1, Point p2, Point p3) {
        return (p3.getY() - p1.getY()) * (p2.getX() - p1.getX()) == (p3.getX() - p1.getX()) * (p2.getY() - p1.getY());
    }

    public boolean checkOrigin(Point p1, Point p2) {
        return (p1.getX() * (p2.getY() - p1.getY()) == p1.getY() * (p2.getX() - p1.getX()));
    }
}
