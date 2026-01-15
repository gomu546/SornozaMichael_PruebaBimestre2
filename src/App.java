//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code

// No ponemos "package App;" porque el archivo está suelto en src
import App.ConsoleApp.KGD;
import App.ConsoleApp.SornozaMichael_SistemaRuso;
import Infrastructure.AppException;

public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA ANT-BOT INICIANDO ===");

        // 1. Instanciamos las clases necesarias
        KGD oKGD = new KGD("1751268655", "Michael Sornoza", "patmic", "123");
        SornozaMichael_SistemaRuso sistemaRuso = new SornozaMichael_SistemaRuso();

        try {
            // 2. Proceso de Autenticación
            if (sistemaRuso.SornozaMichael_autoentificar(oKGD)) {

                // Presentamos los datos del alumno
                sistemaRuso.SornozaMichael_presentar(oKGD);

                // 3. Ejecutamos la validación del bloque de texto
                sistemaRuso.SornozaMichael_mostrardatovalidas();

                System.out.println("\n[PROCESO COMPLETADO]");
                System.out.println("Las hormigas válidas y vivas han sido registradas en la base de datos.");
            } else {
                System.err.println("[ERROR] Usuario o clave incorrectos. Acceso denegado.");
            }

        } catch (AppException e) {
            System.err.println("\n[ERROR CRÍTICO] Ocurrió un problema en el sistema:");
            System.err.println("Mensaje: " + e.getMessage());
            // Si estas líneas siguen en rojo, es porque los métodos no existen en
            // AppException.java
            // Puedes comentarlas con // hasta que los crees.
            // System.err.println("En la clase: " + e.getSornozaMichael_clase());
            // System.err.println("En el método: " + e.getSornozaMichael_metodo());
        } catch (Exception e) {
            // Captura el error de "SornozaMichael_a is null" que tenías antes
            System.err.println("\n[ERROR INESPERADO]: " + e.getMessage());
        }
    }
}