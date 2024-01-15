package com.kmacho.rectangleapi.application.helper;

import com.kmacho.rectangleapi.application.request.InputRectangles;
import com.kmacho.rectangleapi.application.request.Rectangle;
import com.kmacho.rectangleapi.domain.model.RectangleEntity;
import org.springframework.stereotype.Service;

@Service
public class RectangleToRectangleEntityMapper {

    public RectangleEntity rectangleToRectangleEntity(Rectangle rectangle){
        return new RectangleEntity(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
    }

    public Rectangle rectangleEntityToRectangle(RectangleEntity rectangle) {
        return new Rectangle(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }

}
