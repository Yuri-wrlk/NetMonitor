package ProjetoRedes.NetMonitor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        	
        	
        	  long inicio = System.currentTimeMillis();
	  	  URL url = new URL("http://www.cesadufs.com.br/ORBI/public/uploadCatalago/15250816022012Fundamentos_de_Matematica_aula_12.pdf");
	  	  File download = new File("/Users/adelinofernandes/Desktop/teste.pdf");  
	  	  FileUtils.copyURLToFile(url, download);
	  	  long fim = System.currentTimeMillis();
	  	  
	  	  
	  	  System.out.println((fim-inicio)*0.001);
	  	  System.out.println(download.length()/1024);
	  	  System.out.println(((fim-inicio)*0.001)/download.length()/1024);
    }
}
