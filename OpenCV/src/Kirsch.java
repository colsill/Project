import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Kirsch {
   public static void main( String[] args ) {
   
      try {
         int kernelSize = 9;
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
         Mat source = Imgcodecs.imread("C:\\Users\\Colm\\Desktop\\ripImages\\rip1.jpe",  Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         
         Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
            {
               put(0,0,-3);
               put(0,1,-3);
               put(0,2,-3);
      
               put(1,0-3);
               put(1,1,0);
               put(1,2,-3);

               put(2,0,5);
               put(2,1,5);
               put(2,2,5);
            }
         };	      
         
         Imgproc.filter2D(source, destination, -1, kernel);
         Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\Gaussian45.jpg", destination);
         

         /*//Load image img1 as IplImage
            final IplImage image = cvLoadImage("img1.png");
             
            //create canvas frame named 'Demo'
            final CanvasFrame canvas = new CanvasFrame("Demo");
             
            //Show image in canvas frame
            canvas.showImage(image);
             
            //This will close canvas frame on exit
            canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE); */
         
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }
}