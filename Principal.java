import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener
{//inicio de la clase Principal

	Atleta[] atletas= new Atleta[100]; //creacion de un arreglo de objetos de la clase Atletas
	private JButton Incluir, Modificar, Eliminar, Buscar, Limpiar, Ayuda;
	private Font fuente;
	private JLabel labelfont;//creacion de una variable de tipo JLabel
	private JTextField Nombre, DNI, Fecha; //creacion de variables de tipo JTextField
    private JPanel Panel, labelPanel, fieldsPanel, Panel2;    //variables de tipo JPanel
    private String labels[] =                 //creacion de las etiquetas de tipo String
        { "Nombre:", "DNI:","Fecha de Nacimiento: ", "Categoria: ", "Sexo: "};
    private JTextArea textosalida; //creacion de una variable de tipo JTextArea
    private JScrollPane scrollpane; //creacion de una variable de tipo JScrollPane
    private JComboBox box;//creacion de una variable de tipo JCombobox  
    private static String[] categorias= {"Junior", "Promesa","Senior", "Veterano"};  //creacion de un arreglo de tipo String      
    private JRadioButton Masculino, Femenino;
    private ButtonGroup radioGroup;
    private String catego;
    int Primo=101; //numero primo mas cercano y mayor que 800
    Atleta Inicio, Ultimo;
    int tamaño, A, B;
    long modificar, clave, delete;
    
	public Principal() {//inicio del metodo constructor
		Container Contenedor = getContentPane();
		setSize(800,228);
		setTitle("Tarea Programada N°2 -Ariel Ruiz -Christhoper Briceño");
		setLocation(300,150);
		setResizable(false);
		this.Inicio=null;
		this.Ultimo=null;
		this.tamaño=0;
		
		Panel= new JPanel();
		Panel.setLayout(new FlowLayout());
		fuente= new Font("Serief", Font.PLAIN, 18);
		
		Incluir= new JButton("Incluir");
		Incluir.setToolTipText("Incluye un participante a la Carrera");
		Incluir.setFont(fuente);
		Incluir.setBackground(Color.lightGray);
		Panel.add(Incluir);
		
		Modificar= new JButton("Modificar");
		Modificar.setToolTipText("Modifica los datos de participante de la Carrera");
		Modificar.setFont(fuente);
		Modificar.setBackground(Color.lightGray);
		Panel.add(Modificar);
		
		Eliminar= new JButton("Eliminar");
		Eliminar.setToolTipText("Elimina un participante de la Carrera");
		Eliminar.setFont(fuente);
		Eliminar.setBackground(Color.lightGray);
		Panel.add(Eliminar);
		
		Buscar= new JButton("Buscar");
		Buscar.setToolTipText("Busca un participante de la Carrera");
		Buscar.setFont(fuente);
		Buscar.setBackground(Color.lightGray);
		Panel.add(Buscar);
		
		Limpiar= new JButton("Limpiar");
		Limpiar.setToolTipText("Para limpiar los campo de texto");
		Limpiar.setFont(fuente);
		Limpiar.setBackground(Color.lightGray);
		Panel.add(Limpiar);	
		
		Ayuda= new JButton("Ayuda!");
		Ayuda.setToolTipText("Muestra ayuda para el usuario");
		Ayuda.setFont(fuente);
		Ayuda.setBackground(Color.lightGray);
		Panel.add(Ayuda);	
		
		Contenedor.setLayout(new BorderLayout());
		Contenedor.add(Panel, BorderLayout.NORTH);
		
		fuente= new Font("Serief", Font.ROMAN_BASELINE, 18);
	    labelPanel =new JPanel();   
	    labelPanel.setLayout( new GridLayout( 6, 1 ) );
	    
	    for ( int i = 0; i < labels.length; i++ )   //for para recorrer las campos de texto
	      { //inicio del for  
	      	labelfont=new JLabel( labels[ i ], 0);
	         labelfont.setFont(fuente);
	         labelPanel.add( labelfont );
	       } //fin del for
	    
	    Panel2= new JPanel();
		Panel2.setLayout(new FlowLayout());
	    
	    box= new JComboBox(categorias);
	    Masculino = new JRadioButton( "Maculino", true );
	    Femenino = new JRadioButton( "Femenino", true );
	    radioGroup = new ButtonGroup();
	      radioGroup.add(Masculino);
	      radioGroup.add( Femenino );
	      
	      box.addItemListener( new ItemListener() {			 				
				public void itemStateChanged(ItemEvent ex) {
					if (ex.getStateChange()==ItemEvent.SELECTED) {
	 						 catego=categorias[box.getSelectedIndex()];							
					}			 					
				}
			});
	    
	    // Campo de Textos en el Panel  
	      fieldsPanel = new JPanel();
	      fieldsPanel.setLayout( 
	      new GridLayout( 6, 1 ) );
	      Nombre = new JTextField( 20 );
	      fieldsPanel.add( Nombre );
	      DNI= new JTextField( 20 );
	      fieldsPanel.add( DNI );
	      Fecha= new JTextField( 20 );
	      fieldsPanel.add( Fecha );	
	      fieldsPanel.add(box);
	      fieldsPanel.add(Masculino);
	      fieldsPanel.add(Femenino);

          Contenedor.add(labelPanel, BorderLayout.WEST);
          Contenedor.add(fieldsPanel, BorderLayout.CENTER);
   
        fuente= new Font("Serief", Font.ROMAN_BASELINE, 16);
        textosalida= new JTextArea("U.C.R Sede Guanacaste\n"+
          "\nBachillerato en Informatica Empresarial\n "+
           "\nIF-3001 Algoritmos y Estructuras de Datos\n \nPROFESOR: MCI. Kenneth Sánchez Sánchez\n" +
            "\nTarea Programada N° 2\n \nGRUPO: 01 \nCICLO LECTIVO: I-2013\n"+
             "\nESTUDIANTES:   \n \b-Cristopher Briceño Rosales B21142 \n \b-Ariel Ruiz Guadamuz B26003",10, 25 );        
        textosalida.setFont(fuente);
        textosalida.setForeground(Color.blue);
        textosalida.setToolTipText("Portada");
        textosalida.setEditable(false);
        Contenedor.add(scrollpane= new JScrollPane(textosalida), BorderLayout.EAST);
        
		Incluir.addActionListener(this);
		Modificar.addActionListener(this);
		Eliminar.addActionListener(this);
		Buscar.addActionListener(this);
		Limpiar.addActionListener(this);
		Ayuda.addActionListener(this);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//fin del metodo constructor
	
	public static void main(String[] args) {//inicio del metodo main
		Principal app= new Principal();
		app.setVisible(true);
	}//fin del metodo main
	
	public boolean siVacio()
	{//inicio del metodo siVacio
		return(this.Inicio==null);		
	}//fin del metodo siVacio
	
	public void actionPerformed(ActionEvent e)
	{//inicio del metodo actionPerformed
		if (e.getSource()==Incluir) {//inicio del if
	   
	        	   if (!Nombre.getText().equals("") & !Fecha.getText().equals("") &!DNI.getText().equals("")) 
	        	   {//inicio del if
	        		   try{//inicio del try
	        			 Atleta participante= new Atleta();//objeto de la clase Atletas
	        			   
			        	String  Nom=Nombre.getText();
			            String fecha=Fecha.getText();
			           	long Dni=Long.parseLong(DNI.getText());		
			            int Posicion=(int) (Dni%Primo);	
			            
			           	catego=categorias[box.getSelectedIndex()];				           	 
			           	String Sexo=""; 
			           	if (Masculino.isSelected()) 
			           	{//inicio del if
							Sexo="Masculino";
						} //fin del if
			           	else if (Femenino.isSelected())
			           	{//inicio del else if
							Sexo="Femenino";
						}//fin del else if
	 
			           	 int Condicion=0;
			           	 int S=0;
			           	 
			           	 /**
			           	  * Direccionamiento por Encadenamiento
			           	  */
							if (atletas[Posicion]!=null) {//inicio del if								
								Condicion=1;
								Atleta Nuevo= new Atleta(Nom,Sexo, fecha,catego, Dni);
								
								if (atletas[Posicion].Siguiente==null) 
								{//inicio del if
									Inicio=null; 
								}//fin del if
								
								Atleta actual=atletas[Posicion];
								int y=0;
								while (actual!=null) {//inicio del while
									if (actual.DNI==Dni) {//inicio del if
										y=1;
									}//fin del if
									actual=actual.Siguiente;
								}//fin del while
								
								if (y==0) {//inicio del if
									JOptionPane.showMessageDialog(null, "Ha ocurrido una Colisión!","Atencion estimado usuario.",JOptionPane.WARNING_MESSAGE);
									
									if (siVacio()) {//inicio del if
										this.Inicio=Nuevo;
										atletas[Posicion].Siguiente=Inicio;
									}//fin del if 
									else 
									{//inicio del else if									
										
										Ultimo=Inicio;
										Atleta aux= new Atleta();
										aux=atletas[Posicion].Siguiente;
										while (Ultimo.Siguiente!=null) 
										{//inicio del while
										  Ultimo=Ultimo.Siguiente;	
										  aux=aux.Siguiente;
										}//fin del while 
										  Ultimo.Siguiente=Nuevo;
										  aux.Siguiente=Ultimo.Siguiente;	
									}//fin del else if
								}//fin del if
								else if (y==1)
								{//inicio del else if
									JOptionPane.showMessageDialog(null, "No se puede incluir el participante ya que el DNI ingresado ya existe","Atencion estimado usuario",JOptionPane.WARNING_MESSAGE);
									S=1;
								}//fin del else if
							}//fin del if
							/**
				           	  * Fin Direccionamiento por Encadenamiento
				           	  */							
							
							if (Condicion==0) {//inicio del if
								participante.setNombre(Nom);
					           	 participante.setDNI(Dni);
					           	 participante.setFecha(fecha);
					           	 participante.setCategoria(catego);
					           	 participante.setSexo(Sexo);
					           	 
				           	    atletas[Posicion]=participante;
							}//fin del if						 
				    	    Nombre.setText("");
				    	    Fecha.setText("");
				    	   	DNI.setText("");
				    	   	
				    	   	if (S==0) {//inicio del if
					    	   	JOptionPane.showMessageDialog(null, "La posicion de direccion que ocupará el participante es: "+Posicion, "Atencion estimado usuario.",JOptionPane.INFORMATION_MESSAGE);
							}//fin del if				    	   
	        		   }//fin del try
	        		   catch (Exception ex)
	        		   {//inicio del catch
	        		       	 JOptionPane.showMessageDialog(null,
	           		       		     "A ocurrido un error! \nUsted debe de digitar un valor numerico en el campo 'DNI'", "Atencion estimado usuario",
	           		       		     JOptionPane.ERROR_MESSAGE);
	        		       	 Nombre.setText("");
		    	   		     Fecha.setText("");
		    	   		     DNI.setText("");
					   }//fin del cacth
	    		   }//fin del if
	        	   else
	        	   {//inicio del else
	              	 JOptionPane.showMessageDialog(null, "Agregue los datos a insertar en los campos," +
	                         " y luego precione -Incluir- \nRecuerde digitar todos los datos a insertar en cada campo correspondiente!","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
	              	 Nombre.setText("");
    	   		     Fecha.setText("");
    	   		     DNI.setText("");
	        	   }//fin del else	    			
		}//fin del if
		
		else if (e.getSource()==Modificar) {//inicio del else if
			
			int q=0;
			while (q==0) {//inicio del while
				try {//inicio del try
					 modificar=Long.parseLong(JOptionPane.showInputDialog("Ingrese el DNI del participante que desea Modificar los Datos: "));
					 q=1;
				} //fin del try
				catch (Exception e2) {//inicio del catch
					q=0;
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, debe de ingresar un valor numerico para el dato DNI","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
				}//fin del catch							
			}//fin del while
			
			int Pos=(int) (modificar%Primo);
			Atleta [] aux= new Atleta[100];		
			aux[Pos]=atletas[Pos];	
			
			if (aux[Pos]==null)
			{//inicio del if
				JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
			}//fin del if
			else if (aux[Pos]!=null) 
			{//inicio del else if
				
				int k=0;
				Atleta auxlista2=aux[Pos];
				while (auxlista2!=null) 
				{//inicio del while
					if (auxlista2.DNI==modificar) {//inicio del if
						k=1;
					}//fin del if
					auxlista2=auxlista2.Siguiente;
				}//fin del while					
				
				if (k==1) {//inicio del if
					JOptionPane.showMessageDialog(null, "A continuacion se procedera a modificar los datos del participante. \nTodos los Datos excepto el DNI.","Atencion estimado usuario",JOptionPane.INFORMATION_MESSAGE);
					String  Nom=JOptionPane.showInputDialog("Ingrese el Nombre a Modificar: ");
		            String fecha=JOptionPane.showInputDialog("Ingrese la Fecha de Nacimiento a Modificar: ");
		           	
		           	do {//inicio del do while
						    A=Integer.parseInt(JOptionPane.showInputDialog("Escoja una de las Categorias \n1) Junior \n2) Promesa \n3) Senior \n4) Veterano"));
						if (A>=5 | A<=0)
						{//inicio del if
							JOptionPane.showMessageDialog(null, "Usted debe de escoger un numero entre 1 y 4","Atencion estimado usuario", JOptionPane.ERROR_MESSAGE);
						}//fin del if
		           	} while (A>=5 | A<=0);//fin del do while
		           	
		           	String Categoria="";
		           	switch (A) {//inicio del switch
					case 1:
						 Categoria="Junior";
						break;
					case 2:
						 Categoria="Promesa";
						break;
					case 3:
						Categoria="Senior";
						break;
					case 4:
						Categoria="Veterano";
						break;
					default:
						break;
					}//fin del switch
		           	
		         	do {//inicio del do while
					    B=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de la opcion que desea \n1) Masculino \n2) Femenino"));
					if (B>=3 | B<=0)
					{//inicio del if
						JOptionPane.showMessageDialog(null, "Usted debe de escoger el numero 1 ó 2","Atencion estimado usuario", JOptionPane.ERROR_MESSAGE);
					}//fin del if
	           	} while (B>=3 | B<=0);//fin del do while
	           	
	           	String Sexo="";
	           	switch (B) {//inicio del switch
				case 1:
					 Sexo="Masculino";
					break;
				case 2:
					 Sexo="Femenino";
					break;
				default:
					break;
				}//fin del switch
	     		
	           	/**
	           	 * MODIFICAR NODO ULTIMO E INTERMEDIO
	           	 */
	           		if (aux[Pos].Siguiente!=null)
					{//inicio del if
	           			int z=0;
	           			Atleta auxlista=aux[Pos];
						while (auxlista.DNI!=modificar)
						{//inicio del while
							auxlista=auxlista.Siguiente;
							z=1;
						}//fin del while

						if (z==0) {//inicio del if
							aux[Pos].setCategoria(Categoria);
							aux[Pos].setDNI(modificar);
							aux[Pos].setFecha(fecha);
							aux[Pos].setNombre(Nom);
							aux[Pos].setSexo(Sexo);
						}//fin del if
						else if (z==1) {//inicio del else if
							auxlista.setCategoria(Categoria);
							auxlista.setDNI(modificar);
							auxlista.setFecha(fecha);
							auxlista.setNombre(Nom);
							auxlista.setSexo(Sexo);
						}//fin del else if
					}//fin del if
	           		
	           		/**
	           		 * MODIFICAR EL PRIMERO CUANDO SOLO HAY UNO
	           		 */
					else if (aux[Pos].Siguiente==null) 
					{//inicio del else if
						aux[Pos].setCategoria(Categoria);
						aux[Pos].setDNI(modificar);
						aux[Pos].setFecha(fecha);
						aux[Pos].setNombre(Nom);
						aux[Pos].setSexo(Sexo);
					}//fin del else if			

	           	 JOptionPane.showMessageDialog(null,"Se ha realizado la Modificacion con exito!","Atencion estimado usuario",JOptionPane.INFORMATION_MESSAGE);
				}//fin del if
				else if (k==0) {//inicio del else if
					JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
				}//find el else if
			}//fin del else if
		}//fin del else if
		
		else if (e.getSource()==Eliminar) {//inicio del else if
			int q=0;
			while (q==0) {//inicio del while
				try {//inicio del try
					 delete=Long.parseLong(JOptionPane.showInputDialog("Ingrese el DNI del participante que desea Modificar los Datos: "));
					 q=1;
				} //fin del try
				catch (Exception e2) {//inicio del catch
					q=0;
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, debe de ingresar un valor numerico para el dato DNI","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
				}//fin del catch							
			}//fin del while
			
			int Pos=(int) (delete%Primo);
			Atleta [] aux= new Atleta[100];
			
			aux[Pos]=atletas[Pos];
			int x=0;
			
			if (aux[Pos]==null)
			{//inicio del if
				JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
				x=1;
			}//fin del if
			else if (aux[Pos]!=null) 
			{//inicio del else if
				if (aux[Pos].Siguiente!=null)
				{//inicio del if				
					int z=0; int k=0;
					Atleta auxlista2=aux[Pos];
					while (auxlista2!=null) 
					{//inicio del while
						if (auxlista2.DNI==delete) {//inicio del if
							k=1;
						}//fin del if
						auxlista2=auxlista2.Siguiente;
					}//fin del while					
					
					if (k==1) {//inicio del if
						Atleta auxlista=aux[Pos];
						while (auxlista.DNI!=delete) 
						{//inicio del while
							auxlista=auxlista.Siguiente;
							z=1;
						}//fin del while
						
						if (z==0) {//inicio del if
							Atleta templista=aux[Pos];
							int contador = 0;
							while (templista!=null) 
							{//inicio del while
								contador++;
								templista=templista.Siguiente;
							}//fin del while
							
							/**
							 * ELIMINAR PRIMERO CUANDO SOLO HAY DOS NODOS
							 */
							if (contador==2) {//inicio del if
								String Nom=aux[Pos].Siguiente.getNombre();
								long D=aux[Pos].Siguiente.getDNI();
								String sexo=aux[Pos].Siguiente.getSexo();
								String fecha=aux[Pos].Siguiente.getFecha();
								String categoria=aux[Pos].Siguiente.getCategoria();
								
								aux[Pos].setCategoria(categoria);
								aux[Pos].setDNI(D);
								aux[Pos].setFecha(fecha);
								aux[Pos].setNombre(Nom);
								aux[Pos].setSexo(sexo);
								
								aux[Pos].Siguiente=null; 
							} //fin del if
							
							/**
							 * ELIMAR PRIMERO CUANDO HAY MAS DE DOS NODOS
							 */
							else if (contador!=2) {//inicio del else if
								String Nom=aux[Pos].Siguiente.getNombre();
								long D=aux[Pos].Siguiente.getDNI();
								String sexo=aux[Pos].Siguiente.getSexo();
								String fecha=aux[Pos].Siguiente.getFecha();
								String categoria=aux[Pos].Siguiente.getCategoria();
								
								aux[Pos].setCategoria(categoria);
								aux[Pos].setDNI(D);
								aux[Pos].setFecha(fecha);
								aux[Pos].setNombre(Nom);
								aux[Pos].setSexo(sexo);
								
								Atleta templista2=aux[Pos].Siguiente;
								Atleta aux4=null;
								while (templista2!=null) 
								{//inicio del while
									String N=templista2.Siguiente.getNombre();
									long Dn=templista2.Siguiente.getDNI();
									String se=templista2.Siguiente.getSexo();
									String fec=templista2.Siguiente.getFecha();
									String cate=templista2.Siguiente.getCategoria();
									
									templista2.setCategoria(cate);
									templista2.setDNI(Dn);
									templista2.setFecha(fec);
									templista2.setNombre(N);
									templista2.setSexo(se);
									
									aux4=templista2;
									templista2=templista2.Siguiente;
									if (templista2.Siguiente==null) 
									{//inicio del if
										aux4.Siguiente=null;
										templista2=null;
									}//fin del if
								}//fin del while				
							}//fin del else if
						}//fin del if
						
						else if (z==1) {//inicio del else if
							Atleta templista=aux[Pos];
							int contador = 0;
							while (templista!=null) 
							{//inicio del while
								contador++;
								templista=templista.Siguiente;
							}//fin del while
							
							/**
							 * ELIMINAR ULTIMO NODO CUANDO SOLO HAY DOS NODOS
							 */
							if (contador==2)
							{//inicio del if
								 aux[Pos].Siguiente=null; 
							}//fin del  if
							
							else if (contador!=2) 
							{//inicio del else if
								Atleta templista2=aux[Pos].Siguiente;
								Atleta aux3=null;
								while (templista2.DNI!=delete) 
								{//inicio del while	
									aux3=templista2;
									templista2=templista2.Siguiente;
								}//fin del while
								
								/**
								 * ELIMINAR ULTIMO NODO
								 */
								if (templista2.Siguiente==null) 
								{//inicio del if
									aux3.Siguiente=null;
								}//fin del if
								
								/**
								 * ELIMINAR NODO INTERMEDIO
								 */
								else if (templista2.Siguiente!=null)
								{//inicio del else if
									Atleta aux5=null;
									while (templista2!=null)
									{//inicio del while
										String N=templista2.Siguiente.getNombre();
										long Dn=templista2.Siguiente.getDNI();
										String se=templista2.Siguiente.getSexo();
										String fec=templista2.Siguiente.getFecha();
										String cate=templista2.Siguiente.getCategoria();
										
										templista2.setCategoria(cate);
										templista2.setDNI(Dn);
										templista2.setFecha(fec);
										templista2.setNombre(N);
										templista2.setSexo(se);
										
										aux5=templista2;
										templista2=templista2.Siguiente;
										if (templista2.Siguiente==null) 
										{//inicio del if
											aux5.Siguiente=null;
											templista2=null;
										}//fin del if
									}//fin del while	
								}//fin del else if						
							}//fin del else if
						}//fin del else if	
					}  //fin del if
					else {//inicio del else
						JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
						x=1;
					}//fin del else
				}//fin del if
				
				/**
				 * ELIMINAR PRIMER NODO CUANDO SOLO HAY UN NODO
				 */
				else if (aux[Pos].Siguiente==null) 
				{//inicio del else if
					if (atletas[Pos].DNI==delete) {//inicio del if
						atletas[Pos]=null;
					}//fin del if
					else if (aux[Pos].DNI!=delete) {//inicio del else if
						JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
						x=1;
					}//fin del else if				
				}//fin del else if	
				if (x==0) {//inicio del if
					 JOptionPane.showMessageDialog(null,"Se ha realizado la Eliminacion con exito!","Atencion estimado usuario",JOptionPane.INFORMATION_MESSAGE);
				}//fin del if			
			}//fin del else if
		}//fin del else if
		
		else if (e.getSource()==Buscar) {//inicio del else if			
			int q=0;
			while (q==0) {//inicio del while
				try {//inicio del try
					 clave=Long.parseLong(JOptionPane.showInputDialog("Ingrese el DNI del participante que desea Modificar los Datos: "));
					 q=1;
				} //fin del try
				catch (Exception e2) {//inicio del catch
					q=0;
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, debe de ingresar un valor numerico para el dato DNI","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
				}//fin del catch							
			}//fin del while
			
			int Pos=(int) (clave%Primo);
			Atleta [] aux= new Atleta[100];
			
			aux[Pos]=atletas[Pos];
			int x=0;
			
			if (aux[Pos]==null)
			{//inicio del if
				JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
				x=1;
			}//fin del if
			else if (aux[Pos]!=null) 
			{//inicio del else if
				if (aux[Pos].Siguiente!=null)
				{//inicio del if					
					int z=0, k=0;
					Atleta auxlista2=aux[Pos];
					while (auxlista2!=null) 
					{//inicio del while
						if (auxlista2.DNI==clave) {//inicio del if
							k=1;
						}//fin del if
						auxlista2=auxlista2.Siguiente;
					}//fin del while
					
					if (k==1) {//inicio del if
						JOptionPane.showMessageDialog(null, "Se ha producido Colisión!", "Atencion estimado usuario.",JOptionPane.WARNING_MESSAGE);
						Atleta auxlista=aux[Pos];
						while (auxlista.DNI!=clave) 
						{//inicio del while
							auxlista=auxlista.Siguiente;
							z=1;
						}//fin del while
						
						if (z==0) {//inicio del if
							 JOptionPane.showMessageDialog(null, aux[Pos].toString(),"Datos del Participante",JOptionPane.INFORMATION_MESSAGE);
						}//fin del if
						else if (z==1) {//inicio del else if
							 JOptionPane.showMessageDialog(null, auxlista.toString(),"Datos del Participante",JOptionPane.INFORMATION_MESSAGE);
						}//fin del else if
					}//fin del if
					else {//inicio del else
						JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
						x=1;
					}//fin del else					 
				}//fin del if
				else if (aux[Pos].Siguiente==null) 
				{//inicio del else if
					if (aux[Pos].DNI==clave) {//inicio del if
						JOptionPane.showMessageDialog(null, aux[Pos].toString(),"Datos del Participante",JOptionPane.INFORMATION_MESSAGE);
					}//fin del if
					else {//inicio del else
						JOptionPane.showMessageDialog(null, "No existe un particiapnte con el DNI ingresado anteriormente","Atencion estimado usuario", JOptionPane.WARNING_MESSAGE);
						x=1;
					}//fin del else
				}//fin del else if	
				
				if (x==0) {//inicio del  if
					JOptionPane.showMessageDialog(null, "La posicion de direccion que ocupa el participante es: "+Pos, "Atencion estimado usuario.",JOptionPane.INFORMATION_MESSAGE);
				}//fin del if		
			}//fin del else if
		}//fin del else if
		
		else if (e.getSource()==Limpiar) {//inicio del else if
			/**
	    	    * El método showConfirmDialog tal y como esta escrito aquí puede
	    	    * arrojar dos valores enteros los cuales son: 0 para la opción SI o 1
	    	    * para la opción NO. El resultado que traiga se asigna a la variable
	    	    * Condicion, se aplicara el evento solo si algun campo de texto contiene algo 
	    	    * si todos estan vacios no se
	    	    */
	    	  if (!Nombre.getText().equals("") | !Fecha.getText().equals("") | !DNI.getText().equals("")) 
	    	  {//inicio del if
	        	  int Condicion= JOptionPane.showConfirmDialog(null,"¿Esta seguro de limpiar los campos de ingreso de datos?", "Pregunta",
	      			    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);    	   
	  	    	  if (Condicion==0)
	  	    	  {//inicio del if
	  	    		  Nombre.setText("");
	  		       	  Fecha.setText("");
	  		       	  DNI.setText("");
	  		       	 JOptionPane.showMessageDialog(null,
	  		       		     "Se ha se realiazado la accion satisfactoriamente", "Atencion estimado usuario",
	  		       		     JOptionPane.INFORMATION_MESSAGE);
	  			  }//fin del if 
			  } //fin del if 
	    	  else 
	    	  {//inicio del else 
			       	 JOptionPane.showMessageDialog(null,
	  		       		     "No se podran limpiar los campos de texto ya que estan vacios", "Atencion estimado usuario",
	  		       		     JOptionPane.INFORMATION_MESSAGE);
			  }//fin del else 
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
	}//inicio del metodo actionPerformed 
}//fin de la clase Principal