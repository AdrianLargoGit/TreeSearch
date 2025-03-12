package arbolbinario;

import java.util.Stack;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(String dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(String dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    // ------------------------------------------------------------------------
    // TODO 2.3
    public Arbol(String[] reglas) {
        Cola cola = new Cola();
        for (int i = 0; i< reglas.length; i++){
            NodoArbol raizN = null;
            if (Utilidades.esReglaIntermedia(reglas[i])){
                String parteIzq = Utilidades.getParteIzquierda(reglas[i]);
                String parteDer = Utilidades.getParteDerecha(reglas[i]);
                for (int d = 0; d<cola.getNumElementos(); d++){
                    NodoArbol nodo = cola.desencolar();
                    if (parteIzq.equals(nodo.getDato())){
                        raizN = nodo;
                    } else cola.encolar(nodo);
                }
                if (raizN==null && raiz==null){
                    raiz = new NodoArbol(parteIzq);
                    raizN = raiz;
                } else if (raizN == null){
                    System.out.println("Error al construir el arbol: La regla " + reglas[i] + " no se ha podido aplicar");
                    raiz = null;
                    return;
                }
                String[] partes = parteDer.split(" ");
                raizN.setIzquierdo(new NodoArbol(partes[0]));
                raizN.setDerecho(new NodoArbol(partes[1]));
                cola.encolar(raizN.getIzquierdo());
                cola.encolar(raizN.getDerecho());
            } else if (Utilidades.esReglaFinal(reglas[i])){
                String parteIzq = Utilidades.getParteIzquierda(reglas[i]);
                String parteDer = Utilidades.getParteDerecha(reglas[i]);
                for (int d = 0; d<cola.getNumElementos(); d++){
                    NodoArbol nodo = cola.desencolar();
                    if (parteIzq.equals(nodo.getDato())){
                        raizN = nodo;
                        nodo.setIzquierdo(new NodoArbol(parteDer));
                    } else cola.encolar(nodo);
                }
                if (raizN==null){
                    System.out.println("Error al construir el arbol: La regla " + reglas[i] + " no se ha podido aplicar");
                    raiz = null;
                    return;
                }
            }
        }
        if (!cola.vacia()){
            System.out.println("Error al construir el árbol: quedan símbolos no terminales sin expandir");
            raiz = null;
        }
    }

    // ------------------------------------------------------------------------
    // TODO 2.4
    public String[] generarDerivaciones() {
        String[] resultado = new String[9];
        return generarDerivacionesRec(resultado, raiz);
    }

    private String[] generarDerivacionesRec(String[] resultado, NodoArbol nodo){
        if (nodo !=null && nodo.getIzquierdo()!=null){
            int contador = 0;
            if (Utilidades.esSimboloNoTerminal(nodo.getIzquierdo().getDato())){
                while(resultado[contador]!=null){
                    contador++;
                }
                resultado[contador] = (nodo.getDato() + "->" + nodo.getIzquierdo().getDato() + " " + nodo.getDerecho().getDato());
            } else {
                while(resultado[contador]!=null){
                    contador++;
                }
                resultado[contador] = nodo.getDato() + "->" + nodo.getIzquierdo().getDato();
            }
            resultado = generarDerivacionesRec(resultado, nodo.getIzquierdo());
            resultado = generarDerivacionesRec(resultado, nodo.getDerecho());
        }
        return resultado;
    }

    // ------------------------------------------------------------------------
    // TODO 2.5
    public String generarFrase() {
        String frase = "";
        frase = generarFraseRec(frase, raiz);
        return frase;
    }

    public String generarFraseRec(String frase, NodoArbol nodo){
        if (nodo!=null){
            if(Utilidades.esSimboloTerminal(nodo.getDato())){
                frase += nodo.getDato() + " ";
            }
            frase = generarFraseRec(frase, nodo.getIzquierdo());
            frase = generarFraseRec(frase, nodo.getDerecho());
        }
        return frase;
    }


}
