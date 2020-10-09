package CefTest;

import GUI.WindowFunctions;
import com.teamdev.jxbrowser.browser.Browser;
import javafx.application.Application;
import javafx.stage.Stage;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.OS;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.browser.CefMessageRouter;
import org.cef.callback.CefQueryCallback;
import org.cef.handler.*;
import org.cef.network.CefRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.event.MouseWheelEvent.WHEEL_UNIT_SCROLL;

public class App {
    public App app;
    private JFrame mainFrame;
    private CefApp cefApp;
    private CefClient client;
    private CefBrowser browser;
    private Component browserUI;

    public App(){

        /* * Gets the cef application singleton. It loads all resources
         * (native libraries etc.), initializes app...
         */
        cefApp = CefApp.getInstance();
        /*
         * You can create many browser instances per cef app (e.g.
         * used as browser tabs) Responsible for handling all
         * events from the browser instances.
         */
        client = cefApp.createClient();
        /*
         * Browser instances are responsible for rendering of
         * the browser's content.
         */
        browser = client.createBrowser( "https://google.com/", OS.isWindows(), false);
        /*
         * Returns the browser's ui component used for
         * rendering in a awt application
         */
        browserUI = browser.getUIComponent();

        // Create a new frame for holding the browser ui
        mainFrame = new JFrame();

        app = this;

        init();
    }

    public static void main(){

    }

    /**
     * Initialisiert den Browser und das Swing Fenster
     */
    private void init(){
        setupSwingComponents();
        //setupEvents();
        //setupClientEvents();

        //Testing
        //setupBrowser();
    }

    /**
     * Erstellt die Swing Componenten und Öffnet diese
     */
    private void setupSwingComponents(){
        Button btn1 = new Button();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.executeJavaScript("alert('test');","warnung", 0);
            }
        });

        mainFrame.getContentPane().add(btn1, BorderLayout.PAGE_START);

        // Add the browser ui to this newly created frame
        mainFrame.getContentPane().add(browserUI, BorderLayout.CENTER);
        mainFrame.setSize(800, 600); mainFrame.setVisible(true);
        //mainFrame.setLocation(WindowFunctions.screenCenter(WindowFunctions.getScreenSize(), mainFrame.getSize()));
    }

    /**
     * Erstellt alle Events die mit dem Browser Window in Verknüpfung sind.
     */
    private void setupEvents(){
        /*
         * Attach a handler to close the jcef application.
         * Dispose the JFrame and after that destroy the cefApp
         */
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                mainFrame.dispose();
                cefApp.dispose();
                System.exit(1);
                // Alternative: CefApp.getInstance().dispose();
            }
        });

        removeAllMouseListener();

        browserUI.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved (MouseWheelEvent e){
                CefFrame frame = browser.getMainFrame();
                browser.executeJavaScript("window.scrollBy(" + 0 + "," + e.getPreciseWheelRotation() * 30 + ")", "Main", 0);
            }
        });

    }

    private void removeAllMouseListener(){
        for (MouseWheelListener listener:browserUI.getMouseWheelListeners()) {
            browserUI.removeMouseWheelListener(listener);
        }
    }

    private void setupClientEvents(){
        CefMessageRouter msgRouter = CefMessageRouter.create();

        msgRouter.addHandler(new CefMessageRouterHandler() {
            @Override
            public boolean onQuery(CefBrowser cefBrowser, CefFrame cefFrame, long query_id, String request, boolean b, CefQueryCallback cefQueryCallback) {
                System.out.println(request); // prints "Hello World"
                return false;
            }

            @Override
            public void onQueryCanceled(CefBrowser cefBrowser, CefFrame cefFrame, long l) {

            }

            @Override
            public void setNativeRef(String s, long l) {

            }

            @Override
            public long getNativeRef(String s) {
                return 0;
            }
        }, true);
        client.addMessageRouter(msgRouter);
    }

    private void setupBrowser(){
        //CefFrame frame = browser.getMainFrame();
        //frame.executeJavaScript("alert('test');", frame.getURL(), 0);
    }
}