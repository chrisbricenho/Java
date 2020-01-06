import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Plegamiento extends JFrame implements ActionListener{

	JButton Ingresar,Buscar, Eliminar;
	Nodo Inicio, Ultimo, Pivote;
	int tamaño,c;
	ArrayList<Nodo> lista= new ArrayList<Nodo>();
	Nodo[] personas= new Nodo[800];
	long buscacedula, cedulaeliminar;
	int centro;
	
	public Plegamiento() {
		this.Inicio=null;
		this.Ultimo=null;
		this.tamaño=0;
		
		setLayout(new FlowLayout());
		setSize(200,200);
		setLocation(500,250);
		Ingresar=new JButton("Ingresar");
		Buscar=new JButton("Buscar");
		Eliminar= new JButton("Eliminar");
		
		add(Ingresar);
		add(Buscar);
		add(Eliminar);
		
		Ingresar.addActionListener(this);
		Buscar.addActionListener(this);
		Eliminar.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		Plegamiento app=new Plegamiento();
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
				 * PLEGAMIENTO
				 */
				String a=String.valueOf(cedula);
				int m1=Integer.parseInt(a.substring(0,3)); System.out.println(m1);
				int m2=Integer.parseInt(a.substring(3,6)); System.out.println(m2);
				int Posicion=m1+m2; System.out.println(Posicion);
				/**
				 * PLEGAMIENTO
				 */
				
	           	 int S=0;
	           	 
	           	 if (Posicion>personas.length-1) {
	           		String b=String.valueOf(Posicion);
	           		 Posicion=Integer.parseInt(b.substring(1,3)); System.out.println(Posicion);
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
				    
				    c= JOptionPane.showConfirmDialog(null,"¿Desea seguir ingresando Oferentes?", "Pregunta",
		      			    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);    
			}	    
		}//fin del else if
		
		else if (e.getSource()==Buscar) {
			buscacedula=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula: "));
			
			int h=0;
			/**
			 * BUSQUEDA SECUENCIAL
			 */
			for (int i = 0; i < personas.length-1; i++) {
				if (personas[i]!=null) {
					if (personas[i].Cedula==buscacedula) {
						Nodo D= new Nodo();
						D=personas[i];
						JOptionPane.showMessageDialog(null,D.toString());
						h=1;
						break;
					}
				}
			}
			/**
			 * BUSQUEDA SECUENCIAL
			 */
			
			if (h!=1) {
				JOptionPane.showMessageDialog(null,"La cedula ingreada anteriormente no existe");
			}
		}
		
		else if (e.getSource()==Eliminar) {
			cedulaeliminar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula: "));
			
			/**
			 * PLEGAMIENTO
			 */
			String a=String.valueOf(cedulaeliminar);
			int m1=Integer.parseInt(a.substring(0,3)); 
			int m2=Integer.parseInt(a.substring(3,6));
			int Posicion=m1+m2;
			/**
			 * PLEGAMIENTO
			 */

           	 
			/**
           	 * ACARREO POR SI LA POSICION ES MAYOR AL TAMAÑO DEL ARREGLO 
           	 */
           	 if (Posicion>personas.length-1) {
           		String b=String.valueOf(Posicion);
           		 Posicion=Integer.parseInt(b.substring(1,3)); System.err.println(Posicion);
			}
           	/**
           	 * ACARREO POR SI LA POSICION ES MAYOR AL TAMAÑO DEL ARREGLO 
           	 */
           	 
           	 
           	 if (personas[Posicion]==null) {
				JOptionPane.showMessageDialog(null,"La cedula ingreada anteriormente no existe");
			}
           	 else {
				personas[Posicion]=null;
				JOptionPane.showMessageDialog(null, "Se ha eliminado la Persona");
			}
		}
	}
}
