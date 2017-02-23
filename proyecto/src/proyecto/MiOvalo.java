package proyecto;

import java.awt.Color;
import java.awt.Graphics;

public class MiOvalo extends MiFiguraDelimitada {

    public MiOvalo() {
        super();
    }

    public MiOvalo(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
        super(x1, y1, x2, y2, color, relleno);

    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getObtenerColor());
        if (getObtenerRelleno() == true) {
            g.fillOval(calcularX1(), calcularY1(), anchura(), altura());

        } else {

            g.drawOval(calcularX1(), calcularY1(), anchura(), altura());
        }
    }
}
