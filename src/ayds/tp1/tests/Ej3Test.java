package ayds.tp1.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ayds.tp1.ej3.*;

public class Ej3Test {

	@Test
	public void test() {
		
		Cliente clienteA = new Cliente();
		clienteA.nombre = "A";
		clienteA.localidad = Localidad.BAHIA_BLANCA;
		clienteA.saldo = 100;
		
		Cliente clienteB = new Cliente();
		clienteB.nombre = "B";
		clienteB.localidad = Localidad.NONE;
		clienteB.saldo = 0;
		
		Cliente clienteC = new Cliente();
		clienteC.nombre = "C";
		clienteC.localidad = Localidad.TRES_ARROYOS;
		clienteC.saldo = 200;

		LogicaClientes logicaClientes= new LogicaClientes();
		logicaClientes.getClientes().add(clienteA);
		logicaClientes.getClientes().add(clienteB);
		logicaClientes.getClientes().add(clienteC);
		
		List<Cliente> clientesBB = logicaClientes.getClientesPorLocalidad(Localidad.BAHIA_BLANCA);
		
		assertEquals(clientesBB.size(), 1);
		assertEquals(clientesBB.get(0).nombre ,"A");
		
		List<Cliente> clientesB = logicaClientes.getClientesPorNombre("B");
		
		assertEquals(clientesB.size(), 1);
		assertEquals(clientesB.get(0).nombre ,"B");
		
		List<Cliente> clientesSaldo = logicaClientes.getClientesConSaldo();
		
		assertEquals(clientesSaldo.size(), 2);
		assertEquals(clientesSaldo.get(0).nombre ,"A");
		assertEquals(clientesSaldo.get(1).nombre ,"C");
	}

}
