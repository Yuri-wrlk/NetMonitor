package ProjetoRedes.NetMonitor;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
	private Socket cliente;

	private void solicita_arquivo() throws IOException {
		Socket sockServer = null;
		FileOutputStream fos = null;
		InputStream is = null;

		try {
			// Criando conexão com o servidor
			System.out.println("Conectando com Servidor porta 13267");
			sockServer = new Socket("127.0.0.1", 13267);
			is = sockServer.getInputStream();

			// Cria arquivo local no cliente
			fos = new FileOutputStream(new File(System.getProperty("user.home") + "/Downloads/archlinux-64bit.iso"));
			System.out.println(
					"Arquivo Local Criado " + System.getProperty("user.home") + "/Downloads/archlinux-64bit.iso");

			// Prepara variaveis para transferencia
			byte[] cbuffer = new byte[1024];
			int bytesRead;

			// Copia conteudo do canal
			System.out.println("Recebendo arquivo...");
			while ((bytesRead = is.read(cbuffer)) != -1) {
				fos.write(cbuffer, 0, bytesRead);
				fos.flush();
			}
			System.out.println("Arquivo recebido!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sockServer != null)
				sockServer.close();
			if (fos != null)
				fos.close();
			if (is != null)
				is.close();

		}

	}

	public void iniciarCliente() throws IOException {
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao servidor!");

		Scanner teclado = new Scanner(System.in);

		teclado.close();
		cliente.close();
	}

	public void iniciarDownload() {
		PrintStream saida = null;
		try {
			saida = new PrintStream(this.cliente.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		saida.println("la");

		saida.close();
	}
}
