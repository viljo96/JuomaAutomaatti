import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Käyttöliittymä extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTable table;
	private JPanel panel_1;
	private JButton btnLisRivi;
	private JButton btnPoistaRivi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Käyttöliittymä frame = new Käyttöliittymä();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Käyttöliittymä() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea txtrTietokannanSislt = new JTextArea();
		txtrTietokannanSislt.setText("Tietokannan sis\u00E4lt\u00F6");
		contentPane.add(txtrTietokannanSislt, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		table = new JTable();
		panel.add(table);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnLisRivi = new JButton("Lis\u00E4\u00E4 rivi");
		btnLisRivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame lisaa = new JFrame();
				FlowLayout sijoittelija = new FlowLayout();
				lisaa.getContentPane().setLayout(sijoittelija);
				lisaa.setSize(300,300);
				lisaa.setTitle("tietosivu");
				lisaa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				lisaa.setVisible(true);
			}
		});
		panel_1.add(btnLisRivi);
		
		btnPoistaRivi = new JButton("Poista rivi");
		btnPoistaRivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnPoistaRivi);
	}

}
