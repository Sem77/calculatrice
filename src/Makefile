App.class : Calculatrice.class MainController.class ExceptionTropdOperateurs.class ExceptionDivisionParZero.class
	javac --module-path "..\javafx-sdk-11.0.2\lib" --add-modules=javafx.fxml,javafx.controls App.java

MainController.class : Calculatrice.class ExceptionTropdOperateurs.class
	javac --module-path "..\javafx-sdk-11.0.2\lib" --add-modules=javafx.fxml,javafx.controls com\sem\controller\MainController.java

Calculatrice.class :
	javac com\sem\calculatrice\Calculatrice.java

ExceptionTropdOperateurs.class :
	javac com\sem\exceptions\ExceptionTropdOperateurs.java

ExceptionDivisionParZero.class :
	javac com\sem\exceptions\ExceptionDivisionParZero.java