package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import ProjetoRedes.NetMonitor.Cliente;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MainWindow {

	private JFrame frame;
	private JTextField txDownloadBR;
	private JTextField tempoMedioBR;
	private JTextField latenciaBR;
	private JTextField txDownloadEUA;
	private JTextField tempoMedioEUA;
	private JTextField latenciaEUA;
	private JTextField txDownloadRU;
	private JTextField tempoMedioRU;
	private JTextField latenciaRU;
	private JTextField txDownloadJP;
	private JTextField tempoMedioJP;
	private JTextField latenciaJP;
	private JTextField tempoMedioALE;
	private JTextField latenciaALE;
	private JTextField txDownloadCH;
	private JTextField tempoMedioCH;
	private JTextField latenciaCH;
	private JTextField txDownloadFR;
	private JTextField tempoMedioFR;
	private JTextField latenciaFR;
	private JTextField txDownloadAU;
	private JTextField tempoMedioAU;
	private JTextField latenciaAU;
	private JLabel lblStatusConexao;
	private final Action action = new SwingAction();

	private static Cliente mainCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		try {
			mainCliente = new Cliente();
			if(mainCliente.isConnected()){
				lblStatusConexao.setText("Conectado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 689, 432);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_brasil = new JPanel();
		panel_brasil.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_brasil);
		panel_brasil.setLayout(null);
		
		JPanel panel_brasil_dados = new JPanel();
		panel_brasil_dados.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_brasil_dados.setBackground(SystemColor.control);
		panel_brasil_dados.setBounds(10, 36, 152, 169);
		panel_brasil.add(panel_brasil_dados);
		
		JLabel lblNewLabel = new JLabel("Taxa Download");
		panel_brasil_dados.add(lblNewLabel);
		
		txDownloadBR = new JTextField();
		panel_brasil_dados.add(txDownloadBR);
		txDownloadBR.setColumns(12);
		
		JLabel lblTempoMdio = new JLabel("Tempo Médio");
		panel_brasil_dados.add(lblTempoMdio);
		
		tempoMedioBR = new JTextField();
		tempoMedioBR.setColumns(12);
		panel_brasil_dados.add(tempoMedioBR);
		
		JLabel lblLatncia = new JLabel("Latência");
		panel_brasil_dados.add(lblLatncia);
		
		latenciaBR = new JTextField();
		latenciaBR.setColumns(12);
		panel_brasil_dados.add(latenciaBR);
		
		JLabel lblBrasil = new JLabel("BRASIL");
		lblBrasil.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrasil.setBounds(65, 11, 46, 14);
		panel_brasil.add(lblBrasil);
		
		JPanel panel_australia = new JPanel();
		panel_australia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_australia);
		panel_australia.setLayout(null);
		
		JLabel lblEua = new JLabel("EUA");
		lblEua.setHorizontalAlignment(SwingConstants.CENTER);
		lblEua.setBounds(61, 11, 46, 14);
		panel_australia.add(lblEua);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 36, 152, 169);
		panel_australia.add(panel_2);
		
		JLabel label = new JLabel("Taxa Download");
		panel_2.add(label);
		
		txDownloadEUA = new JTextField();
		txDownloadEUA.setColumns(12);
		panel_2.add(txDownloadEUA);
		
		JLabel label_1 = new JLabel("Tempo Médio");
		panel_2.add(label_1);
		
		tempoMedioEUA = new JTextField();
		tempoMedioEUA.setColumns(12);
		panel_2.add(tempoMedioEUA);
		
		JLabel label_2 = new JLabel("Latência");
		panel_2.add(label_2);
		
		latenciaEUA = new JTextField();
		latenciaEUA.setColumns(12);
		panel_2.add(latenciaEUA);
		
		JPanel panel_russia = new JPanel();
		panel_russia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_russia);
		panel_russia.setLayout(null);
		
		JLabel lblRussia = new JLabel("RUSSIA");
		lblRussia.setHorizontalAlignment(SwingConstants.CENTER);
		lblRussia.setBounds(62, 11, 46, 14);
		panel_russia.add(lblRussia);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(10, 36, 152, 169);
		panel_russia.add(panel_3);
		
		JLabel label_3 = new JLabel("Taxa Download");
		panel_3.add(label_3);
		
		txDownloadRU = new JTextField();
		txDownloadRU.setColumns(12);
		panel_3.add(txDownloadRU);
		
		JLabel label_4 = new JLabel("Tempo Médio");
		panel_3.add(label_4);
		
		tempoMedioRU = new JTextField();
		tempoMedioRU.setColumns(12);
		panel_3.add(tempoMedioRU);
		
		JLabel label_5 = new JLabel("Latência");
		panel_3.add(label_5);
		
		latenciaRU = new JTextField();
		latenciaRU.setColumns(12);
		panel_3.add(latenciaRU);
		
		JPanel panel_japao = new JPanel();
		panel_japao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_japao);
		panel_japao.setLayout(null);
		
		JLabel lblJapo = new JLabel("JAPÃO");
		lblJapo.setHorizontalAlignment(SwingConstants.CENTER);
		lblJapo.setBounds(68, 11, 46, 14);
		panel_japao.add(lblJapo);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBounds(10, 36, 152, 169);
		panel_japao.add(panel_4);
		
		JLabel label_6 = new JLabel("Taxa Download");
		panel_4.add(label_6);
		
		txDownloadJP = new JTextField();
		txDownloadJP.setColumns(12);
		panel_4.add(txDownloadJP);
		
		JLabel label_7 = new JLabel("Tempo Médio");
		panel_4.add(label_7);
		
		tempoMedioJP = new JTextField();
		tempoMedioJP.setColumns(12);
		panel_4.add(tempoMedioJP);
		
		JLabel label_8 = new JLabel("Latência");
		panel_4.add(label_8);
		
		latenciaJP = new JTextField();
		latenciaJP.setColumns(12);
		panel_4.add(latenciaJP);
		
		JPanel panel_alemanha = new JPanel();
		panel_alemanha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_alemanha);
		panel_alemanha.setLayout(null);
		
		JLabel lblAlemanha = new JLabel("ALEMANHA");
		lblAlemanha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlemanha.setBounds(45, 11, 68, 14);
		panel_alemanha.add(lblAlemanha);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_8.setBackground(SystemColor.menu);
		panel_8.setBounds(10, 36, 152, 169);
		panel_alemanha.add(panel_8);
		
		JLabel label_9 = new JLabel("Taxa Download");
		panel_8.add(label_9);
		
		JTextField txDownloadALE = new JTextField();
		txDownloadALE.setColumns(12);
		panel_8.add(txDownloadALE);
		
		JLabel label_10 = new JLabel("Tempo Médio");
		panel_8.add(label_10);
		
		tempoMedioALE = new JTextField();
		tempoMedioALE.setColumns(12);
		panel_8.add(tempoMedioALE);
		
		JLabel label_11 = new JLabel("Latência");
		panel_8.add(label_11);
		
		latenciaALE = new JTextField();
		latenciaALE.setColumns(12);
		panel_8.add(latenciaALE);
		
		JPanel panel_china = new JPanel();
		panel_china.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_china);
		panel_china.setLayout(null);
		
		JLabel lblChina = new JLabel("CHINA");
		lblChina.setHorizontalAlignment(SwingConstants.CENTER);
		lblChina.setBounds(54, 11, 68, 14);
		panel_china.add(lblChina);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_5.setBackground(SystemColor.menu);
		panel_5.setBounds(10, 36, 152, 169);
		panel_china.add(panel_5);
		
		JLabel label_12 = new JLabel("Taxa Download");
		panel_5.add(label_12);
		
		txDownloadCH = new JTextField();
		txDownloadCH.setColumns(12);
		panel_5.add(txDownloadCH);
		
		JLabel label_13 = new JLabel("Tempo Médio");
		panel_5.add(label_13);
		
		tempoMedioCH = new JTextField();
		tempoMedioCH.setColumns(12);
		panel_5.add(tempoMedioCH);
		
		JLabel label_14 = new JLabel("Latência");
		panel_5.add(label_14);
		
		latenciaCH = new JTextField();
		latenciaCH.setColumns(12);
		panel_5.add(latenciaCH);
		
		JPanel panel_franca = new JPanel();
		panel_franca.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_franca);
		panel_franca.setLayout(null);
		
		JLabel lblFrana = new JLabel("FRANÇA");
		lblFrana.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrana.setBounds(50, 11, 68, 14);
		panel_franca.add(lblFrana);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_6.setBackground(SystemColor.menu);
		panel_6.setBounds(10, 36, 152, 169);
		panel_franca.add(panel_6);
		
		JLabel label_15 = new JLabel("Taxa Download");
		panel_6.add(label_15);
		
		txDownloadFR = new JTextField();
		txDownloadFR.setColumns(12);
		panel_6.add(txDownloadFR);
		
		JLabel label_16 = new JLabel("Tempo Médio");
		panel_6.add(label_16);
		
		tempoMedioFR = new JTextField();
		tempoMedioFR.setColumns(12);
		panel_6.add(tempoMedioFR);
		
		JLabel label_17 = new JLabel("Latência");
		panel_6.add(label_17);
		
		latenciaFR = new JTextField();
		latenciaFR.setColumns(12);
		panel_6.add(latenciaFR);
		
		JPanel panel_australia_1 = new JPanel();
		panel_australia_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_australia_1);
		panel_australia_1.setLayout(null);
		
		JLabel lblAustralia = new JLabel("AUSTRALIA");
		lblAustralia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAustralia.setBounds(56, 11, 68, 14);
		panel_australia_1.add(lblAustralia);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_7.setBackground(SystemColor.menu);
		panel_7.setBounds(10, 36, 152, 169);
		panel_australia_1.add(panel_7);
		
		JLabel label_18 = new JLabel("Taxa Download");
		panel_7.add(label_18);
		
		txDownloadAU = new JTextField();
		txDownloadAU.setColumns(12);
		panel_7.add(txDownloadAU);
		
		JLabel label_19 = new JLabel("Tempo Médio");
		panel_7.add(label_19);
		
		tempoMedioAU = new JTextField();
		tempoMedioAU.setColumns(12);
		panel_7.add(tempoMedioAU);
		
		JLabel label_20 = new JLabel("Latência");
		panel_7.add(label_20);
		
		latenciaAU = new JTextField();
		latenciaAU.setColumns(12);
		panel_7.add(latenciaAU);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciar.setAction(action);
		btnIniciar.setBounds(145, 471, 89, 23);
		frame.getContentPane().add(btnIniciar);
		
		JButton btnBaixar = new JButton("Baixar");
		btnBaixar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBaixar.setBounds(487, 471, 89, 23);
		frame.getContentPane().add(btnBaixar);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(316, 446, 46, 14);
		frame.getContentPane().add(lblStatus);
		
		lblStatusConexao = new JLabel("Offline");
		lblStatusConexao.setBounds(358, 446, 89, 14);
		frame.getContentPane().add(lblStatusConexao);
		
		JButton btnLatencias = new JButton("Latências");
		btnLatencias.setBounds(305, 471, 109, 23);
		btnLatencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainCliente.CalcularLatencias();
			}
		});
		frame.getContentPane().add(btnLatencias);
		frame.setBounds(100, 100, 739, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction {
		
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Iniciar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			mainCliente.iniciarDownload();
		    System.out.println("Debug!");
		}
	}
}
