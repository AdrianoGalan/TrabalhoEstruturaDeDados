package view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Adriano
 */
public class Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        
        Parent root = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

//        inicia maiximizado
//        stage.setMaximized(true);
//        retira botão de fechar
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}