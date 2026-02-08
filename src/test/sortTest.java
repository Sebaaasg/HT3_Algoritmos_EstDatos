package test;

import sortin.radixsort;
import utils.crearArchivo;

public class sortTest {

    public void ejecutar() {

        // Se crea el objeto que maneja el archivo
        crearArchivo archivo = new crearArchivo();

        // Se crea el archivo y se cargan los números en el arreglo
        archivo.crearArchivos();
        int[] arreglo = archivo.leerArchivo();

        // Muestra los primeros 10 números antes de ordenar
        System.out.println("Antes de ordenar:");
        for (int i = 0; i < 10; i++) {
            System.out.println(arreglo[i]);
        }

        // Se crea el objeto RadixSort y se ordena el arreglo
        radixsort radix = new radixsort();
        radix.ordenar(arreglo);

        // Muestra los primeros 10 números después de ordenar
        System.out.println("\nDespues de ordenar:");
        for (int i = 0; i < 10; i++) {
            System.out.println(arreglo[i]);
        }
    }
}
