package laCasaDelLibro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSV {

	public static void importarCSV() {

		File f = new File("./ArchivoCSV");
		if (!f.exists()) {
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String linea = "";
			if (br.ready()) {
				br.readLine();
				while (br.ready()) {

					linea = br.readLine();

					String[] libroDesmontado = linea.split(",");
					if(libroDesmontado.length==5) {
					String ISBNprov = libroDesmontado[0];
					String tituloprov = libroDesmontado[1];
					String Autorprov = libroDesmontado[2];
					int cantidadprov = Integer.valueOf(libroDesmontado[3]);
					String urlImagenprov = libroDesmontado[4];

					Main.listaLibros.add(new Libro(ISBNprov, tituloprov, Autorprov, cantidadprov, urlImagenprov));

					}
				}
			}
			br.close();
		} catch (NumberFormatException e) {
			System.err.println("Error de formato"+e.getMessage());
			System.exit(10);
		} catch (FileNotFoundException e) {
			System.err.println("File not found"+e.getMessage());
			System.exit(11);
		} catch (IOException e) {
			System.err.println("Error de E/S"+e.getMessage());
			System.exit(13);
		}
	}

	public static void exportarCSV() {

		File f = new File("./ArchivoCSV");
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
			bw.write("ISBN,Titulo,Autor,Stock,Url_imagen_Caratula");
			bw.newLine();
			bw.flush();
			for (Libro libroImportar : Main.listaLibros) {

				bw.write(libroImportar.getISBN() + "," + libroImportar.getTitulo() + "," + libroImportar.getAutor()
						+ "," + libroImportar.getCantidad() + "," + libroImportar.getUrlImagen());
				bw.newLine();
				bw.flush();
			}
			bw.close();
		} catch (IOException e) {
			System.exit(13);
		}
	}

}
