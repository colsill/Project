//source http://stackoverflow.com/questions/15835424/opencv-2-4-4-java-grab-webcam-picture-stream-osx

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class VideoCap {

    public static void main (String args[]) throws InterruptedException{

    System.out.println("Hello, OpenCV");
    // Load the native library.
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    //VideoCapture camera = new VideoCapture("C:\\Users\\Colm\\Desktop\\ripImages\\dumpsTest.mp4");
    VideoCapture camera = new VideoCapture("C:\\Users\\Colm\\Desktop\\ripImages\\dumpsTest.mp4");
   /* camera.open("C:\\Users\\Colm\\Desktop\\ripImages\\dumpsTest.mp4"); //Useless
    if(!camera.isOpened()){
        System.out.println("Camera Error");
    }
    else{
        System.out.println("Camera OK?");
    }*/

    Mat frame = new Mat();
    Mat frame2 = new Mat();
    Mat frame3 = new Mat();

    //camera.grab();
    //System.out.println("Frame Grabbed");
    //camera.retrieve(frame);
    //System.out.println("Frame Decoded");

    camera.read(frame);
    System.out.println("Frame1 Obtained");
    //camera.wait();
    camera.read(frame2);
    System.out.println("Frame2 Obtained");
    
    camera.read(frame3);
    System.out.println("Frame3 Obtained");


    /* No difference
    camera.release();
    */

    System.out.println("Captured Frame Width " + frame.width());

    Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\RipTest\\camera.jpg", frame);
    Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\RipTest\\camera2.jpg", frame2);
    Imgcodecs.imwrite("C:\\Users\\Colm\\Desktop\\RipTest\\camera4.jpg", frame3);
    System.out.println("OK");
    }

    	
    
    }
 