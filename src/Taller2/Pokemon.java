package Taller2;

public class Pokemon {

	private String nombre;
	private String habitat;
	private double porcentajeAparicion;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;
	private String estado;
	
	public Pokemon (String nombre, String habitat, Double porcentajeAparicion,int vida,int ataque, int defensa,int ataqueEsp,int defensaEsp,int velocidad, String tipo, String estado) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		if (vida < 0) {
			this.vida = 0;
		}
		else{
			this.vida = vida;
		}
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getHabitat() {
		return habitat;
	}
	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}
	public int getVida() {
		return vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}
	public int getDefensaEspecial() {
		return defensaEspecial;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public String getTipo() {
		return tipo;
	}
	public String getEstado() {
		return estado;
	}
	
	public void  setEstado(String estado) {
		this.estado = estado;
	}
	
	public void sumarStats() {
	
	}
	 
	
	
	
}
