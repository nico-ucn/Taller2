package Taller2;
//Nicolas Maximo Lucero Bruna-22.221.136-0-nico-ucn


import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {

	static ArrayList<Pokemon> pokedexGlobal = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		cargarPokedex();
		
		
		System.out.println(pokedexGlobal.size());
		
		
		
		
		
	}

	public static void cargarPokedex() {
		try {
			File archivo = new File("Pokedex.txt");
			Scanner lector = new Scanner(archivo);
			
			while(lector.hasNextLine()){
				String linea = lector.nextLine();
				String[] datos = linea.split(";");
				
				String nombre = datos[0];
				String habitat = datos[1];
				double porcentajeAparicion = Double.parseDouble(datos[2]);
				int vida = Integer.parseInt(datos[3]);
				int ataque = Integer.parseInt(datos[4]);
				int defensa = Integer.parseInt(datos[5]);
				int ataqueEsp = Integer.parseInt(datos[6]);
				int defensaEsp = Integer.parseInt(datos[7]);
				int velocidad = Integer.parseInt(datos[8]);
				String tipo = datos[9];
				
				
				Pokemon nuevoPokemon = new Pokemon(nombre,habitat,porcentajeAparicion,vida,ataque,defensa,ataqueEsp,defensaEsp,velocidad,tipo,"vivo");
				
				pokedexGlobal.add(nuevoPokemon);
				
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error grave: no se encontro el archivo de Pokedex.txt");
		}
		
	}

	
	
	
	
	
	
}
