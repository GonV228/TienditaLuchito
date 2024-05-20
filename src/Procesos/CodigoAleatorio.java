
package Procesos;
//importar librerias
import java.util.Random;

public class CodigoAleatorio {
    // Método para generar un código aleatorio de 6 caracteres
    public static String generarCodigo() {
        // Definir los caracteres válidos para el código
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder codigo = new StringBuilder();
        Random rnd = new Random();

        // Generar 6 caracteres aleatorios
        for (int i = 0; i < 6; i++) {
            int indice = rnd.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }

        return codigo.toString();
    }

   /* public static void main(String[] args) {
        // Ejemplo de uso
        String codigoAleatorio = generarCodigo();
        System.out.println("Código aleatorio: " + codigoAleatorio);
    }*/
}
