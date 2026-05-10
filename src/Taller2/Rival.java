package Taller2;

public class Rival {

	protected String nombre;
	protected Pokemon[] equipo;
	protected String estado;
	
	
	public Rival(String nombre,String estado) {
		this.nombre = nombre;
		this.estado = estado;
		this.equipo = new Pokemon[6];
	}
		
		
		public String getNombre() {
			return this.nombre;
	}
	
	public String getEstado(){
		return this.estado;
	}
	
	public Pokemon[] getEquipo() {
		return this.equipo;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void agregarPokemonAlEquipo(Pokemon p, int posicion) {
		if (posicion >= 0 && posicion < 6) {
			this.equipo[posicion] = p;
		}
	}
	
	
}
