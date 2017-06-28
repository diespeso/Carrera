package carrera;

/**
 * @version 0.0.1
 * @author radge
 * Created by radge on 27/06/17.
 */
public class Main {


    public static void main(String[] args) {
        Tortuga tortuga = new Tortuga();
        Liebre liebre = new Liebre();
        String[] pista = new String[71]; //70 en la version final

        System.out.println("Empieza la carrera");
        while(isContinuar(liebre, tortuga)) {
            limpiarPista(pista);
            turno(liebre, tortuga);
            posicionarLiebre(pista, liebre);
            posicionarTortuga(pista, tortuga);
            morder(pista, liebre, tortuga);
            imprimirPista(pista);
            darVeredicto(liebre, tortuga);
        }
    }

    private static void darVeredicto(Liebre liebre, Tortuga tortuga) {
        if(isEmpate(liebre, tortuga)) {
            mostrarMensajeEmpate();
        } else if(isLiebreGano(liebre)) {
            mostrarVictoriaLiebre();
        } else if(isTortugaGano(tortuga)) {
            mostrarVictoriaTortuga();
        }
    }

    private static void mostrarMensajeEmpate() {
        System.out.println("Es un empate");
    }

    private static boolean isEmpate(Liebre liebre, Tortuga tortuga) {
        return isLiebreGano(liebre) && isTortugaGano(tortuga);
    }

    private static void morder(String[] pista, Liebre liebre, Tortuga tortuga) {
        int posicionLiebre = liebre.getPosicionActual();
        int posicionTortuga = tortuga.getPosicionActual();

        if(posicionLiebre == posicionTortuga) {
            pista[posicionLiebre] = "X";
            System.out.println("Ouch");
        }
    }

    private static void imprimirPista(String[] pista) {
        for(String elemento : pista) {
            System.out.printf("%s  ", elemento);
        }
        System.out.println();
    }

    private static void limpiarPista(String[] pista) {
        for(int i = 0; i < pista.length; i++) {
            pista[i] = "-";
        }
    }

    private static void posicionarTortuga(String[] pista, Tortuga tortuga) {
        int posicionTortuga = tortuga.getPosicionActual();
        pista[posicionTortuga] = "T";
    }

    private static void posicionarLiebre(String[] pista, Liebre liebre) {
        int posicionLiebre = liebre.getPosicionActual();
        pista[posicionLiebre] = "L";
    }

    private static void turno(Liebre liebre, Tortuga tortuga) {
        liebre.hacerMovimiento();
        tortuga.hacerMovimiento();
    }

    private static boolean isContinuar(Liebre liebre, Tortuga tortuga) {
        boolean continuar = true;
        if(isEmpate(liebre, tortuga)) {
            continuar = false;
        } else if (isTortugaGano(tortuga)) {
            continuar = false;
        } else if(isLiebreGano(liebre)) {
            continuar = false;
        }
        return continuar;
    }

    private static void mostrarVictoriaLiebre() {
        System.out.println("La liebre gana, qué lástima");
    }

    private static void mostrarVictoriaTortuga() {
        System.out.println("La tortuga gana, yay");
    }

    private static boolean isLiebreGano(Liebre liebre) {
        boolean gano = false;
        if(liebre.getPosicionActual() == 70) {
            gano = true;
        }
        return gano;
    }

    private static boolean isTortugaGano(Tortuga tortuga) {
        boolean gano = false;
        if(tortuga.getPosicionActual() == 70) {
            gano = true;
        }
        return gano;
    }
}
