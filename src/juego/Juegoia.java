package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juegoia extends InterfaceJuego {

    // El objeto Entorno que controla el tiempo y gráficos
    private Entorno entorno;

    // Entidades y variables del juego
    private Personaje personaje;
    private Ladron[] ladrones;
    private int puntaje;
    private Fondo fondo;
    private Manzana manzana;
    private Vidas vidas;

    Juegoia() {
        // Inicializa el objeto entorno (crea la ventana de 800x600)
        this.entorno = new Entorno(this, "Repartidor Mercado Libre", 800, 600);

        // Inicializar las entidades del juego
        this.fondo = new Fondo(400, 300); // Ejemplo con el centro de la pantalla
        this.personaje = new Personaje(400, 500);
        this.manzana = new Manzana(400, 300);
        this.vidas = new Vidas(3);
        this.puntaje = 0;

        // Inicializar arreglo de ladrones
        this.ladrones = new Ladron[4];
        // Aquí puedes instanciar cada ladrón según tus necesidades

        // Inicia el juego
        this.entorno.iniciar();
    }

    /**
     * Ciclo principal del juego (se ejecuta ~60 veces por segundo).
     */
    @Override
    public void tick() {
        // 1. DIBUJAR FONDO Y ESCENARIO
        if (this.fondo != null) {
            this.fondo.dibujar(this.entorno);
        }
        if (this.manzana != null) {
            this.manzana.dibujar(this.entorno);
        }

        // 2. CONTROLES Y LÓGICA DEL JUGADOR
        if (this.personaje != null) {
            if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
                this.personaje.moverDerecha();
            }
            if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
                this.personaje.moverIzquierda();
            }
            if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
                this.personaje.moverArriba();
            }
            if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
                this.personaje.moverAbajo();
            }

            this.personaje.dibujar(this.entorno);
        }

        // 3. LÓGICA Y DIBUJADO DE LADRONES
        if (this.ladrones != null) {
            for (int i = 0; i < this.ladrones.length; i++) {
                if (this.ladrones[i] != null) {
                    this.ladrones[i].mover();
                    this.ladrones[i].dibujar(this.entorno);
                }
            }
        }

        // 4. INTERFAZ (HUD)
        this.entorno.cambiarFuente("Arial", 18, Color.WHITE);
        this.entorno.escribirTexto("Puntaje: " + this.puntaje, 20, 30);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}