package sortin;

public class mergeSort {


    public void ordenar(int[] arreglo) {

        // caso base, vital para usar recursividad
        if (arreglo.length < 2) {
            return; // Un arreglo de 0 o 1 elemento ya está ordenado
        }

        // se divide el arreglo en 2 
        int mid = arreglo.length / 2;
        
        // Dividimos el arreglo en izquierda y derecha
        int[] izquierda = new int[mid];
        int[] derecha = new int[arreglo.length - mid];

        // Copiamos los datos a los sub-arreglos
        // System.arraycopy(arreglo que se copiará, posición desde la que se copiará, array de destino, posición desde la que se recibirá en el array de destino , longitud);
        System.arraycopy(arreglo, 0, izquierda, 0, mid);
        System.arraycopy(arreglo, mid, derecha, 0, arreglo.length - mid);

        // Llamada recursiva donde se ordena cada mitad por separado
        // se dividen hasta quedar en arrays de 1 de longitud
        ordenar(izquierda);
        ordenar(derecha);

        // Conquistar: Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Mezcla dos sub-arreglos ordenados en el arreglo original
    private void merge(int[] resultado, int[] izquierda, int[] derecha) {
        int indexIzquierda = 0; // Índice para izquierda
        int indexDerecha = 0; // Índice para derecha
        int indexResult = 0; // Índice para el arreglo resultado

        // Comparamos elementos de ambos arreglos y se toma el menor
        while (indexIzquierda < izquierda.length && indexDerecha < derecha.length) {

            if (izquierda[indexIzquierda] <= derecha[indexDerecha]) {
                resultado[indexResult++] = izquierda[indexIzquierda++];
            } else {
                resultado[indexResult++] = derecha[indexDerecha++];
            }
        }

        // Si sobran elementos en la izquierda se copian
        while (indexIzquierda < izquierda.length) {
            resultado[indexResult++] = izquierda[indexIzquierda++];
        }

        // Si sobran elementos en la derecha se copian
        while (indexDerecha < derecha.length) {
            resultado[indexResult++] = derecha[indexDerecha++];
        }
    }

    // video de referencia que utilicé para comprender mejor el MergeSort
    // https://www.youtube.com/watch?v=ACFZn_xQcz8 
}
