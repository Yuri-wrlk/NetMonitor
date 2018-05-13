package ProjetoRedes.NetMonitor;
import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

public class Server {
	
	public static void main(String[] args) throws IOException{
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " +     
            cliente.getInetAddress().getHostAddress()
        );

        Scanner s = new Scanner(cliente.getInputStream());
        while (s.hasNextLine()) {
        		String l = s.nextLine();
            System.out.println(l);
            	
            if (l.equals("la")) {
          	  long inicio = System.currentTimeMillis();
	    	  	  URL url = new URL("http://www.cesadufs.com.br/ORBI/public/uploadCatalago/15250816022012Fundamentos_de_Matematica_aula_12.pdf");
	    	  	  File download = new File("/Users/adelinofernandes/Desktop/teste.pdf");  
	    	  	  FileUtils.copyURLToFile(url, download);
	    	  	  long fim = System.currentTimeMillis();
	    	  	  
	    	  	  
	    	  	  System.out.println((fim-inicio)*0.001+"Segundos");
	    	  	  System.out.println(download.length()/1024 + "Kb");
	    	  	  System.out.println((download.length()/1024)/((fim-inicio)*0.001) + "Kbps");
            }
            
            
        }

        s.close();
        servidor.close();
        cliente.close();
		
	}
	
	
}
