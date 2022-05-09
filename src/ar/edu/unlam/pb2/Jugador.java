package ar.edu.unlam.pb2;

public class Jugador {
	
	private String nombre;
	private Integer camiseta;
	private Double valor;

	public Jugador(String nombre, Integer camiseta, Double valor) {
		this.nombre=nombre;
		this.camiseta=camiseta;
		this.valor=valor;
	}

	public Double getValor() {
		return valor;
	}
	
	

}
