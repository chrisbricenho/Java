public class Nodo 
{//inicio de la clase Nodo
   int Edad, Experiencia;
   long Cedula;
   String Nombre, Grado;
   Nodo Siguiente;
   
	public Nodo(long Cedula, int Edad, int Experiencia, String Nombre, String Grado)
	{//inicio del metodo constructor		
		this.Siguiente=null;
	    this.Nombre=Nombre;
		this.Cedula=Cedula;
		this.Edad=Edad;
		this.Experiencia=Experiencia;
		this.Grado=Grado;	
	}//fin del metodo constructor
	
	public String toString()
	{//inicio del metodo toString
		return "Número de cedula: "+Cedula+ "\nNombre: "+Nombre+ "\nEdad: "+Edad+ 
				"\nGrado académico: "+Grado+ "\nAños de experiencia: "+Experiencia;
	}//fin del metodo toString
}//fin de la clase Nodo
