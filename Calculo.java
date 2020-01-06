import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class Calculo extends HttpServlet {
   public void doPost( HttpServletRequest request,
                      HttpServletResponse response )
      throws ServletException, IOException
   {
      PrintWriter output;
      String Num= request.getParameter ("Numero"); 
      int Numero=Integer.parseInt(Num);

      response.setContentType( "text/html" );  // content type
      output = response.getWriter();           // get writer

      // create and send HTML page to client
      StringBuffer buf = new StringBuffer();
      
    output.print(  "<center></B></TD>\n</TR>\n<HR>\n<TABLE BORDER= 5 WIDTH= 10% HEIGHT= 5 cellpadding= 1 cellspacing= 0>\n<TR>\n");
buf.append("		<TD ALIGN="+" middle"+"><B><h3><font color=Black><center>Resultado: </center></font></h3></B></TD>\n</B></TD>\n");
buf.append("</TR>\n<TR></center>\n");
		for (int i=0; i<11; i++){
buf.append("<TD><B><h3><font color= #060504>"+Numero+"X"+i+"="+(Numero*i)+"</font></h3></B></TD>\n</B></TD>\n");				
		}		
buf.append("<tr>\n");	
      output.println( buf.toString() );
      output.close();    // close PrintWriter stream
   }
}

  