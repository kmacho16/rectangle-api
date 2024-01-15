package com.kmacho.rectangleapi.application.controller;

import com.kmacho.rectangleapi.application.helper.RectangleToRectangleEntityMapper;
import com.kmacho.rectangleapi.application.request.InputRectangles;
import com.kmacho.rectangleapi.domain.model.RectangleEntity;
import com.kmacho.rectangleapi.domain.service.RectangleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {

    @Autowired
    RectangleServices rectangleServices;

    @Autowired
    RectangleToRectangleEntityMapper rectangleToRectangleEntityMapper;

    @GetMapping
    public String validateRectangle(@RequestBody InputRectangles rectangles) {
        RectangleEntity rectangle1 = rectangleToRectangleEntityMapper.rectangleToRectangleEntity(rectangles.getRectangle1());
        RectangleEntity rectangle2 = rectangleToRectangleEntityMapper.rectangleToRectangleEntity(rectangles.getRectangle2());


        return "hola";
    }
}
