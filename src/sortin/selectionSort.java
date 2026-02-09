package sortin;

public class selectionSort {


    // Busca repetidamente el elemento mínimo de la parte no ordenada
    // y lo pone al principio.
    // Complejidad: O(n^2) en todos los casos aunque esté ordenado
    public void ordenar(int[] arreglo) {
        int n = arreglo.length;

        // Uno por uno se mueve el límite del sub-arreglo desordenado
        for (int i = 0; i < n - 1; i++) {
            
            // se encuentra el mínimo en el arreglo
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[min_idx]) {
                    min_idx = j;
                }
            }

            // Se intercambia el elemento mínimo encontrado con el primer elemento
            // del sub-arreglo desordenado (la posición i)
            intercambiar(arreglo, min_idx, i);
        }
    }

    
    private void intercambiar(int[] arreglo, int a, int b) {
        int cambio = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = cambio;
    }
}