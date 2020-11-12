package GUI;

import javax.swing.*;
import java.awt.event.*;

public class DialogWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel displayText;

    public DialogWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void createDialog(String WindowTitel, String WindowText) {
        DialogWindow dialog = new DialogWindow();
        dialog.pack();

        //Set Values
        dialog.setTitle(WindowTitel);
        dialog.displayText.setText(WindowText);
        dialog.displayText.setHorizontalTextPosition(SwingConstants.CENTER);
        dialog.displayText.setVerticalTextPosition(SwingConstants.CENTER);

        //setCenter
        System.out.println(WindowFunctions.getScreenSize());
        dialog.setLocation(WindowFunctions.screenCenter(WindowFunctions.getScreenSize(), dialog.getSize()));

        dialog.setVisible(true);
        //System.exit(0);
    }

}
