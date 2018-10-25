package tekstiEditori;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class Tekstieditori extends JFrame {

	private JPanel contentPane;
	private JEditorPane editorPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tekstieditori frame = new Tekstieditori();
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
	public Tekstieditori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				valintaikkuna.setApproveButtonText("Avaa tiedosto");
				valintaikkuna.setDialogTitle("Tiedoston valinta");
				
				String rivi= "";
				String uusiTiedosto=valintaikkuna.getSelectedFile().getAbsolutePath();
				Scanner lukija=null;
				File tiedosto = new File(uusiTiedosto);
				

				try {
					lukija=new Scanner(tiedosto);
					while(lukija.hasNextLine()) {
						rivi+=lukija.nextLine()+"\n";
						System.out.println(rivi);
					}
					}
				
				catch(Exception p){
					System.out.println("Tiedostoa ei löydy "+p);
					
				}
				editorPane.setText(rivi);

				}
			});
		
		mntmAvaa.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/java/swing/plaf/motif/icons/TreeOpen.gif")));
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);
		
		JMenuItem mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser valintaikkuna =new JFileChooser();
				valintaikkuna.showSaveDialog(null);
				String uusiTiedosto=valintaikkuna.getSelectedFile().getAbsolutePath();
				System.out.println("Kirjoitettava tiedosto:" + uusiTiedosto);
				try {
					PrintWriter writer=new PrintWriter("tiedosto.txt");
					String sisalto = editorPane.getText();
					
					writer.println(sisalto);
					
					writer.flush();
					writer.close();
				}catch(Exception e1) {
					System.out.println("Tiedoston tallentamisessa tapahtui virhe!");
					e1.printStackTrace();
				}
			}
		});
		mntmTallenna.setIcon(new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmTallenna);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmLopeta.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		mntmLopeta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmLopeta);
		
		JMenuItem mntmSulje = new JMenuItem("Sulje");
		mntmSulje.setIcon(new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmSulje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_CANCEL, 0));
		mnTiedosto.add(mntmSulje);
		
		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);
		
		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sisalto=editorPane.getText();
				sisalto=sisalto.toLowerCase();
				String haettava= "auto";
				int indeksi = sisalto.indexOf(haettava);
				System.out.println("indeksi: "+indeksi);
				
				editorPane.setSelectionColor(Color.YELLOW);
				editorPane.setSelectionStart(indeksi);
				editorPane.setSelectionEnd(indeksi+haettava.length()
				);
			}
		});
		mntmEtsi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmEtsi.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		mnMuokkaa.add(mntmEtsi);
		
		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sisalto=editorPane.getText();
				sisalto=sisalto.toLowerCase();
				String haettava= "auto";
				String korvaava="mopo";
				int indeksi = sisalto.indexOf(haettava);
				System.out.println("indeksi: "+indeksi);
				String uusiSisalto=sisalto.replaceAll(haettava, korvaava);
				System.out.println(uusiSisalto);
				editorPane.setText(uusiSisalto);
				
				
				
			}
		});
		mntmKorvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmKorvaa.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		mnMuokkaa.add(mntmKorvaa);
		
		JMenu mnTietoa = new JMenu("Tietoa");
		menuBar.add(mnTietoa);
		
		JMenuItem mntmTietoaSovelluksesta = new JMenuItem("Tietoa sovelluksesta");
		mntmTietoaSovelluksesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tietosivu = new JFrame();
				FlowLayout sijoittelija = new FlowLayout();
				tietosivu.getContentPane().setLayout(sijoittelija);
				tietosivu.setSize(300,300);
				tietosivu.setTitle("tietosivu");
				tietosivu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tietosivu.setVisible(true);
				
				JTextArea teksti = new JTextArea();
				teksti.setText("Tämän tekstieditorin kehittäjänä toimi \n Viljami Kittilä\n "
						+ "Olen toisen vuoden opiskelija Laurean ammattikorkeakoulussa\n"
						+ "Facebook profiilini voit löytää käyttämällä\n"
						+ "URL: https://www.facebook.com/viljami.kittila");
				
				tietosivu.getContentPane().add(teksti);
				

				

				
			}
		});
		mntmTietoaSovelluksesta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmTietoaSovelluksesta.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-information.png")));
		mnTietoa.add(mntmTietoaSovelluksesta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setToolTipText("");
		toolBar.setForeground(new Color(0, 0, 0));
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		toolBar.add(button_2);
		
		editorPane = new JEditorPane();
		contentPane.add(editorPane, BorderLayout.CENTER);
		
	}
	public JEditorPane getEditorPane() {
		return editorPane;
	}
}
