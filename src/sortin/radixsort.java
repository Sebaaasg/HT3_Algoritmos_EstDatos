package sortin;

public class radixsort {

    // Método principal que ordena el arreglo usando RadixSort
    public void ordenar(int[] arreglo) {
        int max = obtenerMaximo(arreglo);

        // Aplica el conteo por cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            contarOrdenar(arreglo, exp);
        }
    }

    // Obtiene el valor máximo del arreglo
    private int obtenerMaximo(int[] arreglo) {
        int max = arreglo[0];

        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }

    // Ordena el arreglo según el dígito actual
    private void contarOrdenar(int[] arreglo, int exp) {
        int n = arreglo.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        // Cuenta las ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            int digito = (arreglo[i] / exp) % 10;
            conteo[digito]++;
        }

        // Ajusta el arreglo de conteo
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        // Construye el arreglo ordenado
        for (int i = n - 1; i >= 0; i--) {
            int digito = (arreglo[i] / exp) % 10;
            salida[conteo[digito] - 1] = arreglo[i];
            conteo[digito]--;
        }

        // Copia los valores ordenados al arreglo original
        for (int i = 0; i < n; i++) {
            arreglo[i] = salida[i];
        }
    }
}
