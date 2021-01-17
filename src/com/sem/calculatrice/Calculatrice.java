package com.sem.calculatrice;

import java.util.StringTokenizer;

import com.sem.exceptions.ExceptionDivisionParZero;

public class Calculatrice{

	public static double calculer(String expr) throws ExceptionDivisionParZero{
		String expression = "0" + expr.replaceAll("-", "+-");
		double resultat = calcSousExpPlus(expression);
		return resultat;
	}

	//Cette méthode calcule une expression arithmétique avec les opérateurs +, * et /
	//On fait appel à la méthode calcSousExpProd qui fait appel à son tour à la méthode calcSousExpDiv
	//Puis on fait la somme de chacun des résultats
	private static double calcSousExpPlus(String expr) throws ExceptionDivisionParZero{
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
	private static double calcSousExpProd(String expr) throws ExceptionDivisionParZero{
		StringTokenizer stProd = new StringTokenizer(expr, "*");
		double resultatProd = calcSousExpDiv(stProd.nextToken());

		while(stProd.hasMoreTokens()){
			resultatProd *= calcSousExpDiv(stProd.nextToken());
		}
		
		return resultatProd;
	}


	//Cette méthode calcule une expression arithmétique dont l'unique opérateur est /
	private static double calcSousExpDiv(String expr) throws ExceptionDivisionParZero{
		StringTokenizer stDiv = new StringTokenizer(expr, "/");
		double resultatDiv = Double.parseDouble(stDiv.nextToken());
		double suivant;
		
		while(stDiv.hasMoreTokens()){
			suivant = Double.parseDouble(stDiv.nextToken());
			if(suivant == 0){
				throw new ExceptionDivisionParZero();
			}
			resultatDiv /= suivant;
		}
		return resultatDiv;
	}

}
