package proyectoFinalPrimeraParte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {

    private final MiFigura figuras[];
    private int cuentaFigura;
    private int tipoFigura;
    private MiFigura figuraActual;
    private MiFiguraDelimitada figuraAux;
    private Color colorActual;
    private boolean figuraRellena;
    private final JLabel etiquetaEstado;
    private boolean arrastrando;
    private int grosorActual; //*********************
    MarcoDibujo interfaz;

    public PanelDibujo(JLabel etiquetaEstado, MarcoDibujo interfaz) {
        this.etiquetaEstado = etiquetaEstado;
        this.setBackground(Color.WHITE);
        figuras = new MiFigura[100];
        cuentaFigura = 0;
        tipoFigura = 1;
        figuraActual = null;
        colorActual = Color.BLACK;
        this.interfaz = interfaz;
        arrastrando = false;
        grosorActual = 0; //******
        Eventos raton = new Eventos();
        this.addMouseListener(raton);
        this.addMouseMotionListener(raton);
        EventosClick click = new EventosClick();
        interfaz.deshacer.addActionListener(click);
        interfaz.borrar.addActionListener(click);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arrastrando) {
            switch (tipoFigura) {
                case 0:
                    g.drawOval(figuraAux.calcularX1(), figuraAux.calcularY1(), figuraAux.anchura(), figuraAux.altura());
                    break;
                case 1:
                    g.drawLine(figuraAux.getObtenerX1(), figuraAux.getObtenerY1(), figuraAux.getObtenerX2(), figuraAux.getObtenerY2());
                    break;
                case 2:
                    g.drawRect(figuraAux.calcularX1(), figuraAux.calcularY1(), figuraAux.anchura(), figuraAux.altura());
                    break;
            }
        }
        for (int i = 0; i < cuentaFigura; i++) {
            figuras[i].dibujar(g);
        }
    }

    public void setEstablecerTipoFigura(int tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    public void setEstablecerColorActual(Color colorActual) {
        this.colorActual = colorActual;
    }

    public void setEstablecerFiguraRellena(boolean figuraRellena) {
        this.figuraRellena = figuraRellena;
    }

    public void setEstablecerGrosorActual(int grosorActual) { //+*****
        this.grosorActual = grosorActual;
    }

    public void borrarUltimaFigura() {
        if (cuentaFigura > 0) {
            cuentaFigura--;
        }
        repaint();
    }

    public void borrarDibujo() {
        cuentaFigura = 0;
        repaint();
    }

    class Eventos extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent event) {
            int aux = 0;
            aux = (interfaz.figuras.getSelectedItem().equals("Linea")) ? 1 : aux;
            aux = (interfaz.figuras.getSelectedItem().equals("Rectangulo")) ? 2 : aux;
            aux = (interfaz.figuras.getSelectedItem().equals("Escribir")) ? 3 : aux;
            setEstablecerTipoFigura(aux);
            figuraActual = new MiLinea();
            figuraActual.setEstablecerX1(event.getX());
            figuraActual.setEstablecerY1(event.getY());
            figuraAux = new MiOvalo();
            figuraAux.setEstablecerX1(figuraActual.getObtenerX1());
            figuraAux.setEstablecerY1(figuraActual.getObtenerY1());
            for (int i = 0; i < interfaz.arregloColores.length; i++) {
                if (interfaz.arregloColores[i].equals(interfaz.colores.getSelectedItem())) {
                    setEstablecerColorActual(interfaz.fuenteColores[i]);
                    break;
                }
            }
            figuraActual.setEstablecerColor(colorActual);

            for (int j = 0; j < interfaz.arregloGrosores.length; j++) { //***
                if (interfaz.arregloGrosores[j].equals(interfaz.grosores.getSelectedItem())) {
                    setEstablecerGrosorActual(interfaz.fuenteGrosores[j]);
                    break;
                }
            }
        figuraActual.setEstablecerGrosor(grosorActual);//**
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            figuraActual.setEstablecerX2(event.getX());
            figuraActual.setEstablecerY2(event.getY());
            if (interfaz.rellena.isSelected()) {
                setEstablecerFiguraRellena(true);
            } else {
                setEstablecerFiguraRellena(false);
            }
            switch (tipoFigura) {
                case 0:
                    figuraAux = new MiOvalo();
                    figuraAux.setDefinirRelleno(figuraRellena);
                    figuraActual = new MiOvalo(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor(), figuraAux.getObtenerRelleno(),figuraActual.getObtenerGrosor());//***
                    break;
                case 1:
                    figuraActual = new MiLinea(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor(),figuraActual.getObtenerGrosor());//***
                    break;
                case 2:
                    figuraAux = new MiRectangulo();
                    figuraAux.setDefinirRelleno(figuraRellena);
                    figuraActual = new MiRectangulo(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor(), figuraAux.getObtenerRelleno(),figuraActual.getObtenerGrosor());//*****
                    break;
                case 3:
                    String temporal = "";
                    temporal = JOptionPane.showInputDialog(null, "Que texto deseas agregar aquí");
                    figuraActual = new MiTexto(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor(), temporal,figuraActual.getObtenerGrosor());
                    break;
            }
            figuras[cuentaFigura] = figuraActual;
            cuentaFigura++;
            figuraActual = null;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent event) {
            etiquetaEstado.setText(event.getX() + " , " + event.getY());
            arrastrando = false;
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            arrastrando = true;
            figuraAux.setEstablecerX2(event.getX());
            figuraAux.setEstablecerY2(event.getY());
            repaint();
        }

    }

    class EventosClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == interfaz.deshacer) {
                borrarUltimaFigura();
            } else {
                borrarDibujo();
            }
        }

    }
}
