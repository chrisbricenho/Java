import java.util.ArrayList;

public class Nodo 
{//inicio de la clase Nodo
	String Codigo, Titulo; //creacion de variables de tipo String
	int Copias; //creacion de variable de tipo int
	Copias Copiasalquiladas; //creacion de variable de tipo Copias
	Copias Copiasdisponibles; //creacion de variable de tipo Copias
	Nodo Siguiente, Anterior; //creacion de variable de tipo Nodo
	int Alquiladas; //creacion de variable de tipo int

	public Nodo(String Codigo, String Titulo, int Copias, Copias Copiasaalquiladas, Copias Copiasdisponibles, int Alquiladas) 
	{//inicio del metodo constructor
		this.Siguiente=null;
		this.Anterior=null;
		this.Codigo = Codigo;
		this.Titulo = Titulo;
		this.Copias = Copias;
		this.Copiasalquiladas = Copiasaalquiladas;
		this.Copiasdisponibles = Copiasdisponibles;
		this.Alquiladas=Alquiladas;
	}//fin del metodo constructor

	public String getCodigo() {//inicio del metodo getCodigo
		return Codigo;
	}//fin del metodo getCodigo

	public void setCodigo(String codigo) {//inicio del metodo setCodigo
		Codigo = codigo;
	}//inicio del metodo getCodigo

	public String getTitulo() {//inicio del metodo getTitulo
		return Titulo;
	}//fin del metodo getTitulo

	public void setTitulo(String titulo) {//inicio del metodo setTitulo
		Titulo = titulo;
	}//fin del metodo setTitulo

	public int getCopias() {//inicio del metodo getCopias
		return Copias;
	}//fin del metodo getCopias

	public void setCopias(int copias) {//inicio del metodo setCopias
		Copias = copias;
	}//fin del metodo setCopias

	public Copias getCopiasalquiladas() {//inicio del metodo getCopiasalquiladas
		return Copiasalquiladas;
	}//fin del metodo getCopiasalquiladas

	public void setCopiasalquiladas(Copias copiasalquiladas) {//inicio del metodo setCopiasalquiladas
		Copiasalquiladas = copiasalquiladas;
	}//fin del metodo setCopiasalquiladas

	public Copias getCopiasdisponibles() {//inicio del metodo getCopiasdisponibles
		return Copiasdisponibles;
	}//fin del metodo getCopiasdisponibles

	public void setCopiasdisponibles(Copias copiasdisponibles) {//inicio del metodo setCopiasdisponibles
		Copiasdisponibles = copiasdisponibles;
	}//fin del metodo setCopiasdisponibles
	
	public int getAlquiladas() {//inicio del metodo getAlquiladas
		return Alquiladas;
	}//fin del metodo getAlquiladas

	public void setAlquiladas(int alquiladas) {//inicio del metodo set Alquiladas
		Alquiladas = alquiladas;
	}//fin del metodo setAlquiladas
	
	public String toString() 
	{//inici del metodo toString
		return "Titulo: " + Titulo + "\nNúmero de Copias Prestadas: "
				+ Alquiladas;
	}//fin del metodo toString
}//fin de la clase Nodo