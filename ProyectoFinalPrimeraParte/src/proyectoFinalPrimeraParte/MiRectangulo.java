package proyectoFinalPrimeraParte;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MiRectangulo extends MiFiguraDelimitada {

    public MiRectangulo() {
        super();
    }

    public MiRectangulo(int x1, int y1, int x2, int y2, Color color, boolean relleno,int grosor) {
        super(x1, y1, x2, y2, color, relleno,grosor);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getObtenerColor());
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(grosor);
        g2.setStroke(stroke);
        
        
        if (getObtenerRelleno() == true) {
            g.fillRect(calcularX1(), calcularY1(), anchura(), altura());
        } else {
            g.drawRect(calcularX1(), calcularY1(), anchura(), altura());
        }
    }

}
