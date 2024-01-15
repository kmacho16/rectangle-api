package com.kmacho.rectangleapi.domain.service;


import com.kmacho.rectangleapi.application.response.RectangleResponse;
import com.kmacho.rectangleapi.application.response.RectangleValidations;
import com.kmacho.rectangleapi.domain.model.RectangleEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RectangleServices {

    private RectangleValidations validations;

    public RectangleValidations validateRectangles(RectangleEntity r1, RectangleEntity r2) {
        validations = new RectangleValidations();
        validations.setAdjacencyProperties(new HashMap<>());
        getIntersection(r1, r2);
        validations.setContainment(isContained(r1, r2));
        System.out.println(isContained(r1, r2));
        validateAdjacency(r1,r2);
        return validations;
    }

    public void getIntersection(RectangleEntity r1, RectangleEntity r2) {
        boolean intersects = r1.intersects(r2);
        validations.setIntersection(intersects);
        if(intersects) {
            System.out.println("is Intersection");
            RectangleEntity intersection =  r1.intersection(r2);
            Map<String, Double> map = new HashMap<>();
            map.put("X", intersection.getX());
            map.put("Y", intersection.getY());
            map.put("Width", intersection.getWidth());
            map.put("Height", intersection.getHeight());
            validations.setIntersectionProperties(map);
        }
    }

    public void validateAdjacency(RectangleEntity r1, RectangleEntity r2) {
        boolean exist = isHorizontalAdjacency(r1,r2);
        if(!exist) {
            exist = isVerticalAdjacency(r1,r2);
        }
        validations.setAdjacency(exist);
    }

    public Boolean isHorizontalAdjacency(RectangleEntity r1, RectangleEntity r2) {
        Boolean exist = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>() {{
            put("Proper-H", false);
            put("SubLine-H", false);
            put("Partial-H", false);
        }};
        if(((r1.getX()+ r1.getWidth())) == r2.getX() || (r1.getX() == (r2.getX() + r2.getWidth()) )) {
            if(((r1.getY() + r1.getHeight()) >= r2.getY()) && (r1.getY() <= (r2.getY() + r2.getHeight()))){
                exist = true;
                if(r1.getLeftSide().equals(r2.getRightSide()) || r1.getRightSide().equals(r2.getLeftSide())){
                    map.put("Proper-H", true);
                } else{
                    if (r1.getHeight() > r2.getHeight() || r1.getHeight() < r2.getHeight()){
                        map.put("SubLine-H", true);
                    } else {
                        map.put("Partial-H", true);
                    }
                }
            }
        }
        if (exist){
            validations.setAdjacencyProperties(map);
        }
        return exist;
    }

    public Boolean isVerticalAdjacency(RectangleEntity r1, RectangleEntity r2) {
        Boolean exist = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>() {{
            put("Proper-V", false);
            put("SubLine-V", false);
            put("Partial-V", false);
        }};
        if((r1.getY() == (r2.getY() + r2.getHeight())) || ((r1.getY()+r1.getHeight()) == r2.getY())){
            if(((r1.getX()+ r1.getWidth())) >= r2.getX() && (r1.getX() <= (r2.getX() + r2.getWidth()) )) {
                exist = true;
                if(r1.getTopSide().equals(r2.getBottomSide()) || r1.getBottomSide().equals(r2.getTopSide())){
                    map.put("Proper-V", true);
                } else{
                    if(r1.getWidth()>r2.getWidth() || r1.getWidth() < r2.getWidth()){
                        map.put("SubLine-V", true);
                    }else{
                        map.put("Partial-V", true);
                    }
                }
            }
        }
        if (exist){
            validations.setAdjacencyProperties(map);
        }
        return exist;
    }

    public boolean isContained(RectangleEntity r1, RectangleEntity r2){
        RectangleEntity mainRectangle;
        RectangleEntity secondRectangle;
        if(r1.getArea() > r2.getArea()) {
            mainRectangle = r1;
            secondRectangle = r2;
        }else {
            mainRectangle = r2;
            secondRectangle = r1;
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
