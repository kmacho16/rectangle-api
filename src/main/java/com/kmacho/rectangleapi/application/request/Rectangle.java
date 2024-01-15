package com.kmacho.rectangleapi.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
}
