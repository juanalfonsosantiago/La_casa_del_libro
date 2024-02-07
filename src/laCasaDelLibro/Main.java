package laCasaDelLibro;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static ArrayList<Libro> listaLibros=new ArrayList<Libro>();
	
	public static void main(String[] args) {
		
		Libro libro1 = new Libro("9780345803481", "Ready Player One", "Ernest Cline", 20, "https://imagessl9.casadellibro.com/a/l/s7/79/9788466649179.webp");
        Libro libro2 = new Libro("9780439064873", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 30, "https://imagessl9.casadellibro.com/a/l/s7/69/9781408855669.webp");
        Libro libro3 = new Libro("9780451524935", "1984", "George Orwell", 25, "https://imagessl4.casadellibro.com/a/l/s7/44/9788499890944.webp");
        Libro libro4 = new Libro("9780140283334", "Fight Club", "Chuck Palahniuk", 15, "https://imagessl5.casadellibro.com/a/l/s7/55/9781448114955.webp");
        Libro libro5 = new Libro("9780307474278", "The Girl with the Dragon Tattoo", "Stieg Larsson", 10, "https://imagessl6.casadellibro.com/a/l/s7/36/9780857054036.webp");
        Libro libro6 = new Libro("9780062457790", "The Alchemist", "Paulo Coelho", 35, "https://imagessl8.casadellibro.com/a/l/s7/68/9783966619868.webp");
        Libro libro7 = new Libro("9780307887443", "The Lean Startup", "Eric Ries", 40, "https://imagessl1.casadellibro.com/a/l/s7/81/9783963134081.webp");
        Libro libro8 = new Libro("9781591847786", "Zero to One", "Peter Thiel", 30, "https://imagessl4.casadellibro.com/a/l/s7/04/9780753550304.webp");
        Libro libro9 = new Libro("9780062316110", "Thinking Fast and Slow", "Daniel Kahneman", 20, "https://imagessl0.casadellibro.com/a/l/s7/70/9780141033570.webp");
        Libro libro10 = new Libro("9780062225672", "Divergent", "Veronica Roth", 25, "https://imagessl9.casadellibro.com/a/l/s7/79/9788413141879.webp");
        	
		listaLibros.addAll(Arrays.asList(libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,libro9,libro10));
		
		
		System.out.println(listaLibros);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setTitle("La Casa del Libro - Pagina Principal");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
