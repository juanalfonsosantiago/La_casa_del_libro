package laCasaDelLibro;

public class Libro {

	// ---- Atributos ----//

	private String ISBN = "";
	private String titulo = "";
	private String Autor = "";
	private int cantidad = 0;
	private String urlImagen = "";

	// ----- Metodos ------//

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", Autor=" + Autor + ", cantidad=" + cantidad
				+ ", urlImagen=" + urlImagen + "]";
	}

	// -----Constructores-----//

	public Libro(String iSBN, String titulo, String autor, int cantidad, String urlImagen) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		Autor = autor;
		this.cantidad = cantidad;
		this.urlImagen = urlImagen;
	}

	public Libro(String iSBN, String titulo, String autor, int cantidad) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		Autor = autor;
		this.cantidad = cantidad;
	}

	// ----- Setters && Getters -----//

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

}
