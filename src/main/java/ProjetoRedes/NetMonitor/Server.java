package ProjetoRedes.NetMonitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
	/**
	 * Função para aguardar o envio do arquivo.
	 *
	 **/
	public void envia_server() throws IOException {

		OutputStream socketOut = null;
		ServerSocket servsock = null;
		FileInputStream fileIn = null;

		try {

			// Abrindo porta para conexao de clients
			servsock = new ServerSocket(13267);
			System.out.println("Porta de conexao aberta 13267");

			// Cliente conectado
			Socket sock = servsock.accept();
			System.out.println("Conexao recebida pelo cliente");

			// Criando tamanho de leitura
			byte[] cbuffer = new byte[1024];
			int bytesRead;

			// Criando arquivo que sera transferido pelo servidor

			File file = new File(System.getProperty("user.home") + "/Desktop/archlinux-64bit.iso");
			fileIn = new FileInputStream(file);
			System.out.println("Lendo arquivo...");

			// Criando canal de transferencia
			socketOut = sock.getOutputStream();
			// Lendo arquivo criado e enviado para o canal de transferencia

			System.out.println("Enviando Arquivo...");
			while ((bytesRead = fileIn.read(cbuffer)) != -1) {
				socketOut.write(cbuffer, 0, bytesRead);
				socketOut.flush();
			}
			System.out.println("Arquivo Enviado!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socketOut != null)
				socketOut.close();
			if (servsock != null)
				servsock.close();
			if (fileIn != null)
				fileIn.close();
		}
	}

	/**
	 * Método para calcular a latência. Ao chamar o método passe o domínio por
	 * ex.:google.com O método retorna um array de latências, para ser mais
	 * específico 10 latências para que possa calcular médias... depois...
	 */

	public static double[] latencia(String command) {
		double[] latencias = new double[10];
		String s;
		int limite = 0;
		double n = 0;
		try {
			Process p = Runtime.getRuntime().exec("ping " + command);
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = inputStream.readLine()) != null && limite != 10) {
				String[] tokens = s.split("time=", -1);
				if (tokens.length == 2) {
					String[] teste = tokens[1].split(" ", -1);
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

	public static void adicionarRegioes(HashMap<Regioes, FileDownloader> mapaLinks) {
		mapaLinks.put(Regioes.BRASIL, new FileDownloader(Regioes.BRASIL.toString(),
				"http://pet.inf.ufsc.br/mirrors/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.AUSTRALIA, new FileDownloader(Regioes.AUSTRALIA.toString(),
				"http://ftp.swin.edu.au/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.FRANCA, new FileDownloader(Regioes.FRANCA.toString(),
				"http://archlinux.vi-di.fr/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.RUSSIA, new FileDownloader(Regioes.RUSSIA.toString(),
				"http://mirror.rol.ru/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.EUA, new FileDownloader(Regioes.EUA.toString(),
				"http://mirror.cc.columbia.edu/pub/linux/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.CHINA, new FileDownloader(Regioes.CHINA.toString(),
				"https://mirrors.neusoft.edu.cn/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.JAPAO, new FileDownloader(Regioes.JAPAO.toString(),
				"http://ftp.tsukuba.wide.ad.jp/Linux/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));
		mapaLinks.put(Regioes.ALEMANHA, new FileDownloader(Regioes.ALEMANHA.toString(),
				"http://mirror.23media.de/archlinux/iso/2018.05.01/archlinux-2018.05.01-x86_64.iso"));

	}

	public static void iniciarThreads(HashMap<Regioes, FileDownloader> mapaLinks) {
		for (Regioes reg : Regioes.values()) {
			System.out.println("Iniciando thread de download da região: " + reg.toString());
			mapaLinks.get(reg).start();
		}
	}

	public static void calcularLatencias(HashMap<Regioes, double[]> mapalatencias) {
		mapalatencias.put(Regioes.BRASIL, latencia("pet.inf.ufsc.br"));
		mapalatencias.put(Regioes.AUSTRALIA, latencia("ftp.swin.edu.au"));
		mapalatencias.put(Regioes.FRANCA, latencia("archlinux.vi-di.fr"));
		mapalatencias.put(Regioes.RUSSIA, latencia("mirror.rol.ru"));
		mapalatencias.put(Regioes.EUA, latencia("mirror.cc.columbia.edu"));
		mapalatencias.put(Regioes.CHINA, latencia("mirrors.neusoft.edu.cn"));
		mapalatencias.put(Regioes.JAPAO, latencia("ftp.tsukuba.wide.ad.jp"));
		mapalatencias.put(Regioes.ALEMANHA, latencia("mirror.23media.de"));
	}

	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		Socket cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

		HashMap<Regioes, FileDownloader> mapaLinks = new HashMap<Regioes, FileDownloader>();
		HashMap<Regioes, double[]> mapalatencias = new HashMap<Regioes, double[]>();

		adicionarRegioes(mapaLinks);

		Scanner s = new Scanner(cliente.getInputStream());

		while (s.hasNextLine()) {
			String l = s.nextLine();
			System.out.println(l);
			ObjectOutputStream lat_out = new ObjectOutputStream(cliente.getOutputStream());

			if (l.equals("gg")) {
				System.out.println("teste");
				lat_out.writeObject(mapalatencias);
			}
			if (l.equals("dl")) {
				adicionarRegioes(mapaLinks);
				iniciarThreads(mapaLinks);
				
				
			}
			;
			if (l.equals("la")) {

				calcularLatencias(mapalatencias);

				// Fazer asssim no lado cliente...
				double[] aux = mapalatencias.get(Regioes.BRASIL);
				double media = 0.0;
				for (int i = 0; i < aux.length; i++) {
					media += aux[i];
				}
				media = media / 10;

				double variancia = 0.0;

				for (int i = 0; i < aux.length; i++) {
					variancia += Math.pow((aux[i] - media), 2);
				}

				variancia = variancia / 9;

				double desvio_padrao = Math.sqrt(variancia);

				System.out.println("Desvio " + desvio_padrao);

			}
		}
		s.close();
		servidor.close();
		cliente.close();

	}
}
