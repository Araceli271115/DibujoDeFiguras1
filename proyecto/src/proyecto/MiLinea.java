package proyecto;

import java.awt.Color;
import java.awt.Graphics;

public class MiLinea extends MiFigura {
    
    public MiLinea() {
        super();
    }
    
    public MiLinea(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(getObtenerColor());
        g.drawLine(getObtenerX1(), getObtenerY1(), getObtenerX2(), getObtenerY2());
    }
}
