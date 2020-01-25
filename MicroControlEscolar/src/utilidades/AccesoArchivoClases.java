package utilidades;

import controlEscolar.Clase;
import ficheros.Asignatura;
import ficheros.Maestro;
import java.util.ArrayList;

/**
 *
 * @author SonBear
 */
public class AccesoArchivoClases extends AccesoArchivo<Clase> {

    private ArrayList<Maestro> listaMaestro;
    private ArrayList<Asignatura> listaAsignatura;

    public AccesoArchivoClases() {
        super("clase");
    }

    public void setListaMaestro(ArrayList<Maestro> listaMaestro) {
        this.listaMaestro = listaMaestro;
    }

    public void setListaAsignatura(ArrayList<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    @Override
    public ArrayList<Clase> obtenerObjetos() {

        ArrayList<String> datos = leerArchivo();
        ArrayList<Clase> listaClases = new ArrayList<>();

        Maestro maestro = null;
        Asignatura asignatura = null;

        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            for (int j = 0; j < listaMaestro.size(); j++) {
                if (variables[0].equals(listaMaestro.get(j).getClave() + "")) {
                    maestro = listaMaestro.get(j);
                }
            }
            for (int j = 0; j < listaAsignatura.size(); j++) {
                if (variables[1].equals(listaAsignatura.get(j).getClave())) {
                    asignatura = listaAsignatura.get(j);
                }
            }
            if (maestro != null && asignatura != null) {
                listaClases.add(new Clase(maestro, asignatura));
            }
        }
        return listaClases;
    }

}
