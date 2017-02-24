package proyectoFinalPrimeraParte;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoDibujo extends JFrame {

    private final JPanel arriba;
    JButton deshacer;
    JButton borrar;
    JComboBox<String> colores;
    JComboBox<String> figuras;
    JComboBox<String> grosores; //***********
    JCheckBox rellena;
    String arregloColores[];
    Color fuenteColores[];
    private final String arregloFiguras[];
    String arregloGrosores[]; //**********+
    int fuenteGrosores[];//***********

    public MarcoDibujo() {
        this.arregloColores = new String[]{"Negro", "Azul", "Turqueza", "Gris oscuro", "Gris", "Verde", "Gris claro", "Violeta", "Naranja", "Rosa", "Rojo", "Blanco", "Amarrillo"};
        this.fuenteColores = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
        this.arregloFiguras = new String[]{"Ovalo", "Linea", "Rectangulo", "Escribir"};
        this.arregloGrosores=new String[]{"Grosor1","Grosor2","Grosor3","Grosor4","Grosor5","Grosor6","Grosor7","Grosor8","Grosor9","Grosor10","Grosor11","Grosor12","Grosor13","Grosor14","Grosor15"}; //***
        this.fuenteGrosores=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};//***
        setLayout(new BorderLayout());
        arriba = new JPanel();
        arriba.setBackground(Color.DARK_GRAY);
        deshacer = new JButton("Deshacer");
        deshacer.setBackground(Color.LIGHT_GRAY);
        arriba.add(deshacer);
        borrar = new JButton("Borrar");
        borrar.setBackground(Color.LIGHT_GRAY);
        arriba.add(borrar);
        colores = new JComboBox<>(arregloColores);
        colores.setBackground(Color.LIGHT_GRAY);
        arriba.add(colores);
        figuras = new JComboBox<>(arregloFiguras);
        figuras.setBackground(Color.LIGHT_GRAY);
        arriba.add(figuras);
        rellena = new JCheckBox("Rellena");
        rellena.setBackground(Color.LIGHT_GRAY);
        arriba.add(rellena);
        grosores = new JComboBox<>(arregloGrosores); //***+
        grosores.setBackground(Color.LIGHT_GRAY);//***
        arriba.add(grosores);//**
        add(arriba, BorderLayout.NORTH);
        JLabel etiquetaEstado = new JLabel("");
        add(etiquetaEstado, BorderLayout.SOUTH);
        PanelDibujo panelCentral = new PanelDibujo(etiquetaEstado, this);
        add(panelCentral, BorderLayout.CENTER);
    }
}
