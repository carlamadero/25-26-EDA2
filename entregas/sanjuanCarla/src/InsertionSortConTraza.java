import java.util.Arrays;

public class InsertionSortConTraza {

    static int recursionDepth = 0;

    public static void main(String[] args) {
        int[] arrayIterativo = {5, 2, 8, 1, 9, 3};
        System.out.println("=== INICIO INSERTION SORT ITERATIVO ===");
        System.out.println("Inicial: " + Arrays.toString(arrayIterativo));
        ordenarIterativo(arrayIterativo);
        System.out.println("Final: " + Arrays.toString(arrayIterativo) + "\n");

        int[] arrayRecursivo = {5, 2, 8, 1, 9, 3};
        System.out.println("=== INICIO INSERTION SORT RECURSIVO ===");
        System.out.println("Inicial: " + Arrays.toString(arrayRecursivo));
        ordenarRecursivo(arrayRecursivo, arrayRecursivo.length);
        System.out.println("Final: " + Arrays.toString(arrayRecursivo));
    }

    static void ordenarIterativo(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
            System.out.println("  Iteración " + i + " (insertado " + actual + "): " + Arrays.toString(array));
        }
    }

    static void ordenarRecursivo(int[] array, int n) {
        System.out.println(indent() + "ordenarRecursivo(n=" + n + ")");
        recursionDepth++;

        if (n <= 1) {
            recursionDepth--;
            return;
        }

        ordenarRecursivo(array, n - 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ultimo;
        
        System.out.println(indent() + "Insertado " + ultimo + " -> " + Arrays.toString(array));
        recursionDepth--;
    }

    static String indent() {
        return "  ".repeat(Math.max(0, recursionDepth));
    }
}
