import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


class MatchingDemo {
    public void run(String inFile, String templateFile, String outFile, int match_method) {
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning Template Matching");

        Mat img = Imgcodecs.imread(inFile);
        Mat templ = Imgcodecs.imread(templateFile);

        // / Create the result matrix
        int result_cols = img.cols() - templ.cols() + 1;
        int result_rows = img.rows() - templ.rows() + 1;
        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);

        // / Do the Matching and Normalize
        Imgproc.matchTemplate(img, templ, result, match_method);
        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());

        // / Localizing the best match with minMaxLoc
        MinMaxLocResult mmr = Core.minMaxLoc(result);

        Point matchLoc;
        if (match_method == Imgproc.TM_SQDIFF || match_method == Imgproc.TM_SQDIFF_NORMED) {
            matchLoc = mmr.minLoc;
        } else {
            matchLoc = mmr.maxLoc;
        }

        // / Show me what you got
        Imgproc.rectangle(img, matchLoc, new Point(matchLoc.x + templ.cols(),
                matchLoc.y + templ.rows()), new Scalar(0, 255, 0));

        // Save the visualized detection.
        System.out.println("Writing "+ outFile);
        Imgcodecs.imwrite(outFile, img);

    }
    
        public static void main(String[] args) {
            System.loadLibrary("opencv_java246");
            File riptemplate, source, result;
            result= new File("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\result.png");
            source=new File("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\30.png");
            riptemplate= new File("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\ripTemplete1.png");
            new MatchingDemo().run("C:\\Users\\Colm\\Desktop\\ripImages\\Test\\30.png", "C:\\Users\\Colm\\Desktop\\ripImages\\Test\\result.png", "C:\\Users\\Colm\\Desktop\\ripImages\\Test\\ripTemplete1.png", Imgproc.TM_CCOEFF);
        }
    }


