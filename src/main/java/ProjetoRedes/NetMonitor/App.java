package ProjetoRedes.NetMonitor;

import java.io.*;
import java.util.StringTokenizer;



/**
 * Hello world!
 *
 */
public class App 
{
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

		public static void main(String[] args) {
			
			String ip = "ftp.jaist.ac.jp";
			double[] y = latencia(ip);
			
			for (int i = 0; i < y.length; i++) {
				System.out.println(y[i]);
			}
			
		}
}

