package ProjetoRedes.NetMonitor;

import java.io.*;
import java.util.StringTokenizer;



/**
 * Hello world!
 *
 */
public class App 
{
	  public static  double[] runSystemCommand(String command) {

		  	double [] latencias = new double [11];
			try {
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader inputStream = new BufferedReader(
						new InputStreamReader(p.getInputStream()));

				String s;
				int limite = 0;
				double n = 0;
				
				
				while ((s = inputStream.readLine()) != null && limite != 10) {
					
					
					 String[] tokens = s.split("time=",-1);
					 
					 if(tokens.length == 2) {
						 String[] teste = tokens[1].split(" ",-1);
						 n = Double.parseDouble(teste[0]);
//						 System.out.println(n+"limite "+ limite);
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
			double[] y = runSystemCommand("ping " + ip);
			
			
		}
}

