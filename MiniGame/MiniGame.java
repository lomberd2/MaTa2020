package MiniGame;
import Aufgaben.IO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MiniGame {
    GameFrame frame;
    private static ArrayList<RectObj> rectObjs = new ArrayList<RectObj>();

    public MiniGame(){
        frame = new GameFrame();
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        init();
    }

    private void init(){
        System.out.println("Input: ");
        int input = IO.readInteger();
        if(input == 1){
            //test();
            initObjects();
            System.out.println("Test");
        }
    }

    private RectObj createNewRect(int[] pos, int[] size, Color color){
        RectObj obj = new RectObj();
        obj.pos = pos;
        obj.size = size;
        obj.color = color;

        return obj;
    }

    private void addRectToArray(RectObj obj){
        try {
            int i = rectObjs.size();
            obj.index = i;
            rectObjs.add(obj);
        }catch (Exception e){
            e.printStackTrace();
            obj.index = 0;
            rectObjs.add(obj);
        }
    }

    private boolean initObjects(){
        //Test
        int[] pos = {12, 100};
        int[] size = {25, 50};
        addRectToArray(createNewRect(pos, size, Color.BLACK));

        pos = new int[]{50, 100};
        size = new int[]{25, 50};
        addRectToArray(createNewRect(pos, size, Color.BLACK));

        for(int i = 0; i < rectObjs.size(); i++){
            frame.drawRect(rectObjs.get(i));
        }
        return true;
    }

    public static ArrayList<RectObj> getRectObjs(){
        return rectObjs;
    }
}

class RectObj{
    int index;
    int[] pos;
    int[] size;
    Color color;
}
