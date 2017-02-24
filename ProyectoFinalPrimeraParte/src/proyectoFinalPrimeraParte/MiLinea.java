package proyectoFinalPrimeraParte;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class MiLinea extends MiFigura {

    public MiLinea() {
        super();
    }

    public MiLinea(int x1, int y1, int x2, int y2, Color color, int grosor) {
        super(x1, y1, x2, y2, color, grosor);
    }

    @Override
    public void dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(grosor);
        g2.setStroke(stroke);

        g.setColor(getObtenerColor());
        g.drawLine(getObtenerX1(), getObtenerY1(), getObtenerX2(), getObtenerY2());
    }
}
