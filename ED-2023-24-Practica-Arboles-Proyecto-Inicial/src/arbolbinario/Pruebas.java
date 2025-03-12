package arbolbinario;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS ARBOL SINTACTICO **********");
        System.out.println("Gramática:\n" +
                "S→SN PV\n" +
                "SN→DET N\n" +
                "PV→V SN\n" +
                "DET→el|la\n" +
                "N→gato|perro|película\n" +
                "V→ve|come \n");


        //Primera prueba
        String[] reglas = new String[9];
        reglas[0] = "S->SN PV";
        reglas[1] = "SN->DET N";
        reglas[2] = "PV->V SN";
        reglas[3] = "DET->el";
        reglas[4] = "N->gato";
        reglas[5] = "V->ve";
        reglas[6] = "SN->DET N";
        reglas[7] = "DET->la";
        reglas[8] = "N->pelicula";

        mostrarReglas(reglas);
        Arbol arbol = new Arbol(reglas);

        System.out.print("Derivaciones en preOrden: [");
        for (int i = 0; i<arbol.generarDerivaciones().length; i++){
            if (i==(arbol.generarDerivaciones().length-1)){
                System.out.println(arbol.generarDerivaciones()[i] + "]");
            } else System.out.print(arbol.generarDerivaciones()[i] + ", ");
        }

        System.out.println("La frase reconstruida del árbol es: " + arbol.generarFrase() + "\n");


        //Segunda prueba
        String[] reglas2 = new String[6];
        reglas2[0] = "S->SN PV";
        reglas2[1] = "PV->V SN";
        reglas2[2] = "V->come";
        reglas2[3] = "SN->DET N";
        reglas2[4] = "DET->el";
        reglas2[5] = "N->perro";

        mostrarReglas(reglas2);
        Arbol arbol2 = new Arbol(reglas2);


        //Tercera prueba
        String[] reglas3 = new String[2];
        reglas3[0] = "S->SN PV";
        reglas3[1] = "N->perro";

        System.out.println();
        mostrarReglas(reglas3);
        Arbol arbol3 = new Arbol(reglas3);
    }

    private static void mostrarReglas(String[] reglas){
        System.out.print("Árbol sintáctico para la siguiente secuencia de reglas: [");
        for (int i = 0; i< reglas.length; i++){
            if (i==(reglas.length-1)){
                System.out.println(reglas[i] + "]");
            } else System.out.print(reglas[i] + ", ");
        }
    }

}

