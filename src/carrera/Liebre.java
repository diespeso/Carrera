package carrera;
import java.util.Random;
/**
 * @version 0.0.1
 * Created by radge on 27/06/17.
 */
class Liebre {
    private int posicionActual = 1;

    private Random random = new Random();

//  DORMIR = 0; %20
//  GRAN_SALTO = 9; // %20
//  GRAN_RESBALON = 12; // %10
//  PEQUENO_SALTO = 1; // %30
//  PEQUENO_RESBALON = 2; // %20

    void hacerMovimiento() {
        int aleatorio = random.nextInt(10) + 1;
        if(aleatorio >= 1 && aleatorio <= 2) {
            dormir();
        } else if(aleatorio >= 3 && aleatorio <= 4) {
            darGranSalto();
        } else if(aleatorio == 5) {
            darGranResbalon();
        } else if(aleatorio >= 6 && aleatorio <= 8) {
            darPequenoSalto();
        } else if(aleatorio >= 9 && aleatorio <= 10) {
            darPequenoResbalon();
        }
        if(isPosicionIlegal()) {
            legalizarPosicionActual();
        }
    }

    private void dormir() {
        // no se hace nada
    }

    private void darGranSalto() {
        final int GRAN_SALTO = 9;
        aumentarPosicionActual(GRAN_SALTO);
    }

    private void darGranResbalon() {
        final int GRAN_RESBALON = 12;
        disminuirPosicionActual(GRAN_RESBALON);
    }

    private void darPequenoSalto() {
        final int PEQUENO_SALTO = 1;
        aumentarPosicionActual(PEQUENO_SALTO);
    }

    private void darPequenoResbalon() {
        final int PEQUENO_RESBALON = 2;
        disminuirPosicionActual(PEQUENO_RESBALON);
    }

    private void aumentarPosicionActual(int posiciones) {
        posicionActual += posiciones;
    }

    private void disminuirPosicionActual(int posiciones) {
        posicionActual -= posiciones;
    }

    private boolean isPosicionIlegal() {
        boolean ilegal = false;
        if(posicionActual < 0 || posicionActual > 70) {
            ilegal = true;
        }
        return ilegal;
    }

    private void legalizarPosicionActual() {
        if(posicionActual > 70) {
            posicionActual = 70;
        } else if(posicionActual < 0) {
            posicionActual = 0;
        }
    }

    int getPosicionActual() {
        return posicionActual;
    }
}
