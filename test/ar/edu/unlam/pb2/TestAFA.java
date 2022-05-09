/**
 * 
 */
package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
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

		assertTrue(river.agregarJugador("Enzo",1,15000.0));
		assertEquals(CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS, river.getCantidadDeJugadoresAgregados());
	}
	
	@Test
	public void queSePuedaCalcularCorrectamenteElValorDelEquipo() {
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS=5;
		final Double PRECIO_TOTAL_EQUIPO_ESPERADO=75000.0;

		assertTrue(river.agregarJugador("Enzo",1,15000.0));
		assertTrue(river.agregarJugador("Enzo",1,15000.0));
		assertTrue(river.agregarJugador("Enzo",1,15000.0));
		assertTrue(river.agregarJugador("Enzo",1,15000.0));
		assertTrue(river.agregarJugador("Enzo",1,15000.0));
		assertEquals(CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS, river.getCantidadDeJugadoresAgregados());
		assertEquals(PRECIO_TOTAL_EQUIPO_ESPERADO, river.getPrecioTotalEquipo(), 0.01);
	}

}
