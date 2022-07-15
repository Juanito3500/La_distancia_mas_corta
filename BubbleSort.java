/* Nombre del paquete*/
    package bubblesort;

/* Importación de la clase Scanner para poder leer de teclado*/
import java.util.Scanner;


/* Clase pública*/      
public class BubbleSort {

    /* Inicio del método principal */
    public static void main(String[] args) {

        /* Declaración de variables */
        int nn;

        /* Creamos el objeto sc de la clase Scanner */
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca longitud del array: ");
        /* Guardamos en la variable nn el número de elementos que va a tener nuestro array */
        nn = sc.nextInt();

        /* Creamos el array del tamaño nn (lo que pongamos por teclado) */
        int ArrayN[] = new int[nn];

        /* Bucle para rellenar el array con números introducidos por teclado */
        for (int i = 0; i < ArrayN.length; i++) {
            System.out.println("Introduzca número para el elemento " + (i + 1) + ": ");
            ArrayN[i] = sc.nextInt();
        }
        /* Mostramos primero el array sin ordenar */
        System.out.println("      -SIN ORDENAR-");
        /* Llamada al método */
        mostrarN(ArrayN);
        /* Preguntamos si queremos ordenar */
        System.out.println("¿Desea ordenar los números? S/N");
        Scanner sc2 = new Scanner(System.in);
        /* Con esto capturamos lo que introducimos por teclado */
        String res = sc2.nextLine();
        /* Si es 'S' entra, si no sale */
        if (res.equalsIgnoreCase("S")) {
            /* Muestra el array ordenado */
            System.out.println("       -ORDENADO-   ");
            /*Llama al método para ordenar */
            ordenaBurbuja(ArrayN);
        }

    }
    
    /* Método de ordenación mediante algoritmo de burbuja */
    static void ordenaBurbuja(int ArrayN[]) {
        /* Bucle desde 0 hasta la longitud del array -1 */
        for (int i = 0; i < ArrayN.length - 1; i++) {
            /* Bucle anidado desde 0 hasta la longitud del array -1 */
            for (int j = 0; j < ArrayN.length - 1; j++) { /* Si el número almacenado en la posición j es mayor que el de la posición j+1 (el siguiente del array) */ if (ArrayN[j] > ArrayN[j + 1]) {
                    /* guardamos el número de la posicion j+1 en una variable (el menor) */
                    int temp = ArrayN[j + 1];
                    /* Lo intercambiamos de posición */
                    ArrayN[j + 1] = ArrayN[j];
                    ArrayN[j] = temp;
                    /* y volvemos al inicio para comparar los siguientes hasta que todos se hayan comparado*/
                    /* de esta forma vamos dejando los números mayores al final del array en orden*/
                }
            }
        }
        /* Llama al método mostrarN, si ordena damos por hecho que lo quiere mostrar */
        mostrarN(ArrayN);
    }
    
    /* Método para mostrar el array */
    static void mostrarN(int ArrayN[]) {
        System.out.println("|-----------------------|");
        /* Bucle para mostrar el array desde la posicion 0 hasta la longitud del array */
        for (int i = 0; i < ArrayN.length; i++) { System.out.print(" Elemento " + (i + 1) + " -----> " + ArrayN[i] + "\n");
        }
        System.out.println("|-----------------------|");
    }
/* Fin del método principal */
}