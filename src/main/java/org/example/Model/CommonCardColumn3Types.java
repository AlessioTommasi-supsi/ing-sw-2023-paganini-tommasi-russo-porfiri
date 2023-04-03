package org.example.Model;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class CommonCardColumn3Types implements CommonObjectiveInterface {
    public boolean executeAlgorithm(String nameOfCard) {
        int counterShape = 0;
        Shape shapeLine = new Line2D() {
            @Override
            public double getX1() {
                return 0;
            }

            @Override
            public double getY1() {
                return 0;
            }

            @Override
            public Point2D getP1() {
                return null;
            }

            @Override
            public double getX2() {
                return 0;
            }

            @Override
            public double getY2() {
                return 0;
            }

            @Override
            public Point2D getP2() {
                return null;
            }

            @Override
            public void setLine(double x1, double y1, double x2, double y2) {

            }

            @Override
            public Rectangle2D getBounds2D() {
                return null;
            }
        };
        if (nameOfCard == "Four rows different types") {

            if (counterShape == 4) {
                return true;
            } else {
                return false;
            }
        }
        else if (nameOfCard == "Three columns different types") {
            if (counterShape == 3) {
                return true;
            } else {
                return false;
            }
        }
        return false;}
}
