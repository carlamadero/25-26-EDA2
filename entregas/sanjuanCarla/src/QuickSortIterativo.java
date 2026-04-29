import java.util.Arrays;

public class QuickSortIterativo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== INICIO QUICK SORT ITERATIVO ===");
        System.out.println("Inicial: " + Arrays.toString(array));
        
        ordenar(array, 0, array.length - 1);
        
        System.out.println("Final: " + Arrays.toString(array));
    }

    static void ordenar(int[] array, int inicio, int fin) {
        // Creamos una pila auxiliar para guardar los índices
        int[] pila = new int[fin - inicio + 1];
        int tope = -1;

        // Metemos los índices iniciales en la pila
        pila[++tope] = inicio;
        pila[++tope] = fin;

        // Mientras la pila no esté vacía
        while (tope >= 0) {
            // Sacamos el rango a procesar
            int derecha = pila[tope--];
            int izquierda = pila[tope--];

            // Particionamos y obtenemos la posición final del pivote
            int indicePivote = particionar(array, izquierda, derecha);

            // Si hay elementos a la izquierda del pivote, los metemos en la pila
            if (indicePivote - 1 > izquierda) {
                pila[++tope] = izquierda;
                pila[++tope] = indicePivote - 1;
            }

            // Si hay elementos a la derecha del pivote, los metemos en la pila
            if (indicePivote + 1 < derecha) {
                pila[++tope] = indicePivote + 1;
                pila[++tope] = derecha;
            }
        }
    }

    static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println("  Pivote " + pivote + " ubicado -> " + Arrays.toString(array));
        return i + 1;
    }
}
