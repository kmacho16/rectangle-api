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
}
