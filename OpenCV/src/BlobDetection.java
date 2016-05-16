import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.FeatureDetector;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.List;

public class BlobDetection {

    public static void main(String[] args)
    {
        
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

        String sourcePath = "C:\\Users\\Colm\\Desktop\\ripImages\\rip3bw.jpe";

        Mat srcImgMat = Imgcodecs.imread(sourcePath);

        if (srcImgMat == null)
        {
            System.out.println("Failed to load image at " + sourcePath);
            return;
        }

        System.out.println("Loaded image at " + sourcePath);

        MatOfKeyPoint matOfKeyPoints = new MatOfKeyPoint();

        FeatureDetector blobDetector = FeatureDetector.create(FeatureDetector.SIMPLEBLOB);
        blobDetector.detect(srcImgMat, matOfKeyPoints);

        System.out.println("Detected " + matOfKeyPoints.size()+ " blobs in the image");

        List<KeyPoint> keyPoints = matOfKeyPoints.toList();

    }
}



	