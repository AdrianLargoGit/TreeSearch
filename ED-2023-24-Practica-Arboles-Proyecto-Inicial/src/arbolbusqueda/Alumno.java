package arbolbusqueda;

public class Alumno {

	private String nombre;
	private int matricula;
	private double calificacion;

	public Alumno(String nombre, int matricula, double calificacion) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.calificacion = calificacion;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String toString() {
		return (matricula + ". " + nombre + " (" + calificacion + ")");
	}
}
