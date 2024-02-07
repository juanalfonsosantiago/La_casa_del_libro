package laCasaDelLibro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Dialog.ModalityType;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.BoxLayout;

public class ListarLibros extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private JLabel labelTitulo;
	private JLabel labelTituloListarLibros;
	private JTable table;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ListarLibros dialog = new ListarLibros();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ListarLibros() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // PUEDE QUE ESTE EL PROBLEMA ACÁ
		setBounds(100, 100, 691, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(57, 81, 68), 17));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		logo();

		tituloVentana();

	}

	private void logo() {
		ImageIcon imageIcon = new ImageIcon("./images/logo-b.png");
		JLabel labelImgLogo = new JLabel(imageIcon);
		labelImgLogo.setBounds(39, 28, 193, 65);
		contentPane.add(labelImgLogo);
	}

	private void tituloVentana() {
		labelTituloListarLibros = new JLabel("Listar Libros  ");
		labelTituloListarLibros.setForeground(new Color(57, 81, 68));
		labelTituloListarLibros.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelTituloListarLibros.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTituloListarLibros.setBounds(386, 28, 259, 53);
		contentPane.add(labelTituloListarLibros);

		JButton ayuda = new JButton("Crear Libro");
		ayuda.setForeground(new Color(255, 255, 255));
		ayuda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ayuda.setBackground(new Color(57, 81, 68));
		ayuda.setBounds(39, 374, 238, 27);

		tabla();

		JButton btnImportarCSV = new JButton("Importar CSV");
		btnImportarCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CSV.importarCSV();
			}
		});
		btnImportarCSV.setBackground(new Color(170, 139, 86));
		btnImportarCSV.setBounds(386, 92, 115, 34);
		contentPane.add(btnImportarCSV);

		JButton btnExportarCsv = new JButton("Exportar CSV");
		btnExportarCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CSV.exportarCSV();
			}
		});
		btnExportarCsv.setBackground(new Color(170, 139, 86));
		btnExportarCsv.setBounds(511, 92, 115, 35);
		contentPane.add(btnExportarCsv);
	}

	private void tabla() {

		int contador = 0;

		JPanel p1 = new JPanel();


		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 592, 26);

		p1.add(panel);

		JLabel nº = new JLabel();
		nº.setHorizontalAlignment(SwingConstants.CENTER);
		nº.setPreferredSize(new Dimension(80, 20));
		nº.setMaximumSize(new Dimension(80, 20));
		nº.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(nº);
		nº.setText("Nº");

		JLabel isbn = new JLabel();
		isbn.setHorizontalAlignment(SwingConstants.CENTER);
		isbn.setPreferredSize(new Dimension(145, 20));
		isbn.setMaximumSize(new Dimension(145, 20));
		isbn.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(isbn);
		isbn.setText("ISBN");

		JLabel nombreLibro = new JLabel();
		nombreLibro.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLibro.setPreferredSize(new Dimension(155, 20));
		nombreLibro.setMaximumSize(new Dimension(155, 20));
		nombreLibro.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(nombreLibro);
		nombreLibro.setText("Titulo");

		JLabel vermas = new JLabel();
		vermas.setHorizontalAlignment(SwingConstants.CENTER);
		vermas.setPreferredSize(new Dimension(120, 20));
		vermas.setMaximumSize(new Dimension(120, 20));
		vermas.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(vermas);
		vermas.setText("Ver mas");


		int contadorLibros = 0;
		for (Libro libro : Main.listaLibros) {

			contadorLibros++;
			JPanel datosLibro = new JPanel();
			JLabel datoN = new JLabel();
			
			datoN.setPreferredSize(new Dimension(80, 20));
			datoN.setMaximumSize(new Dimension(80, 20));
			datoN.setFont(new Font("Dialog", Font.PLAIN, 16));
			datosLibro.add(datoN);
			datoN.setText(String.valueOf(contadorLibros));

			JLabel datoISBN = new JLabel();

			datoISBN.setPreferredSize(new Dimension(145, 20));
			datoISBN.setMaximumSize(new Dimension(145, 20));
			datoISBN.setFont(new Font("Dialog", Font.PLAIN, 16));
			datosLibro.add(datoISBN);
			datoISBN.setText(libro.getISBN());

			JLabel nombreLibro2 = new JLabel();
		
			nombreLibro2.setPreferredSize(new Dimension(155, 20));
			nombreLibro2.setMaximumSize(new Dimension(155, 20));
			nombreLibro2.setFont(new Font("Dialog", Font.PLAIN, 16));
			datosLibro.add(nombreLibro2);
			nombreLibro2.setText(libro.getTitulo());

			JButton btnVerMas = new JButton("Detalles");
			btnVerMas.setBackground(new Color(57, 81, 68));
			btnVerMas.setForeground(new Color(255, 255, 255));
			datosLibro.add(btnVerMas);
			btnVerMas.addActionListener(e -> {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {					
							VerMasLibro listarLibros = new VerMasLibro(libro);
							listarLibros.setTitle("La Casa del Libro - Listar Libros");
							listarLibros.setModalityType(ModalityType.APPLICATION_MODAL);
							listarLibros.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			});
			p1.add(datosLibro);

		}

		JScrollPane scroll = new JScrollPane(p1);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBackground(new Color(192, 192, 192));
		scroll.setBounds(39, 138, 592, 264);

//		frame.add(scroll, BorderLayout.NORTH);

		contentPane.add(scroll, BorderLayout.NORTH);

	}
}
