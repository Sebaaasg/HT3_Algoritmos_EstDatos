package sortin;

public class quicksort {

    // Método que ordena todo el arreglo
    public void ordenar(int[] arreglo) {
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    // Método que aplica QuickSort usando recursividad
    private void quickSort(int[] arreglo, int inicio, int fin) {

        // Verifica que el arreglo tenga más de un elemento
        if (inicio < fin) {

            // Obtiene la posición del pivote
            int pivote = particionar(arreglo, inicio, fin);

            // Ordena la parte izquierda
            quickSort(arreglo, inicio, pivote - 1);

            // Ordena la parte derecha
            quickSort(arreglo, pivote + 1, fin);
        }
    }

    // Método que coloca el pivote en su posición correcta
    private int particionar(int[] arreglo, int inicio, int fin) {

        // Se toma el último elemento como pivote
        int pivote = arreglo[fin];

        // Índice para ordenar los elementos
        int i = inicio - 1;

        // Recorre el arreglo
        for (int j = inicio; j < fin; j++) {

            // Si el número es menor o igual al pivote
            if (arreglo[j] <= pivote) {
                i++;
                // Intercambia los valores
                intercambiar(arreglo, i, j);
            }
        }

        // Coloca el pivote en su lugar
        intercambiar(arreglo, i + 1, fin);

        // Devuelve la posición del pivote
        return i + 1;
    }

    // Método para intercambiar dos valores del arreglo
    private void intercambiar(int[] arreglo, int i, int j) {
        int aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }
}
