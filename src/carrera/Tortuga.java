package carrera;
import java.util.Random;
/**
 * @author radge
 * @version 0.0.1
 *
 * Created by radge on 27/06/17.
 */
class Tortuga {
    private int posicionActual = 1;

    private Random random = new Random();

//    PASO_RAPIDO 50%
//    RESBALON = 6; // 20%
//    int PASO_LENTO = 1; // 30%

    void hacerMovimiento() {
        int aleatorio = random.nextInt(10) + 1 ;
        if(1 <= aleatorio && aleatorio <= 5) {
            darPasoRapido();
        } else if(6 <= aleatorio && aleatorio <= 7) {
            darResbalon();
        } else if(8 <= aleatorio && aleatorio <= 10) {
            darPasoLento();
        }
    }

    private void darPasoRapido() {
        final int PASO_RAPIDO = 3;
        aumentarPosicionActual(PASO_RAPIDO);
    }

    private void darResbalon() {
        final int RESBALON = 6;
        disminuirPosicionActual(RESBALON);
    }

    private void darPasoLento() {
        final int PASO_LENTO = 1;
        aumentarPosicionActual(PASO_LENTO);
    }

    private void aumentarPosicionActual(int posiciones) {
        posicionActual += posiciones;
        if(posicionActual > 70) {
            posicionActual = 70;
        }
    }

    private void disminuirPosicionActual(int posiciones) {
        posicionActual -= posiciones;
        if(isPosicionIlegal()) {
            legalizarPosicionActual();
        }
    }

    private boolean isPosicionIlegal() {
        boolean ilegal = false;
        if(posicionActual <= 0) {
            ilegal = true;
        }
        return ilegal;
    }

    private void legalizarPosicionActual() {
        posicionActual = 1;
    }

    int getPosicionActual() {
        return posicionActual;
    }
}


