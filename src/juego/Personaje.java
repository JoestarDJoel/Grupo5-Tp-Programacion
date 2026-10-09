package juego;

import java.awt.Color;
import entorno.Entorno;
public class Personaje {
    private double x;
    private double y;
    private double ancho;
    private double alto;
    public Personaje(double x, double y) {
        this.x= x;
        this.y=y;
        this.ancho= 30;
        this.alto= 30;
    }
    public void dibujar(Entorno entorno){
        entorno.dibujarRectangulo(this.x,thix.y.this.ancho,this.alto,0, Color.Azul);
    }
    public void Aladerecha(){
        this.x +=3;
    }
    public void Alaizquierda(){
        this.x -=3;
    }
    public void Arriba(){
        this.y +=3;
    }
    public void Abajo(){
        this.y -=3;
    }
}
