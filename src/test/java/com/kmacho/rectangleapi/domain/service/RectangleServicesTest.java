package com.kmacho.rectangleapi.domain.service;

import com.kmacho.rectangleapi.application.response.RectangleValidations;
import com.kmacho.rectangleapi.domain.model.RectangleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RectangleServicesTest {

    @Autowired
    RectangleServices rectangleServices;

    private RectangleEntity rectangle1;

    private RectangleEntity rectangle2;

    @Mock
    private RectangleValidations validations;

    @BeforeEach
    void setup() {
        Mockito.doNothing().when(validations).setIntersection(true);
    }

    @Test
    void validateRectangles() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(2,7,2,3);
        RectangleValidations result = rectangleServices.validateRectangles(rectangle1, rectangle2);
        assertAll(
                () -> assertFalse(result.isAdjacency()),
                () -> assertTrue(result.isIntersection()),
                () -> assertFalse(result.isContainment())
        );
    }

    @Test
    void existIntersection() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(2,7,2,3);
        boolean result = rectangleServices.getIntersection(rectangle1, rectangle2);
        assertTrue(result);
    }

    @Test
    void noExistIntersection() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(6,7,2,3);
        boolean result = rectangleServices.getIntersection(rectangle1, rectangle2);
        assertFalse(result);
    }

    @Test
    void validateAdjacency() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(5,7,2,3);
        boolean result = rectangleServices.validateAdjacency(rectangle1, rectangle2);
        assertTrue(result);
    }

    @Test
    void isHorizontalAdjacency() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(5,7,2,3);
        boolean result = rectangleServices.isHorizontalAdjacency(rectangle1, rectangle2);
        assertTrue(result);
    }

    @Test
    void isVerticalAdjacency() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(2,8,2,3);
        boolean result = rectangleServices.isVerticalAdjacency(rectangle1, rectangle2);
        assertTrue(result);
    }

    @Test
    void isContained() {
        rectangle1 = new RectangleEntity(1,1,4,7);
        rectangle2 = new RectangleEntity(2,2,2,3);
        boolean result = rectangleServices.isContained(rectangle1, rectangle2);
        assertTrue(result);
    }
}