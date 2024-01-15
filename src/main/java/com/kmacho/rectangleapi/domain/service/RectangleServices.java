package com.kmacho.rectangleapi.domain.service;


import com.kmacho.rectangleapi.domain.model.RectangleEntity;
import org.springframework.stereotype.Service;

@Service
public class RectangleServices {

    public void getIntersection(RectangleEntity r1, RectangleEntity r2) {
        if(r1.intersects(r2)){
            System.out.println("is Intersection");
            RectangleEntity intersection =  r1.intersection(r2);
            System.out.println(intersection.getX());
            System.out.println(intersection.getY());
            System.out.println(intersection.getWidth());
            System.out.println(intersection.getHeight());
        } else {
            r1.isContained(r2);
            System.out.println(r1.isContained(r2));
        }
    }

    public void validateAdjacency(RectangleEntity r1, RectangleEntity r2) {
        if(isHorizontalAdjacency(r1,r2)) {
            System.out.println("Exist horizontal");
        } else if(isVerticalAdjacency(r1,r2)){
            System.out.println("Exist vertical");
        }
    }

    public boolean isHorizontalAdjacency(RectangleEntity r1, RectangleEntity r2) {
        if(((r1.getX()+ r1.getWidth())) == r2.getX() || (r1.getX() == (r2.getX() + r2.getWidth()) )) {
            if(((r1.getY() + r1.getHeight()) >= r2.getY()) && (r1.getY() <= (r2.getY() + r2.getHeight()))){
                if(r1.getLeftSide().equals(r2.getRightSide()) || r1.getRightSide().equals(r2.getLeftSide())){
                    System.out.println("Proper horizontal");
                    return true;
                } else{
                    if(r1.getHeight() > r2.getHeight() || r1.getHeight() < r2.getHeight()){
                        System.out.println("Subline horizontal");
                        return true;
                    }else{
                        System.out.println("partial horizontal");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isVerticalAdjacency(RectangleEntity r1, RectangleEntity r2) {
        if((r1.getY() == (r2.getY() + r2.getHeight())) || ((r1.getY()+r1.getHeight()) == r2.getY())){
            if(((r1.getX()+ r1.getWidth())) >= r2.getX() && (r1.getX() <= (r2.getX() + r2.getWidth()) )) {
                if(r1.getTopSide().equals(r2.getBottomSide()) || r1.getBottomSide().equals(r2.getTopSide())){
                    System.out.println("Proper vertical");
                    return true;
                } else{
                    if(r1.getWidth()>r2.getWidth() || r1.getWidth() < r2.getWidth()){
                        System.out.println("Subline vertical");
                        return true;
                    }else{
                        System.out.println("partial vertical");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
