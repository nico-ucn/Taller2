package Taller2;

public class Gimnasio extends Rival{
private int numeroGimnasio;
private int cantPokemons;


	public Gimnasio(int numeroGimnasio,String nombre, String estado, int cantPokemons) {
		super(nombre, estado);
		
		this.numeroGimnasio = numeroGimnasio;
		this.cantPokemons = cantPokemons;
	}
	
	public int getNumeroGimnasio() {
		return this.numeroGimnasio;
	}
	
	public int getCantPokemons() {
		return this.cantPokemons;
	}
	
}
