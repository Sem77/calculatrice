package com.sem.exceptions;

public class ExceptionTropdOperateurs extends Exception{
    
    public ExceptionTropdOperateurs(){  
        super(); 
    }

    public String toString(){
        return "operateur déjà sélectionné";
    }
}
