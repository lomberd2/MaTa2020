package HTMLGui;

import FXGui.FXGui;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HTMLFx extends Application {
    private static HTMLFx fxGui;

    public HTMLFx(){
        fxGui = this;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static HTMLFx getThis(){
        return fxGui;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("HTMLGuiMainFx.fxml"));
            Scene mainScene = new Scene(root , root.getPrefWidth(), root.getPrefHeight(), Color.BLUE);

            primaryStage.setScene(mainScene);
            primaryStage.setTitle("HTML Gui");

            initBrowser();

            primaryStage.show();

        }
        catch (Exception e){
            System.err.println(e);
            System.exit(1);
        }
    }

    private void initBrowser(){
        // Create and initialize the Engine
        EngineOptions options = EngineOptions.newBuilder(
                RenderingMode.HARDWARE_ACCELERATED).build();
        Engine engine = Engine.newInstance(options);

        Browser browser = engine.newBrowser();
        BrowserView view = BrowserView.newInstance(browser);
    }
}
