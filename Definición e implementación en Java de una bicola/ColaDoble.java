class ColaDoble<T> {
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente, anterior;
        Nodo(T dato) { this.dato = dato; }
    }

    private Nodo<T> frente, finalCola;
    private int tamano;

    public boolean estaVacia() { return tamano == 0; }
    public int tamano() { return tamano; }

    public void agregarFrente(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            finalCola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = frente;
            frente.anterior = nuevoNodo;
        }
        frente = nuevoNodo;
        tamano++;
    }

    public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            nuevoNodo.anterior = finalCola;
        }
        finalCola = nuevoNodo;
        tamano++;
    }

    public T eliminarFrente() {
        if (estaVacia()) throw new IllegalStateException("La cola doble está vacía");
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            finalCola = null;
        } else {
            frente.anterior = null;
        }
        tamano--;
        return dato;
    }

    public T eliminarFinal() {
        if (estaVacia()) throw new IllegalStateException("La cola doble está vacía");
        T dato = finalCola.dato;
        finalCola = finalCola.anterior;
        if (finalCola == null) {
            frente = null;
        } else {
            finalCola.siguiente = null;
        }
        tamano--;
        return dato;
    }

    public T verFrente() {
        if (estaVacia()) throw new IllegalStateException("La cola doble está vacía");
        return frente.dato;
    }

    public T verFinal() {
        if (estaVacia()) throw new IllegalStateException("La cola doble está vacía");
        return finalCola.dato;
    }

    public void imprimirCola() {
        Nodo<T> actual = frente;
        System.out.print("Cola doble: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ColaDoble<Integer> colaDoble = new ColaDoble<>();
        System.out.println("Agregando elementos al final:");
        colaDoble.agregarFinal(10);
        colaDoble.agregarFinal(20);
        colaDoble.agregarFinal(30);
        colaDoble.agregarFinal(40);
        colaDoble.agregarFinal(50);
        colaDoble.imprimirCola();
        
        System.out.println("Agregando elementos al frente:");
        colaDoble.agregarFrente(5);
        colaDoble.agregarFrente(1);
        colaDoble.imprimirCola();
        
        System.out.println("Eliminando elemento del frente:");
        colaDoble.eliminarFrente();
        colaDoble.imprimirCola();
        
        System.out.println("Eliminando elemento del final:");
        colaDoble.eliminarFinal();
        colaDoble.imprimirCola();
        
        System.out.println("Agregando un nuevo elemento al final:");
        colaDoble.agregarFinal(60);
        colaDoble.imprimirCola();
        
        System.out.println("Estado final de la cola:");
        colaDoble.imprimirCola();
    }
}
