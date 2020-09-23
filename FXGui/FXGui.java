package FXGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXGui extends Application {
    private static FXGui fxGui;

    public FXGui(){
        if(fxGui == null){
            fxGui = this;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static FXGui getThis(){
        return fxGui;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
            Scene mainScene = new Scene(root , root.getPrefWidth(), root.getPrefHeight(), Color.BLUE);

            primaryStage.setScene(mainScene);
            primaryStage.setTitle("TestGui");
            primaryStage.show();
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
    }
}
