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
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingConstants;



public class CrearLibro extends JDialog {
	
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
	String error11 = "El ISBN ya existe, introduzca otro.";
	String error12 = "Debe contener una extensión real de imagen.";
	
	ArrayList <String> extensiones = new ArrayList<String>();
	
	
		
		String contenido1 ="png";
		String contenido2 = "jpg"; 
		String contenido3 = "jpeg";
		String contenido4 = "gif";
		String contenido5 = "webp";
	
	public void anadirExtensiones() {
		
		extensiones.add("png");
		extensiones.add("jpg");
		extensiones.add("jpeg");
		extensiones.add("gif");
		extensiones.add("webp");
	}

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
	private JLabel labelTituloCrear;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CrearLibro frame = new CrearLibro();
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
	public CrearLibro() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //PUEDE QUE ESTE EL PROBLEMA ACÁ
		setBounds(100, 100, 691, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(57, 81, 68), 17));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		anadirExtensiones();
		
		logo();
		
		isbn();
		

		
		titulo();
		
		autor();
		
		cantidad();
		
		enlaceImagen();
		
		botonCrear();
		
		ImageIcon imageIllustration = new ImageIcon("./images/Bookshop-ill.png");
		JLabel lblNewLabel_6 = new JLabel(imageIllustration);
		lblNewLabel_6.setBounds(360, 103, 285, 298);
		contentPane.add(lblNewLabel_6);
		
		labelTituloCrear = new JLabel("Crear Libro  ");
		labelTituloCrear.setForeground(new Color(57, 81, 68));
		labelTituloCrear.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelTituloCrear.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTituloCrear.setBounds(452, 28, 193, 53);
		contentPane.add(labelTituloCrear);
	}

	private void logo() {
		ImageIcon imageIcon = new ImageIcon("./images/logo-b.png");
		JLabel labelImgLogo = new JLabel(imageIcon);
		labelImgLogo.setBounds(39, 28, 193, 65);
		contentPane.add(labelImgLogo);
	}

	private void titulo() {
		labelTitulo = new JLabel("Titulo");
		labelTitulo.setBounds(39, 158, 81, 14);
		contentPane.add(labelTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setToolTipText("");
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(39, 174, 238, 27);
		contentPane.add(textFieldTitulo);
		
	}

	private void isbn() {
		JLabel labelISBN = new JLabel("ISBN");
		labelISBN.setBounds(39, 104, 81, 14);
		contentPane.add(labelISBN);	
		
		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(39, 120, 238, 27);
		contentPane.add(textFieldISBN);
		textFieldISBN.setColumns(10);
	}

	private void autor() {
		labelNombreAutor = new JLabel("Nombre Autor");
		labelNombreAutor.setBounds(39, 212, 81, 14);
		contentPane.add(labelNombreAutor);
		
		textFieldNombreAutor = new JTextField();
		textFieldNombreAutor.setToolTipText("");
		textFieldNombreAutor.setColumns(10);
		textFieldNombreAutor.setBounds(39, 228, 238, 27);
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
		contentPane.add(textFieldEnlaceImagen);
	}

	private void botonCrear() {
		
		JButton btnCrearLibro = new JButton("Crear Libro");
		btnCrearLibro.setForeground(new Color(255, 255, 255));
		btnCrearLibro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCrearLibro.setBackground(new Color(57, 81, 68));
		btnCrearLibro.setBounds(39, 374, 238, 27);
		contentPane.add(btnCrearLibro);
		
		btnCrearLibro.addActionListener(e->{
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
			}else {
				Libro nuevoLibro = new Libro(isbn,titulo,nombre,cantidad,url);
				Main.listaLibros.add(nuevoLibro);
				JOptionPane.showMessageDialog(null, "Se ha creado el libro correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				
				System.out.println(Main.listaLibros.toString());
				System.out.println(Main.listaLibros.size());
				
				
			}
		
			
		});
		
		 
	}
	
	
	public void comprobarISBN(String isbn) {
		if(isbn.length()!=13) {
			listaErrores.add(error1);
		}
		if(isbn.contains(",")) {
			listaErrores.add(error7);
		}
		for (Libro l : Main.listaLibros) {
			if (l.getISBN().equals(isbn)) {
				listaErrores.add(error11);
				break;
			}
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
		
	
		String [] enlacePartido = enlace.split("\\.");
		System.out.println(enlace);
		System.out.println(Arrays.toString(enlacePartido));
		if(enlacePartido.length> 0) {
			
			
			if(!extensiones.contains(enlacePartido[enlacePartido.length-1])) {
				listaErrores.add(error12);
			}
		}
		
		
	}

	
}
