package ar.edu.unlam.pb2;

public class Equipo {

	private String nombre;
	private Jugador jugadores[];
	private Integer cantidadDeJugadoresMaximo, cantidadDeJugadoresAgregados;

	public Equipo(String nombre, Integer cantidadDeJugadoresMaximo) {
		this.nombre = nombre;
		this.cantidadDeJugadoresMaximo=cantidadDeJugadoresMaximo;
		this.cantidadDeJugadoresAgregados=0;
		jugadores = new Jugador[cantidadDeJugadoresMaximo];
	}

	public boolean agregarJugador(String nombre, Integer numeroCamiseta) {
		Jugador candidatoAFichar = new Jugador(nombre, numeroCamiseta);
		if(cantidadDeJugadoresAgregados<cantidadDeJugadoresMaximo) {
			for (int i = 0; i < jugadores.length; i++) {
				if(jugadores[i]==null) {
					jugadores[i]=candidatoAFichar;
					cantidadDeJugadoresAgregados++;
					return true;
				}
			}
		}
		return false;
	}

	public Integer getCantidadDeJugadoresAgregados() {
		return cantidadDeJugadoresAgregados;
	}
	
	
	

}
