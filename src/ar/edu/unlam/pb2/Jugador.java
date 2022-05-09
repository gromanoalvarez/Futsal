package ar.edu.unlam.pb2;

public class Jugador {
	
	private String nombre;
	private Integer camiseta;
	private Double valor;
	private Integer edad;

	public Jugador(String nombre, Integer camiseta, Double valor, Integer edad) {
		this.nombre=nombre;
		this.camiseta=camiseta;
		this.valor=valor;
		this.edad=edad;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getEdad() {
		return edad;
	}
	
	

}
