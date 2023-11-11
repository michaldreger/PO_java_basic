package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import java.lang.Math;

public class Obrot implements Transformacja {
    private final double degree;

    public Obrot(double degree) {
        this.degree = degree;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(-degree);
    }

    @Override
    public Punkt transformuj(Punkt p) {
        double radians = Math.toRadians(degree); // Convert degrees to radians
        double x = (p.getX() * Math.cos(radians)) - (p.getY() * Math.sin(radians));
        double y = (p.getX() * Math.sin(radians)) + (p.getY() * Math.cos(radians));

        // Zaokrąglenie do określonej liczby miejsc po przecinku (np. 2 miejsca po
        // przecinku)
        x = Math.round(x * 100.0) / 100.0;
        y = Math.round(y * 100.0) / 100.0;

        return new Punkt(x, y);
    }

    public double getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Obrót punktu o " + degree + " stopni.";
    }
}
