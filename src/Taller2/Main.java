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
	static ArrayList<String> habitatsGlobales = new ArrayList<>();
	static ArrayList<Gimnasio> gimnasiosGlobales = new ArrayList<>();
	static ArrayList<AltoMando> altoMandoGlobal = new ArrayList<>();
	static Jugador jugadorActual;
	
	public static void main(String[] args) {
		
		
		cargarPokedex();
		
		 
		
		
		
		
		
		
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
		public static Pokemon buscadorStats(String nombreBuscado, String estado) {
			for (Pokemon p : pokedexGlobal) {
				if(p.getNombre().equals(nombreBuscado)) {
					return new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(),p.getVida(), p.getAtaque(), p.getDefensa(),p.getAtaqueEspecial(), p.getDefensaEspecial(),p.getVelocidad(), p.getTipo(), estado);
				}
			}
			return null;
		}
			
		
		
		public static void cargarHabitats() {
			try {
				File archivo = new File("Habitats.txt");
				Scanner lector = new Scanner(archivo);
				
				while (lector.hasNextLine()) {
					String linea = lector.nextLine();
					habitatsGlobales.add(linea);
				}
				lector.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Error: no se ha encontró Habitats.txt");
			
		}
		
			
			
		
	}

	public static void cargarGimnasio() {
		try {
			File archivo = new File("Gimnasios.txt");
			Scanner lector = new Scanner(archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] datos = linea.split(";");
				
				int numGimnasio = Integer.parseInt(datos[0]);
				String nombreLider = datos[1];
				String estado = datos[2];
				int cantPokemons = Integer.parseInt(datos[3]);
				
				
				Gimnasio nuevoGimnasio = new Gimnasio(numGimnasio,nombreLider,estado,cantPokemons );
				
				for(int i = 0 ; i < cantPokemons;i++) {
					String nombrePokemon = datos[4+i];
					Pokemon P = buscadorStats(nombrePokemon, "Vivo");
					nuevoGimnasio.agregarPokemonAlEquipo(P, i);
				}
				
				gimnasiosGlobales.add(nuevoGimnasio);
			}
			lector.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: no se encontro el archivo Gimnasios.txt");
	}
	
	
	
	}
	
}
