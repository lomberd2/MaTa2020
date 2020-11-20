package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    private Graphics graph;
    private boolean isFirstTime = true;


    @Override
    public void paint(Graphics g) {
        //Init Graph
        if(isFirstTime){
            this.graph = g;
            isFirstTime = false;
        }

        super.paint(g);
        g.setFont(new Font("Dialog", Font.PLAIN, 18));
        g.setColor(Color.BLUE);
        g.drawString("Hallo Welt", 10,40);

        drawAll(g);
    }

    public void drawRect(RectObj obj){
        Graphics gra = this.getGraphics();
        gra.setColor(obj.color);
        gra.drawRect(obj.pos[0], obj.pos[1], obj.size[0], obj.size[1]);
        System.out.println("Draw Rect at index: " + obj.index);
    }

    private void drawAll(Graphics g){
        ArrayList<RectObj> rectobjs = MiniGame.getRectObjs();
        for(RectObj obj: rectobjs){
            System.out.println("Draw Rect at index: " + obj.index);
            g.setColor(obj.color);
            g.drawRect(obj.pos[0], obj.pos[1], obj.size[0], obj.size[1]);
        }
    }

}
