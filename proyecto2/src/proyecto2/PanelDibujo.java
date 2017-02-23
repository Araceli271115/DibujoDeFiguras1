package proyecto2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
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
                    figuraActual = new MiOvalo(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor(), figuraAux.getObtenerRelleno());
                    break;
                case 1:
                    figuraActual = new MiLinea(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor());
                    break;
                case 2:
                    figuraAux = new MiRectangulo();
                    figuraAux.setDefinirRelleno(figuraRellena);
                    figuraActual = new MiRectangulo(figuraActual.getObtenerX1(), figuraActual.getObtenerY1(), figuraActual.getObtenerX2(), figuraActual.getObtenerY2(), figuraActual.getObtenerColor(), figuraAux.getObtenerRelleno());
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
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            Graphics g = getGraphics();
            figuraAux.setEstablecerX2(event.getX());
            figuraAux.setEstablecerY2(event.getY());
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
            repaint();
            g.dispose();
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