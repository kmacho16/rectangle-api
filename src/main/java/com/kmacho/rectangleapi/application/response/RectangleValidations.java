package com.kmacho.rectangleapi.application.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class RectangleValidations {
    private boolean isIntersection;
    private Map<String, Double> intersectionProperties;
    private boolean isContainment;
    private boolean isAdjacency;
    private Map<String, Boolean> adjacencyProperties;
}
