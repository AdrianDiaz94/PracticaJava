package paquete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class VectorTest {

	@Test
	void testBuscarPico() {
		int [] v = {0,4,5,2};
		assertEquals(1, Vector.buscarPico(v));
	}

}
