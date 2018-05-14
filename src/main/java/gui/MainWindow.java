package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class MainWindow {

	private JFrame frame;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 450, 183);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_brasil = new JPanel();
		panel_brasil.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_brasil);
		panel_brasil.setLayout(null);
		
		ImagePanel brIcon = new ImagePanel("src/brazil-flag-round-xl.png");
		brIcon.setBounds(12, 12, 68, 27);
		panel_brasil.add(brIcon);
		
		
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(12, 40, 88, 39);
		panel_brasil.add(panel_9);
		
		JPanel panel_australia = new JPanel();
		panel_australia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_australia);
		panel_australia.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(12, 40, 88, 39);
		panel_australia.add(panel_10);
		
		JPanel panel_franca = new JPanel();
		panel_franca.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_franca);
		panel_franca.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(12, 40, 88, 39);
		panel_franca.add(panel_11);
		
		JPanel panel_russia = new JPanel();
		panel_russia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_russia);
		panel_russia.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(12, 40, 88, 39);
		panel_russia.add(panel_12);
		
		JPanel panel_eua = new JPanel();
		panel_eua.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_eua);
		panel_eua.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(12, 40, 88, 39);
		panel_eua.add(panel_13);
		
		JPanel panel_china = new JPanel();
		panel_china.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_china);
		panel_china.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(12, 40, 88, 39);
		panel_china.add(panel_14);
		
		JPanel panel_japao = new JPanel();
		panel_japao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_japao);
		panel_japao.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(12, 40, 88, 39);
		panel_japao.add(panel_15);
		
		JPanel panel_alemanha = new JPanel();
		panel_alemanha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_alemanha);
		panel_alemanha.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(12, 40, 88, 39);
		panel_alemanha.add(panel_16);
		frame.setBounds(100, 100, 484, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
