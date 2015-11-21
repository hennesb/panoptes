package ie.panoptes.resource.loaders;

import static org.junit.Assert.*;
import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.image.io.ImageResourceLoader;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;

public class ResourceLoaderTest {

	public ResourceLoaderTest() {
	}
	
    private ImageResourceLoader loader;
	
	@Before
	public void setUp() throws Exception {
		loader = new ImageResourceLoader();
	}

	@Test
	public void file_in_root_src_can_be_loaded_from_classpath() {		
		Resource resource = loader.resourceFromClasspath(IOTestsConfig.FILE);
	    assertTrue(resource.exists());
	}
	
	@Test
	public void file_in_package_can_be_loaded_from_classpath() {		
		Resource resource = loader.resourceFromClasspath(IOTestsConfig.TEST_PACKAGE + IOTestsConfig.FILE);
	    assertTrue(resource.exists());
	}	

}
