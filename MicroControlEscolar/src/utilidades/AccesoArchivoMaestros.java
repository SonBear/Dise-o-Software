package utilidades;

import ficheros.Maestro;
import java.util.ArrayList;

/**
 *
 * @author SonBear
 */
public class AccesoArchivoMaestros extends AccesoArchivo<Maestro> {

    public AccesoArchivoMaestros() {
        super("maestros");
    }

    @Override
    public ArrayList<Maestro> obtenerObjetos() {
        ArrayList<Maestro> maestros = new ArrayList();
        ArrayList<String> datos = leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Maestro unMaestro = new Maestro(Integer.parseInt(variables[0]), variables[1], variables[2]);
            maestros.add(unMaestro);
        }
        return maestros;
    }

}
