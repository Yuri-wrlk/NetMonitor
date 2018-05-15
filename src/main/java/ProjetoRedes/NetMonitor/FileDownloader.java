package ProjetoRedes.NetMonitor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader extends Thread {

	private String urlDownload;
	
	private String regiao;
	
	private double tamArqkb;	
	private double velocDownload;
	private double tempoMedioDownload;
	
	FileDownloader(String regiao, String url){
		this.regiao = regiao;
		this.urlDownload = url;
		this.tamArqkb = 0.0;
		this.velocDownload = 0.0;
		this.tempoMedioDownload = 0.0;
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
		
	  	File download = new File(System.getProperty("user.home") + "/Desktop/archlinux-64bit.iso");  
	  	try {
			FileUtils.copyURLToFile(url, download);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  	long fim = System.currentTimeMillis();
	  	  
	  	this.tempoMedioDownload = (fim-inicio)*0.001;
	  	this.tamArqkb = download.length()/1024;
	  	this.velocDownload = (download.length()/1024)/((fim-inicio)*0.001); 
	  	System.out.println("Região: " + regiao);
	  	System.out.println(tempoMedioDownload+"Segundos");
	  	System.out.println(tamArqkb + "Kb");
	  	System.out.println(velocDownload + "Kbps");
	}

	public String getUrlDownload() {
		return urlDownload;
	}

	public String getRegiao() {
		return regiao;
	}

	public double getTamArqkb() {
		return tamArqkb;
	}

	public double getVelocDownload() {
		return velocDownload;
	}

	public double getTempoMedioDownload() {
		return tempoMedioDownload;
	}
	
	public EstatisticaDownload paraEstatistica() {
		EstatisticaDownload ed = new EstatisticaDownload();
		ed.setRegiao(regiao);
		ed.setUrlDownload(urlDownload);
		ed.setVelocDownload(velocDownload);
		ed.setTempoMedioDownload(tempoMedioDownload);
		return ed;
	}
}
