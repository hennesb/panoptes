package ie.panoptes.framework.base;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Runner {

	public static void main(String[] args) {
		System.out.println("Runner executed");
		MyClass cls = new MyClass();
		System.out.println("Get class name" + cls.getClass().getName());
		detectFace();

	}

	/**
	 * 
	 */
	private static void detectFace() {
		CascadeClassifier faceDetector = new CascadeClassifier("");

		Mat image = null;

		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections);
		System.out.println(String.format("Detected %s faces",
				faceDetections.toArray().length));
		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(
					rect.x + rect.width, rect.y + rect.height), new Scalar(0,
					255, 0));
		}
		String filename = "faceDetection.png";
		System.out.println(String.format("Writing %s", filename));
	}

	private static class MyClass extends NativeLibraryInitializer {

	}

}
