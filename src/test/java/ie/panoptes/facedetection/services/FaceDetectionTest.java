package ie.panoptes.facedetection.services;

import static org.junit.Assert.*;

import java.io.IOException;

import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.image.io.AbstractImageLoaderTest;
import ie.panoptes.image.io.ImageResourceLoader;

import org.junit.Test;
import org.springframework.core.io.Resource;

public class FaceDetectionTest extends AbstractImageLoaderTest {

	private FaceDetection<Resource> detecter = new ResourceBasedFaceDetectionService();;

	public FaceDetectionTest() {
	}

	@Test
	public void face_found_after_loading_image_as_resource() throws IOException {
		assertTrue(detecter.faceDetected(imageResource));
	}

	@Test
	public void no_face_in_resource_no_face_found() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_NO_FACE);
		assertFalse(detecter.faceDetected(imageResource));
	}

	@Test
	public void multiple_faces_in_resource_face_found() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_MULTIPLE_FACES);
		assertTrue(detecter.faceDetected(imageResource));
	}

	@Test
	public void hand_in_resource_no_face_found() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_HAND);
		assertFalse(detecter.faceDetected(imageResource));
	}

	@Test
	public void cat_face_not_detected_as_human() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_CAT);
		assertFalse(detecter.faceDetected(imageResource));
	}

	@Test
	public void black_and_white_image_face_detected() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_BLACK_AND_WHITE_WITH_FACE);
		assertTrue(detecter.faceDetected(imageResource));
	}
	
	@Test
	public void crowd_image_face_detected() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_CROWD);
		assertTrue(detecter.faceDetected(imageResource));
	}
	
	@Test
	public void back_of_head_no_face_detected() throws IOException {
		Resource imageResource = new ImageResourceLoader()
				.resourceFromClasspath(IOTestsConfig.TEST_BACK_OF_SOMEONES_HEAD);
		assertFalse(detecter.faceDetected(imageResource));
	}
}
