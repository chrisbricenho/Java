import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class A_Ordenamiento extends JFrame implements ActionListener
{//inicio de la clase A_Ordenamiento
	private Nodo Inicio, Ultimo, Primero, Final, First, Last;
	private int intercambios, comparaciones, intercambiosshell, comparacionesshell, intercambiosquick, comparacionesquick, tamaño , tamaño2, condicion=0, condicion2=0, A, B, K, intervalo;
	private JButton Insertar, Insertar2, Mostrar ;
	private Font fuente;   //variable fuente de tipo Font
	int Edad, Experiencia;
	long Cedula;
	String Nombre, Grado;
	
	public A_Ordenamiento()
	{//inicio del metodo constructor
		this.Inicio=null;
		this.Ultimo=null;
		this.Primero=null;
		this.Final=null;
		this.First=null;
		this.Last=null;
		this.tamaño=0;
		
		Container Panel = getContentPane();
		Panel.setBackground(Color.DARK_GRAY);
		setSize(550,350);
		setTitle("Ex_Plota S.A");
		setLocation(400,150);
		setResizable(false);
		Panel.setLayout(new FlowLayout());
		
		fuente= new Font("Serief", Font.PLAIN, 20);
		
		Insertar= new JButton("Ingresar Oferentes");
		Insertar.setToolTipText("Para ingresar los curriculums de los oferentes");
		Insertar.setFont(fuente);
		Insertar.setBackground(new Color( 220, 220, 220));
		this.add(Insertar);
		
		Insertar2= new JButton("Crear segunda lista");
		Insertar2.setToolTipText("Para crear una nueva lista de oferentes");
		Insertar2.setFont(fuente);
		Insertar2.setBackground(new Color( 220, 220, 220));
		this.add(Insertar2);
		
		Mostrar= new JButton("Mostrar");
		Mostrar.setToolTipText("Muestra la unica lista formada");
		Mostrar.setFont(fuente);
		Mostrar.setBackground(new Color( 220, 220, 220));
		this.add(Mostrar);
		
		Insertar.addActionListener(this);
		Insertar2.addActionListener(this);
		Mostrar.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//inicio del metodo constructor

	public static void main(String[] args)
	{//inicio del metodo main
		A_Ordenamiento A= new A_Ordenamiento();
		A.setVisible(true);
	}//fin del metodo main

	public boolean siVacio()
	{//inicio del metodo siVacio
		return(this.Inicio==null);		
	}//fin del metodo siVacio
	
	public boolean siVacio2()
	{//inicio del metodo siVacio2
		return(this.Primero==null);		
	}//fin del metodo siVacio2

	public void actionPerformed(ActionEvent e) 
	{//inicio del metodo actionPerformed
		if (e.getSource()==Insertar) 
		{//inicio del if
			if (A==0)
			{//inicio del if
				while (condicion==0) 
				{//inicio del while		
					int V=0;
					while (V==0)
					{//inicio del while
						try 
						{//inicio del try
							Cedula=Long.parseLong(JOptionPane.showInputDialog("Ingrese el Número de Cedula: "));
							Nombre=JOptionPane.showInputDialog("Ingrese el Nonbre: ");
							Edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Edad: "));
							Experiencia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese sus años de experiencia: "));
							Grado=JOptionPane.showInputDialog("Ingrese su grado académico: ");
							V=1;
						} //fin del try
						catch (Exception e2)
						{//inicio del catch
							JOptionPane.showMessageDialog(null, "A ocurrido un error usted debe de ingresar valores numericos para \nlos datos de Número de Cedula, Edad y Años de Experiencia.","Atención estimado usuario",JOptionPane.ERROR_MESSAGE);
						    V=0;
						    JOptionPane.showMessageDialog(null,"Vuelva a ingresar los datos del Oferente","Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
						}//fin del catch	
					}//fin del while

					Nodo Nuevo= new Nodo(Cedula, Edad, Experiencia, Nombre, Grado);
					
					if (siVacio())
					{//inicio del if
						this.Inicio=Nuevo;
					}//fin del if 
					else 
					{//inicio del else
						Ultimo=Inicio;
						while (Ultimo.Siguiente!=null)
						{//inicio del while
						Ultimo=Ultimo.Siguiente;	
						}//fin del while 
						Ultimo.Siguiente=Nuevo;
					}//fin del else
					this.tamaño++;
				    condicion= JOptionPane.showConfirmDialog(null,"¿Desea seguir ingresando Oferentes?", "Pregunta",
			      			    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);    
				}//fin del while
				A++;
				Shell();
			}//fin del if	
			else 
			{//inicio del else
			  JOptionPane.showMessageDialog(null, "Ya se ha creado la lista de oferentes.", "Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
			}//fin del else
		}//fin del if
		
		else if (e.getSource()==Insertar2)
		{//inicio del else if
			if (B==0)
			{//inicio del if
				while (condicion2==0) 
				{//inicio del while
					int V=0;
					while (V==0)
					{//inicio del while
						try 
						{//inicio del try
							Cedula=Long.parseLong(JOptionPane.showInputDialog("Ingrese el Número de Cedula: "));
							Nombre=JOptionPane.showInputDialog("Ingrese el Nonbre: ");
							Edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Edad: "));
							Experiencia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese sus años de experiencia: "));
							Grado=JOptionPane.showInputDialog("Ingrese su grado académico: ");
							V=1;
						} //fin del try
						catch (Exception e2)
						{//inicio del catch
							JOptionPane.showMessageDialog(null, "A ocurrido un error usted debe de ingresar valores numericos para \nlos datos de Número de Cedula, Edad y Años de Experiencia.","Atención estimado usuario",JOptionPane.ERROR_MESSAGE);
						    V=0;
						    JOptionPane.showMessageDialog(null,"Vuelva a ingresar los datos del Oferente","Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
						}//fin del catch	
					}//fin del while
					
					Nodo Nuevo= new Nodo(Cedula, Edad, Experiencia, Nombre, Grado);
					
					if (siVacio2())
					{//inicio del if
						this.Primero=Nuevo;
					}//fin del if 
					else 
					{//inicio del else
						Final=Primero;
						while (Final.Siguiente!=null)
						{//inicio del while
						Final=Final.Siguiente;	
						}//fin del while 
						Final.Siguiente=Nuevo;
					}//fin del else
					this.tamaño2++;
				    condicion2= JOptionPane.showConfirmDialog(null,"¿Desea seguir ingresando Oferentes?", "Pregunta",
			      			    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);    	   
				}//fin del while
				B++;
				Seleccion();
			}//fin del if	
			else 
			{//inicio del else
			  JOptionPane.showMessageDialog(null, "Ya se ha creado la segunda lista de oferentes.", "Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
			}//fin del else
		}//fin del else if
		
		else if (e.getSource()==Mostrar)
		{//inicio del else if
			if (B!=0 && A!=0) 
			{
				int X=0;
				Nodo A=Inicio;
				Nodo B=Primero;
				if (A.Experiencia<B.Experiencia)
				{
					First=A;
					X=1;
				}
				else if (B.Experiencia<A.Experiencia)
				{
					First=B;
					X=2;
				}
				
				while (X==1)
				{
					A=A.Siguiente;
					if (A.Experiencia<B.Experiencia)
					{
						Last=A;
						X=1;
					}
				}
				while (X==2)
				{
					B=B.Siguiente;
					if (B.Experiencia<B.Experiencia)
					{
						Last=B;
						X=2;
					}
				}
			}//fin del if
			else 
			{//inicio del else
			  JOptionPane.showMessageDialog(null, "Aun no se han creado las listas.", "Atención estimado usuario",JOptionPane.INFORMATION_MESSAGE);
			}//fin del else
		}//fin del else if
	}//fin del metodo actionPerformed
	
	public void Shell()
	{//inicio del metodo Shell
		K=tamaño/2;
		Nodo Auxiliar=null;
		Nodo Temp=null;
		Nodo A=null;
		Nodo Temp2= null;
		
		while (K>=1) 
		{//inicio del while
			for (int i = 0; i < tamaño-K; i++) 
			{//inicio del for
				if (i==0)
				{//inicio del if
					Auxiliar=Inicio;
					A=Inicio;
					System.out.println("Incio:_"+Auxiliar.Cedula);
					intervalo=K;
					Temp=Inicio;
					Temp2=Inicio;
				}//fin del if
				else
				{//inicio del else
					Auxiliar=Auxiliar.Siguiente;
					System.out.println(Auxiliar.Cedula);
					A=A.Siguiente;
					Temp=Inicio;
					Temp2=Inicio;
				}//fin del else
				
				for (int j = 0; j < intervalo+i; j++)
				{//inicio del for
					Temp=Temp.Siguiente;	
					Temp2=Temp2.Siguiente;
				}//fin del for
				
					comparacionesshell++;
					if (i==0)
					{//inicio del if	
						if (Inicio.Cedula>Temp.Cedula) 
						{//inicio del if							
						    Temp.Cedula=A.Cedula;
						    Temp.Grado=A.Grado;
						    Temp.Experiencia=A.Experiencia;
						    Temp.Edad=A.Edad;
						    Temp.Nombre=A.Nombre;
							JOptionPane.showMessageDialog(null,Temp.toString(),"TEMP", JOptionPane.ERROR_MESSAGE);						
													   
							Auxiliar.Cedula=Temp2.Cedula;
						    Auxiliar.Grado=A.Grado;
						    Auxiliar.Experiencia=A.Experiencia;
						    Auxiliar.Edad=A.Edad;
						    Auxiliar.Nombre=A.Nombre;				
							JOptionPane.showMessageDialog(null,Auxiliar.toString(),"AUXILIAR", JOptionPane.ERROR_MESSAGE);						
							
							//A=Auxiliar;
							JOptionPane.showMessageDialog(null,A.toString(),"AAA", JOptionPane.ERROR_MESSAGE);													
							//Temp2=Temp;
							JOptionPane.showMessageDialog(null,Temp2.toString(),"TEMP2", JOptionPane.ERROR_MESSAGE);													
							intercambiosshell++;
						}//fin del if
					}//fin del if
					else
					{//inicio del else
						if(Auxiliar.Cedula>Temp.Cedula)
						{//inicio del if
							Auxiliar.Cedula=Temp2.Cedula;
						    Auxiliar.Grado=Temp2.Grado;
						    Auxiliar.Experiencia=Temp2.Experiencia;
						    Auxiliar.Edad=Temp2.Edad;
						    Auxiliar.Nombre=Temp2.Nombre;JOptionPane.showMessageDialog(null,Auxiliar.toString(),"ESTE AUXILIAR", JOptionPane.ERROR_MESSAGE);													
							
						    Temp.Cedula=A.Cedula;
						    Temp.Grado=A.Grado;
						    Temp.Experiencia=A.Experiencia;
						    Temp.Edad=A.Edad;
						    Temp.Nombre=A.Nombre;
							JOptionPane.showMessageDialog(null, Temp.toString(),"ESTE ES TEMP", JOptionPane.ERROR_MESSAGE);
						
							//A=Auxiliar;
							JOptionPane.showMessageDialog(null,A.toString(),"ESTE ES AAAA", JOptionPane.ERROR_MESSAGE);													
							//Temp2=Temp;
							JOptionPane.showMessageDialog(null,Temp2.toString(),"ESTE ES TEMP2", JOptionPane.ERROR_MESSAGE);													
							intercambiosshell++;
							System.out.println("------------");
						}//fin del if
					}//fin del else					
			}//fin del for	
			K /= 2;
		}//fin del while
		
		if (tamaño!=0) {
			Nodo Mostrar=Inicio;
			while (Mostrar!=null) {
			Mostrar.toString();
			JOptionPane.showMessageDialog(null, Mostrar,"Curriculum", JOptionPane.INFORMATION_MESSAGE);
			Mostrar=Mostrar.Siguiente;
			}
		}		
		JOptionPane.showMessageDialog(null,"El número de intercambios para el metodo Shell fue: "+intercambiosshell,"Intercambios del Shell",JOptionPane.INFORMATION_MESSAGE );
		JOptionPane.showMessageDialog(null,"El número de comparaciones para el metodo Shell fue: "+comparacionesshell,"Comparaciones del Shell",JOptionPane.INFORMATION_MESSAGE );		
	}//fin del metodo Shell
	
	public void Quicsort()
	{//inicio del metodo Quicksort
		Nodo Pivote=Inicio;
		int Pivot=tamaño/2;
		for (int i = 1; i < Pivot; i++)
		{//inicio del for
			Pivote=Pivote.Siguiente;
		}//fin del for
		Nodo I= Inicio;
		Nodo J=Pivote.Siguiente;
		
		while (I.Experiencia<Pivote.Experiencia)
		{//inicio del while
			comparacionesquick++;
			I= I.Siguiente;
		}//fin del while
		while (J.Experiencia>Pivote.Experiencia)
		{//inicio del while
			comparacionesquick++;
			if (J.Siguiente!=null)
			{//inicio del if
				J= J.Siguiente;
			}//fin del if
		}//fin del while
		
		I=J;
			
	}//fin del metodo Quicksort
	
	public void Seleccion()
	{//inicio del metodo Seleccion
		Nodo temp=Primero;
		Nodo aux=null;
		Nodo aux2= null;
		
		while (temp!=null)
		{
			aux=temp;
			while (aux.Siguiente!=null) 
			{
				aux=aux.Siguiente;
				if (temp.Experiencia<aux.Experiencia)
				{
					aux2=temp;
					JOptionPane.showMessageDialog(null, aux2);
					temp=aux;
					JOptionPane.showMessageDialog(null, temp);
					aux=aux2;
				}
			}
			temp=temp.Siguiente;
		}
		
		if (tamaño2!=0) {
			Nodo Mostrar=Primero;
			while (Mostrar!=null) {
			Mostrar.toString();
			JOptionPane.showMessageDialog(null, Mostrar,"Curriculum", JOptionPane.INFORMATION_MESSAGE);
			Mostrar=Mostrar.Siguiente;
			}
		}
	}//fin del metodo Seleccion
}//fin de la clase A_Ordenamiento

