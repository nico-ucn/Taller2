package Taller2;
import java.util.ArrayList;

public class Jugador {

	private String nombreJugador;
	private int medallas;
	private Pokemon[] equipo;
	private ArrayList<Pokemon> pc;
	
	public Jugador(String nombreJugador, int medallas) {
		
		this.nombreJugador = nombreJugador;
		this.medallas = medallas;
		this.equipo = new Pokemon[6];
		this.pc = new ArrayList<>();
		
	}
	
	public String getnombreJugador() {
		return this.nombreJugador;
	}
	
	public int getMedallas() {
		return this.medallas;
	}
	public Pokemon[] getEquipo() {
		return this.equipo;
	}
	public ArrayList getPc() {
		return this.pc;
	}
	
	public void setMedallas(int medallas) {
		this.medallas = medallas;
	}
	public void curarEquipo() {
		for ( int i =0;  i < equipo.length; i++) {
			
			if (equipo[i] != null){
				
				equipo[i].setEstado("Vivo");
			}
		}
	}
}
