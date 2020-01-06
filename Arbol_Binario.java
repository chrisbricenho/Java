import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Arbol_Binario extends JFrame implements ActionListener
{//inicio de la clase Arbol_Binario

	private Nodo raiz; //creacion de una variable de tipo Nodo
	private JButton Crear, Añadir, Eliminar, Recorrer, Limpiar, Ayuda;//creacion de variables de tipo JButton
	private Font fuente;//creacion de variable de tipo Font
	private JPanel Panel;//creacion de variable de tipo JPanel
	long Num;//creacion de variable de tipo long
	String Nom, Direc;//creacion de variables de tipo String
	private JLabel labelfont;//creacion de una variable de tipo JLabel
	private JTextField Numero, Nombre, Direccion; //creacion de variables de tipo JTextField
    private JPanel labelPanel, fieldsPanel;    //variables de tipo JPanel
    private String labels[] =                 //creacion de las etiquetas de tipo String
        { "Nombre:", "Número de Asegurado:", "Direccion:"};
    private JTextArea textosalida; //creacion de una variable de tipo JTextArea
    private JScrollPane scrollpane; //creacion de una variable de tipo JScrollPane
    private JTable table;
    private JFrame Frame2;
	private File f= new File("Arbol Binario.txt");
	private PrintWriter Es= null;
    int A=2, tamaño=0, B=0, C=0, D=0, E=0, F=0;

	public Arbol_Binario()
	{//inicio del metodo constructor
		raiz=null;
		Container Contenedor = getContentPane();
		setSize(850,210);
		setTitle("Tarea Programada N°1 -Ariel Ruiz -Christhoper Briceño");
		setLocation(300,150);
		setResizable(false);
		
		Panel= new JPanel();
		Panel.setLayout(new FlowLayout());
		
		Crear= new JButton("Crear Árbol");
		Crear.setToolTipText("Crea un árbol binario");
		fuente= new Font("Serief", Font.BOLD, 18);
		Crear.setFont(fuente);
		Crear.setBackground(Color.lightGray);
		Panel.add(Crear);
		
		Añadir= new JButton("Añadir");
		Añadir.setToolTipText("Añade nuevos registros al árbol");
		fuente= new Font("Serief", Font.BOLD, 18);
		Añadir.setFont(fuente);
		Añadir.setBackground(Color.lightGray);
		Panel.add(Añadir);
		
		Eliminar= new JButton("Eliminar un Registro");
		Eliminar.setToolTipText("Elimina un registro dada la clave");
		fuente= new Font("Serief", Font.BOLD, 18);
		Eliminar.setFont(fuente);
		Eliminar.setBackground(Color.lightGray);
		Panel.add(Eliminar);
		
		Recorrer= new JButton("Recorrer el árbol");
		Recorrer.setToolTipText("Recorre el árbol Enorden");
		fuente= new Font("Serief", Font.BOLD, 18);
		Recorrer.setFont(fuente);
		Recorrer.setBackground(Color.lightGray);
		Panel.add(Recorrer);
		
		Limpiar= new JButton("Limpiar");
		Limpiar.setToolTipText("Para limpiar los campo de texto");
		fuente= new Font("Serief", Font.BOLD, 18);
		Limpiar.setFont(fuente);
		Limpiar.setBackground(Color.lightGray);
		Panel.add(Limpiar);	
		
		Ayuda= new JButton("Ayuda!");
		Ayuda.setToolTipText("Muestra ayuda para el usuario");
		fuente= new Font("Serief", Font.BOLD, 18);
		Ayuda.setFont(fuente);
		Ayuda.setBackground(Color.lightGray);
		Panel.add(Ayuda);	
		
		Contenedor.setLayout(new BorderLayout());
		Contenedor.add(Panel, BorderLayout.NORTH);
		
		fuente= new Font("Serief", Font.ROMAN_BASELINE, 20);
	    labelPanel =new JPanel();   
	    labelPanel.setLayout( new GridLayout( labels.length, 1 ) );
	    
	    for ( int i = 0; i < labels.length; i++ )   //for para recorrer las campos de texto
	      { //inicio del for  
	      	labelfont=new JLabel( labels[ i ], 0);
	         labelfont.setFont(fuente);
	         labelPanel.add( labelfont );
	       } //fin del for
	    
	    // Campo de Textos en el Panel  
	      fieldsPanel = new JPanel();
	      fieldsPanel.setLayout( 
	      new GridLayout( labels.length, 1 ) );
	      Nombre = new JTextField( 20 );
	      fieldsPanel.add( Nombre );
	      Numero = new JTextField( 20 );
	      fieldsPanel.add( Numero );
	      Direccion= new JTextField( 20 );
	      fieldsPanel.add( Direccion );	      	      
          Contenedor.add(labelPanel, BorderLayout.WEST);
          Contenedor.add(fieldsPanel, BorderLayout.CENTER);
   
        fuente= new Font("Serief", Font.ROMAN_BASELINE, 16);
        textosalida= new JTextArea("U.C.R Sede Guanacaste\n"+
          "\nBachillerato en Informatica Empresarial\n "+
           "\nIF-3001 Algoritmos y Estructuras de Datos\n \nPROFESOR: MCI. Kenneth Sánchez Sánchez\n" +
            "\nTarea Programada N° 1\n \nGRUPO: 01 \nCICLO LECTIVO: I-2013\n"+
             "\nESTUDIANTES:   \n \b-Cristopher Briceño Rosales B21142 \n \b-Ariel Ruiz Guadamuz B26003" );        
        textosalida.setFont(fuente);
        textosalida.setSize(200,100);
        textosalida.setForeground(Color.blue);
        textosalida.setToolTipText("Portada");
        textosalida.setEditable(false);
        Contenedor.add(scrollpane= new JScrollPane(textosalida), BorderLayout.EAST);
        
		Crear.addActionListener(this);
		Añadir.addActionListener(this);
		Eliminar.addActionListener(this);
		Recorrer.addActionListener(this);
		Limpiar.addActionListener(this);
		Ayuda.addActionListener(this);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}//fin del metodo constructor

	public void actionPerformed(ActionEvent e)
	{//inicio del metodo actionPerformed
       if (e.getSource()==Crear)
       {//inicio del if
    	   if (A==2)
    	   {//inicio del if		   
        	   if (!Nombre.getText().equals("") & !Numero.getText().equals("") &!Direccion.getText().equals("")) 
        	   {//inicio del if
        		Nom=Nombre.getText();
           	   	String number=Numero.getText();
           	   	Num=Integer.parseInt(number);
           	   	Direc=Direccion.getText();
       			Nodo Nuevo= new Nodo(Nom, Num, Direc);			
       			if (raiz==null) {//inicio del if
       				this.raiz=Nuevo;
       				raiz.derecha=null;
       				raiz.izquierda=null;
       		       	 JOptionPane.showMessageDialog(null,
       		       		     "Se ha se creado el árbol satisfactoriamente", "Atencion estimado usuario",
       		       		     JOptionPane.INFORMATION_MESSAGE);
       		       	 tamaño++;
    	   		     Nombre.setText("");
    	   		     Numero.setText("");
    	   		     Direccion.setText("");
    	   		     A=1;
       				} //fin del if	
    		   }//fin del if
        	   else
        	   {//inicio del else
              	 JOptionPane.showMessageDialog(null, "Agregue los datos a insertar en los campos de 'Nombre',  \n'Número de Asegurado' y 'Direccion'" +
                         " y luego precione -Crear Árbol-","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
    		     Nombre.setText("");
    		     Numero.setText("");
    		     Direccion.setText("");
        	   }//fin del else	    
		   }//fin del if
    	   else 
    	   {//inicio del else
            	 JOptionPane.showMessageDialog(null, "Ya se ha Creado el Árbol anteriormente por lo tanto no se puede volver a crear","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
    		     Nombre.setText("");
    		     Numero.setText("");
    		     Direccion.setText("");
		   }  //fin del else 	         	   
	   }//fin del if
       
       else if (e.getSource()==Añadir)
       {//inicio del else if
    	   int Cond = 0;
    	   if (raiz==null) 
    	   {//inicio del if
    		   JOptionPane.showMessageDialog(null, "Aun no se ha creado el Árbol, primero debe crearlo para añadir registros","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
		     Cond=1;
    	   }//fin del if
    	   if (Cond==0) 
    	   {//inicio del if
    	   if (!Nombre.getText().equals("") & !Numero.getText().equals("") &!Direccion.getText().equals("")) 
    	   {//inicio del if
    		     Nom=Nombre.getText();
            	 String number=Numero.getText();
            	 Num=Integer.parseInt(number);
            	 Direc=Direccion.getText();
        		 Nodo Nuevo= new Nodo(Nom, Num, Direc);	
    		     Nodo Auxiliar=null;
    		     Nodo Padre=raiz;
    		     B=0;
    		     if (Padre.Numero==Num) 
    		     {//inicio del if
    		    	 JOptionPane.showMessageDialog(null, "No se puede añadir el registro ya que el Número de Asegurado ya existe","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 
    		    	 B=1;
				 }//fin del if
    		     if (B==0)
    		     {//inicio del if
    		    	 while (Padre!=null)
        		     {//inicio del while
        		    	 Auxiliar=Padre;
            		    	 if (Num<Padre.Numero) 
            		    	 {//inicio del if
        						Padre=Padre.izquierda;
        					 }//fin del if
            		    	 else 
            		    	 {//inicio del else
        						Padre=Padre.derecha;
        					 }//fin del else
    				 }//fin del while
    	    		 
        		     if (Auxiliar.Numero==Num) 
        		     {//inicio del if
        		    	 JOptionPane.showMessageDialog(null, "No se puede añadir el registro ya que el Número de Asegurado ya existe","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 
    				 }//fin del if
        		     
        		     else if (Num< Auxiliar.Numero)
        		     	{//inicio del else if 
            		    		 Auxiliar.izquierda=Nuevo;
         						JOptionPane.showMessageDialog(null,
         	       		       		     "Se ha se añadido el registro satisfactoriamente", "Atencion estimado usuario",
         	       		       		     JOptionPane.INFORMATION_MESSAGE);
         						tamaño++;				
    					}//fin del else if
        		     	else if (Num>Auxiliar.Numero) 
        		     	{//inicio del else
            		    		 Auxiliar.derecha=Nuevo;
         						JOptionPane.showMessageDialog(null,
         	       		       		     "Se ha se añadido el registro satisfactoriamente", "Atencion estimado usuario",
         	       		       		     JOptionPane.INFORMATION_MESSAGE);
         						tamaño++;			
    					}//fin del else	 
				 }//fin del if

    		     Nombre.setText("");
      		     Numero.setText("");
      		     Direccion.setText("");
    	   }//fin del if
    	   
    	   else 
    	   {//inicio del else
    		 JOptionPane.showMessageDialog(null, "Agregue los datos a añadir en los campos de 'Nombre',  \n'Número de Asegurado' y 'Direccion'" +
                       " y luego precione -Añadir-","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
  		     Nombre.setText("");
  		     Numero.setText("");
  		     Direccion.setText("");
		   }//fin del else
    	   }//fin del if
    	   else 
    	   {//inicio del else
  		     Nombre.setText("");
  		     Numero.setText("");
  		     Direccion.setText("");
		   }//fin del else
	   }//fin del else if
       
       else if (e.getSource()==Eliminar)
       {//inicio del else if
    	   if (!Numero.getText().equals("") ) 
    	   {//inicio del if
    		   Num=Integer.parseInt(Numero.getText());
    		   Nodo Auxiliar=null;
  		       Nodo Padre=raiz;	 
  		       E=0;
  		     
  		     while (Padre!=null)
  		     {//inicio del while
  		    	 Auxiliar=Padre;
      		    	 if (Num<Padre.Numero) 
      		    	 {//inicio del if
  						Padre=Padre.izquierda;
  					 }//fin del if
      		    	 else 
      		    	 {//inicio del else
  						Padre=Padre.derecha;
  					 }//fin del else
				 }//fin del while  
  		     
	  		   if (raiz==null)
	  		   {//inicio del if
	  			 JOptionPane.showMessageDialog(null, "Aun no se ha creado el Árbol, primero debe crearlo para eliminar registros","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );	  			
	    		 Nombre.setText("");
      		     Numero.setText("");
      		     Direccion.setText("");
	  		   } //fin del if
	  		   /*
	  		    * Elimimar si el árbol solo contiene un registro
	  		    */
	  		   else if (tamaño==1)
    		   {//inicio del else if
    			   if (Num==Auxiliar.Numero)
        		   {//inicio del if
    				   Padre=null;
    	  		       raiz=Padre;
    	  		       JOptionPane.showMessageDialog(null, "Se ha eliminado el registro satisfactoriamente","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 				
    	  		       tamaño--;
    	  		       A=2;

    			   }//fin del if
    			   else if (Num!=Auxiliar.Numero)
    			   {//inicio del else if
    					 JOptionPane.showMessageDialog(null, "No se puede eliminar el registro ya que el Número de Asegurado no existe","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			     				    	
				   }//fin del else if
	    		     Nombre.setText("");
	      		     Numero.setText("");
	      		     Direccion.setText("");
			   }//fin del else if

	  		   else if (tamaño>1)
	  		   {//inicio del else if
	  		       Nodo X=raiz;	       
	    		   Nodo I=null;  
	    		     while (X!=null)
	    		     {//inicio del while
	    		    	 I=X;
	        		    	 if (Num<X.Numero) 
	        		    	 {//inicio del if
	    						X=X.izquierda;
	    					 }//fin del if
	        		    	 else if (Num>X.Numero) 
	        		    	 {//inicio del else
	    						X=X.derecha;
	    					 }//fin del else
	        		    	 else if (Num==X.Numero)
	        		    	 {//inicio del else if
								X=null;
							 }//fin del else
	  				 }//fin del while  
	  			   
	    		     if (I.Numero!=Num) 
        		     {//inicio del if
        		    	 JOptionPane.showMessageDialog(null, "No se puede eliminar el registro ya que el Número de Asegurado no existe","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 
        		    	 E=1;
    	    		     Nombre.setText("");
    	      		     Numero.setText("");
    	      		     Direccion.setText("");
        		     }//fin del if        		            		     
	    		     
	    		   if (E==0)
	    		   {//inicio del if
	    			   /*
			  		    * Eliminar si el registro a eliminar es la raiz
			  		    */
			  		   if (raiz.Numero==Num)
			  		   {//inicio del else if
			  			   F=0;
			  			   	if (raiz.derecha==null)
			  			   	{//inicio del if
			  			   	  F=1;	
			  			   	   Nodo padre= raiz;
			    			   Nodo auxiliar=null;
			    			   Nodo temp=null;
			    			   Nodo aux=null;
			    			   while (padre.Numero!=Num)
			    			   {//inicio del while
			    				  auxiliar=padre; 
								  padre=padre.izquierda;
								  C=0;
								  if (padre.Numero<Num)
								  {//inicio del if
									while (padre.Numero!=Num)
									{//inicio while
										auxiliar=padre;
										padre=padre.derecha;
										C=1;
									}//fin del while
								  }//fin del if
							   }//fin del while
			    			   
			    			    if (padre.izquierda!=null)
								  {//inicio del else if
			    			    	  C=2;
									  temp=padre.izquierda;
									  aux=temp.derecha;
									  if (aux!=null)
									  {//inicio del if
										  while (aux.derecha!=null) 
										  {//inicio del while
											temp=aux;  
											aux=aux.derecha;
										  }//fin del while
										  padre.Numero=aux.Numero;
										  padre.Nombre=aux.Nombre;
										  padre.Direccion=aux.Direccion;
										  temp.derecha=null;
									  }	//fin del if	
									  else if (aux==null)
									  {//inicio del else if
										  if (temp.izquierda!=null) 
										  {//inicio del if
											  Nodo C=null;
											  while (temp.izquierda!=null)
											  {//inicio del while
												  C=temp;  
												  if (padre.izquierda.Numero==C.Numero)
												  {
													  padre.Numero=C.Numero;
													  padre.Nombre=C.Nombre;
													  padre.Direccion=C.Direccion;
												  }
												  temp=temp.izquierda;										 
											  }//fin del while										  
										  }
										  /*
										   * Eliminar rama con intercambio de hoja mientras que la hoja.izquierda==null
										   */
										  else if (temp.izquierda==null)
										  {//inicio del else if
											  padre.Numero=temp.Numero;
											  padre.Nombre=temp.Nombre;
											  padre.Direccion=temp.Direccion;
											  padre.izquierda=null;
										  }//fin del else if						  
									  }//fin del else if
								  }//fin del else if
			    			    else if (padre.izquierda==null & padre.derecha!=null)
			    			      {//inicio del else if
			    			    	  C=2; 
									  Nodo reemplazo=padre.derecha;
									  Nodo S=null;
									  Nodo T=null;
									  
									  /*
									   * Eliminar una rama con intercambio de hoja por el subarbol derecho de la rama
									   */
									  if (reemplazo.izquierda!=null) 
									  {//inicio del if
										while (reemplazo.izquierda!=null) 
										{//inicio del while
											T=reemplazo;
											reemplazo=reemplazo.izquierda;
										}//fin del while
										  padre.Numero= reemplazo.Numero;
										  padre.Nombre= reemplazo.Nombre;
										  padre.Direccion= reemplazo.Direccion;								 
										  T.izquierda=null;
									  }//fin del if
									  
									/*
									 * Elimina rama con intercambio de nodo rama mientras que nodo rama.derecha!=null
									 */
									  else if (reemplazo.izquierda==null & reemplazo.derecha!=null)
									  {//inicio del else if
										  padre.Numero= padre.derecha.Numero;
										  padre.Nombre= padre.derecha.Nombre;
										  padre.Direccion= padre.derecha.Direccion;

										  while (reemplazo.derecha!=null) 
										  {//inicio del while
											  S=reemplazo;
											  reemplazo.Numero= reemplazo.derecha.Numero;
											  reemplazo.Nombre= reemplazo.derecha.Nombre;
											  reemplazo.Direccion= reemplazo.derecha.Direccion;
											  reemplazo=reemplazo.derecha;
										  }//fin del while
										  if (S!=null)
										  {//inicio del if
											  S.derecha=null;
										  }//fin del if
									  }//fin del else if
									  
									  /*
									   * Eliminar rama con intercambio de hoja
									   */
									  else if (reemplazo.izquierda==null & reemplazo.derecha==null)
									  {//inicio del else if
										  padre.Numero= padre.derecha.Numero;
										  padre.Nombre= padre.derecha.Nombre;
										  padre.Direccion= padre.derecha.Direccion;
										  padre.derecha=null;
									  }	//fin del else if					  
								  }//fin del else if
							}//fin del if
			  			   	else if (F==0)
			  			   	{//inicio del else if
				  			   if (raiz.izquierda==null)
				  			   	{//fin del else if
					    			   Nodo padre= raiz;
					    			   Nodo auxiliar=null;
					    			   Nodo temp=null;
					    			   Nodo aux=null;   			  
					    			   while (padre.Numero!=Num)
					    			   {//inicio del while
					    				  auxiliar=padre; 
										  padre=padre.derecha;		
										  C=0;
										  if (padre.Numero>Num)
										  {//inicio del if
											while (padre.Numero!=Num)
											{//inicio while
												auxiliar=padre;
												padre=padre.izquierda;
												C=1;
											}//fin del while
										  }//fin del if
									   }//fin del while
					    			      			   		    			   
					    			    if (padre.derecha!=null)
										  {//inicio del else if
					    			    	  C=2;
											  temp=padre.derecha;
											  aux=temp.izquierda;
											  if (aux!=null)
											  {//inicio del if
												  while (aux.izquierda!=null) 
												  {//inicio del while
													temp=aux;  
													aux=aux.izquierda;
												  }//fin del while
												  padre.Numero=aux.Numero;
												  padre.Nombre=aux.Nombre;
												  padre.Direccion=aux.Direccion;
												  temp.izquierda=null;
											  }	//fin del if	
											  else if (aux==null)
											  {//inicio del else if
												  if (temp.derecha!=null) 
												  {//inicio del if
													  Nodo C=null;
													  while (temp.derecha!=null)
													  {//inicio del while
														  C=temp;  
														  if (padre.derecha.Numero==C.Numero)
														  {
															  padre.Numero=C.Numero;
															  padre.Nombre=C.Nombre;
															  padre.Direccion=C.Direccion;
														  }
														  temp=temp.derecha;										 
													  }//fin del while										  
												  }
												  /*
												   * Eliminar rama con intercambio de hoja mientras que la hoja.derecha==null
												   */
												  else if (temp.derecha==null)
												  {//inicio del else if
													  padre.Numero=temp.Numero;
													  padre.Nombre=temp.Nombre;
													  padre.Direccion=temp.Direccion;
													  padre.derecha=null;
												  }//fin del else if						  
											  }//fin del else if
										  }//fin del else if
					    			    else if (padre.derecha==null & padre.izquierda!=null)
					    			      {//inicio del else if
					    			    	  C=2; 
											  Nodo reemplazo=padre.izquierda;
											  Nodo S=null;
											  Nodo T=null;
											  
											  /*
											   * Eliminar una rama con intercambio de hoja por el subarbol izquierdo de la rama
											   */
											  if (reemplazo.derecha!=null) 
											  {//inicio del if
												while (reemplazo.derecha!=null) 
												{//inicio del while
													T=reemplazo;
													reemplazo=reemplazo.derecha;
												}//fin del while
												  padre.Numero= reemplazo.Numero;
												  padre.Nombre= reemplazo.Nombre;
												  padre.Direccion= reemplazo.Direccion;								 
												  T.derecha=null;
											  }//fin del if
											  
											/*
											 * Elimina rama con intercambio de nodo rama mientras que nodo rama.izquierda!=null
											 */
											  else if (reemplazo.derecha==null & reemplazo.izquierda!=null)
											  {//inicio del else if
												  padre.Numero= padre.izquierda.Numero;
												  padre.Nombre= padre.izquierda.Nombre;
												  padre.Direccion= padre.izquierda.Direccion;

												  while (reemplazo.izquierda!=null) 
												  {//inicio del while
													  S=reemplazo;
													  reemplazo.Numero= reemplazo.izquierda.Numero;
													  reemplazo.Nombre= reemplazo.izquierda.Nombre;
													  reemplazo.Direccion= reemplazo.izquierda.Direccion;
													  reemplazo=reemplazo.izquierda;
												  }//fin del while
												  if (S!=null)
												  {//inicio del if
													  S.izquierda=null;
												  }//fin del if
											  }//fin del else if
											  
											  /*
											   * Eliminar rama con intercambio de hoja
											   */
											  else if (reemplazo.derecha==null & reemplazo.izquierda==null)
											  {//inicio del else if
												  padre.Numero= padre.izquierda.Numero;
												  padre.Nombre= padre.izquierda.Nombre;
												  padre.Direccion= padre.izquierda.Direccion;
												  padre.izquierda=null;
											  }	//fin del else if					  
										  }//fin del else if   
					    			   
					   			    /*
					   			     * Eliminar hoja derecha del árbol derecho
					   			     */
					    			   if (C==0)
					    			   {//inicio del if
					    				   auxiliar.derecha=null;
									   }//fin del if
					    			   
					   			    /*
					   			     * Eliminar hoja izquierda del árbol derecho
					   			     */
					    			   else if (C==1)
					    			   {//inicio del else if
					    				   auxiliar.izquierda=null;
									   }//fin del else if
					    			   JOptionPane.showMessageDialog(null, "Se ha eliminado el registro satisfactoriamente","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 				
					   	  		       tamaño--; 					
								}//fin del else if
							}//fin del else if 	
					   }//fin del else if
			  		   
			  		   /*
			  		    * Eliminar si el registro a eliminar es una rama o una hoja del árbol izquierdo
			  		    */	  		   
		    		   else if (raiz.Numero>Num) 
		    		   {//inicio del else if
		    			   Nodo padre= raiz;
		    			   Nodo auxiliar=null;
		    			   Nodo temp=null;
		    			   Nodo aux=null;
		    			   while (padre.Numero!=Num)
		    			   {//inicio del while
		    				  auxiliar=padre; 
							  padre=padre.izquierda;
							  C=0;
							  if (padre.Numero<Num)
							  {//inicio del if
								while (padre.Numero!=Num)
								{//inicio while
									auxiliar=padre;
									padre=padre.derecha;
									C=1;
								}//fin del while
							  }//fin del if
						   }//fin del while
		    			   
		    			    if (padre.izquierda!=null)
							  {//inicio del else if
		    			    	  C=2;
								  temp=padre.izquierda;
								  aux=temp.derecha;
								  if (aux!=null)
								  {//inicio del if
									  while (aux.derecha!=null) 
									  {//inicio del while
										temp=aux;  
										aux=aux.derecha;
									  }//fin del while
									  padre.Numero=aux.Numero;
									  padre.Nombre=aux.Nombre;
									  padre.Direccion=aux.Direccion;
									  temp.derecha=null;
								  }	//fin del if	
								  else if (aux==null)
								  {//inicio del else if
									  if (temp.izquierda!=null) 
									  {//inicio del if
										  Nodo C=null;
										  while (temp.izquierda!=null)
										  {//inicio del while
											  C=temp;  
											  if (padre.izquierda.Numero==C.Numero)
											  {
												  padre.Numero=C.Numero;
												  padre.Nombre=C.Nombre;
												  padre.Direccion=C.Direccion;
											  }
											  temp=temp.izquierda;										 
										  }//fin del while										  
									  }
									  /*
									   * Eliminar rama con intercambio de hoja mientras que la hoja.izquierda==null
									   */
									  else if (temp.izquierda==null)
									  {//inicio del else if
										  padre.Numero=temp.Numero;
										  padre.Nombre=temp.Nombre;
										  padre.Direccion=temp.Direccion;
										  padre.izquierda=null;
									  }//fin del else if						  
								  }//fin del else if
							  }//fin del else if
		    			    else if (padre.izquierda==null & padre.derecha!=null)
		    			      {//inicio del else if
		    			    	  C=2; 
								  Nodo reemplazo=padre.derecha;
								  Nodo S=null;
								  Nodo T=null;
								  
								  /*
								   * Eliminar una rama con intercambio de hoja por el subarbol derecho de la rama
								   */
								  if (reemplazo.izquierda!=null) 
								  {//inicio del if
									while (reemplazo.izquierda!=null) 
									{//inicio del while
										T=reemplazo;
										reemplazo=reemplazo.izquierda;
									}//fin del while
									  padre.Numero= reemplazo.Numero;
									  padre.Nombre= reemplazo.Nombre;
									  padre.Direccion= reemplazo.Direccion;								 
									  T.izquierda=null;
								  }//fin del if
								  
								/*
								 * Elimina rama con intercambio de nodo rama mientras que nodo rama.derecha!=null
								 */
								  else if (reemplazo.izquierda==null & reemplazo.derecha!=null)
								  {//inicio del else if
									  padre.Numero= padre.derecha.Numero;
									  padre.Nombre= padre.derecha.Nombre;
									  padre.Direccion= padre.derecha.Direccion;

									  while (reemplazo.derecha!=null) 
									  {//inicio del while
										  S=reemplazo;
										  reemplazo.Numero= reemplazo.derecha.Numero;
										  reemplazo.Nombre= reemplazo.derecha.Nombre;
										  reemplazo.Direccion= reemplazo.derecha.Direccion;
										  reemplazo=reemplazo.derecha;
									  }//fin del while
									  if (S!=null)
									  {//inicio del if
										  S.derecha=null;
									  }//fin del if
								  }//fin del else if
								  
								  /*
								   * Eliminar rama con intercambio de hoja
								   */
								  else if (reemplazo.izquierda==null & reemplazo.derecha==null)
								  {//inicio del else if
									  padre.Numero= padre.derecha.Numero;
									  padre.Nombre= padre.derecha.Nombre;
									  padre.Direccion= padre.derecha.Direccion;
									  padre.derecha=null;
								  }	//fin del else if					  
							  }//fin del else if

		    			    /*
		    			     * Eliminar hoja izquierda del árbol izquierdo
		    			     */
		    			   if (C==0) 
		    			   {//inicio del if
		    				   auxiliar.izquierda=null;	
						   }//fin del if
		    			   
		   			    /*
		   			     * Eliminar hoja derecha del árbol izquierdo
		   			     */
		    			   else if (C==1)
		    			   {//inicio del else if
							auxiliar.derecha=null;
						   }//fin del else   			  
		    			   JOptionPane.showMessageDialog(null, "Se ha eliminado el registro satisfactoriamente","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 				
		   	  		       tamaño--; 			    				          	
					   }//fin del else if
			  		   
			  		   /*
			  		    * Eliminar si el registro a eliminar es una rama o una hoja del árbol derecho
			  		    */	 
		    		   else if (raiz.Numero<Num) 
		    		   {//fin del else if
		    			   Nodo padre= raiz;
		    			   Nodo auxiliar=null;
		    			   Nodo temp=null;
		    			   Nodo aux=null;   			  
		    			   while (padre.Numero!=Num)
		    			   {//inicio del while
		    				  auxiliar=padre; 
							  padre=padre.derecha;		
							  C=0;
							  if (padre.Numero>Num)
							  {//inicio del if
								while (padre.Numero!=Num)
								{//inicio while
									auxiliar=padre;
									padre=padre.izquierda;
									C=1;
								}//fin del while
							  }//fin del if
						   }//fin del while
		    			      			   		    			   
		    			    if (padre.derecha!=null)
							  {//inicio del else if
		    			    	  C=2;
								  temp=padre.derecha;
								  aux=temp.izquierda;
								  if (aux!=null)
								  {//inicio del if
									  while (aux.izquierda!=null) 
									  {//inicio del while
										temp=aux;  
										aux=aux.izquierda;
									  }//fin del while
									  padre.Numero=aux.Numero;
									  padre.Nombre=aux.Nombre;
									  padre.Direccion=aux.Direccion;
									  temp.izquierda=null;
								  }	//fin del if	
								  else if (aux==null)
								  {//inicio del else if
									  if (temp.derecha!=null) 
									  {//inicio del if
										  Nodo C=null;
										  while (temp.derecha!=null)
										  {//inicio del while
											  C=temp;  
											  if (padre.derecha.Numero==C.Numero)
											  {
												  padre.Numero=C.Numero;
												  padre.Nombre=C.Nombre;
												  padre.Direccion=C.Direccion;
											  }
											  temp=temp.derecha;										 
										  }//fin del while										  
									  }
									  /*
									   * Eliminar rama con intercambio de hoja mientras que la hoja.derecha==null
									   */
									  else if (temp.derecha==null)
									  {//inicio del else if
										  padre.Numero=temp.Numero;
										  padre.Nombre=temp.Nombre;
										  padre.Direccion=temp.Direccion;
										  padre.derecha=null;
									  }//fin del else if						  
								  }//fin del else if
							  }//fin del else if
		    			    else if (padre.derecha==null & padre.izquierda!=null)
		    			      {//inicio del else if
		    			    	  C=2; 
								  Nodo reemplazo=padre.izquierda;
								  Nodo S=null;
								  Nodo T=null;
								  
								  /*
								   * Eliminar una rama con intercambio de hoja por el subarbol izquierdo de la rama
								   */
								  if (reemplazo.derecha!=null) 
								  {//inicio del if
									while (reemplazo.derecha!=null) 
									{//inicio del while
										T=reemplazo;
										reemplazo=reemplazo.derecha;
									}//fin del while
									  padre.Numero= reemplazo.Numero;
									  padre.Nombre= reemplazo.Nombre;
									  padre.Direccion= reemplazo.Direccion;								 
									  T.derecha=null;
								  }//fin del if
								  
								/*
								 * Elimina rama con intercambio de nodo rama mientras que nodo rama.izquierda!=null
								 */
								  else if (reemplazo.derecha==null & reemplazo.izquierda!=null)
								  {//inicio del else if
									  padre.Numero= padre.izquierda.Numero;
									  padre.Nombre= padre.izquierda.Nombre;
									  padre.Direccion= padre.izquierda.Direccion;

									  while (reemplazo.izquierda!=null) 
									  {//inicio del while
										  S=reemplazo;
										  reemplazo.Numero= reemplazo.izquierda.Numero;
										  reemplazo.Nombre= reemplazo.izquierda.Nombre;
										  reemplazo.Direccion= reemplazo.izquierda.Direccion;
										  reemplazo=reemplazo.izquierda;
									  }//fin del while
									  if (S!=null)
									  {//inicio del if
										  S.izquierda=null;
									  }//fin del if
								  }//fin del else if
								  
								  /*
								   * Eliminar rama con intercambio de hoja
								   */
								  else if (reemplazo.derecha==null & reemplazo.izquierda==null)
								  {//inicio del else if
									  padre.Numero= padre.izquierda.Numero;
									  padre.Nombre= padre.izquierda.Nombre;
									  padre.Direccion= padre.izquierda.Direccion;
									  padre.izquierda=null;
								  }	//fin del else if					  
							  }//fin del else if   
		    			   
		   			    /*
		   			     * Eliminar hoja derecha del árbol derecho
		   			     */
		    			   if (C==0)
		    			   {//inicio del if
		    				   auxiliar.derecha=null;
						   }//fin del if
		    			   
		   			    /*
		   			     * Eliminar hoja izquierda del árbol derecho
		   			     */
		    			   else if (C==1)
		    			   {//inicio del else if
		    				   auxiliar.izquierda=null;
						   }//fin del else if
		    			   JOptionPane.showMessageDialog(null, "Se ha eliminado el registro satisfactoriamente","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );    		    			 				
		   	  		       tamaño--; 	
					   }//fin del else if   		   
		    		     Nombre.setText("");
		      		     Numero.setText("");
		      		     Direccion.setText("");
				  } //fin del if 		  		   
			   }//fin del else if

    	   }//fin del if
    	   else
    	   {//inicio del else
      		 JOptionPane.showMessageDialog(null, "Agregue en el campo de 'Número de Asegurado' el dato correspondiente \nal Empleado a eliminar" +
                     " y luego precione -Eliminar-","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
		     Nombre.setText("");
		     Numero.setText("");
		     Direccion.setText("");
		   }//fin del else
	   }//fin del else if
		
       else if (e.getSource()==Recorrer)
       {//inicio del else if
    	   int Cond = 0;
    	   if (raiz==null) 
    	   {//inicio del if
    		   JOptionPane.showMessageDialog(null, "Aun no se ha creado el Árbol, primero debe crearlo para ver los registros","Atencion estimado usuario", JOptionPane.INFORMATION_MESSAGE  );
		     Cond=1;
    	   }//fin del if
    	   if (Cond==0) 
    	   {//inicio del if
    		   do {
    			   String H=JOptionPane.showInputDialog("Que Opcion desea: \n1)Enorden \n2)PreOrden \n3)PostOrden: ");
        		   D=Integer.parseInt(H);
        		   if (D>=4 |D<=0) 
        		   {
					JOptionPane.showMessageDialog(null, "Vuelva ingressar un numero");
				   }
			} while (D>=4 |D<=0);
    		   
    		 switch (D) {
			case 1:
	    		   if (raiz != null)
	    			  {
	    			    raiz.re_enorden(tamaño);
	    			  }
				break;

			case 2:
				
						 if (raiz != null)
		   			  {
		   			    raiz.re_preorden(tamaño);
		   			  }
				break;
			case 3:
					 if (raiz != null)
		   			  {
		   			    raiz.re_postorden(tamaño);
		   			  }
				break;
			default:
				break;
			}      		
		  }//fin del if
    	  
    	 /*  
    	  String salida= "Número de Asegurado \tNombre \tDireccion";
    	  salida+="\n"+raiz.Numero+"         \t"+raiz.Nombre+"      \t"+raiz.Direccion; 		 textosalida.add();
    	 */
	   }//fin del else if   
  
       else if (e.getSource()==Limpiar)
       {//inicio del else if
    	   /**
    	    * El método showConfirmDialog tal y como esta escrito aquí puede
    	    * arrojar dos valores enteros los cuales son: 0 para la opción SI o 1
    	    * para la opción NO. El resultado que traiga se asigna a la variable
    	    * scd
    	    */
    	  int Condicion= JOptionPane.showConfirmDialog(null,"¿Esta seguro de limpiar los campos de ingreso y salida de datos?", "Pregunta",
    			    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);    	   
	    	  if (Condicion==0)
	    	  {//inicio del if
	    		  Nombre.setText("");
		       	  Numero.setText("");
		       	  Direccion.setText("");
		       	 JOptionPane.showMessageDialog(null,
		       		     "Se ha se realiazado la accion satisfactoriamente", "Atencion estimado usuario",
		       		     JOptionPane.INFORMATION_MESSAGE);
			  }//fin del if   	 
	   }//fin del else if
       
       else if (e.getSource()==Ayuda)
       {//inicio del else if
    	   try
    	   {//inicio del try
			    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"src\\Ejercicios.pdf");
		   }//fin del try 
    	   catch (Exception ex)
    	   {//inicio del catch
    		   JOptionPane.showMessageDialog(null,
		       		     "Se ha se producido un error", "Atencion estimado usuario",
		       		     JOptionPane.INFORMATION_MESSAGE);
		   }//fin del catch
	   }//fin del else if
	}//fin del metodo actionPerformed
	
	public static void main(String[] args) 
	{//inicio del metodo main
		Arbol_Binario arbol=new Arbol_Binario(); //creacion de una objeto de la clase Arbol_Binario
        arbol.setVisible(true);
	}//fin del metodo main
}//fin de la clase Arbol_Binario