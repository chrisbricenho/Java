import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Video_Club extends JFrame implements ActionListener
{//fin de la clase Video_Club
	Nodo Inicio, Ultimo; //variables de tipo Nodo
	JButton Ingresar, MostrarQuick, MostrarShell, Ayuda; //creacion de variables de tipo JButton
	private Font fuente;   //variable fuente de tipo Font 
	private int Dias, tamaño, tamaño2, condicion=0, V, Cop, intervalo, K, R=0, T=0,pelis=-1; //creacion de variables de tipo int
	private String Situacion, Nombre; //creacion de variables de tipo String
	ArrayList<Nodo> arreglo= new ArrayList<Nodo>();	//creacion de un arraylist de tipo Nodo
	Copias Primero, Final; //creacion de variables de tipo Copias
	Copias First, Last; //creacion de variables de tipo Copias
	Nodo Peliculas []= new Nodo[200]; //creacion de un arreglo de tipo Nodo donde se guardan todas las peliculas
	int maximo=-1; //creacion de variable de tipo int
	
	public Video_Club()
	{//inicio del metodo Constructor
		this.Inicio=null;
		this.Ultimo=null;
		this.Primero=null;
		this.Final=null;
		this.First=null;
		this.Last=null;
		this.tamaño=0;
		this.tamaño2=0;
		
		Container Panel = getContentPane();
		Panel.setBackground(Color.DARK_GRAY);
		setSize(650,350);
		setTitle("Video Club");
		setLocation(400,150);
		setResizable(false);
		Panel.setLayout(new FlowLayout());
		
		fuente= new Font("Serief", Font.PLAIN, 20);

		Ingresar= new JButton("Ingresar Pelicula");
		Ingresar.setToolTipText("Para ingresar los datos de cada Pelicula");
		Ingresar.setFont(fuente);
		Ingresar.setBackground(new Color( 220, 220, 220));
		this.add(Ingresar);
		
		MostrarQuick= new JButton("Presentar Ordenamiento Quick");
		MostrarQuick.setToolTipText("Presenta los titulos de las películas con más copias presentadas");
		MostrarQuick.setFont(fuente);
		MostrarQuick.setBackground(new Color( 220, 220, 220));
		this.add(MostrarQuick);
		
		MostrarShell= new JButton("Presentar Ordenamiento Shell");
		MostrarShell.setToolTipText("Prsenta los nombres de los clientes ordenados deacuerdo a la cantidad de dias");
		MostrarShell.setFont(fuente);
		MostrarShell.setBackground(new Color( 220, 220, 220));
		this.add(MostrarShell);
		
		Ayuda= new JButton("Ayuda");
		Ayuda.setToolTipText("Manual de Ayuda");
		Ayuda.setFont(fuente);
		Ayuda.setBackground(new Color( 220, 220, 220));
		this.add(Ayuda);
		
		Ingresar.addActionListener(this);
		MostrarQuick.addActionListener(this);
		MostrarShell.addActionListener(this);
		Ayuda.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//fin del metodo constructor
	
	public static void main(String[] args) 
	{//inicio del metodo main
		Video_Club app= new Video_Club();
		app.setVisible(true);
	}//fin del metodo main
	
	public boolean siVacio()
	{//inicio del metodo siVacio
		return(this.Inicio==null);		
	}//fin del metodo siVacio
	
	public boolean siVacio2()
	{//inicio del metodo siVacio
		return(this.Primero==null);		
	}//fin del metodo siVacio
	
	public boolean siVacio3()
	{//inicio del metodo siVacio
		return(this.First==null);		
	}//fin del metodo siVacio

	public void actionPerformed(ActionEvent e) 
	{//inicio del metodo actionPerformed
		if (e.getSource()==Ingresar) {//inicio del if
			if (maximo<=199)
			{//inicio del if
				maximo++;
				String Codigo=JOptionPane.showInputDialog("Ingrese el codigo de la Película: ");
				String Titulo=JOptionPane.showInputDialog("Ingrese el titulo de la Película: ");
				int z=0;
				while (z==0)
				{//inicio del while
					try {//inicio del try
						do {//inicio del do while
							Cop=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de copias de la Película: "));					
							if (Cop>=16 | Cop<=-1) {//inicio del if
							 JOptionPane.showMessageDialog(null, "La cantidad maxima de copias es de 15", "Atencion estimado usuario", JOptionPane.ERROR_MESSAGE);
						   }//fin del if
						} while (Cop>=16 | Cop<=-1);	//fin del do while					
						z=1;
					} //fin del try
					catch (Exception e2) {//inicio del catch
						JOptionPane.showMessageDialog(null, "A ocurrido un error usted debe de ingresar un valor numerico para la cantidad de copias","Atención estimado usuario",JOptionPane.ERROR_MESSAGE);
					    z=0;
					    JOptionPane.showMessageDialog(null,"Vuelva a ingresar la cantidad de copias de la película","Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
					}//fin del catch
				}//fin del while
				int b=0;
				
				for (int i = 0; i < Cop; i++) 
				{//inicio del for
					do {//inicio del do while
							String Situ=JOptionPane.showInputDialog("Escaja una de las opciones para la situacion de la copia #"+(i+1)+" de la película "+Titulo+" \n1)Alquilada \n2)Disponible");
							 V=Integer.parseInt(Situ);
							 if (V>=3 | V<=0) 
								{//inicio del if
									JOptionPane.showMessageDialog(null, "A ocurrido un error usted debe de digitar uno de las siguientes numeros: 1 ó 2", "Atención estimado Usuario",JOptionPane.ERROR_MESSAGE);
								}//fin del if
						} while (V>=3 | V<=0); //fin del do while
					
					switch (V) {//inicio del switch
					case 1:
						 Situacion="Alquilada";
						 b++;
						break;
					case 2:
						Situacion="Disponible";
						break;
					default:
						break;
					}//fin del swtich
					
					if (Situacion.equals("Alquilada")) {//inicio del if
						Nombre=JOptionPane.showInputDialog("Ingrese el Nombre del cliente de la copia #"+(i+1)+" de la película "+Titulo+":");
						int r=0;
						while (r==0)
						{//inicio del while
							try {//inicio del try
								Dias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dias que se alquilo la copia #"+(i+1)+" de la película "+Titulo+":"));
								r=1;
							} //fin del try
							catch (Exception e2) {//inicio del catch
								JOptionPane.showMessageDialog(null, "A ocurrido un error usted debe de ingresar un valor numerico para la cantidad de dias","Atención estimado usuario",JOptionPane.ERROR_MESSAGE);
							    r=0;
							    JOptionPane.showMessageDialog(null,"Vuelva a ingresar la cantidad de dias de alquiler de la película","Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
							}//fin del catch
						}//fin del while
						Copias Nuevo=new Copias(Situacion, Nombre, Dias, Titulo);
						if (siVacio2())
						{//inicio del if
							//this.Inicio=Nuevo;
							this.Primero=Nuevo;
							this.Final=Nuevo;
							this.Primero.Siguiente=null;
							this.Primero.Anterior=null;
						}//fin del if 
						else 
						{//inicio del else
							Final.Siguiente=Nuevo;
							Nuevo.Anterior=Final;
							Final=Nuevo;
						}//fin del else
						this.tamaño2++;
					}//fin del if
					else {//inicio del else
						int r=0;
						while (r==0)
						{//inicio del while
							try {//inicio del try
								Dias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dias que lleva sin alquilarse la copia #"+(i+1)+" de la película "+Titulo+":"));
								r=1;
							} //fin del try
							catch (Exception e2) {//inicio del catch
								JOptionPane.showMessageDialog(null, "A ocurrido un error usted debe de ingresar un valor numerico para la cantidad de dias","Atención estimado usuario",JOptionPane.ERROR_MESSAGE);
							    r=0;
							    JOptionPane.showMessageDialog(null,"Vuelva a ingresar la cantidad de dias de alquiler de la película","Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
							}//fin del catch
						}//fin del while
						Copias Nuevo=new Copias(Dias);
						if (siVacio3())
						{//inicio del if
							//this.Inicio=Nuevo;
							this.First=Nuevo;
							this.Last=Nuevo;
							this.First.Siguiente=null;
							this.First.Anterior=null;
						}//fin del if 
						else 
						{//inicio del else
							Last.Siguiente=Nuevo;
							Nuevo.Anterior=Last;
							Last=Nuevo;
						}//fin del else
					}//fin del else		
				}//fin del for
				
				Nodo Nuevo=new Nodo(Codigo, Titulo, Cop, Primero, First, b);
				if (siVacio())
				{//inicio del if
					pelis++;
					this.Inicio=Nuevo;
					this.Ultimo=Nuevo;
					this.Inicio.Siguiente=null;
					this.Inicio.Anterior=null;
					arreglo.add(Inicio);
					Peliculas[pelis]=Inicio;
				}//fin del if 
				else 
				{//inicio del else
					pelis++;
					Ultimo.Siguiente=Nuevo;
					Nuevo.Anterior=Ultimo;
					Ultimo=Nuevo;
					arreglo.add(Ultimo);
					Peliculas[pelis]=Ultimo;
				}//fin del else
				this.tamaño++;
				Nodo aux=Inicio;
				Nodo aux2=Inicio;
				String Codi=aux.Codigo;
				int NumPeli=1;
				if (aux.Siguiente==null) {//inicio del if
					NumPeli=1;
				}//fin del if
				else {//inicio del else
					while (aux!=null) {//inicio del while
						if (aux.Siguiente!=null) {
							if (aux.Codigo!=aux.Siguiente.Codigo) {
								NumPeli++;
							}
							else {
								NumPeli--;
							}
						}						
						aux=aux.Siguiente;
					}//fin del while
				}//fin del else
				JOptionPane.showMessageDialog(null, "El número de películas distintas en el Video Club es: "+NumPeli,"Atención estimado usuario", JOptionPane.INFORMATION_MESSAGE);
			}//fin del if
			else {//inicio del else
				JOptionPane.showMessageDialog(null,"Ya no se puede ingresar mas peliculas (maximo 200)","Atencion estimado usuario",JOptionPane.WARNING_MESSAGE);
			}//fin del else
		}//fin del if
		
		else if (e.getSource()==MostrarQuick) {//inicio del else if
			
				Quicksort(arreglo, 0, arreglo.size()-1);
				
				if (tamaño!=0) {//inicio del if
					Nodo Mostrar=Inicio;
					while (Mostrar!=null) {//inicuio del while
					Mostrar.toString();
					JOptionPane.showMessageDialog(null, Mostrar,"Titulos de las peliculas -Quicksort-", JOptionPane.INFORMATION_MESSAGE);
					Mostrar=Mostrar.Siguiente;
					}//fin del while
				}//fin del if	
		}//fin del else if
		
		else if (e.getSource()==MostrarShell) {//inicio del else if
				Shell();	
		}//fin del else if
		
		else if (e.getSource()==Ayuda) {//inicio del else if
			 try
	    	   {//inicio del try
				    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"src\\ayuda.pdf");
			   }//fin del try 
	    	   catch (Exception ex)
	    	   {//inicio del catch
	    		   JOptionPane.showMessageDialog(null,
			       		     "Se ha se producido un error", "Atencion estimado usuario",
			       		     JOptionPane.INFORMATION_MESSAGE);
			   }//fin del catch
		}//fin del else if
	}//fin del metodo actionPerformed
	
	public void Shell()
	{//inicio del metodo Shell		
		/**
		 * Inicio del Algoritmo de Ordenamiento Shell
		 */
		K=tamaño2/2;
		Copias Auxiliar=null;
		Copias Temp=null;
		Copias A=null;
		
		while (K>=1) 
		{//inicio del while
			for (int i = 0; i < tamaño2-K; i++) 
			{//inicio del for
				if (i==0)
				{//inicio del if
					Auxiliar=Primero;
					A=Primero;
					intervalo=K;
					Temp=Primero;
				}//fin del if
				else
				{//inicio del else
					Auxiliar=Auxiliar.Siguiente;
					A=A.Siguiente;
					Temp=Primero;
				}//fin del else
				
				for (int j = 0; j < intervalo+i; j++)
				{//inicio del for
					Temp=Temp.Siguiente;	
				}//fin del for
				
					if (i==0)
					{//inicio del if
							if (Primero.Dias<Temp.Dias) 
							{//inicio del if							
							 int Dias=Temp.Dias;
							 String Situacion=Temp.Situacion;
							 String Nombre=Temp.Nombre;		
							 String Titulo=Temp.Titulo;	
								
								Temp.setSituacion(A.Situacion);
							    Temp.setDias(A.Dias);
							    Temp.setNombre(A.Nombre);
							    Temp.setTitulo(A.Titulo);
								
							    Auxiliar.setSituacion(Situacion);
								Auxiliar.setDias(Dias);
								Auxiliar.setNombre(Nombre);
								Auxiliar.setTitulo(Titulo);
							}//fin del if					
					}//fin del if
					else
					{//inicio del else
							if(Auxiliar.Dias<Temp.Dias)
							{//inicio del if							
								 int Dias=Temp.Dias;
								 String Situacion=Temp.Situacion;
								 String Nombre=Temp.Nombre;
								 String Titulo=Temp.Titulo;	
								
								Temp.setDias(A.Dias);
							    Temp.setSituacion(A.Situacion);
							    Temp.setNombre(A.Nombre);
							    Temp.setTitulo(A.Titulo);
							    
								Auxiliar.setSituacion(Situacion);
								Auxiliar.setDias(Dias);
								Auxiliar.setNombre(Nombre);	
								Auxiliar.setTitulo(Titulo);
							}//fin del if
					}//fin del else					
			}//fin del for	
			K /= 2;
		}//fin del while
		/**
		 * Fin del Algoritmo de Ordenamiento Shell
		 */
		
		
		/**
		 * Inicio del Algoritmo de Ordenamiento Insersion Directa
		 */
		Copias aux=Primero;
		Copias aux2=null;
		
		while (aux.Siguiente!=null) 
		{//inicio del while
			if (aux.Siguiente!=null) 
			{//inidio del if
				if (aux.Dias<aux.Siguiente.Dias)
				{//inicio del if
					 int Dias=aux.Siguiente.Dias;
					 String Situacion=aux.Siguiente.Situacion;
					 String Nombre=aux.Siguiente.Nombre;
					 String Titulo=aux.Siguiente.Titulo;	
					 
					 int days=aux.Dias;
					 String Situ=aux.Situacion;
					 String Name=aux.Nombre; 
					 String titu=aux.Titulo;					 
				    
				    aux.Siguiente.setDias(days);
				    aux.Siguiente.setSituacion(Situ);
				    aux.Siguiente.setNombre(Name);
				    aux.Siguiente.setTitulo(titu);
				    
				    aux.setDias(Dias);
				    aux.setSituacion(Situacion);
				    aux.setNombre(Nombre);
				    aux.setTitulo(Titulo);
				    
				    if (aux.Anterior!=null)
				    {//inicio del if
				    	aux2=aux.Anterior;
				    	if (aux2.Dias>Dias) 
				    	{//inicio del if
				    		aux.setSituacion(Situacion);
						    aux.setDias(Dias);
						    aux.setNombre(Nombre);
						    aux.setTitulo(Titulo);
						}//fin del if
				    	else {//inicio del else
				    		while (aux2.Dias<Dias)
							{//inicio del while
					    		 int di=aux2.Dias;
								 String Si=aux2.Situacion;
								 String Nom=aux2.Nombre;
								 String Ti=aux2.Titulo;
								 
							    aux2.Siguiente.setDias(di);
							    aux2.Siguiente.setSituacion(Si);
							    aux2.Siguiente.setNombre(Nom);
							    aux2.Siguiente.setTitulo(Ti);
							    
							    aux2.setDias(Dias);
							    aux2.setSituacion(Situacion);
							    aux2.setNombre(Nombre);
							    aux2.setTitulo(Titulo);
							    
							    if (aux2.Anterior!=null)
							    {//inicio del if
								 	aux2=aux2.Anterior;
								}//fin del if
							}//fin del while
						}	//fin del else		    	
					}//fin del if			    
				}//fin del if
			}//fin del if	
			aux=aux.Siguiente;
		}//fin del while 
		/**
		 * Fin del Algoritmo de Ordenamiento Insersion Directa
		 */
		
		if (tamaño2!=0) {//inicio del if
			Copias Mostrar=Primero;
			while (Mostrar!=null) {//inicuio del while
			Mostrar.toString();
			JOptionPane.showMessageDialog(null, Mostrar,"Nombres de Clientes -Shell-", JOptionPane.INFORMATION_MESSAGE);
			Mostrar=Mostrar.Siguiente;
			}//fin del while
		}//fin del if	
	}//fin del metodo Shell
	
	public ArrayList<Nodo> Quicksort(ArrayList<Nodo> a, int izq,int der){//inicio del metodo Quicksort
		int i=izq;
		int j = der;
		int Pivote = a.get((izq+der)/2).Alquiladas;
		do{//inicio de do while

		while(a.get(i).Alquiladas > Pivote){//inicio del while
		i++;
		}//fin del while
		while(a.get(j).Alquiladas < Pivote){//inicio del while
		j--;
		}//fin del while
		if (i <= j){//inicio del if
			
		String codigo = a.get(i).Codigo;
		String titulo=a.get(i).Titulo;
		int copias=a.get(i).Copias;
		Copias copiasalquiladas=a.get(i).Copiasalquiladas;
		Copias copiasdisponibles=a.get(i).Copiasdisponibles;
		int alquiladas=a.get(i).Alquiladas;
		
		a.get(i).setCodigo(a.get(j).Codigo);
		a.get(i).setTitulo(a.get(j).Titulo);
		a.get(i).setCopias(a.get(j).Copias);
		a.get(i).setCopiasalquiladas(a.get(j).Copiasalquiladas);
		a.get(i).setCopiasdisponibles(a.get(j).Copiasdisponibles);
		a.get(i).setAlquiladas(a.get(j).Alquiladas);
		
		a.get(j).setCodigo(codigo);
		a.get(j).setTitulo(titulo);
		a.get(j).setCopias(copias);
		a.get(j).setCopiasalquiladas(copiasalquiladas);
		a.get(j).setCopiasdisponibles(copiasdisponibles);
		a.get(j).setAlquiladas(alquiladas);
		
		i++;
		j--;
		}//fin del if
		}while (i <= j); //fin del do while
		
		if(izq < j){//inicio del if
		Quicksort(a,izq,j);
		}//fin del if
		
		if(i < der){//inicio del if
		Quicksort(a,i,der);
		}//fin del id
		
		return a;
		}//fin del metodo Quicksort
}//fin de la clase Video_Club