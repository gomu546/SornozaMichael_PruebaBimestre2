package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Infrastructure.AppException;
import SornozaMichael_BusinessLogic.Interfaces.SornozaMichael_IEntomologo;

public abstract class SornozaMichael_EntomologoBL implements SornozaMichael_IEntomologo {

    private final String SornozaMichael_AZUL = "\u001B[34m";
    private final String SornozaMichael_ROJO = "\u001B[31m";
    private final String SornozaMichael_RESET = "\u001B[0m";

    @Override
    public List<SornozaMichael_Hormiga> SornozaMichael_etlAntNest() throws AppException {
        List<SornozaMichael_Hormiga> SornozaMichael_lista = new ArrayList<>();

        String SornozaMichael_path = "SornozaMichael_storage\\DataFiles\\AntNest.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(SornozaMichael_path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toUpperCase().contains("HLARVA")) {
                    SornozaMichael_lista.add(new SornozaMichael_HLarva());
                    System.out.println(
                            SornozaMichael_AZUL + "[OK] Cargando HLarva desde: " + linea + SornozaMichael_RESET);
                } else if (linea.toUpperCase().contains("HOBRERA")) {
                    SornozaMichael_lista.add(new SornozaMichael_HObrera());
                    System.out.println(
                            SornozaMichael_AZUL + "[OK] Cargando HObrera desde: " + linea + SornozaMichael_RESET);
                } else {
                    System.out.println(
                            SornozaMichael_ROJO + "[ERROR] Formato desconocido: " + linea + SornozaMichael_RESET);
                }
            }
        } catch (Exception e) {

            throw new AppException("No se pudo leer el archivo de hormigas", e, getClass(),
                    "SornozaMichael_etlAntNest");
        }
        return SornozaMichael_lista;
    }

    @Override
    public List<SornozaMichael_Alimento> SornozaMichael_etlAntFood() throws AppException {
        List<SornozaMichael_Alimento> SornozaMichael_lista = new ArrayList<>();

        String SornozaMichael_path = "SornozaMichael_storage\\DataFiles\\AntFood.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(SornozaMichael_path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toUpperCase().contains("NECTARVORO")) {
                    SornozaMichael_lista.add(new SornozaMichael_Nectar());
                    System.out.println(
                            SornozaMichael_AZUL + "[FOOD OK] Néctar detectado: " + linea + SornozaMichael_RESET);
                } else if (linea.toUpperCase().contains("HERBIVORO")) {
                    SornozaMichael_lista.add(new SornozaMichael_Herbivoro());
                    System.out.println(
                            SornozaMichael_AZUL + "[FOOD OK] Herbívoro detectado: " + linea + SornozaMichael_RESET);
                }
            }
        } catch (Exception e) {
            throw new AppException("No se pudo leer el archivo de suministros", e, getClass(),
                    "SornozaMichael_etlAntFood");
        }
        return SornozaMichael_lista;
    }
}
