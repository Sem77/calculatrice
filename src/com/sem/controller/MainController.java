package com.sem.controller;
/*
FONCTIONNEMENT DU PROGRAMME COMPLET

On laisse la possibilité à l'utilisateur de saisir les expressions arithmétiques
Après qu'il ait appuyé sur la touche '=', la méthode calculBtEgal évalue l'expression
	On utilise la classe StringTokenizer pour séparer l'expression en sous-expression selon le séparateur '+'
	Lorsqu'il y a l'opérateur '-', il est traîté comme l'opérateur '+' avec le nombre qui suit considéré comme négatif (4 * 12 + 7 * 2 + (-9) / 2)
	On aura donc dans chaque sous-expression les opérateurs '*' et/ou '/'
	On parcours ensuite chacunes des sous-expressions et on fait appel à la méthode calcSousExp qui retourne le résultat de la sous*expression
	les différents résultats sont enregistrés dans le tableau resultatsSousExp
	On finit parcourir le tableau resultatsSousExp pour faire la somme de tous les sous résultats on l'enregistre dans la variable resultat
	Pour finir on affiche le résultat à l'écran
*/


/*
EXCEPTIONS GEREES
	- Dans le cas où l'utilisateur saisi deux opérateurs à la suite, le deuxième ne s'affichera pas
*/

import com.sem.calculatrice.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainController implements Initializable{

	@FXML
	private Label expArtLabel;
	@FXML
	private Button boutonPlus, boutonMoins, boutonFois, boutonDiv;
	@FXML
	private Button bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9, bouton0, boutonPoint, boutonEgal, boutonClear;
	
	private String expArtCopy = "";
	private double resultat = 0;
	private boolean opPressed = false;
	private Calculatrice calculatrice = new Calculatrice("");

	//Méthode qui affiche à l'écran chaque touche pressée
	@FXML
	protected void ecrire(ActionEvent e) {	
		if(e.getSource() == bouton1){
			expArtLabel.setText(expArtLabel.getText() + "1");
			expArtCopy += "1";
			opPressed = false;
		}
		else if(e.getSource() == bouton2){
			expArtLabel.setText(expArtLabel.getText() + "2");
			expArtCopy += "2";
			opPressed = false;
		}
		else if(e.getSource() == bouton3){
			expArtLabel.setText(expArtLabel.getText() + "3");
			expArtCopy += "3";
			opPressed = false;
		}
		else if(e.getSource() == bouton4){
			expArtLabel.setText(expArtLabel.getText() + "4");
			expArtCopy += "4";
			opPressed = false;
		}
		else if(e.getSource() == bouton5){
			expArtLabel.setText(expArtLabel.getText() + "5");
			expArtCopy += "5";
			opPressed = false;
		}
		else if(e.getSource() == bouton6){
			expArtLabel.setText(expArtLabel.getText() + "6");
			expArtCopy += "6";
			opPressed = false;
		}
		else if(e.getSource() == bouton7){
			expArtLabel.setText(expArtLabel.getText() + "7");
			expArtCopy += "7";
			opPressed = false;
		}
		else if(e.getSource() == bouton8){
			expArtLabel.setText(expArtLabel.getText() + "8");
			expArtCopy += "8";
			opPressed = false;
		}
		else if(e.getSource() == bouton9){
			expArtLabel.setText(expArtLabel.getText() + "9");
			expArtCopy += "9";
			opPressed = false;
		}
		else if(e.getSource() == bouton0){
			expArtLabel.setText(expArtLabel.getText() + "0");
			expArtCopy += "0";
			opPressed = false;
		}
		else if(e.getSource() == boutonPoint){
			expArtLabel.setText(expArtLabel.getText() + ".");
			expArtCopy += ".";
		}
		else if(e.getSource() == boutonPlus){
			if(opPressed == false){
				expArtLabel.setText(expArtLabel.getText() + "+");
				expArtCopy += "+";
				opPressed = true;
			}
		}
		else if(e.getSource() == boutonMoins){
			if(opPressed == false){
				expArtLabel.setText(expArtLabel.getText() + "-");
				expArtCopy += "+-";
				opPressed = true;
			}
		}
		else if(e.getSource() == boutonFois){
			if(opPressed == false){
				expArtLabel.setText(expArtLabel.getText() + "*");
				expArtCopy += "*";
				opPressed = true;
			}
		}
		else if(e.getSource() == boutonDiv){
			if(opPressed == false){
				expArtLabel.setText(expArtLabel.getText() + "/");
				expArtCopy += "/";
				opPressed = true;
			}
		}
		
	}


	//Méthode qui évalue l'expression arithmétique puis calcule le résultat après que la touche '=' ait été préssée
	@FXML
	protected void actionBtEgal(){
		calculatrice.setexpArt(expArtCopy);
		calculatrice.calculer();
		resultat = calculatrice.getResultat();

		expArtLabel.setText(String.valueOf(resultat));
	}

	//Méthode qui réinitialise tout suite à l'appui sur le bouton clear
	@FXML
	private void reinitialiser(){
		expArtLabel.setText("");
		expArtCopy = "";
		resultat = 0;
		calculatrice.setResultat(0);
		calculatrice.setexpArt("");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		expArtLabel.setText("");
		System.out.println("Welcome on the calculator");
	}
}
