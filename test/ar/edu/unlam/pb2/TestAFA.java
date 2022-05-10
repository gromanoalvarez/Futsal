/**
 * 
 */
package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author German Romano Alvarez
 *
 */
public class TestAFA {
	
	@Test
	public void queSePuedanAgregarEquiposAlTorneo() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_EQUIPOS_AGREGADOS_ESPERADOS=1;
		
		assertTrue(sistemaAfa.agregarEquipo(river));
		assertEquals(CANTIDAD_EQUIPOS_AGREGADOS_ESPERADOS, sistemaAfa.getCantidadDeEquiposAgregados());
	}
	
	@Test
	public void queSePuedanAgregarJugadoresALosEquipos() {
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS=1;

		assertTrue(river.agregarJugador("Enzo",1,15000.0, 30));
		assertEquals(CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS, river.getCantidadDeJugadoresAgregados());
	}
	
	@Test
	public void queSePuedaCalcularCorrectamenteElValorDelEquipo() {
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS=5;
		final Double PRECIO_TOTAL_EQUIPO_ESPERADO=75000.0;

		assertTrue(river.agregarJugador("Enzo",1,15000.0,30));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,30));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,30));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,30));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,30));
		assertEquals(CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS, river.getCantidadDeJugadoresAgregados());
		assertEquals(PRECIO_TOTAL_EQUIPO_ESPERADO, river.getPrecioTotalEquipo(), 0.01);
	}
	
	@Test
	public void queSePuedaCalcularCorrectamenteLaEdadPromedioDelEquipo() {
		Equipo river = new Equipo("River Plate", 5);
		final Double EDAD_PROMEDIO_EQUIPO_ESPERADO=25.6;

		assertTrue(river.agregarJugador("Enzo",1,15000.0,30));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,20));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,25));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,35));
		assertTrue(river.agregarJugador("Enzo",1,15000.0,18));
		assertEquals(EDAD_PROMEDIO_EQUIPO_ESPERADO, river.getPromedioEdadEquipo(), 0.01);
	}
	
	@Test
	public void queSePuedaCrearUnNuevoPartidoConLocalYVisitante() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);

		assertNotNull(sistemaAfa.registrarNuevoPartido(river, boca));
	}
	
	@Test
	public void queSeRegistreElAutorYMinutoDelGol() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String AUTOR_Y_MINUTO_ESPERADO="Enzo ha marcado el gol a los 00:15 minutos";
		final Integer CANTIDAD_DE_GOLES_MARCADOS_ESPERADOS=1;

		river.agregarJugador("Enzo",1,15000.0,30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);
		String nombreDelAutorYMinuto=clasico.marcarGol(river, river.getJugadorSegunOrdenDelFichaje(0));
		
		assertEquals(AUTOR_Y_MINUTO_ESPERADO, nombreDelAutorYMinuto);
		assertEquals(CANTIDAD_DE_GOLES_MARCADOS_ESPERADOS, river.getGolesTotales());
	}
	
	@Test
	public void queSePuedaAmonestarUnJugadorYSeaRetornadoJuntoAlMinutoDeLaFalta() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String MENSAJE_ESPERADO= "Se ha amonestado a Enzo a los 66min";
		final Integer CANTIDAD_DE_AMONESTADOS_ESPERADOS=1;

		river.agregarJugador("Enzo",5,15000.0,30);
		river.agregarJugador("armani",1,15000.0,30);
		river.agregarJugador("casco",7,15000.0,30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);
		
		assertEquals(MENSAJE_ESPERADO, clasico.amonestacionDeJugadores(river.getJugadorSegunOrdenDelFichaje(0)));
		assertEquals(CANTIDAD_DE_AMONESTADOS_ESPERADOS, (Integer)clasico.amonestados.size());
	}
	
	@Test
	public void queCuandoUnJugadorTengaDobleAmonestaciónSeaExpulsadoDelPartido() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String MENSAJE_ESPERADO= "Se ha expulsado a casco por doble amonestación a los 41 min";
		final Integer CANTIDAD_DE_EXPULSADOS_ESPERADOS=1;
		final Integer CANTIDAD_DE_AMONESTADOS_ESPERADOS=0;

		river.agregarJugador("Enzo",5,15000.0,30);
		river.agregarJugador("armani",1,15000.0,30);
		river.agregarJugador("casco",7,15000.0,30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);
		
		Jugador amonestado = river.getJugadorSegunOrdenDelFichaje(2);
		//primera amonestacion
		clasico.amonestacionDeJugadores(amonestado);
		
		//segunda amonestacion
		assertEquals(MENSAJE_ESPERADO, clasico.amonestacionDeJugadores(amonestado));
		assertEquals(CANTIDAD_DE_AMONESTADOS_ESPERADOS, (Integer)clasico.amonestados.size());
		assertEquals(CANTIDAD_DE_EXPULSADOS_ESPERADOS, (Integer)clasico.expulsados.size());	
	}
	
	@Test
	public void queSePuedaConocerLaListaDeExpulsados() {
		//ya sea por doble amonestacion o por falta directa
	}
	
	@Test
	public void queSePuedaConocerElResumenDelPartido() {
		//resultado
		//autoresDeGoles
		//amonestados
		//expulsados
	}
	

}
