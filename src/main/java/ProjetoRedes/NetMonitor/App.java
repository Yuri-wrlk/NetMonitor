package ProjetoRedes.NetMonitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class App {
  public static void main(String[] args) {

    //Criando Classe cliente para receber arquivo
    App cliente = new App();

    //Solicitando arquivo
    cliente.getFileFromServeR();
  }

  private void getFileFromServeR() {
    Socket sockServer = null;
    FileOutputStream fos = null;
    InputStream is = null;

    try {
      // Criando conexão com o servidor
      System.out.println("Conectando com Servidor porta 13267");
      sockServer = new Socket("10.9.99.18", 13267);
      is = sockServer.getInputStream();

      // Cria arquivo local no cliente
      fos = new FileOutputStream(new File(System.getProperty("user.home") +"/Downloads/archlinux-64bit.iso"));
      System.out.println("Arquivo Local Criado "+ System.getProperty("user.home") +"/Downloads/archlinux-64bit.iso");
      
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
      if (sockServer != null) {
        try {
          sockServer.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }

      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }

      if (is != null) {
        try {
          is.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    }

  }
}