package utilidades;

import controlEscolar.Clase;
import controlEscolar.Curso;
import java.util.ArrayList;

/**
 *
 * @author SonBear
 */
public class AccesoArchivoCursos extends AccesoArchivo<Curso> {

    private ArrayList<Clase> listaClases;

    public AccesoArchivoCursos() {
        super("cursos");
    }

    @Override
    public ArrayList<Curso> obtenerObjetos() {
        ArrayList<Curso> listaCursos = new ArrayList<>();
        for (int i = 0; i < listaClases.size(); i++) {
            listaCursos.add(new Curso(listaClases.get(i), this));

        }

        return listaCursos;
    }

    public void reescribirArchivoCursos(ArrayList<Curso> listaCursos) {
        limpiarArchivo();
        for (int i = 0; i < listaCursos.size(); i++) {
            for (int j = 0; j < listaCursos.get(i).getListaAlumnosInscritos().size(); j++) {
                agregarContenido(listaCursos.get(i).getListaAlumnosInscritos().get(j).toString() + "," + listaCursos.get(i).getClase().toString());
            }
        }
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

}
