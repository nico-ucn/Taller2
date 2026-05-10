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
		cargarHabitats();
		cargarGimnasio();
		cargarAltoMando();
		 
		
		menuInicial();
		
		
		
		
		
		
	}
	
	
	public static void menuInicial() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ INICIAL ===");
            System.out.println("1) Continuar.");
            System.out.println("2) Nueva Partida.");
            System.out.println("3) Salir.");
            System.out.print("Ingrese Opcion: ");
            
            
            String entradaUsuario = teclado.nextLine(); 
            
            try {
               
                opcion = Integer.parseInt(entradaUsuario);
            } catch (NumberFormatException e) {
               
                opcion = -1; 
            }

            switch (opcion) {
            case 1:
                System.out.println("");
                System.out.println("Cargando partida guardada...");
                cargarRegistros(); 
               
                if (jugadorActual != null) {
                    System.out.println("¡Bienvenido de vuelta, " + jugadorActual.getnombreJugador() + "!");
                    menuJuego(); 
                } else {
                    System.out.println("Error: No se encontró una partida guardada. Intente 'Nueva Partida'.");
                }
                break;
                
            case 2:
               System.out.println("");
                System.out.print("Ingrese su apodo de jugador: ");
                String apodo = teclado.nextLine(); 
                
               
                jugadorActual = new Jugador(apodo, 0); 
                
                System.out.println("¡Bienvenido " + apodo + "!!");
                menuJuego();
                break;
                
            case 3:
        
                System.out.println("¡Gracias por jugar! Cerrando el simulador...");
                break;
                
            default:
                System.out.println("Error: Por favor, ingrese un número válido del 1 al 3.");
        }

    } while (opcion != 3); 
}
	
	public static void menuJuego() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

       
        do {
            System.out.println( jugadorActual.getnombreJugador() + ", que deseas hacer?");
            System.out.println("1) Revisar equipo.");
            System.out.println("2) Salir a capturar.");
            System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
            System.out.println("4) Retar un gimnasio.");
            System.out.println("5) Desafío al Alto Mando.");
            System.out.println("6) Curar Pokémon.");
            System.out.println("7) Guardar.");
            System.out.println("8) Guardar y Salir.");
            System.out.print("Ingrese Opcion: ");
            
            try {
                
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; 
            }

            switch (opcion) {
                case 1:
                	System.out.println("");
                    System.out.println("--- REVISANDO EQUIPO ---");
                    // opción 1
                    break;
                case 2:
                	System.err.println("");
                    System.out.println("--- SALIENDO A CAPTURAR ---");
                    // opción 2
                    break;
                case 3:
                	System.out.println("");
                    System.out.println("--- ACCESO AL PC ---");
                    // opción 3
                    break;
                case 4:
                	System.out.println("");
                	System.out.println("--- RETAR GIMNASIO ---");
                    // opción 4
                    break;
                case 5:
                	System.out.println("");
                    System.out.println("--- ALTO MANDO ---");
                    //  opción 5
                    break;
                case 6:
                    
                    jugadorActual.curarEquipo();
                    System.out.println("");
                    System.out.println("¡Tu equipo se ha recuperado!");
                    break;
                case 7:
                	System.out.println("");
                    System.out.println("Guardando partida...");
                    // guardarPartida();
                    System.out.println("¡Partida guardada con éxito!");
                    break;
                case 8:
                	System.out.println("");
                    System.out.println("Guardando partida...");
                    // guardarPartida();
                    System.out.println("Nos vemos entrenador...");
                   
                    break;
                default:
                    System.out.println("Opción inválida. Ingresa un número del 1 al 8.");
            }

        } while (opcion != 8);
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

	
	public static void cargarAltoMando() {
        try {
            File archivo = new File("Alto Mando.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(";");

                int numMando = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                AltoMando nuevoMando = new AltoMando(numMando, nombre);

                
                for (int i = 0; i < 6; i++) {
                    String nombrePoke = datos[2 + i];
                    Pokemon p = buscadorStats(nombrePoke, "Vivo");
                    nuevoMando.agregarPokemonAlEquipo(p, i);
                }

                altoMandoGlobal.add(nuevoMando);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró Alto Mando.txt");
        }
    }
	
	public static void cargarRegistros() {
        try {
            File archivo = new File("Registros.txt");
            Scanner lector = new Scanner(archivo);


            if (lector.hasNextLine()) {
                String lineaJugador = lector.nextLine();
                String[] datosJugador = lineaJugador.split(";");
                jugadorActual = new Jugador(datosJugador[0], Integer.parseInt(datosJugador[1]));
            }


            int contadorEquipo = 0;

            while (lector.hasNextLine()) {
                String lineaPoke = lector.nextLine();
                String[] datosPoke = lineaPoke.split(";");
                
                String nombrePoke = datosPoke[0];
                String estadoPoke = datosPoke[1];
               
                Pokemon p = buscadorStats(nombrePoke, estadoPoke);

                
                if (contadorEquipo < 6) {
                    jugadorActual.getEquipo()[contadorEquipo] = p;
                    contadorEquipo++;
                } else {
                   
                    jugadorActual.getPc().add(p);
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró Registros.txt");
        }
    }
	
	
	
	
	
	
	
	
}

