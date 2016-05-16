import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

public class Webcam {
	  public static void main( String[] args )
	  {
	    try
	    {
	         System.out.println("Welcome to OpenCV " + Core.VERSION);
	         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	         Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);
	         System.out.println("m = " + m.dump());

	   // VideoCapture cap= new VideoCapture("D:/css/pizzavideo.mp4");

	  VideoCapture cap = new VideoCapture("http://88.87.182.6/axis-cgi/mjpg/video.cgi?resolution=480x360"); 

	        if(cap.isOpened())
	        {
	            System.out.println(" camera found----"+cap);   

	                 Mat frame = new Mat();
	                 while(true){
	                     if (cap.read(frame)){
	                         System.out.println("Frame Obtained");
	                         System.out.println("Captured Frame Width " + frame.width() + " Height " + frame.height());
	                         Imgcodecs.imwrite("img1.jpg", frame);

	                         System.out.println("OK");
	                         break;
	                     }
	                 }      
	        }
	        else
	        {   
	            System.out.println("Did not connect to camera");   
	        }
	            cap.release();
	    }
	    catch(Exception e)
	    {
	        System.out.println("Exception---"+e.getMessage());
	    }
	  }
	 }