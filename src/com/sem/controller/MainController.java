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
import com.sem.exceptions.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class MainController implements Initializable{

	@FXML
	private TextField TextFieldExpression;
	@FXML
	private Button boutonPlus, boutonMoins, boutonFois, boutonDiv;
	@FXML
	private Button bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9, bouton0, boutonPoint, boutonEgal, boutonClear;
	
	private double resultat = 0;
	private boolean opPressed = false;
	private boolean btEgalPressed= false;
	private char carActuel;

	//Méthode qui affiche à l'écran chaque touche pressée
	@FXML
	protected void ecrire(ActionEvent e) throws ExceptionTropdOperateurs{
		if(btEgalPressed == true){TextFieldExpression.setText(""); btEgalPressed = false;}
		try{	
			if(e.getSource() == bouton1){
				opPressed = false; carActuel = '1';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton2){
				opPressed = false; carActuel = '2';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton3){
				opPressed = false; carActuel = '3';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton4){
				opPressed = false; carActuel = '4';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton5){
				opPressed = false; carActuel = '5';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton6){
				opPressed = false; carActuel = '6';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton7){
				opPressed = false; carActuel = '7';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton8){
				opPressed = false; carActuel = '8';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton9){
				opPressed = false; carActuel = '9';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == bouton0){
				opPressed = false; carActuel = '0';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == boutonPoint){
				carActuel = '.';
				TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
			}
			else if(e.getSource() == boutonPlus){
				carActuel = '+';
				if(opPressed == false){
					opPressed = true;
					TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
				}
				else
					throw new ExceptionTropdOperateurs();
			}
			else if(e.getSource() == boutonMoins){
				carActuel = '-';
				if(opPressed == false){
					opPressed = true;
					TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
				}
				else
					throw new ExceptionTropdOperateurs();
			}
			else if(e.getSource() == boutonFois){
				carActuel = '*';
				if(opPressed == false){
					opPressed = true;
					TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
				}
				else
					throw new ExceptionTropdOperateurs();
			}
			else if(e.getSource() == boutonDiv){
				carActuel = '/';
				if(opPressed == false){
					opPressed = true;
					TextFieldExpression.setText(TextFieldExpression.getText() + carActuel);
				}
				else
					throw new ExceptionTropdOperateurs();
			}
		}catch(ExceptionTropdOperateurs ex){
			TextFieldExpression.setText(TextFieldExpression.getText().substring(0, TextFieldExpression.getText().length()-1) + carActuel);
		}
	}


	//Méthode qui évalue l'expression arithmétique puis calcule le résultat après que la touche '=' ait été préssée
	@FXML
	protected void actionBtEgal() throws ExceptionDivisionParZero{
		btEgalPressed = true;
		try{
			resultat = Calculatrice.calculer(TextFieldExpression.getText());
			TextFieldExpression.setText(String.valueOf(resultat));
		}catch(ExceptionDivisionParZero e){
			TextFieldExpression.setText(e.getMessage());
		}catch(NumberFormatException e){
			TextFieldExpression.setText("Erreur de syntaxe");
		}
		
	}

	//Méthode qui réinitialise tout suite à l'appui sur le bouton clear
	@FXML
	private void reinitialiser(){
		TextFieldExpression.setText("");
		resultat = 0;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TextFieldExpression.setText("");
	}
}
