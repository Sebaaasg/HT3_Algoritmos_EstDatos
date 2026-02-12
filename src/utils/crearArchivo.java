package utils;
import java.io.*;
import java.util.Random;

public class crearArchivo {

    private int cantidadNumeros = 3000;
    private String nombreArchivo = "numeros.txt";

    // este metodo crea el archivo de numeros randoms y el try solo se encarga de cerrar eñ ciclo cuando se finalice el documento o se produzca un error.
    public void crearArchivos() {
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < cantidadNumeros; i++) {
                int numero = random.nextInt(10000);
                writer.write(String.valueOf(numero));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public int[] leerArchivo() {
        int[] numeros = new int[cantidadNumeros];
        int indice = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null && indice < cantidadNumeros) {
                numeros[indice] = Integer.parseInt(linea);
                indice++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return numeros;
    }

    public void verificarOrden(int[] array) {
        System.out.print("Muestra de primeros 5: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}



