package ProjetoRedes.NetMonitor;

import java.io.*;



/**
 * Hello world!
 *
 */
public class App 
{
	  public static void runSystemCommand(String command) {

			try {
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader inputStream = new BufferedReader(
						new InputStreamReader(p.getInputStream()));

				String s = "";
			
				while ((s = inputStream.readLine()) != null) {
					System.out.println(s);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			
			String ip = "overleaf.com";
			runSystemCommand("ping " + ip);

		
		}
}

