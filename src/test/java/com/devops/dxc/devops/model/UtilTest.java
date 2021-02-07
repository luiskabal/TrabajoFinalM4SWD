package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UtilTest {
	
	@Autowired
	Util util;

	/**
	 *  Caso de uso: ahorro mayor a 150UF.
	 * @throws IOException 
	 */
	@Test
	void testAhorroMayor() throws IOException {
		int ahorro = 56500000;
		int sueldo = 700000;
		int verif10 = Util.getDxc(ahorro, sueldo);
		System.out.println(verif10);
		assertNotNull(verif10);
		assertEquals((150*Util.getUf()), verif10);
	}
	
	/**
	 *  Caso de uso: ahorro menor a 1 millón.
	 * @throws IOException 
	 */
	@Test
	void testAhorroMenor() throws IOException {
		int ahorro = 870000;
		int sueldo = 350000;
		int verif10 = Util.getDxc(ahorro, sueldo);
		assertNotNull(verif10);
		assertEquals(870000, verif10);
    }
    
    /**
	 *  Caso de uso: ahorro mayor a 1 millón (35 UF) y menor a 10.000.000.
	 * @throws IOException 
	 */
	@Test
	void testAhorroMedio() throws IOException {
		int ahorro = 8700000;
		int sueldo = 350000;
		int verif10 = Util.getDxc(ahorro, sueldo);
		assertNotNull(verif10);
		assertEquals(35*Util.getUf(), verif10);
	}
	
	/**
	 * Verificar que exista valor de UF
	 * @throws IOException
	 */
	@Test
	void testGetUf() throws IOException {
		float ActualUF = Util.getUf();
		assertNotNull(ActualUF);
	}
	
	/**
	 * Caso de uso: paga impuesto por pertenecer al tercer tramo 
	 */
	@Test
	void testGetImpuesto() throws IOException {
		int ahorro = 56500000;
		int sueldo = 5000000;
		double impuesto = Util.getImpuesto(ahorro, sueldo);
        assertNotNull(impuesto);
        double supposedImp = (int)(150 * Util.getUf() * 0.304);
		assertEquals(supposedImp, impuesto);
	}
	
	/**
	 * Caso de uso: saldo restante de un retiro maximo
	 */
	@Test
	void testGetSaldoRestante() throws IOException {
		int ahorro = 71400000;
		int sueldo = 1700000;
		int resto = Util.getSaldoRestante(ahorro, sueldo);
        assertNotNull(resto);
        int supposedRest = ahorro - (int) (150 * Util.getUf());
		assertEquals(supposedRest, resto);
	}
}