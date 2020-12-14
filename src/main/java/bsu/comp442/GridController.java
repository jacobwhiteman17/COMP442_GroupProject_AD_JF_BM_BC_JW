package bsu.comp442;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class GridController {
    @FXML
    public TitledPane job1,job2,job3,job4,job5,job6;
    public Text desc1,desc2,desc3,desc4,desc5,desc6;
    public Button refresh,listview;

    sJob studentJob1,studentJob2,studentJob3,studentJob4,studentJob5,studentJob6;

    public sJob getRandomObject(sJob[] arrayOfJobs)
    {
        Random rand = new Random();
        sJob next = arrayOfJobs[rand.nextInt(arrayOfJobs.length)];
        return next;
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) listview.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void listviewPressed()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bsu/comp442/BSUJobBoardListView.fxml"));
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
    public void refreshPressed()
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

            //grid view
            job1.setText(studentJob1.getTitle());
            job2.setText(studentJob2.getTitle());
            job3.setText(studentJob3.getTitle());
            job4.setText(studentJob4.getTitle());
            job5.setText(studentJob5.getTitle());
            job6.setText(studentJob6.getTitle());

            //grid view
            desc1.setText(studentJob1.getDescription());
            desc2.setText(studentJob2.getDescription());
            desc3.setText(studentJob3.getDescription());
            desc4.setText(studentJob4.getDescription());
            desc5.setText(studentJob5.getDescription());
            desc6.setText(studentJob6.getDescription());

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
