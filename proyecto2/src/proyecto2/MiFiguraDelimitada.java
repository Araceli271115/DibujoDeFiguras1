package proyecto2;

import java.awt.Color;
import static java.lang.Math.abs;

public abstract class MiFiguraDelimitada extends MiFigura {

    boolean relleno;

    public MiFiguraDelimitada() {
        super();
    }

    public MiFiguraDelimitada(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
        super(x1, y1, x2, y2, color);
        this.relleno = relleno;
    }

    public boolean getObtenerRelleno() {
        return relleno;
    }

    public void setDefinirRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public int calcularX1() {
        return (getObtenerX1() < getObtenerX2()) ? getObtenerX1() : getObtenerX2();
    }

    public int calcularY1() {
        return (getObtenerY1() < getObtenerY2()) ? getObtenerY1() : getObtenerY2();
    }

    public int anchura() {
        return (abs(getObtenerX1() - getObtenerX2()));
    }

    public int altura() {
        return (abs(getObtenerY1() - getObtenerY2()));
    }
}