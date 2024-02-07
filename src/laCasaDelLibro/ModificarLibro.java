package laCasaDelLibro;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class ModificarLibro extends JDialog {
	
	public  ArrayList<String> listaErrores=new ArrayList<String>();
	String error1= "El ISBN tiene que tener 13 caracteres. ";
	String error2= "Introduce un título, está vacio. ";
	String error3 = "Introduce un autor, está vacío. ";
	String error4 = "Introduce una cantidad. ";
	String error5 = "Cantidad debe ser un número entero. ";
	String error6 = "Introduce el enlace de la imagen. ";
	String error7 = "El ISBN no puede contener comas. ";
	String error8 = "El título no puede contener comas. ";
	String error9 = "El autor no puede contener comas. ";
	String error10 = "El enlace no puede contener comas. ";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldISBN;
	private JLabel labelTitulo;
	private JTextField textFieldTitulo;
	private JLabel labelNombreAutor;
	private JTextField textFieldNombreAutor;
	private JLabel labelCantidad;
	private JTextField textFieldCantidad;
	private JLabel labelEnlaceImagen;
	private JTextField textFieldEnlaceImagen;
	private JLabel labelTituloModificar;
	private Libro libro;
//	private VerMasLibro verMas = new VerMasLibro();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModificarLibro frame = new ModificarLibro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ModificarLibro(Libro libroMod) {
		setModal(true);
		this.libro = libroMod;
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//PUEDE QUE ESTE EL PROBLEMA ACÁ
		setBounds(100, 100, 691, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(57, 81, 68), 17));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logo();
		
		isbn();
		
		titulo();
		
		autor();
		
		cantidad();
		
		enlaceImagen();
		
		botonModificar();
		
		tituloVentana();
		
		try {
			imagenLibro();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void logo() {
		ImageIcon imageIcon = new ImageIcon("./images/logo-b.png");
		JLabel labelImgLogo = new JLabel(imageIcon);
		labelImgLogo.setBounds(39, 28, 193, 65);
		contentPane.add(labelImgLogo);
	}

	private void tituloVentana() {
		labelTituloModificar = new JLabel("Modificar Libro  ");
		labelTituloModificar.setForeground(new Color(57, 81, 68));
		labelTituloModificar.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelTituloModificar.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTituloModificar.setBounds(386, 28, 259, 53);
		contentPane.add(labelTituloModificar);
	}

	private void imagenLibro() throws MalformedURLException {
		URL enlaceImagen = new URL(libro.getUrlImagen());
        ImageIcon icon = new ImageIcon(enlaceImagen);
        Image image = icon.getImage();
        
        JLabel imagenPortada = new JLabel();
        imagenPortada.setBounds(386, 104, 253, 298);
        
        image = image.getScaledInstance(imagenPortada.getWidth(), imagenPortada.getHeight(), Image.SCALE_DEFAULT);
        
		imagenPortada.setIcon(new ImageIcon(image));
		contentPane.add(imagenPortada);
	}

	private void isbn() {
		JLabel labelISBN = new JLabel("ISBN");
		labelISBN.setBounds(39, 104, 81, 14);
		contentPane.add(labelISBN);	
		
		textFieldISBN = new JTextField();
		textFieldISBN.setEditable(false);
		textFieldISBN.setBounds(39, 120, 238, 27);
		contentPane.add(textFieldISBN);
		textFieldISBN.setText(this.libro.getISBN());
		textFieldISBN.setColumns(10);
	}

	private void titulo() {
		labelTitulo = new JLabel("Titulo");
		labelTitulo.setBounds(39, 158, 81, 14);
		contentPane.add(labelTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setToolTipText("");
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(39, 174, 238, 27);
		textFieldTitulo.setText(this.libro.getTitulo());
		contentPane.add(textFieldTitulo);
	}

	private void autor() {
		labelNombreAutor = new JLabel("Nombre Autor");
		labelNombreAutor.setBounds(39, 212, 81, 14);
		contentPane.add(labelNombreAutor);
		
		textFieldNombreAutor = new JTextField();
		textFieldNombreAutor.setToolTipText("");
		textFieldNombreAutor.setColumns(10);
		textFieldNombreAutor.setBounds(39, 228, 238, 27);
		textFieldNombreAutor.setText(this.libro.getAutor());
		contentPane.add(textFieldNombreAutor);
	}

	private void cantidad() {
		labelCantidad = new JLabel("Cantidad");
		labelCantidad.setBounds(39, 267, 81, 14);
		contentPane.add(labelCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setToolTipText("");
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(39, 283, 238, 27);
		textFieldCantidad.setText(String.valueOf(this.libro.getCantidad()));
		contentPane.add(textFieldCantidad);
	}

	private void enlaceImagen() {
		labelEnlaceImagen = new JLabel("Enlace Imagen");
		labelEnlaceImagen.setBounds(39, 320, 105, 14);
		contentPane.add(labelEnlaceImagen);
		
		textFieldEnlaceImagen = new JTextField();
		textFieldEnlaceImagen.setToolTipText("");
		textFieldEnlaceImagen.setColumns(10);
		textFieldEnlaceImagen.setBounds(39, 336, 238, 27);
		textFieldEnlaceImagen.setText(this.libro.getUrlImagen());
		contentPane.add(textFieldEnlaceImagen);
	}

	private void botonModificar() {
		
		JButton btnModificarLibro = new JButton("Modificar Libro");
		btnModificarLibro.setForeground(new Color(255, 255, 255));
		btnModificarLibro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnModificarLibro.setBackground(new Color(57, 81, 68));
		btnModificarLibro.setBounds(39, 374, 238, 27);
		contentPane.add(btnModificarLibro);
		
		btnModificarLibro.addActionListener(e->{
			listaErrores.clear();

			String isbn = textFieldISBN.getText();
			comprobarISBN(isbn);
			String titulo = textFieldTitulo.getText();
			comprobarTitulo(titulo);
			String nombre = textFieldNombreAutor.getText();
			comprobarAutor(nombre);
			int cantidad = 0;
			try {
			 cantidad = Integer.parseInt(textFieldCantidad.getText());
			} catch (NumberFormatException e1) {
			listaErrores.add(error5);
			}
			String url = textFieldEnlaceImagen.getText();
			comprobarEnlace(url);
			String totalErrores="";
			if(listaErrores.size()>0) {
				for(String error : listaErrores) {
				 totalErrores+=error;
				}
				JOptionPane.showMessageDialog(null, totalErrores, "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE); //Crear alerta al crear el objeto correctamente (tambien lo puedes usar para debugear

				System.out.println(totalErrores);
			} else {
				JOptionPane.showMessageDialog(null, "Libro modificado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
			
			
			this.libro.setTitulo(titulo);
			this.libro.setAutor(nombre);
			this.libro.setCantidad(cantidad);
			this.libro.setUrlImagen(url);
			
			System.out.println(Main.listaLibros.toString());
			System.out.println(Main.listaLibros.size());
			}
			
		});
		
		//JOptionPane.showMessageDialog(null, "Este es un mensaje de alerta", "Correcto", JOptionPane.DEFAULT_OPTION); Crear alerta al crear el objeto correctamente (tambien lo puedes usar para debugear
	}
	
	public void comprobarISBN(String isbn) {
		if(isbn.length()!=13) {
			listaErrores.add(error1);
		}
		if(isbn.contains(",")) {
			listaErrores.add(error7);
		}
	}
	
	public void comprobarTitulo(String titulo) {
		if(titulo.length()==0) {
			listaErrores.add(error2);
		}
		if(titulo.contains(",")) {
			listaErrores.add(error8);
		}
	}
	
	
	public void comprobarAutor(String autor) {
		if (autor.length()==0){
			listaErrores.add(error3);
			
		}if(autor.contains(",")) {
			listaErrores.add(error9);
		}
	}
	
	public void comprobarEnlace(String enlace) {
		if(enlace.length()==0) {
			listaErrores.add(error6);
		}
		if(enlace.contains(",")) {
			listaErrores.add(error10);
		}
	}
	
}