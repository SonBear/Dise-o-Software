/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlEscolar.Curso;
import ficheros.Alumno;
import ficheros.Asignatura;
import ficheros.Maestro;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author SonBear
 */
public class GeneradorPdf {

    public static void generarPDF(Curso h) {
        try {
            FileOutputStream archivo = new FileOutputStream("archivos\\lista" + h.getClase().toString() + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Asignatura asignatura = h.getClase().getAsignatura();
            Maestro maestro = h.getClase().getMaestro();

            Paragraph p = new Paragraph();
            p.add(asignatura.getNombre());
            p.setAlignment(1);
            doc.add(p);
            Paragraph p2 = new Paragraph(maestro.getNombre() + " " + maestro.getApellido());
            p2.setAlignment(1);
            doc.add(p2);
            doc.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Nombre");
            tabla.addCell("Asistencia");
            tabla.addCell("Fecha");
            ArrayList<Alumno> alumnos = h.getListaAlumnosInscritos();

            Collections.sort(alumnos);

            for (int i = 0; i < alumnos.size(); i++) {

                tabla.addCell(alumnos.get(i).getApellido() + " " + alumnos.get(i).getNombre());
                tabla.addCell(" ");
                tabla.addCell(" ");
            }
            doc.add(tabla);
            doc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo esta abierto, cierrelo para modificar");
        } catch (DocumentException ex) {
            System.out.println("Error en el archivo");
        }

    }

}
