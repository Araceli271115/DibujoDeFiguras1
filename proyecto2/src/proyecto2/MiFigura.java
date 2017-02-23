package proyecto2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MiFigura {

    private int coordenadaX1;
    private int coordenadaY1;
    private int coordenadaX2;
    private int coordenadaY2;
    private Color color;

    public MiFigura() {
        this.coordenadaX1 = 0;
        this.coordenadaY1 = 0;
        this.coordenadaX2 = 0;
        this.coordenadaY2 = 0;
        this.color = Color.BLACK;
    }

    public MiFigura(int x1, int y1, int x2, int y2, Color color) {
        this.coordenadaX1 = x1;
        this.coordenadaY1 = y1;
        this.coordenadaX2 = x2;
        this.coordenadaY2 = y2;
        this.color = color;
    }

    public abstract void dibujar(Graphics g);

    public void setEstablecerX1(int x1) {
        this.coordenadaX1 = x1;
    }

    public int getObtenerX1() {
        return coordenadaX1;
    }

    public void setEstablecerY1(int y1) {
        this.coordenadaY1 = y1;
    }

    public int getObtenerY1() {
        return coordenadaY1;
    }

    public void setEstablecerX2(int x2) {
        this.coordenadaX2 = x2;
    }

    public int getObtenerX2() {
        return coordenadaX2;
    }

    public void setEstablecerY2(int y2) {
        this.coordenadaY2 = y2;
    }

    public int getObtenerY2() {
        return coordenadaY2;
    }

    public void setEstablecerColor(Color color) {
        this.color = color;
    }

    public Color getObtenerColor() {
        return color;
    }
}
