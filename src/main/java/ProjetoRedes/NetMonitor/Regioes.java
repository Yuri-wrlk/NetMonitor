package ProjetoRedes.NetMonitor;

public enum Regioes {

	BRASIL("Brasil"),
	AUSTRALIA("Australia"),
	FRANCA("França"),
	RUSSIA("Russia"),
	EUA("Estados Unidos"),
	CHINA("China"),
	JAPAO("Japao"),
	ALEMANHA("Alemanha");
	
	private String text;
	
	Regioes (String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return this.text;
	}

}
