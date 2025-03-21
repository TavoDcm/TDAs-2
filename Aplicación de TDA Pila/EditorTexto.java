import java.util.Scanner;
import java.util.Stack;

public class EditorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> texto = new Stack<>();
        Stack<String> deshechos = new Stack<>();

        System.out.println("Editor de texto iniciado. Escribe líneas o usa los comandos: DESHACER, REHACER, MOSTRAR, SALIR");

        while (true) {
            // El usuario debe de ingresar los datos que serán manejados en el programa, de lo contrario el programa no funcionará ya que no tendrá datos para manejar.
            String entrada = scanner.nextLine();

            switch (entrada.toUpperCase()) {
                case "DESHACER":
                    if (!texto.isEmpty()) {
                        deshechos.push(texto.pop());
                    } else {
                        System.out.println("Nada que deshacer.");
                    }
                    break;

                case "REHACER":
                    if (!deshechos.isEmpty()) {
                        texto.push(deshechos.pop());
                    } else {
                        System.out.println("Nada que rehacer.");
                    }
                    break;

                case "MOSTRAR":
                    if (texto.isEmpty()) {
                        System.out.println("(Texto vacío)");
                    } else {
                        for (String linea : texto) {
                            System.out.println(linea);
                        }
                    }
                    break;

                // El usuario puede eliminar todos los datos si desea y dejar la pila vacía, puede agregar más si lo necesita y eliminar los que no necesita, pero siempre será el último dato el que puede eliminar.
                case "SALIR":
                    System.out.println("Saliendo del editor...");
                    scanner.close();
                    return;

                default:
                    texto.push(entrada);
                    deshechos.clear(); 
                    break;
            }
        }
    }
}
