package ie.panoptes.mappers;

import static org.junit.Assert.*;
import ie.panoptes.opencv.types.ThreeByteBGR;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OpenCvTypesFromAwtTypesTest {

	public OpenCvTypesFromAwtTypesTest() {
	}

	private OpenCvTypesFromAwtTypes types ;
	@Before
	public void setUp() throws Exception {
		types = new OpenCvTypesFromAwtTypes();
	}

	@Test
	public void test() {
		assertThat(types.map(BufferedImage.TYPE_3BYTE_BGR), instanceOf(ThreeByteBGR.class));
	}

}
