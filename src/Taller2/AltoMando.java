package Taller2;

public class AltoMando extends Rival{
	
	private int numeroMando;
	
	public AltoMando(int numeroMando, String nombre) {
		super(nombre,"Sin derrotar");
		
		this.numeroMando = numeroMando;
	}
	
	public int getNumeroMando() {
		return this.numeroMando;
	}
	
}
