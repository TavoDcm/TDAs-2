import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class CaramelosSalvavidas {
    public static void main(String[] args) {
        // Se necesita crear un arreglo simulando el paquete de dulces y los diferentes dulces que contiene el paquete, ya que con estos datos se va a trabajar para el ordenamiento.
        String[] paquete = {"rojo", "amarillo", "verde", "amarillo", "azul", "amarillo", "rojo"};
        
        System.out.println("Paquete original:");
        imprimirPaquete(paquete);
        
        paquete = seleccionarCaramelos(paquete);
        
        System.out.println("Paquete después de seleccionar los caramelos amarillos:");
        imprimirPaquete(paquete);
    }
    
    public static String[] seleccionarCaramelos(String[] paquete) {
        Stack<String> pila = new Stack<>(); 
        Queue<String> amarillos = new LinkedList<>(); 
        
        int countNoAmarillos = 0; 
        
        for (String caramelo : paquete) {
            if (caramelo.equals("amarillo")) {
                amarillos.add(caramelo); 
            } else {
                pila.push(caramelo);
                countNoAmarillos++; 
            }
        }
        
        String[] nuevoPaquete = new String[countNoAmarillos];

        for (int i = countNoAmarillos - 1; i >= 0; i--) {
            nuevoPaquete[i] = pila.pop();
        }
        
        return nuevoPaquete;
    }
    
    // Como resultado final obtendremos el paquete de dulces ordenado, esta vez sin los amarillos ya que fueron los dulces que se comió el niño.
    public static void imprimirPaquete(String[] paquete) {
        for (String caramelo : paquete) {
            System.out.print(caramelo + " ");
        }
        System.out.println();
    }
}
