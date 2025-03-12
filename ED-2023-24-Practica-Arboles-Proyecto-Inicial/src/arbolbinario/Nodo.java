package arbolbinario;

public class Nodo {

    private NodoArbol dato;
    private Nodo siguiente;

    public Nodo(NodoArbol dato, Nodo sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo sig) {
        this.siguiente = sig;
    }

    public NodoArbol getDato() {
        return dato;
    }

    public void setDato(NodoArbol dat) {
        this.dato = dat;
    }
}