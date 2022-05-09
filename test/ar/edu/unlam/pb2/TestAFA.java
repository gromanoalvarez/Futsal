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
		final Integer CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS=5;
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

}
