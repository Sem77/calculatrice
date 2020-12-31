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

    	double resultatsSousExp[] = new double[100];
    	int tailleResultatsSousExp = 0;

	    StringTokenizer st = new StringTokenizer(expArt, "+");
			
		while(st.hasMoreTokens()){
			resultatsSousExp[tailleResultatsSousExp] = calcSousExp(st.nextToken());
			tailleResultatsSousExp++;
		}
			
		for(int i=0; i<tailleResultatsSousExp; i++){
			resultat += resultatsSousExp[i];
		}
	}

    private double calcSousExp(String expr){

		/*
		FONCTIONNEMENT DE LA METHODE calcSousExp
		On parcours caractère la String expr (sous-expression de l'expression arithmétique) caractère par caractère
		si le caratère est différent de '*' ou '/' ou si il s'agit du dernier caractère, on le concatène à la String ch
		si on tombe sur un opérateur alors on ajoute la chaîne ch au tableau exp en prennant soin de la convertir en double
			on ajoute ensuite le signe trouvé au tableau tabSignes et on vide ensuite la chaîne ch
		
		Après avoir séparé les nombres d'un côté et les opérateurs d'un côté,
		on parcours le tableau expr ainsi que le tableau tabSignes pour calculer la sous-expression
		On retourne ensuite le résultat
		*/

		double exp[] = new double[100];
		int tailleExp = 0;
		String ch = "";
		char tabSignes[] = new char[100];
		int tailleTabSignes = 0;
		double result;
		for(int i=0; i<expr.length(); i++){
			if(expr.charAt(i) != '*' && expr.charAt(i) != '/'){
				ch += expr.charAt(i);
				if(i == expr.length()-1){
					exp[tailleExp] = Double.parseDouble(ch);
					ch = "";
					tailleExp++;
				}
			}
			else{
				tabSignes[tailleTabSignes] = expr.charAt(i);
				exp[tailleExp] = Double.parseDouble(ch);
				ch = "";
				tailleExp++;
				tailleTabSignes++;
			}
		}
		result = exp[0];
		int j = 1;
		for(int i=0; i<tailleTabSignes; i++){
			if(tabSignes[i] == '*')
				result *= exp[j];
			else if(tabSignes[i] == '/')
				result /= exp[j];
			j++;
		}
		return result;
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
