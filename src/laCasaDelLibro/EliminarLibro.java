package laCasaDelLibro;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import java.awt.GridLayout;

public class EliminarLibro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private static CardLayout tarjetas;
	private static JPanel panelCard;
	private static JPanel panelSinLibro;
	private static JPanel panelInfoLibro;
	private JTextPane textPaneISBNLibro;
	private JTextPane textPaneTituloLibro;
	private JTextPane textPaneAutorLibro;
	private JLabel labelCantidadLibro;
	private JLabel labelTitulo;
	private JLabel labelTituloListarLibros;
	private JLabel labelImagenLibro;
	private static JTextField tf_buscar;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarLibro dialog = new EliminarLibro();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public EliminarLibro() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //PUEDE QUE ESTE EL PROBLEMA ACÁ
		setBounds(100, 100, 691, 481);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(57, 81, 68), 17));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logo();
		
		tituloVentana();

		tf_buscar = new JTextField();
		tf_buscar.setBounds(462, 234, 175, 39);
		getContentPane().add(tf_buscar);
		tf_buscar.setColumns(10);

		tarjetas = new CardLayout();
		panelCard = new JPanel();
		panelCard.setBounds(39, 122, 403, 284);
		contentPane.add(panelCard);
		panelCard.setLayout(tarjetas);
		
		panelSinLibro();
		
		panelInfoLibro();
		
		tituloLibro();
		
		autorLibro();
		
		isbnLibro();
		
		cantidadLibro();
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setForeground(new Color(255, 255, 255));
		btn_buscar.setBounds(462, 284, 175, 33);
		btn_buscar.setBackground(new Color(57, 81, 68));
		getContentPane().add(btn_buscar);
		btn_buscar.addActionListener(e -> {
			buscarLibro(Main.listaLibros);
			errores();
			JLabel datos_libro = new JLabel("");
			datos_libro.setBounds(63, 42, 152, 155);
			getContentPane().add(datos_libro);
			Libro libroFinal = buscarLibro(Main.listaLibros);

			if (libroFinal != null) {
				
				if(!panelInfoLibro.isShowing()) {
					tarjetas.next(panelCard);
				}
				//TRANSFORMAR JLABEL A JTEXTAREA PARA SOPORTE MULTILINEA
				textPaneTituloLibro.setText(libroFinal.getTitulo());
				textPaneAutorLibro.setText(libroFinal.getAutor());
				textPaneISBNLibro.setText("ISBN: "+libroFinal.getISBN());
				labelCantidadLibro.setText("Cantidad: "+libroFinal.getCantidad()+"");
				
//				String dl = "ISBN: " + libroFinal.getISBN() + "\nTítulo: " + libroFinal.getTitulo() + "\nAutor: "
//						+ libroFinal.getAutor() + "\nStock " + libroFinal.getCantidad() + "\nURL"
//						+ libroFinal.getUrlImagen();
				
				imagenLibro(libroFinal.getUrlImagen());
				
//				datos_libro.setText(dl);
			} else {
				if(panelInfoLibro.isShowing()) {
					tarjetas.next(panelCard);
				}
			}
		});
		{
			lblNewLabel = new JLabel("Busca un libro por su titulo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(462, 202, 175, 21);
			contentPane.add(lblNewLabel);
		}

	}

	private void panelInfoLibro() {
		panelInfoLibro = new JPanel();
		panelCard.add(panelInfoLibro, "name_416572730188500");
		panelInfoLibro.setLayout(null);
	}

	private void cantidadLibro() {
	}

	private void isbnLibro() {
	}

	private void autorLibro() {
	}

	private void tituloLibro() {
		{
			panel = new JPanel();
			panel.setBounds(186, 21, 207, 252);
			panelInfoLibro.add(panel);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			textPaneTituloLibro = new JTextPane();
			panel.add(textPaneTituloLibro);
			textPaneTituloLibro.setEditable(false);
			textPaneTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textPaneTituloLibro.setText("Titulo");
			textPaneTituloLibro.setOpaque(false);
			textPaneTituloLibro.setEnabled(true);
			textPaneAutorLibro = new JTextPane();
			textPaneAutorLibro.setEditable(false);
			panel.add(textPaneAutorLibro);
			textPaneAutorLibro.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textPaneAutorLibro.setText("Autor");
			textPaneAutorLibro.setOpaque(false);
			textPaneISBNLibro = new JTextPane();
			textPaneISBNLibro.setEditable(false);
			panel.add(textPaneISBNLibro);
			textPaneISBNLibro.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textPaneISBNLibro.setText("ISBN");
			textPaneISBNLibro.setOpaque(false);
			labelCantidadLibro = new JLabel("Cantidad");
			panel.add(labelCantidadLibro);
			labelCantidadLibro.setFont(new Font("Tahoma", Font.PLAIN, 15));
			

			
			JButton btn_eliminar = new JButton("Eliminar libro");
			panel.add(btn_eliminar);
			btn_eliminar.setBackground(new Color(248, 102, 102));
			
			btn_eliminar.addActionListener(e -> {
				eliminarLibro(Main.listaLibros);
			});
		}
	}

	private void imagenLibro(String enlace) {
		URL enlaceImagen;
		ImageIcon icon;
		Image image;
		
		try {
		    enlaceImagen = new URL(enlace);
		    icon = new ImageIcon(enlaceImagen);
		    image = icon.getImage();
		} catch (MalformedURLException e1) {
			icon = new ImageIcon("images/error.png");
		    image = icon.getImage();
		    System.err.println(e1.getMessage());
		}

		if(labelImagenLibro != null) {
		    panelInfoLibro.remove(labelImagenLibro);
		    panelInfoLibro.repaint();
		}
		labelImagenLibro = new JLabel();
		labelImagenLibro.setBounds(10, 23, 152, 250);

		image = image.getScaledInstance(labelImagenLibro.getWidth(), labelImagenLibro.getHeight(), Image.SCALE_DEFAULT);
		labelImagenLibro.setIcon(new ImageIcon(image));
		panelInfoLibro.add(labelImagenLibro);
		
//		try {
//			enlaceImagen = new URL(enlace);
//			icon = new ImageIcon(enlaceImagen);
//			image = icon.getImage();
//			
//			if(labelImagenLibro != null) {
//			    panelInfoLibro.remove(labelImagenLibro);
//			    panelInfoLibro.repaint();
//			}
//			labelImagenLibro = new JLabel();
//			labelImagenLibro.setBounds(10, 23, 152, 250);
//
//			image = image.getScaledInstance(labelImagenLibro.getWidth(), labelImagenLibro.getHeight(), image.SCALE_DEFAULT);
//			labelImagenLibro.setIcon(new ImageIcon(image));
//			panelInfoLibro.add(labelImagenLibro);
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//		}
	}

	private void panelSinLibro() {
		panelSinLibro = new JPanel();
		panelSinLibro.setBackground(new Color(255, 255, 255));
		panelCard.add(panelSinLibro, "name_416572718344900");
		panelSinLibro.setLayout(null);
		
		ImageIcon imageIllustration = new ImageIcon("./images/reading-book.png");
		Image image = imageIllustration.getImage();
		
		JLabel labelImagenSinLibro = new JLabel();
		labelImagenSinLibro.setBounds(10, 11, 383, 262);
		
		image = image.getScaledInstance(labelImagenSinLibro.getWidth(), labelImagenSinLibro.getHeight(), Image.SCALE_SMOOTH);
		labelImagenSinLibro.setIcon(new ImageIcon(image));
		panelSinLibro.add(labelImagenSinLibro);
	}

	public static Libro buscarLibro(ArrayList<Libro> listaLibros) {
		for (int i = 0; i < listaLibros.size(); i++) {
			if (listaLibros.get(i).getTitulo().equalsIgnoreCase(tf_buscar.getText())) {
				Libro libro = listaLibros.get(i);
				return libro;
			}
		}
		return null;
	}

	public static void eliminarLibro(ArrayList<Libro> listaLibros) {
		if (tf_buscar.getText().length() == 0) {
			errores();
		} else {
			for (int i = 0; i < listaLibros.size(); i++) {
				Libro libroTemp = buscarLibro(listaLibros);
				if (libroTemp != null) {
					if (buscarLibro(listaLibros).getTitulo().equalsIgnoreCase(listaLibros.get(i).getTitulo())) {
						listaLibros.remove(listaLibros.get(i));
						JOptionPane.showMessageDialog(null, "Libro eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
						if(panelInfoLibro.isShowing()) {
							tarjetas.next(panelCard);
						}
					}
				}
			}
		}
	}
		

	public static void errores() {
		String error1 = "El libro no existe";
		String error2 = "Debe rellenar el campo";
		Libro l = buscarLibro(Main.listaLibros);
		if (l == null && tf_buscar.getText().length() != 0) {
			JOptionPane.showMessageDialog(null, error1, "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE);
		}
		if (tf_buscar.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, error2, "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void logo() {
		ImageIcon imageIcon = new ImageIcon("./images/logo-b.png");
		JLabel labelImgLogo = new JLabel(imageIcon);
		labelImgLogo.setBounds(39, 28, 193, 65);
		contentPane.add(labelImgLogo);
	}

	private void tituloVentana() {
		labelTituloListarLibros = new JLabel("Eliminar Libro");
		labelTituloListarLibros.setForeground(new Color(57, 81, 68));
		labelTituloListarLibros.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelTituloListarLibros.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTituloListarLibros.setBounds(386, 28, 259, 53);
		contentPane.add(labelTituloListarLibros);
		

		
	}
}
