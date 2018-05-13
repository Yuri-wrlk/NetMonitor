package ProjetoRedes.NetMonitor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader extends Thread {

	private String urlDownload;
	
	private double tempoMedioDownload;
	
	FileDownloader(String url){
		this.urlDownload = url;
	}
	
	@Override
	public void run() {
		long inicio = System.currentTimeMillis();
	  	URL url = null;
		try {
			url = new URL(urlDownload);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	  	File download = new File(System.getProperty("user.home") + "/Desktop/");  
	  	try {
			FileUtils.copyURLToFile(url, download);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  	long fim = System.currentTimeMillis();
	  	  
	  	this.tempoMedioDownload = (fim-inicio)*0.001;
	  	System.out.println(tempoMedioDownload+"Segundos");
	  	System.out.println(download.length()/1024 + "Kb");
	  	System.out.println((download.length()/1024)/((fim-inicio)*0.001) + "Kbps");
	}
}
