package ayds.tp1.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ayds.tp1.ej4.*;


public class Ej4Test {
	
	@Test
	public void test() {
		
		ProcesadorDeOrdenes procesador =  new ProcesadorDeOrdenes();
		assertEquals(NotificarPorMail.getInstance().ordenes.size(), 0);
		
		procesador.procesar(new Orden());
		
		assertEquals(NotificarPorMail.getInstance().ordenes.size(), 1);
	}

}
