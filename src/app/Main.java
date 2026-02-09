package app;

import sortin.*;
import utils.crearArchivo;
import utils.lectorArchivo;

public class Main {
    
    public static void main(String[] args) {

        // Se generan y se cargan los datos
        crearArchivo generador = new crearArchivo();
        System.out.println("Creando archivo con números aleatorios");
        generador.crearArchivos();
        
        // se leen los datos del archivo
        int[] datosOriginales = generador.leerArchivo();
        lectorArchivo Orden = new lectorArchivo();

        java.util.Arrays.sort(datosOriginales); // para hacer la prueba con datos ordenados
        System.out.println("Datos cargados. Total: " + datosOriginales.length);
        System.out.println("-------------------------------------------------");

        int Tamano = datosOriginales.length;

        int repeticionesRapidos; // Merge, Quick y Radix
        int repeticionesLentos; // Selection, Gnome

        if (Tamano <= 10){
            repeticionesRapidos = 1000000;
            repeticionesLentos = 10000000;

        } else if (Tamano <= 1000) {
            repeticionesRapidos = 100000;
            repeticionesLentos = 100000;
        } else {
            repeticionesRapidos = 10000;
            repeticionesLentos = 10000;
        }

        // Gnome Sort
        gnomeSort gnome = new gnomeSort();
        System.out.println("Iniciando Gnome Sort..");
        for (int i = 0; i < repeticionesLentos; i++) {
            int[] datosGnome = datosOriginales.clone(); // .clone(), crea y devuelve una copia del objeto
            gnome.ordenar(datosGnome);
        }
        //Orden.verificarOrden(datosGnome);

        // Selection Sort
        selectionSort selection = new selectionSort();
        System.out.println("\nIniciando Selection Sort...");
        for (int i = 0; i < repeticionesLentos; i++) {
            int[] datosSelection = datosOriginales.clone();
            selection.ordenar(datosSelection);
        }
        // Orden.verificarOrden(datosSelection);


        // Quick Sort
        quicksort quick = new quicksort();
        System.out.println("\nIniciando Quick Sort...");
        for (int i = 0; i < repeticionesRapidos; i++) {
            int[] datosQuick = datosOriginales.clone();
            quick.ordenar(datosQuick);
        }
        // Orden.verificarOrden(datosQuick);

        // Radix Sort
        radixsort radix = new radixsort();
        System.out.println("\nIniciando Radix Sort...");
        for (int i = 0; i < repeticionesRapidos; i++) {
            int[] datosRadix = datosOriginales.clone();
            radix.ordenar(datosRadix);
        }
        // Orden.verificarOrden(datosRadix);

        // Merge Sort
        mergeSort merge = new mergeSort();
        System.out.println("\nIniciando Merge Sort...");
        for (int i = 0; i < repeticionesRapidos; i++) {
            int[] datosMerge = datosOriginales.clone();
            merge.ordenar(datosMerge);
        }
        // Orden.verificarOrden(datosMerge);
        
    }

    
}
