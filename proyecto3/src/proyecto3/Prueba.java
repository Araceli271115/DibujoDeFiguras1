package proyecto3;

import javax.swing.JFrame;

public class Prueba {

    public static void main(String[] args) {
        MarcoDibujo marco = new MarcoDibujo();
        //marco.setSize(Toolkit.getDefaultToolkit().getScreenSize());    Para hacer la ventana del tamaño de la pantalla
        marco.setSize(700, 500);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
