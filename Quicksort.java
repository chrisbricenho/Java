import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Quicksort extends JFrame implements ActionListener{

	JButton Ingresar, Quicksort,Buscar, Eliminar;
	Nodo Inicio, Ultimo, Pivote;
	int tamaño,c;
	ArrayList<Nodo> lista= new ArrayList<Nodo>();
	Nodo[] personas= new Nodo[800];
	long buscacedula, eliminar;
	int centro, WTF;
	
	public Quicksort() {
		this.Inicio=null;
		this.Ultimo=null;
		this.tamaño=0;
		
		setLayout(new FlowLayout());
		setSize(200,200);
		setLocation(500,250);
		Ingresar=new JButton("Ingresar");
		Quicksort= new JButton("Quicksort");
		Buscar=new JButton("Buscar");
		Eliminar= new JButton("Eliminar");
		
		add(Ingresar);
		add(Quicksort);
		add(Buscar);
		add(Eliminar);
		
		Ingresar.addActionListener(this);
		Quicksort.addActionListener(this);
		Buscar.addActionListener(this);
		Eliminar.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		Quicksort app=new Quicksort();
		app.setVisible(true);
	}
	
	public boolean siVacio()
	{//inicio del metodo siVacio
		return(this.Inicio==null);		
	}//fin del metodo siVacio

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Ingresar) {
			
			while (c==0) {
				long cedula=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula: "));
				String name=JOptionPane.showInputDialog("Ingrese el Nombre: ");
				
				Nodo persona= new Nodo();
				
				/**
				 * MITAD DEL CUADRADO
				 */
				double potencia=  Math.pow(cedula, 2);
				long Pos=(long) potencia;
				String a=String.valueOf(Pos);
				
				if (a.length() <5) {
					JOptionPane.showMessageDialog(null,"NO SE PUEDE INGRESAR LA CEDULA YA QUE NO ES DE 6 DIGITOS");
				}
				else {
					int Posicion=Integer.parseInt(a.substring(5,8)); System.out.println(Posicion);
					/**
					 * MITAD DEL CUADRADO
					 */
					
		           	 int S=0;
		           	 
		           	 if (Posicion>personas.length-1) {
		           		String b=String.valueOf(Posicion);
		           		 Posicion=Integer.parseInt(b.substring(0,1)); System.out.println(Posicion);
					}
		           	 
		           	 /**
		           	  * PRUEBA LINEAL O DIRECCIONAMIENTO ABIERTO
		           	  */
		           	 	if (personas[Posicion]==null) {
							persona.setCedula(cedula);
							persona.setNombre(name);
							personas[Posicion]=persona;
							lista.add(personas[Posicion]);
						}	
		           	 	else if (personas[Posicion]!=null) {
							while (personas[Posicion]!=null) {
								Posicion++;
							}
							persona.setCedula(cedula);
							persona.setNombre(name);
							personas[Posicion]=persona;
							lista.add(personas[Posicion]);
						}	           	 
		           	/**
		           	  * PRUEBA LINEAL O DIRECCIONAMIENTO ABIERTO
		           	  */
			    	   	
			    	   	if (S==0) {//inicio del if
				    	   	JOptionPane.showMessageDialog(null, "La posicion de direccion que ocupará el participante es: "+Posicion, "Atencion estimado usuario.",JOptionPane.INFORMATION_MESSAGE);
						}//fin del if

					    this.tamaño++;
				}	    
				    c= JOptionPane.showConfirmDialog(null,"¿Desea seguir ingresando Oferentes?", "Pregunta",
		      			    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);    
			}	    
		}//fin del else if
		
		else if (e.getSource()==Quicksort) {
			if (WTF==0 && c==1) {
				WTF++;
				quicksort(lista,0,lista.size()-1);
				
				if (tamaño!=0) {
					for (int i = 0; i < lista.size(); i++) {
						Nodo aux= new Nodo();
						aux=lista.get(i);
						
						long DNI=aux.Cedula;
						double potencia=  Math.pow(DNI, 2);
						long Pos=(long) potencia;
						String a=String.valueOf(Pos);
						int Posicion=Integer.parseInt(a.substring(5,8)); 						
						personas[Posicion]=aux;						
						JOptionPane.showMessageDialog(null, aux.toString());
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "YA SE HA ORDENADO LA LISTA O NO SE HA CREADO LA LISTA");
			}
		}
		
		else if (e.getSource()==Buscar) {
			if (WTF!=0) {
				buscacedula=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula: "));
				
				int inicio=0;
				int fin=personas.length-1;
				
				double potencia=  Math.pow(buscacedula, 2);
				long Pos=(long) potencia;
				String a=String.valueOf(Pos);
				int Posicion=Integer.parseInt(a.substring(5,8)); System.out.println("\n"+Posicion);
				
				/**
	           	 * ACARREO POR SI LA POSICION ES MAYOR AL TAMAÑO DEL ARREGLO 
	           	 */
				if (Posicion>personas.length-1) {
	           		String b=String.valueOf(Posicion);
	           		 Posicion=Integer.parseInt(b.substring(0,1)); System.out.println(Posicion);
				}
				/**
	           	 * ACARREO POR SI LA POSICION ES MAYOR AL TAMAÑO DEL ARREGLO 
	           	 */
				
				if (personas[Posicion]==null) {
					JOptionPane.showMessageDialog(null, "NO EXISTE LA CEDULA INGRESADA ANTERIORMENTE.");
				}
				else {
					/**
					 * BUSQUEDA BINARIA
					 */
					while (inicio<=fin) {
						centro=(inicio+fin)/2;
						
						if (centro==Posicion) {
							JOptionPane.showMessageDialog(null, personas[centro].toString());
							break;
						}
						else if (Posicion<centro) {
							fin=centro-1;
						}
						else if (Posicion>centro) {
							inicio=centro+1;
						}
					}
					/**
					 * BUSQUEDA BINARIA
					 */
				}			
			}	
			else {
				JOptionPane.showMessageDialog(null,"PRIMERO DEBE DE ORDENAR EL ARREGLO YA QUE PARA USAR BUSQUEDA BINARIA \nEL ARREGLO DEBE DE ESTAR ORDENADO");
			}
		}
		
		else if (e.getSource()==Eliminar) {
			eliminar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula: "));
			
			double potencia=  Math.pow(eliminar, 2);
			long Pos=(long) potencia;
			String a=String.valueOf(Pos);
			if (a.length()>9) {
				int Posicion=Integer.parseInt(a.substring(5,8)); System.out.println("\n"+Posicion);
				
				/**
	           	 * ACARREO POR SI LA POSICION ES MAYOR AL TAMAÑO DEL ARREGLO 
	           	 */
				if (Posicion>personas.length-1) {
	           		String b=String.valueOf(Posicion);
	           		 Posicion=Integer.parseInt(b.substring(0,1)); System.out.println(Posicion);
				}
				/**
	           	 * ACARREO POR SI LA POSICION ES MAYOR AL TAMAÑO DEL ARREGLO 
	           	 */
				
				if (personas[Posicion]==null) {
					JOptionPane.showMessageDialog(null, "NO EXISTE LA CEDULA INGRESADA ANTERIORMENTE.");
				}
				else {
					personas[Posicion]=null;
					JOptionPane.showMessageDialog(null,"SE HA ELIMINADO LA PERSONA!");
				}
			}
			
			
		}
	}

	public ArrayList<Nodo> quicksort(ArrayList<Nodo> a, int izq,int der){
		int i=izq;
		int j = der;
		long Pivote = a.get((izq+der)/2).Cedula;
		do{

		while(a.get(i).Cedula < Pivote){
		i++;
		}
		while(a.get(j).Cedula > Pivote){
		j--;
		}
		if (i <= j){
		long aux = a.get(i).Cedula;
		String name=a.get(i).Nombre;
		a.get(i).setCedula(a.get(j).Cedula) ;
		a.get(i).setNombre(a.get(j).Nombre) ;
		a.get(j).setCedula(aux);
		a.get(j).setNombre(name);
		i++;
		j--;
		}
		}while (i <= j);
		if(izq < j){
		quicksort(a,izq,j);
		}
		if(i < der){
		quicksort(a,i,der);
		}
		return a;
		}
}
