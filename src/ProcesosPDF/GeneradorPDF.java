package ProcesosPDF;

import Modelo.Productos;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GeneradorPDF {

    public String generarCatalogoPDF(List<Productos> listaProductos, String categoria) {
        String nombreArchivo = "Catalogo_Productos_" + categoria + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Título
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.BLACK);
            Paragraph titulo = new Paragraph("Tienda Luchito", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Espacio en blanco
            document.add(new Paragraph("\n"));

            // Subtítulo
            Font fontSubtitulo = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.DARK_GRAY);
            Paragraph subtitulo = new Paragraph("Categoría: " + categoria, fontSubtitulo);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitulo);

            // Espacio en blanco
            document.add(new Paragraph("\n"));

            // Agregar tabla de productos
            PdfPTable table = new PdfPTable(5); // 5 columnas para ID, Nombre, Stock, Información y Precio
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 3, 1, 3, 2}); // Ancho relativo de las columnas

            // Encabezados de columna
            Font fontEncabezado = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("ID", fontEncabezado));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Nombre", fontEncabezado));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Stock", fontEncabezado));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Información", fontEncabezado));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Precio", fontEncabezado));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            // Contenido de la tabla
            for (Productos producto : listaProductos) {
                table.addCell(String.valueOf(producto.getID_Producto()));
                table.addCell(producto.getNombreP());
                table.addCell(String.valueOf(producto.getStock()));
                table.addCell(producto.getInformacion());
                table.addCell(String.valueOf(producto.getPrecio()));
            }

            document.add(table);
            document.close();
            return nombreArchivo; // Devuelve la ruta del archivo generado
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void abrirPDF(String rutaPDF) {
        try {
            File file = new File(rutaPDF);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("El archivo PDF no existe en la ruta especificada.");
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo PDF: " + e.getMessage());
        }
    }
}
