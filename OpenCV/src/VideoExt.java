
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jcodec.api.FrameGrab;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;


public class VideoExt {
	public static void main (String[] args) throws  InterruptedException, IOException{
		/* FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber("C:/Users/Digilog/Downloads/Test.mp4");
	        frameGrabber.start();
	        IplImage i;
	        try {

	            i = frameGrabber.grab();
	            BufferedImage  bi = i.getBufferedImage();
	            ImageIO.write(bi,"png", new File("D:/Img.png"));
	            frameGrabber.stop();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
*/		
		
		//Create canvas frame for displaying video.
	     CanvasFrame canvas = new CanvasFrame("Video Test"); 
	   
	    //Set Canvas frame to close on exit
	     canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   
	      
	     //Declare FrameGrabber to import video from "video.mp4"
	     FrameGrabber frameGrabber = new OpenCVFrameGrabber("C:\\Users\\Colm\\Desktop\\ripImages\\dumpsTest.mp4");  
	      
	     try {      
	       
	      //Start grabber to capture video
	     // grabber.start();      
	       frameGrabber.start();
	      //Declare img as IplImage
	      IplImage img;
	       
	      while (true) {
	        
	       //inser grabed video fram to IplImage img
	       img = frameGrabber.grab();
	       //Set canvas size as per dimentions of video frame.
	       canvas.setCanvasSize(500, 500);; 
	        
	       if (img != null) {       
	        //Show video frame in canvas
	        canvas.showImage(img); 
	       }
	        IplImage i;
	        try {

	            i = frameGrabber.grab();
	            BufferedImage  bi = i.getBufferedImage();
	            ImageIO.write(bi,"png", new File("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\img.png"));
	            frameGrabber.stop();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       }
	      }
	     catch (Exception e) {      
	     }
		/*
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("Hello, OpenCV");

       Mat frame = new Mat();
       VideoCapture cap = new VideoCapture("C:/Users/Colm/Desktop/ripImages/dumpsTest.mp4");
                             
       Thread.sleep(500);	// 0.5 sec of a delay. This is not obvious but its necessary
                             // as the camera simply needs time to initialize itself
       cap.open("C:/Users/Colm/Desktop/ripImages/dumpsTest.mp4");
       if(!cap.isOpened()){
         System.out.println("Did not connect to camera");
       }else System.out.println("found webcam: "+ cap.toString());
      
     
       cap.retrieve(frame);// The current frame in the camera is saved in "frame"
       System.out.println("Captured image with "+ frame.width()+ " pixels wide by "         		  										+ frame.height() + " pixels tall.");
       Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\me1.jpg", frame);
       Mat frameBlur = new Mat();
       Imgproc.blur(frame, frameBlur, new Size(5,5) );
       Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\me2-blurred.jpg", frameBlur);

       cap.release(); // Remember to release the camera*/
		}
}
		
	    
	     
		            
		
		   
	  


