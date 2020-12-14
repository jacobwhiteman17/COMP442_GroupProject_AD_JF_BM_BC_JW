package bsu.comp442;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class ListController {

    @FXML
    public Label listJob1,listJob2,listJob3,listJob4,listJob5,listJob6;
    public Text listDesc1,listDesc2,listDesc3,listDesc4,listDesc5,listDesc6;
    public Button listviewRefresh,listviewGridview;

    sJob studentJob1,studentJob2,studentJob3,studentJob4,studentJob5,studentJob6;

    public sJob getRandomObject(sJob[] arrayOfJobs)
    {
        Random rand = new Random();
        sJob next = arrayOfJobs[rand.nextInt(arrayOfJobs.length)];
        return next;
    }
    @FXML
    public void closeWindow() {
        Stage stage = (Stage) listviewGridview.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void listviewGridViewPressed()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bsu/comp442/BSUJobBoardGridView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
        closeWindow();
    }

    @FXML
    public void listviewRefreshPressed()
    {
        var gson = new Gson();
        try(Reader reader = new FileReader("StudentJobs.json")){
            sJob[] data = gson.fromJson(reader, sJob[].class);

            studentJob1 = getRandomObject(data);
            studentJob2 = getRandomObject(data);
            studentJob3 = getRandomObject(data);
            studentJob4 = getRandomObject(data);
            studentJob5 = getRandomObject(data);
            studentJob6 = getRandomObject(data);

            //listview
            listJob1.setText(studentJob1.getTitle());
            listJob2.setText(studentJob2.getTitle());
            listJob3.setText(studentJob3.getTitle());
            listJob4.setText(studentJob4.getTitle());
            listJob5.setText(studentJob5.getTitle());
            listJob6.setText(studentJob6.getTitle());

            //listview
            listDesc1.setText(studentJob1.getDescription());
            listDesc2.setText(studentJob2.getDescription());
            listDesc3.setText(studentJob3.getDescription());
            listDesc4.setText(studentJob4.getDescription());
            listDesc5.setText(studentJob5.getDescription());
            listDesc6.setText(studentJob6.getDescription());


        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
