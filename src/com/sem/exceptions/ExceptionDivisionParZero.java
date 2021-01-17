package com.sem.exceptions;

public class ExceptionDivisionParZero extends Exception{
    
    /**
     *
     */
    private static final long serialVersionUID = 813830508572998047L;

    public ExceptionDivisionParZero() {
        super("Impossible de diviser par 0");
    }
}
