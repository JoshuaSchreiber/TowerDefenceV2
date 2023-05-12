package de.joshua.gameobjects;

import de.joshua.util.Coordinate;
import de.joshua.util.GameObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.*;

public class Tower extends GameObject {
    public double deltaMovingAngle = 0;
    public double turningVelocity = 30;

    private Shape transformedTankBody = new RoundRectangle2D.Double();
    private double angleCannon = 0;

    public double getAngleCannon() {
        return angleCannon;
    }
    public void setDeltaMovingAngle(String richtung, double changeMovingAngle){
        if(richtung.equals("+")){
            this.deltaMovingAngle = deltaMovingAngle + changeMovingAngle;
        }else{
            this.deltaMovingAngle = deltaMovingAngle - changeMovingAngle;
        }
    }

    public Tower(Coordinate objectPosition, double width, double height) {
        super(objectPosition, width, height);
    }

    @Override
    public void paintMe(java.awt.Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        paintTower(g2d);
    }

    private void paintTower(Graphics2D g2d) {
        Ellipse2D towerBody = new Ellipse2D.Double(getObjectPosition().getX(), getObjectPosition().getY(), getWidth()*0.8, getHeight()*0.8);

        double d = 0.75;
        double c = 0.16;
        RoundRectangle2D tankCannon = new RoundRectangle2D.Double(getObjectPosition().getX() + getWidth()*(d/2),
                getObjectPosition().getY() + getHeight() *(c/0.5),
                getWidth() * d, getHeight()
                * c, 5, 5);

        double f = 0.4;
        RoundRectangle2D tankTurret = new RoundRectangle2D.Double(getObjectPosition().getX() + getWidth() * f/2,
                getObjectPosition().getY() + getHeight() * (f/2),
                getWidth() * f, getHeight() * f, 15, 8);


        AffineTransform transform = new AffineTransform();
        transform.rotate(deltaMovingAngle, towerBody.getCenterX(), towerBody.getCenterY());

        g2d.setColor(Color.decode("#02A272"));
        Shape transformed = transform.createTransformedShape(towerBody);
        g2d.fill(transformed);
        g2d.setColor(Color.DARK_GRAY);
        transformed = transform.createTransformedShape(tankCannon);
        g2d.fill(transformed);

        transformed = transform.createTransformedShape(tankTurret);
        g2d.fill(transformed);
    }

}
