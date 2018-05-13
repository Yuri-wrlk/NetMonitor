package ProjetoRedes.NetMonitor;
import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

public class Server {
	
	/**
	 * Método para calcular a latência. Ao chamar o método passe o domínio por ex.:google.com
	 * O método retorna um array de latências, para ser mais específico 10 latências para que 
	 * possa calcular médias... depois...
	 */
	
	  public static  double[] latencia(String command) {
		  	double [] latencias = new double [10];
			String s;
			int limite = 0;
			double n = 0;
			try {
				Process p = Runtime.getRuntime().exec("ping " + command);
				BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));		
				while ((s = inputStream.readLine()) != null && limite != 10) {
					 String[] tokens = s.split("time=",-1);			 
					 if(tokens.length == 2) {
						 String[] teste = tokens[1].split(" ",-1);
						 n = Double.parseDouble(teste[0]);
						 latencias[limite] = n;
						 limite++;
					 }	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return latencias;
		}
	
	public static void AdicionarRegioes(HashMap<Regioes, FileDownloader> mapaLinks) {
		mapaLinks.put(Regioes.BRASIL, 
				new FileDownloader("http://pet.inf.ufsc.br/mirrors/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.AUSTRALIA, 
				new FileDownloader("http://ftp.swin.edu.au/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.FRANCA, 
				new FileDownloader("http://archlinux.vi-di.fr/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.RUSSIA, 
				new FileDownloader("http://mirror.rol.ru/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.EUA, 
				new FileDownloader("http://mirror.cc.columbia.edu/pub/linux/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.CHINA, 
				new FileDownloader("https://mirrors.neusoft.edu.cn/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.JAPAO, 
				new FileDownloader("http://ftp.tsukuba.wide.ad.jp/Linux/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.ALEMANHA, 
				new FileDownloader("http://mirror.23media.de/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
			
	}
	
	public static void main(String[] args) throws IOException{
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " +     
            cliente.getInetAddress().getHostAddress()
        );

        HashMap<Regioes, FileDownloader> mapaLinks = new HashMap<Regioes, FileDownloader>();
        
        AdicionarRegioes(mapaLinks);
        
        Scanner s = new Scanner(cliente.getInputStream());
        
        while (s.hasNextLine()) {
        		String l = s.nextLine();
            System.out.println(l);
            	
            if (l.equals("la")) {          
            	for(Regioes reg : Regioes.values()) {
            		mapaLinks.get(reg).start();
            	}
        	}
        }
        s.close();
        servidor.close();
        cliente.close();
		
	}
}
	

