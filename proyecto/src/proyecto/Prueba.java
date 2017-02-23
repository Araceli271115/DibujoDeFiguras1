package proyecto;

import java.awt.Color;
import javax.swing.JFrame;

public class Prueba {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setSize(1000, 1000);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //      MiLinea obj = new MiLinea(0, 0, 100, 100, Color.red);
    //    ventana.add(obj);
    MiRectangulo obj1 = new MiRectangulo(100, 100, 500, 200, Color.blue,true);
        ventana.add(obj1);
//         MiOvalo obj2 = new MiOvalo(0, 700, 400, 200, Color.blue,true);
//        ventana.add(obj2);
        ventana.setVisible(true);

    }
}
