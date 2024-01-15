package com.kmacho.rectangleapi.application.response;

import com.kmacho.rectangleapi.application.request.Rectangle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class RectangleResponse {
    List<Rectangle> inputRectangles;
    RectangleValidations validations;
}
