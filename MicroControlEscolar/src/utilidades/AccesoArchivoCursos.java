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

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

}
