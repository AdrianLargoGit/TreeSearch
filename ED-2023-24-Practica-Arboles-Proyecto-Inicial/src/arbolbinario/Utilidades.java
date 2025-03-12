package arbolbinario;

public class Utilidades {
    public static boolean esSimboloNoTerminal(String s) {
        return s!= null && s.matches("[A-Z]+");
    }

    public static boolean esSimboloTerminal(String s) {
        return s!= null && s.matches("[a-z]+");
    }

    public static String getParteIzquierda(String s) {
        return s.split("->")[0];
    }

    public static String getParteDerecha(String s) {
        return s.split("->")[1];
    }

    public static boolean esReglaIntermedia(String s) {
        String lhs = Utilidades.getParteIzquierda(s);
        String[] rhs = Utilidades.getParteDerecha(s).split(" ");

        return Utilidades.esSimboloNoTerminal(lhs) &&
                rhs.length == 2 &&
                Utilidades.esSimboloNoTerminal(rhs[0]) &&
                Utilidades.esSimboloNoTerminal(rhs[1]);
    }

    public static boolean esReglaFinal(String s) {
        String lhs = Utilidades.getParteIzquierda(s);
        String rhs = Utilidades.getParteDerecha(s);

        return Utilidades.esSimboloNoTerminal(lhs) &&
                Utilidades.esSimboloTerminal(rhs);
    }
}
