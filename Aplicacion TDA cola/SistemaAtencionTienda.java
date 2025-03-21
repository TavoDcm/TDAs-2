import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaAtencionTienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>();
        
        while (true) {
            String input = scanner.nextLine();
            String[] comando = input.split(" ", 2);
            
            switch (comando[0].toUpperCase()) {
                // Este caso es necesario para la ejecución del código, ya que será el encargado de proporcionar datos con los cuales trabajaremos en el programa.
                case "LLEGAR":
                    if (comando.length > 1) {
                        fila.add(comando[1]);
                    } else {
                        System.out.println("Debe ingresar un nombre después de LLEGAR");
                    }
                    break;
                case "ATENDER":
                    if (!fila.isEmpty()) {
                        System.out.println("Atendiendo a: " + fila.poll());
                    } else {
                        System.out.println("No hay clientes en la fila");
                    }
                    break;
                case "MOSTRAR":
                    if (fila.isEmpty()) {
                        System.out.println("La fila está vacía");
                    } else {
                        System.out.println("Fila actual: " + String.join(", ", fila));
                    }
                // Antes de salir del programa, debemos de verificar que la cola se haya vaciado y que el orden de ejecución haya sido de forma FIFO, osea los primeros clientes en entrar, serán los primeros en ser atendidos.
                    break;
                case "SALIR":
                    System.out.println("Saliendo del sistema de turnos...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Comando no reconocido");
                    break;
            }
        }
    }
}
