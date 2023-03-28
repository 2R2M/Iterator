package com.example.lab_iterator;

import com.example.lab_iterator.model.ImageCollection;
import com.example.lab_iterator.model.Iterator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.lang.constant.Constable;
import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private Label welcomeText;
    @FXML
    private Button start_stop_button;
    @FXML
    private ImageView view;
    @FXML
    private TextField time;
    public ImageCollection imgs = new ImageCollection("");
    public Iterator iter_main = imgs.getIterator();
    private int i=100;
    private  Timeline timeline;
    private  boolean flag=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline = new Timeline(new KeyFrame(new Duration(i), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.setImage((Image) iter_main.next());
                System.out.println(i);
            }

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }
    public void setInterval(ActionEvent actionEvent) {
        i = Integer.parseInt(time.getText());
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(new Duration(i), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.setImage((Image) iter_main.next());
                System.out.println(i);
            }
        }));
    }

    @FXML
    public void next(ActionEvent actionEvent) {
        view.setImage((Image)iter_main.next());

    }

    @FXML
    public void previous(ActionEvent actionEvent) {
        view.setImage((Image) iter_main.previous());
    }

    public void start_stop(ActionEvent actionEvent) {
        if (flag) {
            start_stop_button.setText("Стоп");
            timeline.play();
            flag = false;

        } else {
            start_stop_button.setText("Старт");
            timeline.stop();
            flag = true;
        }
    }


}
