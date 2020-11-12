package GUI;

import java.awt.*;

public class WindowFunctions {

    public static Dimension getScreenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Point screenCenter(Dimension screenDimension, Dimension frameSize) {
        Point ScreenCenterPoint = new Point();
        int screenX = screenDimension.width;
        int screenY = screenDimension.height;

        if (screenX == 0 || screenY == 0)
            getScreenSize();

        ScreenCenterPoint.x = (int) (screenX / 2) - (frameSize.width / 2);
        ScreenCenterPoint.y = (int) (screenY / 2) - (frameSize.height / 2);

        return ScreenCenterPoint;
    }
}