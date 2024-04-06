import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

class CameraCapture {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // Open the default camera (usually 0)
        VideoCapture camera = new VideoCapture(0);

        // Check if the camera is opened successfully
        if (!camera.isOpened()) {
            System.out.println("Error: Unable to open camera.");
            return;
        }

        // Create a new Mat object to store the captured image
        Mat frame = new Mat();

        // Capture an image from the camera
        if (camera.read(frame)) {
            // Save the captured image to a file
            Imgcodecs.imwrite("captured_image.jpg", frame);
            System.out.println("Image captured successfully.");
        } else {
            System.out.println("Error: Failed to capture image.");
        }

        // Release the camera
        camera.release();
    }
}
