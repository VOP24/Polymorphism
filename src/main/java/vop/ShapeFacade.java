/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import java.lang.reflect.Parameter;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        AbstractShape figure;
        switch (shape) {
            case CIRCLE:
                figure = new Circle(parametre[0]);
                break;
            case SQUARE:
                figure = new Square(parametre[0]);
                break;
            case ELLIPSE:
                figure = new Ellipse(parametre[0], parametre[1]);
                break;
            case RECTANGLE:
                figure = new Rectangle(parametre[0], parametre[1]);
                break;
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
        return figure.toString();
    }

}
