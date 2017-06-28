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
        }
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
        if(isLiebreGano(liebre) || isTortugaGano(tortuga)) {
            continuar = false;
        }
        return continuar;
    }

    private static boolean isLiebreGano(Liebre liebre) {
        boolean gano = false;
        if(liebre.getPosicionActual() == 70) {
            gano = true;
            System.out.println("La liebre gana, que lástima");
        }
        return gano;
    }

    private static boolean isTortugaGano(Tortuga tortuga) {
        boolean gano = false;
        if(tortuga.getPosicionActual() == 70) {
            gano = true;
            System.out.println("La tortuga gana, yay");
        }
        return gano;
    }
}
