//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package App.ConsoleApp;

import App.ConsoleApp.KGD;
import SornozaMichael_BusinessLogic.SornozaMichael_FactoryBL;
import SornozaMichael_BusinessLogic.SornozaMichael_Entities.*;
import SornozaMichael_DataAccess.SornozaMichael_DAC.SornozaMichael_HormigaDAC;
import Infrastructure.AppException;
import java.util.List;

public class SornozaMichael_SistemaRuso {

    public boolean SornozaMichael_autoentificar(KGD oKGD) {
        if (oKGD != null) {
            return (oKGD.getUsuario().equals("patmic") && oKGD.getClave().equals("123"));
        }
        return false;
    }

    public void SornozaMichael_presentar(KGD oKGD) {
        if (oKGD != null) {
            System.out.println("----------------------------------");
            oKGD.show();
            System.out.println("----------------------------------");
        }
    }

    public void SornozaMichael_mostrardatovalidas() throws AppException {
        try {
            SornozaMichael_EntomologoGenetista michaelGenetista = new SornozaMichael_EntomologoGenetista();
            SornozaMichael_FactoryBL<SornozaMichael_Hormiga> SornozaMichael_fBL = new SornozaMichael_FactoryBL<>(
                    SornozaMichael_HormigaDAC.class);

            List<SornozaMichael_Hormiga> SornozaMichael_listaH = michaelGenetista.SornozaMichael_etlAntNest();
            List<SornozaMichael_Alimento> SornozaMichael_listaA = michaelGenetista.SornozaMichael_etlAntFood();

            System.out.println("[SISTEMA RUSO] Procesando tokens...");

            if (!SornozaMichael_listaH.isEmpty() && !SornozaMichael_listaA.isEmpty()) {

                // Separamos por comas lo que viene del bloque de texto
                String[] hormigasEncontradas = SornozaMichael_listaH.get(0).toString().split(",");
                String[] alimentosEncontrados = SornozaMichael_listaA.get(0).getSornozaMichael_Nombre().split(",");

                int total = Math.min(hormigasEncontradas.length, alimentosEncontrados.length);

                for (int i = 0; i < total; i++) {
                    String hNombre = hormigasEncontradas[i].trim().toUpperCase();
                    String aNombre = alimentosEncontrados[i].trim().toUpperCase();

                    boolean esValida = hNombre.contains("HLARVA") || hNombre.contains("HOBRERA");
                    boolean alimValido = aNombre.contains("HERBÍVORO") || aNombre.contains("NECTARÍVORO")
                            || aNombre.contains("NECTARIVORO");

                    if (esValida && alimValido) {
                        // 1. Instanciar Hormiga
                        SornozaMichael_Hormiga hParaGuardar = hNombre.contains("LARVA") ? new SornozaMichael_HLarva()
                                : new SornozaMichael_HObrera();

                        // 2. Instanciar Alimento de forma anónima sin usar el constructor de 6
                        // parámetros
                        // Esto evita el error de "super" porque usa el constructor vacío
                        SornozaMichael_Alimento aParaGuardar = new SornozaMichael_Alimento() {
                        };
                        aParaGuardar.setSornozaMichael_Nombre(aNombre);

                        // 3. Proceso biológico
                        michaelGenetista.SornozaMichael_alimentarAnt(hParaGuardar, aParaGuardar);

                        // 4. Mapeo manual para base de datos
                        hParaGuardar.setSornozaMichael_IdHormigaTipo(hNombre.contains("LARVA") ? 1 : 6);
                        hParaGuardar.setSornozaMichael_IdEstado(1);
                        hParaGuardar.setSornozaMichael_Nombre(hNombre);

                        // 5. Guardar
                        if (SornozaMichael_fBL.SornozaMichael_add(hParaGuardar)) {
                            System.out.println("[OK] GUARDADO: " + hNombre + " | Alimento: " + aNombre);
                        }
                    } else {
                        System.err.println("[-] SALTADO: " + hNombre + " + " + aNombre);
                    }
                }
            }
            System.out.println("\n[SISTEMA RUSO] Finalizado.");
        } catch (Exception e) {
            throw new AppException("Error en el sistema", e, getClass(), "SornozaMichael_mostrardatovalidas");
        }
    }
}