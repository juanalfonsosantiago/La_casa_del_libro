package laCasaDelLibro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.EventQueue;

public class VerMasLibro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private JPanel panelInfoLibro;
	private JLabel labelTitulo;
	private JLabel labelTituloListarLibros;
	private JTable table;
	private JLabel labelIsbn;
	private JLabel labelAutor;
	private JLabel labelStock;
	private static Libro libro;


	/**
	 * Create the dialog.
	 */
	public VerMasLibro(Libro libroVer) {
//		VerMasLibro.this.repaint();
		setModal(true);
		this.libro = libroVer;
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //PUEDE QUE ESTE EL PROBLEMA ACÁ
		setBounds(100, 100, 691, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(57, 81, 68), 17));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelInfoLibro = new JPanel();
		panelInfoLibro.setBounds(39, 105, 585, 298);
		contentPane.add(panelInfoLibro);
		panelInfoLibro.setLayout(null);
		
		//panelInfoLibro.add(panelInfoLibro);
		logo();
		
		tituloVentana();
		
		titulo();
		
		isbn();
		
		autor();
		
		stock();
		
		try {
			imagenLibro();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		botonModificar();
		
		botonEliminar();
		
		
	}
	
	private void logo() {
		ImageIcon imageIcon = new ImageIcon("./images/logo-b.png");
		JLabel labelImgLogo = new JLabel(imageIcon);
		labelImgLogo.setBounds(39, 28, 193, 65);
		contentPane.add(labelImgLogo);
	}

	private void tituloVentana() {
		labelTituloListarLibros = new JLabel("Ver Más  ");
		labelTituloListarLibros.setForeground(new Color(57, 81, 68));
		labelTituloListarLibros.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelTituloListarLibros.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTituloListarLibros.setBounds(386, 28, 259, 53);
		contentPane.add(labelTituloListarLibros);
		
	}
	
	private void titulo () {
		labelTitulo = new JLabel(libro.getTitulo());
		labelTitulo.setVerticalAlignment(SwingConstants.TOP);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		labelTitulo.setBounds(210, 30, 365, 51);
		panelInfoLibro.add(labelTitulo);
	}
	
	private void autor () {
		labelAutor = new JLabel(libro.getAutor());
		labelAutor.setFont(new Font("Segoe UI", Font.BOLD, 23));
		labelAutor.setBounds(210, 91, 225, 44);
		panelInfoLibro.add(labelAutor);
	}
	
	private void isbn () {
		labelIsbn = new JLabel(libro.getISBN());
		labelIsbn.setFont(new Font("Segoe UI", Font.BOLD, 24));
		labelIsbn.setBounds(210, 158, 225, 44);
		panelInfoLibro.add(labelIsbn);
	}
	
	private void stock () {
		labelStock = new JLabel("Stock: " + libro.getCantidad());
		labelStock.setFont(new Font("Segoe UI", Font.BOLD, 24));
		labelStock.setBounds(210, 216, 225, 44);
		panelInfoLibro.add(labelStock);
	}
	
	private void botonModificar () {
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(57, 81, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {					
							ModificarLibro modificarLibro = new ModificarLibro(libro);
							modificarLibro.setTitle("La Casa del Libro - Modificar Libro");
							modificarLibro.setModalityType(ModalityType.APPLICATION_MODAL);
							modificarLibro.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(439, 123, 136, 56);
		panelInfoLibro.add(btnNewButton);
	}
	
	private void botonEliminar () {
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(new Color(248, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.listaLibros.remove(libro);
				JOptionPane.showMessageDialog(null, "Libro eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				System.out.println(Main.listaLibros.size());
				VerMasLibro.this.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(439, 204, 136, 56);
		panelInfoLibro.add(btnNewButton);
	}
	
	
	private void imagenLibro() throws MalformedURLException {

		URL enlaceImagen = new URL(libro.getUrlImagen());
        ImageIcon icon = new ImageIcon(enlaceImagen);
        Image image = icon.getImage();
        
        JLabel imagenPortada = new JLabel();
        imagenPortada.setBounds(20, 20, 170, 240);
        
        image = image.getScaledInstance(imagenPortada.getWidth(), imagenPortada.getHeight(), Image.SCALE_DEFAULT);
        
		imagenPortada.setIcon(new ImageIcon(image));
		panelInfoLibro.add(imagenPortada);
		
	}
}