package arbolbinario;

public class Cola {
    private Nodo cabeza, fin;
    private int numElem;

    public Cola() {                 //Constructor
        cabeza = null;
        fin = null;
        numElem = 0;
    }

    public boolean vacia() {
        // Comprueba si la cola está vacía
        return cabeza == null;
    }

    public void encolar(NodoArbol v) {
        Nodo nuevo = new Nodo(v, null);
        if (cabeza != null)
            fin.setSiguiente(nuevo);

        else
            cabeza = nuevo;
        fin = nuevo;
        numElem++;
    }
    public NodoArbol desencolar() {
        Nodo aux;
        NodoArbol resul = null;

        if (cabeza == null)
            System.out.println("Error, la cola está vacía");
        else {
            aux= cabeza;
            cabeza = aux.getSiguiente();
            resul = aux.getDato();
            if (cabeza == null)
                fin = null;

            numElem--;
        }
        return resul;
    }


    public int getNumElementos() {
        return numElem;
    }


}
