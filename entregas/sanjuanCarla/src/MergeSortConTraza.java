import java.util.Arrays;

public class MergeSortConTraza {

    static int recursionDepth = 0;

    public static void main(String[] args) {
        int[] arrayRecursivo = {5, 2, 8, 1, 9, 3};
        System.out.println("=== INICIO MERGE SORT RECURSIVO ===");
        System.out.println("Inicial: " + Arrays.toString(arrayRecursivo));
        ordenarRecursivo(arrayRecursivo, 0, arrayRecursivo.length - 1);
        System.out.println("Final: " + Arrays.toString(arrayRecursivo) + "\n");

        int[] arrayIterativo = {5, 2, 8, 1, 9, 3};
        System.out.println("=== INICIO MERGE SORT ITERATIVO ===");
        System.out.println("Inicial: " + Arrays.toString(arrayIterativo));
        ordenarIterativo(arrayIterativo);
        System.out.println("Final: " + Arrays.toString(arrayIterativo));
    }

    static void ordenarRecursivo(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) return;

        System.out.println(indent() + "Dividiendo: izq=" + izquierda + ", der=" + derecha);
        recursionDepth++;

        int medio = izquierda + (derecha - izquierda) / 2;
        
        ordenarRecursivo(array, izquierda, medio);
        ordenarRecursivo(array, medio + 1, derecha);
        fusionar(array, izquierda, medio, derecha);

        recursionDepth--;
    }

    static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Pasadas para tamaño: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        
        for (int i = 0; i < tamanoIzquierda; i++) mitadIzquierda[i] = array[izquierda + i];
        for (int i = 0; i < tamanoDerecha; i++) mitadDerecha[i] = array[medio + 1 + i];
        
        int i = 0, j = 0, k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k++] = mitadIzquierda[i++];
            } else {
                array[k++] = mitadDerecha[j++];
            }
        }
        
        while (i < tamanoIzquierda) array[k++] = mitadIzquierda[i++];
        while (j < tamanoDerecha) array[k++] = mitadDerecha[j++];
        
        System.out.println(indent() + "Fusionados izq=" + izquierda + " a der=" + derecha + " -> " + Arrays.toString(array));
    }

    static String indent() {
        return "  ".repeat(Math.max(0, recursionDepth));
    }
}
