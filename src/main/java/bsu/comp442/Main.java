package bsu.comp442;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = null;
        var loc = getClass().getResource("/bsu/comp442/BSUJobBoardGridView.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file");
        }
        Scene windowContents = new Scene(root, 1200,800);
        primaryStage.setScene(windowContents);
        primaryStage.setTitle("BSU Job Board");
        primaryStage.show();//setting the stage
    }
}
