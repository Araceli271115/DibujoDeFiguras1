package proyecto2;

import javax.swing.JFrame;

public class Prueba {

    public static void main(String[] args) {
        MarcoDibujo marco = new MarcoDibujo();
        //marco.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        marco.setSize(700, 500);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
