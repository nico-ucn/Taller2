package Taller2;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		cargarPokedex();
		
		
		
		
	}

	public static void cargarPokedex() {
		try {
			File archivo = new File("Pokedex.txt");
			Scanner lector = new Scanner(archivo);
			
			while(lector.hasNextLine());{
				String linea = lector.nextLine();
				String[] datos = linea.split(";");
				
				String nombre = datos[0];
				String habitat = datos[1];
				double probAparicion = Double.parseDouble(datos[2]);
				int vida = Integer.parseInt(datos[3]);
				int ataque = Integer.parseInt(datos[4]);
				int defensa = Integer.parseInt(datos[5]);
				int atqEspecial = Integer.parseInt(datos[6]);
				int defEspecial = Integer.parseInt(datos[7]);
				int velocidad = Integer.parseInt(datos[8]);
				String tipo = datos[9];
				
				
				
			}
			lector.close();
		}
		
	}

	
	
	
	
	
	
}
