package com.kmacho.rectangleapi.application.controller;

import com.kmacho.rectangleapi.application.request.InputRectangles;
import com.kmacho.rectangleapi.domain.service.RectangleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {

    @Autowired
    RectangleServices rectangleServices;

    @GetMapping
    public String validateRectangle(@RequestBody InputRectangles rectangles) {
        System.out.println(rectangles.getRectangle1().getX());
        return "hola";
    }
}
