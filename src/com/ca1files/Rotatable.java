package com.ca1files;

/* Rotatable interface to be implemented in Quad (as it already inherits Shape) */
public interface Rotatable {

    /* method to be overridden. No need to pass in angle arg as it's in Consts
    *  file but potential to take args change 90 in future updates */
    void rotateNinetyDegrees();

}


