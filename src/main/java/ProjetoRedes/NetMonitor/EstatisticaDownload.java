package ProjetoRedes.NetMonitor;

public class EstatisticaDownload {

	private String urlDownload;
	private String regiao;
	private double tamArqkb;	
	private double velocDownload;
	private double tempoMedioDownload;
	
	public String getUrlDownload() {
		return urlDownload;
	}
	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public double getTamArqkb() {
		return tamArqkb;
	}
	public void setTamArqkb(double tamArqkb) {
		this.tamArqkb = tamArqkb;
	}
	public double getVelocDownload() {
		return velocDownload;
	}
	public void setVelocDownload(double velocDownload) {
		this.velocDownload = velocDownload;
	}
	public double getTempoMedioDownload() {
		return tempoMedioDownload;
	}
	public void setTempoMedioDownload(double tempoMedioDownload) {
		this.tempoMedioDownload = tempoMedioDownload;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Região: "+ this.regiao +"/n");
		sb.append("URL: "+ this.urlDownload +"/n");
		sb.append("Tamanho Arquivo: "+ this.tamArqkb +"kb/n");
		sb.append("Velocidade: "+ this.velocDownload+"kbps/n");
		sb.append("Tempo Médio: "+ this.tempoMedioDownload+"s/n");
		return sb.toString();
	}

}
