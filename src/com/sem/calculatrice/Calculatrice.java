package com.sem.calculatrice;

/*
    Un objet de type calculatrice prend une expression arithmétique de type String
    la traîte et renvoie le résultat de type double
*/

import java.util.StringTokenizer;

public class Calculatrice{

    private String expArt;
    private double resultat;

    public Calculatrice(String expArt){
        this.expArt = expArt;
    }

    public void calculer(){
		expArt = expArt.replaceAll("-", "+-"); //On ajoute + devant tous les -
		resultat = calcSousExpPlus(expArt);
	}


	//Cette méthode calcule une expression arithmétique avec les opérateurs +, * et /
	//On fait appel à la méthode calcSousExpProd qui fait appel à son tour à la méthode calcSousExpDiv
	//Puis on fait la somme de chacun des résultats
	private double calcSousExpPlus(String expr){
		StringTokenizer stPlus = new StringTokenizer(expr, "+");
		double resultatPlus = calcSousExpProd(stPlus.nextToken());

		while(stPlus.hasMoreTokens()){
			resultatPlus += calcSousExpProd(stPlus.nextToken());
		}
		return resultatPlus;
	}


	//Cette méthode calcule une expression arithmétique avec les opérateurs * et /
	//On parse chacunes des sous-expressions séparées par l'opérateur * à la méthode calcSousExpDiv
	//Puis on fait le produit de chacun des résultats
	private double calcSousExpProd(String expr){
		StringTokenizer stProd = new StringTokenizer(expr, "*");
		double resultatProd = calcSousExpDiv(stProd.nextToken());

		while(stProd.hasMoreTokens()){
			resultatProd *= calcSousExpDiv(stProd.nextToken());
		}
		
		return resultatProd;
	}


	//Cette méthode calcule une expression arithmétique dont l'unique opérateur est /
	private double calcSousExpDiv(String expr){
		StringTokenizer stDiv = new StringTokenizer(expr, "/");
		double resultatDiv = Double.parseDouble(stDiv.nextToken());
		while(stDiv.hasMoreTokens()){
			resultatDiv /= Double.parseDouble(stDiv.nextToken());
		}
		return resultatDiv;
	}

	public double getResultat(){
		return resultat;
	}
	
	public void setResultat(double resultat){
		this.resultat = resultat;
	}
    
    public void setexpArt(String expArt){
        this.expArt = expArt;
    }
}
