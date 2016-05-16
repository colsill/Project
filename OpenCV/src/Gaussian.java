import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class Gaussian {
   public static void main( String[] args ){
   
      try {
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
         Mat source = Imgcodecs.imread("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\120.png",
         Imgcodecs.CV_LOAD_IMAGE_COLOR);
         
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         Imgproc.GaussianBlur(source, destination,new Size(19,19), 0);
         Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\Gaussian45.jpg", destination);
      
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }
}