package com.kmacho.rectangleapi.application.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Component
public class RectangleValidations {
    private boolean isIntersection;
    private boolean isContainment;
    private boolean isAdjacency;
    private Map<String, Boolean> adjacencyProperties;
    private Map<String, Double> intersectionProperties;
}
