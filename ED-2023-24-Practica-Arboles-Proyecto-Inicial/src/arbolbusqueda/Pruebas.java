package arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

		Alumno alumno = new Alumno("Felipe Garcia", 1253, 5.3);
		Alumno alumno1 = new Alumno("Adriana Torres", 2345, 7.0);
		Alumno alumno2 = new Alumno("Alicia Blazquez Martín", 5622, 10.0);
		Alumno alumno3 = new Alumno("Diego Perez Gonzalez", 8135, 8.0);
		Alumno alumno4 = new Alumno("Mar Hernando Lopez", 8217, 6.3);
		Alumno alumno5 = new Alumno("Pedro Jimenez del Pozo", 8510, 3.0);
		Alumno alumno6 = new Alumno("Eduardo Parra Martín", 8765, 6.7);
		arbol.insertar(alumno2);
		arbol.insertar(alumno1);
		arbol.insertar(alumno);
		arbol.insertar(alumno5);
		arbol.insertar(alumno3);
		arbol.insertar(alumno4);
		arbol.insertar(alumno6);


		System.out.println("-------------- Arbol binario de busqueda ------------");
		System.out.print("ABB alumnos (inicial). ");
		arbol.preOrdenNivel();

		Alumno alumnoN = new Alumno("Temporal", 1111, 0.0);
		arbol.agregarRangoDeMatriculas(1300, 1310, alumnoN);

		System.out.print("\nABB alumnos tras agregar el rango de matrículas [1300-1310]. ");
		arbol.preOrdenNivel();

		arbol.eliminarRangoMatriculas(1300, 6000);

		System.out.print("\nABB alumnos tras eliminar el rango de matrículas [1300-6000]. ");
		arbol.preOrdenNivel();

		arbol.eliminarRangoMatriculas(500, 600);

		System.out.print("\nABB alumnos tras eliminar el rango de matrículas [500-600]. ");
		arbol.preOrdenNivel();

		System.out.println("\nEl sucesor inmediato a '" + alumno5 + "' es '"
				+ arbol.encontrarSucesorInmediato(alumno5));
		System.out.println("El sucesor inmediato a '" + alumno4 + "' es '"
				+ arbol.encontrarSucesorInmediato(alumno4));
		System.out.println("El sucesor inmediato a '" + alumno2 + "' es '"
				+ arbol.encontrarSucesorInmediato(alumno2));
		System.out.println("El sucesor inmediato a '" + alumno6 + "' es '"
				+ arbol.encontrarSucesorInmediato(alumno6));

		arbol.pivotarSobre(alumno3);

		System.out.print("\nABB alumnos tras pivotar de nuevo a '" + alumno3 + "' a la raiz. ");
		arbol.preOrdenNivel();

		arbol.pivotarSobre(alumno3);

		System.out.print("\nABB alumnos tras pivotar de nuevo a '" + alumno3 + "' a la raiz (prueba idempotencia). ");
		arbol.preOrdenNivel();
		System.out.println("----------------------------------------------------");
	}
}
