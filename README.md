# rectangle-api

this is a Java project that analyze rectangles and
features that exist among rectangles.

## Consume the API
Download the project and run it  will be exposed under the 8080 port.

`http://localhost:8080`

to consume the API is necesary send the following request 
````
{
    "rectangle1": {
        "x": 1,
        "y": 1,
        "width": 4,
        "height": 7
    },
    "rectangle2": {
        "x": 2,
        "y": 7,
        "width": 2,
        "height": 3
    }
}
````

Once you consume the base endpoint you will get the following response 

```aidl
{
    "inputRectangles": [
        {
            "x": 1,
            "y": 1,
            "width": 4,
            "height": 7
        },
        {
            "x": 2,
            "y": 7,
            "width": 2,
            "height": 3
        }
    ],
    "validations": {
        "adjacencyProperties": {},
        "intersectionProperties": {
            "X": 2.0,
            "Y": 7.0,
            "Height": 1.0,
            "Width": 2.0
        },
        "intersection": true,
        "containment": false,
        "adjacency": false
    }
}
```
### inputRectangle
in the `inputRectangle` you will receive the rectangles that you send in the first step 

### validations
in the `validations` propertied you will receive all the results from your validations
if the intersection, contained or adjacency was true, they will be showed in the flag

#### intersectionProperties
if the `intersection` flag is mark as true, then in this field will show the intersection point showing `(x,y)` coordenate 
and the `height` and `width` propertie.

#### adjacencyProperties
if the `adjacency` flag is mark as true, then in this section it will find if is part of a proper, subline, or partial structure
```aidl
"adjacencyProperties": {
        "Proper-[H or V]": false,
        "SubLine-[H or V]": true,
        "Partial-[H or V]": false
    }
```
