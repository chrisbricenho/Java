import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 
import javax.swing.*;

@SuppressWarnings("serial")

public class PrincipalQuiz extends JFrame implements ActionListener {
	
	public static int a,b,c; 
	private JButton botonCrear; 
	private JButton botonInsertar; 
	private JButton botonVisualizar; 
	private JButton botonMostrar; 
	private JButton botonBuscar; 
	private JButton botonEliminar; 
	private JButton botonSalir; 
	
	ListaQuiz1 A = new ListaQuiz1();
	String Tipo=null;
	String Nombre=null;
	String Cedula=null;
	String Nac=null;
	String Licencia=null; 
	float Seguro=0;
	float ley=0;
	float valor=0; 
	float MontoInfraccion=0; 
	double Infraccion=0;
	double Pani=0;
	int Total=0;

	public static void main(String[] args) throws IOException {
	PrincipalQuiz Marco = new PrincipalQuiz();
	Marco.setVisible(true);
	}
	
	
	public PrincipalQuiz (){
		Container contenidoPanel = getContentPane();
		setSize (350,500);
		setResizable(false);
		setTitle("Oficina de cobros JAGOCON S.A");
		setLocation(500,120); 
		
		contenidoPanel.setLayout (null); 
		
		botonCrear = new JButton ("CREAR BOLETA");
		botonCrear.setBounds(40,50,250,30);
		contenidoPanel.add(botonCrear);
		
		botonInsertar = new JButton ("INSERTAR DATOS");
		botonInsertar.setBounds(40,100,250,30);
		contenidoPanel.add(botonInsertar);
		
		botonVisualizar = new JButton ("Visualizar");
		botonVisualizar.setBounds(40,150,250,30);
		contenidoPanel.add(botonVisualizar);
		
		botonMostrar = new JButton ("Mostrar");
		botonMostrar.setBounds(40,200,250,30);
		contenidoPanel.add(botonMostrar);
		
		botonBuscar = new JButton ("Buscar");
		botonBuscar.setBounds(40,250,250,30);
		contenidoPanel.add(botonBuscar);
		
		botonEliminar = new JButton ("Eliminar");
		botonEliminar.setBounds(40,300,250,30);
		contenidoPanel.add(botonEliminar);
		
		botonSalir = new JButton ("Salir");
		botonSalir.setBounds(40,350,250,30);
		contenidoPanel.add(botonSalir);
		
		botonCrear.addActionListener(this); 
		botonInsertar.addActionListener(this); 
		botonVisualizar.addActionListener(this); 
		botonMostrar.addActionListener(this); 
		botonBuscar.addActionListener(this); 
		botonEliminar.addActionListener(this); 
		botonSalir.addActionListener(this); 
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed (ActionEvent Quiz){
		
		
		JButton botonOprimido = (JButton) Quiz.getSource();
		String textoDelBoton = botonOprimido.getText();
		setTitle ("Oprimió "+ textoDelBoton);
		
		if (botonOprimido == botonCrear){
			
			String oficina=JOptionPane.showInputDialog("Digite la cantidad de Clientes a Ingresar: ");
			a = Integer.parseInt(oficina);
			
			for (int i=0; i<a; i++){
				Tipo=JOptionPane.showInputDialog("Ingrese el tipo de Vehiculo: \n1.Particular \n2.Gobierno \n3.Privado");
				Nombre=JOptionPane.showInputDialog("Ingrese el Nombre del Propietario N°"+(i+1)+" :");
				Cedula=JOptionPane.showInputDialog("Ingrese el número de Cedula del Propietario N°"+(i+1)+" :");
				Nac=JOptionPane.showInputDialog("Ingrese la Nacionalidad del Propietario N°"+(i+1)+" :");
				Licencia=JOptionPane.showInputDialog("Ingrese el tipo de Licencia del Propietario N°"+(i+1)+" :");
				String Seg=JOptionPane.showInputDialog("Ingrese el Monto del Seguro Obligatorio del vehiculo N°"+(i+1)+" :");
				String ley1=JOptionPane.showInputDialog("Ingrese el monto del la ley de conservacion de Flora y Fauna :");
				String Infrac=JOptionPane.showInputDialog("Ingrese la cantidad de Infracciones:");
				String ValorF=JOptionPane.showInputDialog("Ingrese el Valor Fiscal del Vehiculo N°"+(i+1)+" :");
				String MontoInfrac=JOptionPane.showInputDialog("Ingrese el Monto de la Infraccion :");
				
				Seguro=Float.parseFloat(Seg);
				ley=Float.parseFloat(ley1);
				Infraccion=Double.parseDouble(Infrac);
				valor=Float.parseFloat(ValorF);
				MontoInfraccion=Float.parseFloat(MontoInfrac);
				
			} 
		}     
		
		else if (botonOprimido == botonInsertar){
			
		}
		
		
		else if (botonOprimido == botonVisualizar){
			A.Visualizar();
		}
        
	    
		else if (botonOprimido == botonMostrar){
			A.Mostrar();
		}
		
        
		else if (botonOprimido == botonBuscar){
			A.Buscar();
		}
		
        
		else if (botonOprimido == botonEliminar){
			A.Eiminar();
		}
		
        
		else if (botonOprimido == botonSalir){
			System.exit(0);
		}
	}	
	}