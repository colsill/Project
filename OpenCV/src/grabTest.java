//http://stackoverflow.com/questions/15735716/how-can-i-get-a-frame-sample-jpeg-from-a-video-mov
//http://stackoverflow.com/questions/14056754/best-approach-for-extract-extracting-images-image-sequence-from-videos-vid
//http://stackoverflow.com/questions/13382886/capture-frames-with-intervals-using-opencv-and-javacv

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;







import javax.imageio.ImageIO;


import javax.swing.Timer;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;


public class grabTest {
public static void main(String args[]) throws Exception, IOException, InterruptedException{
	
		CanvasFrame canvas = new CanvasFrame("Video Test"); 
	    //Set Canvas frame to close on exit
	     canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   
	     //Declare FrameGrabber to import video from "video.mp4"
	     File ripVid = new File("C:\\Users\\Colm\\Desktop\\ripImages\\dumpsTest2.mp4");
	     FrameGrabber grabber = new OpenCVFrameGrabber(ripVid); 
	     canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());
	     
	     
        
         
	    
	      
    if (grabber == null)
    {
        System.out.println("!!! Failed OpenCVFrameGrabber");
        return;
    }
    try            
    {
        grabber.start();
        
       
        IplImage frame = null;  

        int frame_counter = 1;
        System.out.println(grabber.getLengthInFrames());
        //while(true)
        while (frame_counter<=grabber.getLengthInFrames())
        {
            frame = grabber.grab();               
            if (frame == null)
            {
                System.out.println("!!! Failed grab");
                break;
            }

            if ((frame_counter % 30) == 0)
            {
            	frame = grabber.grab();
	            BufferedImage  bi = frame.getBufferedImage();
	            BufferedImage rotated;
	            rotated=rotate90CW(bi);
	            
	            String path = "C:\\Users\\Colm\\Desktop\\RipTest\\"+frame_counter+".png";
	            //int x =grabber.getFrameNumber();
	            
	           
	           ImageIO.write(rotated,"png", new File(path));
	            //System.out.println(frameGrabber.getTimestamp());
	           //System.out.println((frameGrabber.getFrameRate()/30==0));
            }
            frame_counter++;
        }
    }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}

//rotate image 90 degrees clockwise
public static BufferedImage rotate90CW(BufferedImage img) {  
    int width = img.getWidth();  
    int height = img.getHeight();  
    BufferedImage newImage = new BufferedImage(width, height, img.getType());
    Graphics2D g2 = newImage.createGraphics();
    g2.rotate(Math.toRadians(90), width/2, height/2);  
    g2.drawImage(img,null,0,0);
    return newImage;  
}
}
                // do something pretty with frame 5, 10, 15, 20, 25, ..
	/*    
	CanvasFrame canvas = new CanvasFrame("Video Test"); 
    //Set Canvas frame to close on exit
     canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   
     //Declare FrameGrabber to import video from "video.mp4"
     FrameGrabber frameGrabber = new OpenCVFrameGrabber("C:\\Users\\Colm\\Desktop\\ripImages\\timer.mp4"); 
	
     frameGrabber.start(); //start
     IplImage i;
     int frame_counter = 1;
	
     try {
	            for(int ii=1;ii<frameGrabber.getTimestamp();ii++){
	           
	            i = frameGrabber.grab();
	            BufferedImage  bi = i.getBufferedImage();
	            String path = "C:\\Users\\Colm\\Desktop\\ripImages\\Test\\"+ii+".png";
	            int x =frameGrabber.getFrameNumber();
	            
	           // if((frameGrabber.getFrameNumber()/60==0)||frameGrabber.getFrameNumber()/120==0||frameGrabber.getFrameNumber()/240==0){
	           ImageIO.write(bi,"png", new File(path));
	            System.out.println(frameGrabber.getTimestamp());
	           //System.out.println((frameGrabber.getFrameRate()/30==0));
	           

	            }
	            frameGrabber.stop();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
}
}*/
