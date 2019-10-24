package com.VT.XO.controllers;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.AlreadyOccupiedException;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Figure figure, final Point point)
            throws AlreadyOccupiedException, InvalidMoveException{

            field.setFigure(figure, point);


    }
}
