package CefTest;

import GUI.WindowFunctions;
import com.teamdev.jxbrowser.browser.Browser;
import javafx.application.Application;
import javafx.stage.Stage;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.OS;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.browser.CefMessageRouter;
import org.cef.callback.CefQueryCallback;
import org.cef.handler.*;
import org.cef.network.CefRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.event.MouseWheelEvent.WHEEL_UNIT_SCROLL;

public class App {
    public App app;
    final JFrame mainFrame;
    final CefApp cefApp;
    final CefClient client;
    final CefBrowser browser;
    final Component browserUI;

    public App(){
        // Create a new frame for holding the browser ui
        mainFrame = new JFrame();
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
        browser = client.createBrowser( "https://html5test.com/", OS.isWindows(), true);
        /*
         * Returns the browser's ui component used for
         * rendering in a awt application
         */
        browserUI = browser.getUIComponent();

        app = this;

        init();
    }

    /**
     * Initialisiert den Browser und das Swing Fenster
     */
    private void init(){
        setupSwingComponents();
        setupEvents();
        setupClientEvents();
        //Testing
        setupBrowser();
    }

    /**
     * Erstellt die Swing Componenten und Öffnet diese
     */
    private void setupSwingComponents(){
        // Add the browser ui to this newly created frame
        mainFrame.getContentPane().add(browserUI, BorderLayout.CENTER);
        mainFrame.setSize(800, 600); mainFrame.setVisible(true);
        mainFrame.setLocation(WindowFunctions.screenCenter(WindowFunctions.getScreenSize(), mainFrame.getSize()));
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

        for (MouseWheelListener listener:browserUI.getMouseWheelListeners()) {
            browserUI.removeMouseWheelListener(listener);
        }
        browserUI.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved (MouseWheelEvent e){
                CefFrame frame = browser.getMainFrame();
                browser.executeJavaScript("window.scrollBy(" + 0 + "," + e.getPreciseWheelRotation() * 50 + ")", frame.getURL(), 0);
                setupBrowser();
            }
        });
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
        CefFrame frame = browser.getMainFrame();
        frame.executeJavaScript("alert('test');", frame.getURL(), 0);
    }
}