package ar.edu.unlam.pb2;


public class Partido {
	Equipo local, visitante;
	
	
	public Partido(Equipo local, Equipo visitante) {
		this.local= local;
		this.visitante=visitante;
	}

	public String marcarGol(Equipo equipo, Jugador jugador) {
		
		Gol nuevoGol = new Gol(jugador);
		equipo.sumargolesTotales();
		jugador.sumarGolAFavor();
		return nuevoGol.getAutor().getNombre()+" ha marcado el gol a los 00:15 minutos";
	}

}
