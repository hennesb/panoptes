package ie.panoptes.image.transforms.api;

/**
 * 
 * @author int13h
 * 
 *
 */

public enum ImageTypes {
	JPG(".jpg"), JPEG(".jpeg"), BMP(".bmp"), DIB(".dib"),GIF(".gif"),
	JPE(".jpe"), JP2(".jp2"), PNG(".png"), WEBP(".webp"), PBM(".pbm"),
	PGM(".pgm"), PPM(".ppm"), SR(".sr"), RAS(".ras"), TIFF(".tiff"),
	TIF(".tif");

	private final String format;

	private ImageTypes(final String fileFormat) {
		this.format = fileFormat;
	}

	@Override
	public String toString() {
		return format;
	}
}
