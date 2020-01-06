public class Copias 
{//inicio de la clase Copias
	String Situacion, Nombre, Titulo; //creacion de bvariables de tipo String
	int Dias;//creacion de variable de tipo int
	Copias Siguiente, Anterior;//creacion de variables de tipo Copias
	
	public Copias(String Situacion, String Nombre, int Dias, String Titulo)
	{//inicio del metodo Constructor
		this.Siguiente=null;
		this.Anterior=null;
		this.Situacion = Situacion;
		this.Nombre = Nombre;
		this.Dias = Dias;
		this.Titulo=Titulo;
	}//fin del metodo constrcutor
	
	public Copias( int Dias)
	{//inicio del metodo Constructor
		this.Siguiente=null;
		this.Anterior=null;
		this.Dias = Dias;
	}//fin del metodo constrcutor
	
	public String getSituacion() {//inicio del metodo getSituacion
		return Situacion;
	}//fin del metodo getSituacion
	
	public void setSituacion(String situacion) {//inicio del metodo setSituacion
		Situacion = situacion;
	}//fin del metodo setSituacion
	
	public String getNombre() {//inicio del metodo getNombre
		return Nombre;
	}//fin del metodo getNombre
	
	public void setNombre(String nombre) {//inicio del metodo setNombre
		Nombre = nombre;
	}//fin del metodo setNombre
	
	public int getDias() {//fin del metodo getDias
		return Dias;
	}//fin del metodo getDias
	
	public void setDias(int dias) {//inicio del metodo setDias
		Dias = dias;
	}//fin del metodo setDias

	public String getTitulo() {//inicio del metodo getTitulo
		return Titulo;
	}//fin del metodo getTitulo

	public void setTitulo(String titulo) {//inicio del metodo setTitulo
		Titulo = titulo;
	}//fin del metodo setTitulo

	public String toString() 
	{//inicio del metodo toString
		return  "Nombre: " + Nombre	+"\nTitulo: "+Titulo+ "\nNúmero de Dias: " + Dias ;
	}//fin del metodo toString
}//fin de la clase Copias