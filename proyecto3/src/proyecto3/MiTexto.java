package proyecto3;

import java.awt.Color;
import java.awt.Graphics;

public class MiTexto extends MiFigura {

    String texto;

    public MiTexto(int x1, int y1, int x2, int y2, Color color, String texto) {
        super(x1, y1, x2, y2, color);
        this.texto = texto;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getObtenerColor());
        g.drawString(texto, getObtenerX1(), getObtenerY1());
    }

}
