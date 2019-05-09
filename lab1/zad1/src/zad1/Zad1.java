/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import static java.io.FileDescriptor.in;
import static java.lang.System.in;
import static javafx.scene.paint.Color.color;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import static org.opencv.highgui.HighGui.WINDOW_AUTOSIZE;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.namedWindow;
import static org.opencv.highgui.HighGui.waitKey;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.circle;

/**
 *
 * @author idek PL
 */
public class Zad1 {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Mat img = new Mat(3, 3, CvType.CV_8U);
//        int row = 0, col = 0;
//        img.put(row, col, 1, 2, 3, 3, 5, 6, 6, 7, 8);
//        System.out.println(img.dump());   
//        //2
//        
//        Mat img1 = Imgcodecs.imread("ja.jpg");
//        Imgcodecs.imwrite("jax.jpg",img1);
//        
//        //3.
//        Mat img1 = Imgcodecs.imread("ja.jpg");
//        namedWindow("Display Window", WINDOW_AUTOSIZE);
//        imshow("Display Window", img1);
//        waitKey(0);
//        //4
//        Mat img2=imread("ja.jpg", CV_LOAD_IMAGE_GRAYSCALE);
//        namedWindow("Display Window", WINDOW_AUTOSIZE);
//        imshow("Display Window", img2);
//        waitKey(0);
//        //5
//        Mat img3=imread("mis.bmp");
//        namedWindow("Display Window", WINDOW_AUTOSIZE);
//        imshow("Display Window", img3);
//        waitKey(0);
//        Mat img4=imread("giphy.gif");
//        namedWindow("Display Window1", WINDOW_AUTOSIZE);
//        imshow("Display Window1", img4);
//        waitKey(0);
        // napisz o błędzie 
        //6 a
//        Mat img5=imread("ja.jpg");
//        Imgproc.putText(img5,        //Matrix obj of the image
//         "Tekst",           //Text to be added
//         new Point(10, 20),        //point
//         Core.FONT_HERSHEY_SIMPLEX , //front face
//         1,                          //front scale
//         new Scalar(0, 0, 0),        //Scalar object for color
//         5);
//        Imgcodecs.imwrite("jax.jpg", img5);
//        namedWindow("Display Window1", WINDOW_AUTOSIZE);
//        imshow("Display Window1", img5);
//        waitKey(0);
        //6 b
//        Mat img5=imread("ja.jpg");
//        Imgproc.putText(img5,        //Matrix obj of the image
//         "Tekst",           //Text to be added
//         new Point(30, 70),        //point
//         Core.FONT_HERSHEY_DUPLEX , //front face
//         2,                          //front scale
//         new Scalar(150, 40, 10),        //Scalar object for color
//         5);
//        Imgcodecs.imwrite("jax.jpg", img5);
//        namedWindow("Display Window1", WINDOW_AUTOSIZE);
//        imshow("Display Window1", img5);
//        waitKey(0);
        //7 a
        Mat img6=imread("ja.jpg");
        Imgproc.rectangle(img6, new Point(30, 30), new Point(50, 50), new Scalar(100, 100, 50), 2);
        Imgproc.line(img6, new Point(30, 30), new Point(50, 50), new Scalar(100, 100, 50), 3);
        Imgproc.circle(img6, new Point(50,50), 50, new Scalar(150, 150, 150), 7);
        namedWindow("Display Window1", WINDOW_AUTOSIZE);
        imshow("Display Window1", img6);
        waitKey(0);
    }

    
    
}
