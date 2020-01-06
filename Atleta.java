public class Atleta
{//inicio de la clase Atleta
	String Nombre, Sexo,Fecha, Categoria;
	long DNI;
	Atleta Siguiente;
	
	public Atleta() 
	{//inicio del metodo constructor
	}//fin del metodo constructor
	
	public Atleta(String Nombre, String Sexo, String Fecha, String Categoria, long DNI) 
	{//inicio del metodo constructor para la lista enlazada
		this.Siguiente=null;
		this.Nombre=Nombre;
		this.Sexo=Sexo;
		this.Fecha=Fecha;
		this.Categoria=Categoria;
		this.DNI=DNI;
	}//fin del metodo constructor para la lista enlazada

	public String getNombre() {//inicio del metodo getNombre
		return Nombre;
	}//fin del metodo getNombre

	public void setNombre(String nombre) {//inicio del metodo setNombre
		Nombre = nombre;
	}//fin del metodo setNombre

	public String getSexo() {//inicio del metodo getSexo
		return Sexo;
	}//fin del metodo getSexo

	public void setSexo(String sexo) {//inicio del metodo getSexo
		Sexo = sexo;
	}//fin del metodo setSexo

	public String getFecha() {//inicio del metodo getFecha
		return Fecha;
	}//fin del metodo getFecha

	public void setFecha(String fecha) {//inicio del metodo setFecha
		Fecha = fecha;
	}//fin del metodo setFecha

	public String getCategoria() {//inicio del metodo getCategoria
		return Categoria;
	}//fin del metodo getCategoria

	public void setCategoria(String categoria) {//inicio del metodo setCategoria
		Categoria = categoria;
	}//fin del metodo setCategoria

	public long getDNI() {//inicio del metodo getDNI
		return DNI;
	}//fin del metodo getDNI

	public void setDNI(long dNI) {//inicio del metodo setDNI
		DNI = dNI;
	}//fin del metodo setDNI

	public String toString() {//inico del metodo toString
		return "Nombre: " + Nombre + "\nSexo: " + Sexo + "\nFecha: "
				+ Fecha + "\nCategoria: " + Categoria + "\nDNI: " + DNI;
	}//fin del metodo toString		
}//fin de la clase Atleta
