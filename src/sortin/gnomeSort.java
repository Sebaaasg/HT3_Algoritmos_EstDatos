package sortin;

public class gnomeSort {
    
    // Complejidad del gnomeSort O(n^2) promedio, pero O(n) si ya está ordenado
    // @param El arreglo de datos desordenados
    public void ordenar(int[] arreglo) {
        int index = 0;

        while (index < arreglo.length) {
            // Si se está al inicio o el par actual está en orden correcto
            if (index == 0 || arreglo[index] >= arreglo[index - 1]) {
                index++; // se avanza
            } else {
                // Si están desordenados se intercambian
                intercambiar(arreglo, index, index - 1);
                index--; // Se retrocede para revisar si el cambio afectó el orden previo
            }
        }
    }

    // metodo separado para mantener orden en el sort
    private void intercambiar(int[] arreglo, int i, int j) {
        int cambio = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = cambio;
    }
}
