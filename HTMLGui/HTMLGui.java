package HTMLGui;

import FXGui.FXGui;
import javafx.application.Application;

public class HTMLGui {
    private static HTMLFx mainFx;


    public HTMLGui(){
        //Start HTML Gui
        new Thread(() -> Application.launch(HTMLFx.class)).start();
        mainFx = HTMLFx.getThis();
    }

    public HTMLGui getHTMLGui(){
        return this;
    }
}
