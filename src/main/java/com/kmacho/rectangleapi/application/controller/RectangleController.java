package com.kmacho.rectangleapi.application.controller;

import com.kmacho.rectangleapi.application.helper.RectangleToRectangleEntityMapper;
import com.kmacho.rectangleapi.application.request.InputRectangles;
import com.kmacho.rectangleapi.application.response.RectangleResponse;
import com.kmacho.rectangleapi.application.response.RectangleValidations;
import com.kmacho.rectangleapi.domain.model.RectangleEntity;
import com.kmacho.rectangleapi.domain.service.RectangleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RectangleController {

    @Autowired
    RectangleServices rectangleServices;

    @Autowired
    RectangleToRectangleEntityMapper rectangleToRectangleEntityMapper;

    @GetMapping
    public RectangleResponse validateRectangle(@RequestBody InputRectangles rectangles) {
        RectangleEntity rectangle1 = rectangleToRectangleEntityMapper.rectangleToRectangleEntity(rectangles.getRectangle1());
        RectangleEntity rectangle2 = rectangleToRectangleEntityMapper.rectangleToRectangleEntity(rectangles.getRectangle2());
        RectangleValidations validateRectangles  = rectangleServices.validateRectangles(rectangle1,rectangle2);
        RectangleResponse response = new RectangleResponse();
        response.setInputRectangles(List.of(rectangles.getRectangle1(),rectangles.getRectangle2()));
        response.setValidations(validateRectangles);
        return response;
    }
}
