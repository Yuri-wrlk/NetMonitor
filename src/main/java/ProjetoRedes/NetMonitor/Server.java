package ProjetoRedes.NetMonitor;
import java.io.*;
import java.net.*;
import java.util.*;

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
            System.out.println(s.nextLine());
        }

        s.close();
        servidor.close();
        cliente.close();
		
	}
	
	
}
