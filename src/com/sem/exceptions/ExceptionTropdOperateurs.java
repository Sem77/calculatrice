package com.sem.exceptions;

public class ExceptionTropdOperateurs extends Exception{

	/**
     *
     */
    private static final long serialVersionUID = 5094332360859160518L;

    public ExceptionTropdOperateurs() {
        super(); 
    }

    public String toString(){
        return "operateur déjà sélectionné";
    }
}
