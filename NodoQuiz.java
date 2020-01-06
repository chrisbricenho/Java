
public class NodoQuiz {
	
	NodoQuiz sgt; 
	String Tipo, Nombre, Cedula, Nac, Licencia;
	float Seguro, ley, valor, MontoInfraccion;  
	double Pani, Total, MontoTotal, timbres; 
    int Infraccion; 
    
    public NodoQuiz(){
    }
    
    public NodoQuiz (String Tipo, String Nombre, String Cedula, String Nac, String Licencia, float Seguro, float ley, float valor, 
    		float MontoInfraccion, int Infraccion, double Pani, double Total, double MontoTotal, double timbres){
    	
    	this.Tipo=Tipo; 
    	this.Nombre=Nombre;
    	this.Cedula=Cedula;
    	this.Nac=Nac; 
    	this.Licencia=Licencia; 
    	this.Seguro=Seguro;
    	this.ley=ley;
    	this.valor=valor;
    	this.timbres=timbres;
    	this.MontoInfraccion=MontoInfraccion;
    	this.Infraccion=Infraccion; 
    	this.Pani=Pani;
    	this.Total=Total; 
    	this.MontoTotal=MontoTotal;
    	this.sgt=null; 
    }
    
    public String toString(){
    	
    	timbres=valor*0.02;
    	Pani=Infraccion*0.07; 
    	Total=MontoInfraccion+Pani;
    	MontoTotal=Seguro+ley+valor+timbres+Total; 
    	
    	
    return"\nTipo de Vehículo: "+Tipo+"\nNombre del Propietario: "+Nombre+"\nCédula del Propietario: "+Cedula+"\nTipo de Licencia: "
    +Licencia+"\nMonto del Seguro Obligatorio: "+Seguro+"\nLey Conservación Fauna y FLora: "+ley+"\nValor Fiscal del Vehiculo: "
    +valor+"\nNúmero de Infracción: "+Infraccion+"\nMonto individual de infraccion: "+MontoInfraccion+"\nImpuesto de PANI: "+Pani+
    "\nMonto total de infracción: "+Total+"\nMONTO TOTAL A PAGAR: "+MontoTotal;
    }
}
