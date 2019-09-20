import static org.junit.*;

import org.junit.jupiter.api.Test;

import junit.framework.*;


class pruebaJinites {

	@Test
	void test() {
		int [] v = {18,15};
		
		Assert.assertEquals(1, Correo.jinetes(v));
	}

}
