package ar.edu.unlam.pb2;

public class Jugador {
	
	private String nombre;
	private Integer camiseta, edad, golAFavor;
	private Double valor;

	public Jugador(String nombre, Integer camiseta, Double valor, Integer edad) {
		this.nombre=nombre;
		this.camiseta=camiseta;
		this.valor=valor;
		this.edad=edad;
		golAFavor=0;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getEdad() {
		return edad;
	}

	public void sumarGolAFavor() {
		golAFavor++;
	}

	public String getNombre() {
		return nombre;
	}
	
	

}
