import java.io.*;
import javax.swing.JOptionPane; 

public class ListaQuiz1 {
	
	private NodoQuiz Empieza; 
	public String Tipo, Nombre, Cedula, Nac, Licencia; 
	public float Seguro, ley, valor, MontoInfraccion;  
    public  int Infraccion;
    private int size;
    
    public ListaQuiz1(){
    	this.Empieza=null;
    	this.size=0;
    }
     public boolean siVacio(){
    	 return (this.Empieza==null);
     }
     
     public ListaQuiz1 Ingresar (String Tipo, String Nombre, String Cedula, String Nac, String Licencia, float Seguro, float ley, float valor, 
     		float MontoInfraccion, double Infraccion){
    	 NodoQuiz Nuevo = new NodoQuiz (); 
    	 
    	 NodoQuiz Ultimo=null; 
    	 
    	 if (siVacio()){
    		 this.Empieza=Nuevo;
    	 }
    	 else {
    		 Ultimo=Empieza; 
    		 while (Ultimo.sgt != null){
    			 Ultimo=Ultimo.sgt;
    		 }
    		 Ultimo.sgt=Nuevo; 
    	 }
    	 this.size++;
    	 return this;
     }
     
    public void Visualizar (){
    	if (size != 0){
    		NodoQuiz Most=Empieza;
    		while (Most != null){
    	Most.toString(); 
    	JOptionPane.showMessageDialog(null, Most);
    	Most=Most.sgt;
    		}
    	}
    }
    
    
    public void Mostrar (){
    	NodoQuiz Actual=Empieza; 
    	String Tipo1=JOptionPane.showInputDialog("Ingrese el Tipo de Vehiculo que desea Mostrar: ");
    	while (Actual != null){
    		if (Tipo1.equals(Actual.Tipo)){
    			JOptionPane.showMessageDialog(null, Actual.toString());
    			Actual=Actual.sgt; 
    		}
    		else{
    			Actual = Actual.sgt; 
    		}   }
    }
    
    public void Buscar (){
    	NodoQuiz Actual=Empieza; 
    	String Cedula1=JOptionPane.showInputDialog("Ingrese el número de Cédula que desea buscar: ");
    	while (Actual != null){
    		if (Cedula1.equals(Actual.Cedula)){
    			JOptionPane.showMessageDialog(null, Actual.toString());
    			Actual=Actual.sgt; 
    		}
    		else{
    			Actual = Actual.sgt; 
    		}   }
    }
    
    public void Eiminar (){
    	NodoQuiz Actual =Empieza;
    	
    	while (Actual != null){
    		if (MontoInfraccion==0){
    			Empieza=Actual.sgt;
    			Actual=null; 
    		}
    		else {
    			Actual=Actual.sgt;
    		}
    	}
    }
    
    
}