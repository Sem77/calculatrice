Projet de calculatrice

Langage utilisé: Java
Interface graphique: javafx

-------------------------------------------------------------------------------------------------------------
Compilation et lancement:
Le projet est déja pseudo-compilé
Exécuter la commande make pour le peudo-compiler si on le souhaite
Exécuter le fichier execution.bat sous windows pour exécuter le projet


-------------------------------------------------------------------------------------------------------------
Fonctionnement du programme complet:
    Lors de l'appui sur le bouton égal, l'expression arithmétique dans la zone texte est récupérée
    et est passée comme paramètre à la méthode statique calculer de la classe Calculatrice.
    La classe calculatrice évalue l'expression puis lance d'éventuelles erreurs qui seront attrapées
    dans la classe MainController.
    S'il n'y a aucune erreur, la classe calculatrice calcule le résultat puis le retourne à la classe
    MainController qui à son tour affichera le résultat à l'écran.


-------------------------------------------------------------------------------------------------------------
Fonctionnement de la classe App:
    La classe App affiche l'interface graphique à l'écran en chargeant le fichier Ui.fxml qui à son tour
    charge le fichier style.css pour la décoration.


-------------------------------------------------------------------------------------------------------------
Fonctionnement de la classe MainController:
    Méthode ecrire:
        Elle capture toutes les touches pressées et effectue
        l'action souhaitée (soit afficher à l'écran, soit l'agalité, soit effacer)

    Méthode actionBtEgal:
        Est appelée lors d'un appui sur la touche "=".
        Elle récupère l'expression tapée à l'écran, l'envoie à la classe Calculatrice, récupère le résultat
        et l'affiche à l'écran.
        Cette méthode gère aussi les erreurs.

    Méthode reinitialiser:
        Elle est appelée lors de l'appui du le bouton "CLEAR"
        Elle efface l'expression arithmétique à l'écran et réinitialise la variable resultat à 0.


-------------------------------------------------------------------------------------------------------------
Fonctionnement de la class Calculatrice:
    Méthode calculer:
        Elle prend en paramètre l'expression à calculer, puis rajouter le signe "+" devant tous les "-"
        Ceci pour que la soustraction soit traitée comme une addition de nombre(s) négatif(s)
        Elle envoie ensuite la nouvelle expression à la méthode calcSousExpPlus
        Exemple d'expression: 68+98*4/2+-52+8/98+-53+4*6

    Méthode calcSousExpPlus:
        Cette méthode utilise la classe StringTokenizer pour séparer l'expression en plusieurs tokens
        selon le séparateur "+".

        Elle envoie ensuite chaque token à la méthode calcSousExpProd puis fait la somme de entre
        chaque résultat de token renvoyés par la méthode calcSousExpProd 
        tokens obtenus après avoir séparer: (68) (98*4/2) (-52) (8/98) (-53) (4*6)

        Pour l'exemple on ne va utliser que le token (98*4/2) main l'opération sera la même pour tous
        les autres.
        Expression envoyée à calcSousExpProd: (98*4/2)

    Méthode calcSousExpProd:
        Elle la même chose que la méthode calcSousExpPlus sauf qu'elle sépare selon le séparateur "*"
        et envoie les tokens à la méthode calcSousExpDiv, puis fait le produit des résultats de tokens
        renvoyés par calcSousExpDiv.
        Expressions envoyées à calcSousExpDiv: (98) et (4/2)

    Méthode calcSousExpDiv:
        Elle divise selon le séparateur "/" et fait la division puis renvoie les résultats à la 
        méthode calcSousExpProd
        Expressions renvoyées à calcSousExpProd: 98 et 2
        