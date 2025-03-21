import java.util.Stack;

public class InvertirLista {
    public static void main(String[] args) {
        // Se necesita crear la lista con datos con los cuales vamos a trabajar.
        int[] lista = {1, 2, 3, 4, 5};
        
        System.out.println("Lista original:");
        imprimirLista(lista);
        
        invertirLista(lista);
        
        System.out.println("Lista invertida:");
        imprimirLista(lista);
    }
    
    public static void invertirLista(int[] lista) {
        Stack<Integer> pila = new Stack<>();
        
        for (int num : lista) {
            pila.push(num);
        }
        
        for (int i = 0; i < lista.length; i++) {
            lista[i] = pila.pop();
        }
    }
    
    public static void imprimirLista(int[] lista) {
        for (int num : lista) {
            System.out.print(num + " ");
        }
        // Obtendremos en pantalla la primera lista con los datos ordenados y también obtendremos la segunda lista con los datos reordanos de forma invertida.
        System.out.println();
    }
}
