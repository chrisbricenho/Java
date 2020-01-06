
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Lista extends JFrame implements ActionListener{


	private Nodo Inicio;
	private Nodo Ultimo;
	private int Tamaño;
	public int o,n;
	public String Tipo,Cat;
	private File f=new File("EMPOSAN.txt");
	
	private JButton Crear;
	private JButton Mostrar;
	private JButton Buscar;
	private JButton BuscarPlaca;
	private JButton Eliminar;
	private JButton Almacenar;
	private JButton Salir;
	
	private Font fuente;
	private JLabel S;
	private ImageIcon i;
	
	
	public Lista(){
		this.Inicio=null;
		this.Ultimo=null;
		this.Tamaño=0;
		
		Container Panel = getContentPane();
		Panel.setBackground(Color.BLUE);
		setSize(550,350);
		setTitle("Renta Car EMPOSAN -Ariel Ruiz B26003");
		setLocation(500,150);
		setResizable(false);
		Panel.setLayout(new FlowLayout());
		
		i=new ImageIcon(getClass().getResource("ucr.png"));
		
		S= new JLabel("¡BIENVENI@!");
		fuente= new Font("Serief", Font.BOLD, 50);
		S.setFont(fuente);
		S.setToolTipText("BIENVENIDO");
		S.setIcon(i);
		this.add(S);
		
		Crear= new JButton("INGRESAR DATOS");
		Crear.setToolTipText("Crear Lista");
		fuente= new Font("Serief", Font.BOLD, 20);
		Crear.setFont(fuente);
		Crear.setBackground(Color.ORANGE);
		this.add(Crear);
		
		
		Mostrar= new JButton("MOSTRAR");
		Crear.setToolTipText("Muestra de todos los datos ingresados");
		fuente= new Font("Serief", Font.BOLD, 20);
		Mostrar.setFont(fuente);
		Mostrar.setBackground(Color.RED);
		this.add(Mostrar);
		
		Buscar= new JButton("BUSCAR POR TIPO DE CLIENTE");
		Buscar.setToolTipText("Buscar y Mostrar");
		fuente= new Font("Serief", Font.BOLD, 20);
		Buscar.setFont(fuente);
		Buscar.setBackground(Color.PINK);
		this.add(Buscar);
		
		BuscarPlaca= new JButton("BUSCAR POR N° DE PLACA");
		BuscarPlaca.setToolTipText("Buscar Cliente por Numero de Placa");
		fuente= new Font("Serief", Font.BOLD, 20);
		BuscarPlaca.setFont(fuente);
		BuscarPlaca.setBackground(Color.CYAN);
		this.add(BuscarPlaca);
		
		Eliminar= new JButton("ELIMINAR");
		Eliminar.setToolTipText("Eliminar clientes con deposito inferior a $150");
		fuente= new Font("Serief", Font.BOLD, 20);
		Eliminar.setFont(fuente);
		Eliminar.setBackground(Color.GREEN);
		this.add(Eliminar);
		
		Almacenar= new JButton("ALMACENAR DATOS");
		Almacenar.setToolTipText("Guardar los datos en un archivo");
		fuente= new Font("Serief", Font.BOLD, 20);
		Almacenar.setFont(fuente);
		Almacenar.setBackground(Color.white);
		this.add(Almacenar);
		
		Salir= new JButton("SALIR");
		Salir.setToolTipText("Finalizar el Programa");
		fuente= new Font("Serief", Font.BOLD, 20);
		Salir.setFont(fuente);
		Salir.setBackground(Color.ORANGE);
		this.add(Salir);
		
		Crear.addActionListener(this);
		Mostrar.addActionListener(this);
		Buscar.addActionListener(this);
		BuscarPlaca.addActionListener(this);
		Eliminar.addActionListener(this);
		Almacenar.addActionListener(this);
		Salir.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public boolean siVacio(){
		return(this.Inicio==null);		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==Crear){
			String O= JOptionPane.showInputDialog("Ingrese la Cantidad de Clientes: ");
			o=Integer.parseInt(O);
			
			for (int i = 0; i < o; i++) {
				
			do {
				String Ti=JOptionPane.showInputDialog("Categorias de Clientes: \n1) Corporativo (C) \n2) Individual (P) \nIngrese la Categoria del Cliente "+(i+1)+": ");
				 n=Integer.parseInt(Ti);
				
				switch (n) {
				case 1:
					Tipo="Corporativo (C)";
					break;
                case 2:
                	 Tipo="Individual (P)";
					break;
				default: JOptionPane.showMessageDialog(null, "ERROR" ,"ATENCION", JOptionPane.INFORMATION_MESSAGE);
					break;
				}	
				
			if (n>=3 | n<=0) {
				JOptionPane.showMessageDialog(null, "ERROR SOLO PUEDE DIGITAR EL NUMRO 1 Ó 2","ATENCION", JOptionPane.INFORMATION_MESSAGE);
			}
			
			} while (n>=3 | n<=0);
					
				
			String Nombre=JOptionPane.showInputDialog("Ingrese el Nombre del Cliente "+(i+1)+": ");
		  String Cedula=JOptionPane.showInputDialog("Ingrese el Numero de Cedula del Cliente "+(i+1)+": ");
				String Placa=JOptionPane.showInputDialog("Ingrese el Numero de Placa del Vehiculo a Rentar "+(i+1)+": ");
				String Marca=JOptionPane.showInputDialog("Ingrese la Marca del Vehiculo a Rentar "+(i+1)+": ");
				String mon=JOptionPane.showInputDialog("Ingrese el Monto del Deposito "+(i+1)+": ");
				long Monto=Long.parseLong(mon);
				String di=JOptionPane.showInputDialog("Ingrese el Numero de Dias a Rentar "+(i+1)+": ");
				int Dias=Integer.parseInt(di);
				
				
				Nodo Nuevo= new Nodo(Tipo, Nombre, Cedula,  Placa,  Marca, Monto, Dias);
				
				if (siVacio()) {
					this.Inicio=Nuevo;
				} else {
					Ultimo=Inicio;
					while (Ultimo.Siguiente!=null) {
					Ultimo=Ultimo.Siguiente;	
					} Ultimo.Siguiente=Nuevo;
				}
				this.Tamaño++;
			}		
		}
		
		else if (e.getSource()==Mostrar) {
			
			if (Tamaño!=0) {
				Nodo Mostrar=Inicio;
				while (Mostrar!=null) {
				Mostrar.toString();
				JOptionPane.showMessageDialog(null, Mostrar,"DATOS DEL CLIENTE", JOptionPane.INFORMATION_MESSAGE);
				Mostrar=Mostrar.Siguiente;
}
  }
}
		
		else if (e.getSource()==Buscar) {
			
			Nodo Actual=Inicio;

			do {
				String Ti=JOptionPane.showInputDialog("Categorias de Clientes: \n1) Corporativo (C) \n2) Individual (P) \nIngrese la Categoria del Cliente que desea ver los Datos: ");
				 n=Integer.parseInt(Ti);
				
				switch (n) {
				case 1:
					Cat="Corporativo (C)";
					break;
                case 2:
                	 Cat="Individual (P)";
					break;
				default: 
					break;
				}	
				
			if (n>=3 | n<=0) {
				JOptionPane.showMessageDialog(null, "ERROR SOLO PUEDE DIGITAR EL NUMERO 1 Ó 2","ATENCION", JOptionPane.INFORMATION_MESSAGE);
			}
			
			} while (n>=3 | n<=0);
					
			
			
			do {
				if (Actual.Tipo.equals(Cat)) {
					Actual.toString();
					JOptionPane.showMessageDialog(null, Actual,"DATOS DEL CLIENTE", JOptionPane.INFORMATION_MESSAGE);
					Actual=Actual.Siguiente;
				}
				else if (Actual.Tipo!=Cat) {
					Actual=Actual.Siguiente;
				}
			} while (Actual!=null);
	
		}
		
		else if (e.getSource()==BuscarPlaca) {
			Nodo Actual=Inicio;
			String placa=JOptionPane.showInputDialog("Ingrese el Numero de Placa del Vehiculo que desea ver los Datos: ");
			
			do {
				if (Actual.Placa.equals(placa)) {
					Actual.toString();
					JOptionPane.showMessageDialog(null, Actual,"DATOS DEL CLIENTE", JOptionPane.INFORMATION_MESSAGE);
					Actual=Actual.Siguiente;
				}
				else if (Actual.Placa!=placa) {
					Actual=Actual.Siguiente;
				}
			} while (Actual!=null);
		}	
		else if (e.getSource()==Eliminar) {
			
			if (Tamaño!=0) {
			Nodo Aux=Inicio;
				Ultimo=Inicio;
			do {
				if (Aux.Monto<=149) {
					Inicio=Inicio.Siguiente;
					Ultimo=Ultimo.Siguiente;
					Aux=null;
				}
				else if (Aux.Monto>149) {
					Inicio=Inicio.Siguiente;
					Ultimo=Ultimo.Siguiente;
					Aux=Inicio;
					Aux=Aux.Siguiente;
						
					} 
			} while (Ultimo.Siguiente!=null);
			}  
			
			}
		
		else if (e.getSource()==Almacenar) {
			FileWriter A=null;
			try {
				A=new FileWriter(f);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			
			if (Tamaño!=0) {
				Nodo Mostrar=Inicio;
				while (Mostrar!=null) {
				try {
					A.write(Mostrar.Tipo+"//"+Mostrar.Nombre+"//"+Mostrar.Cedula+"//"+Mostrar.Placa+"//"+Mostrar.Marca+"//"+Mostrar.Monto+"//"+Mostrar.Dias+"//"+Mostrar.Total+"--");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				Mostrar=Mostrar.Siguiente; 
				if (Mostrar==null) {
					JOptionPane.showMessageDialog(null,"SE HA GUARDADO EL ARCHIVO","ATENCION", JOptionPane.INFORMATION_MESSAGE);
				}
				}
			
		} try {
			A.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
		
		else if (e.getSource()==Salir) {
			System.exit(0);
		}

	}  }
