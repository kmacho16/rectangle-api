package com.kmacho.rectangleapi.domain.model;

import java.awt.*;

public class RectangleEntity extends Rectangle {

    private SideEntity topSide;
    private SideEntity rightSide;
    private SideEntity bottomSide;
    private SideEntity leftSide;

    public RectangleEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
        topSide = new SideEntity(x, (y+height), (x + width), (y+height));
        rightSide = new SideEntity((x+width), y, (x+width), (y+height));
        bottomSide = new SideEntity(x, y, (x + width), y);
        leftSide = new SideEntity(x, y, x, (y+height));
    }

    public SideEntity getTopSide() {
        return topSide;
    }

    public SideEntity getRightSide() {
        return rightSide;
    }

    public SideEntity getBottomSide() {
        return bottomSide;
    }

    public SideEntity getLeftSide() {
        return leftSide;
    }


    public int getArea() {
        return this.height * this.width;
    }

    public RectangleEntity intersection(Rectangle r) {
        Rectangle myR =  super.intersection(r);
        return new RectangleEntity(r.x,r.y,r.width, r.height);
    }

    public boolean isContained(RectangleEntity rectangle){
        RectangleEntity mainRectangle;
        RectangleEntity secondRectangle;
        if(this.getArea() > rectangle.getArea()) {
            mainRectangle = this;
            secondRectangle = rectangle;
        }else {
            mainRectangle = rectangle;
            secondRectangle = this;
        }
        double main_x1 = mainRectangle.getX();
        double main_y1 = mainRectangle.getY() + mainRectangle.getHeight();
        double main_x2 = mainRectangle.getX() + mainRectangle.getWidth();
        double main_y2 = mainRectangle.getY();

        double second_x1 = secondRectangle.getX();
        double second_y1 = secondRectangle.getY() + secondRectangle.getHeight();
        double second_x2 = secondRectangle.getX() + secondRectangle.getWidth();
        double second_y2 = secondRectangle.getY();

        if(main_x1 <= second_x1 && main_y1 >= second_y1) {
            if(main_x2 >= second_x2 && main_y2 <= second_y2){
                return true;
            }
        }
        return false;
    }
}
