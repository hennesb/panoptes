package ie.panoptes.framework.base;

import org.opencv.core.Core;
/**
 * 
 * @author Brian Hennessy
 * Framework class to load the native opencv libraries
 *
 */
public abstract class FrameworkNativeLibraryInitializer {
	
	static{
		
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	}

}
