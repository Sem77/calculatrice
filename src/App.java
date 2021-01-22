import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("com/sem/controller/Ui2.fxml"));
		
		stage.setTitle("Calculatrice");
		stage.setResizable(false); 
		
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("style.css").toString());
		
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String args[]) {
		Application.launch(args);
	}
}
