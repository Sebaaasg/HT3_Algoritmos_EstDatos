package app;

import sortin.*;
import utils.crearArchivo;
import utils.lectorArchivo;

public class Main {
    
    public static void main(String[] args) {

        // Se generan y se cargan los datos
        crearArchivo generador = new crearArchivo();
        System.out.println("Generando archivo con números aleatorios...");
        generador.crearArchivos(); 
        
        int[] datosOriginales = generador.leerArchivo();
        System.out.println("Datos cargados. Total: " + datosOriginales.length);
        System.out.println("-------------------------------------------------");

        lectorArchivo Orden = new lectorArchivo();

        // Gnome Sort
        int[] datosGnome = datosOriginales.clone(); // .clone(), crea y devuelve una copia del objeto
        gnomeSort gnome = new gnomeSort();
        System.out.println("Iniciando Gnome Sort..");
        gnome.ordenar(datosGnome);
        Orden.verificarOrden(datosGnome);

        // Merge Sort
        int[] datosMerge = datosOriginales.clone();
        mergeSort merge = new mergeSort();
        System.out.println("\nIniciando Merge Sort...");
        merge.ordenar(datosMerge);
        Orden.verificarOrden(datosMerge);

        // Quick Sort
        int[] datosQuick = datosOriginales.clone();
        quicksort quick = new quicksort();
        System.out.println("\nIniciando Quick Sort...");
        quick.ordenar(datosQuick);
        Orden.verificarOrden(datosQuick);

        // Radix Sort
        int[] datosRadix = datosOriginales.clone();
        radixsort radix = new radixsort();
        System.out.println("\nIniciando Radix Sort...");
        radix.ordenar(datosRadix);
        Orden.verificarOrden(datosRadix);
        
        // Selection Sort
        int[] datosSelection = datosOriginales.clone();
        selectionSort selection = new selectionSort();
        System.out.println("\nIniciando Selection Sort...");
        selection.ordenar(datosSelection);
        System.out.println("Selection Sort finalizado.");
        Orden.verificarOrden(datosSelection);
    }

    
}
