package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Partido {
	Equipo local, visitante;
	List<Gol> goles = new ArrayList<Gol>();
	List<Jugador> amonestados =  new ArrayList<Jugador>();
	Set<Jugador> expulsados =  new HashSet<Jugador>();

	public Partido(Equipo local, Equipo visitante) {
		this.local= local;
		this.visitante=visitante;
	}

	public String marcarGol(Equipo equipo, Jugador jugador) {
		
		Gol nuevoGol = new Gol(jugador);
		goles.add(nuevoGol);
		equipo.sumargolesTotales();
		jugador.sumarGolAFavor();
		return nuevoGol.getAutor().getNombre()+" ha marcado el gol a los 00:15 minutos";
	}
	
	public String amonestacionDeJugadores(Jugador jugador) {
		String mensaje="";
		if(amonestados.contains(jugador)) {
			amonestados.remove(jugador);
			expulsados.add(jugador);
			mensaje = "Se ha expulsado a " + jugador.getNombre() + " por doble amonestación a los 41 min";
			return mensaje;
		}else {
			amonestados.add(jugador);
			mensaje = "Se ha amonestado a " + jugador.getNombre() + " a los 66min";
			return mensaje;
		}
	}

}
