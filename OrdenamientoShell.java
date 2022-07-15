package ordenamientoshell;
public class OrdenamientoShell {
public static void main(String[] args) {
    int vector1[]={5, 2, 1, 8, 3, 9, 7};
    int vector2[]={8, 11, 16, 2, 5, 7, 9, 1, 3};
    OrdenamientoDeShell ordenar = new OrdenamientoDeShell();
    System.out.println("Arreglo Original");
    ordenar.mostrarArreglo(vector2);
    ordenar.shell(vector2);
                }
    
}
