/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.MORPH_CROSS;

/**
 *
 * @author idek PL
 */
public class Lab4 {
    public static void zad1(Mat img){
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(img, img, 180, 255, Imgproc.THRESH_BINARY);
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        Imgproc.erode(img, img, element); //The function erodes the source image using the specified structuring element that determines 
        
        imshow("Zdjecie po erozji", img);
        waitKey(0);
        
        System.exit(0);
    }
    
    public static void zad2(Mat img){
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(img, img, 180, 255, Imgproc.THRESH_BINARY);
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        Imgproc.erode(img, img, element); //The function erodes the source image using the specified structuring element that determines 
        Imgproc.erode(img, img, element);
        Imgproc.erode(img, img, element);
        
        imshow("Zdjecie po erozji", img);
        waitKey(0);
        
        System.exit(0);
    }
    
    public static void zad3(Mat img){
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(img, img, 127, 255, Imgproc.THRESH_BINARY);
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        Imgproc.dilate(img, img, element);
        
        imshow("Zdjecie po dyladacji", img);
        waitKey(0);
        
        System.exit(0);
    }
    
    public static void zad4(Mat img){
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(img, img, 127, 255, Imgproc.THRESH_BINARY);
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        Imgproc.dilate(img, img, element);
        Imgproc.dilate(img, img, element);
        
        imshow("Zdjecie po dyladacji", img);
        waitKey(0);
        
        System.exit(0);
    }
    
    public static void zad5a(Mat src) {
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(src, src, 127, 255, Imgproc.THRESH_BINARY);
        Mat dst = new Mat();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        Imgproc.erode(src, dst, element);
        Imgproc.dilate(dst, dst, element);
        
        imshow("Otwarcie", dst);
        waitKey(0);
        
        System.exit(0);
    }
    
    public static void zad5b(Mat src) {
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(src, src, 127, 255, Imgproc.THRESH_BINARY);
        Mat dst = new Mat();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        
        Imgproc.dilate(src, dst, element);
        Imgproc.erode(dst, dst, element);
        
        imshow("Zamknięcie", dst);
        waitKey(0);
        
        System.exit(0);
    }
    
    public static void zad6a(Mat src){
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*1+1, 2*1+1), new Point(1,1));
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Mat kontur = new Mat(src.rows(),src.cols(),src.type());
        Mat tmp = new Mat(src.rows(),src.cols(),src.type());
        
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(src, src, 127, 255, Imgproc.THRESH_BINARY);
        Imgproc.dilate(src, dst, element);
        Core.add(src, dst, tmp);
        Core.subtract(tmp, src, kontur);
        imwrite( "zad6a.png", kontur );
        System.exit(0);
    }
    
    public static void zad6b(Mat src){
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*1+1, 2*1+1), new Point(1,1));
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(src, src, 127, 255, Imgproc.THRESH_BINARY);
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Mat kontur = new Mat(src.rows(),src.cols(),src.type());
        Mat tmp = new Mat(src.rows(),src.cols(),src.type());
        
        Imgproc.erode(src, dst, element);
        Core.add(src, dst, tmp);
        Core.subtract(src, tmp, kontur);
        imwrite( "zad6b.png",  dst);
        System.exit(0);
    }
    
    public static void zad6c(Mat src){
        Mat dst1 = new Mat(src.rows(),src.cols(),src.type());
        Mat dst2 = new Mat(src.rows(),src.cols(),src.type());
        Mat kontur = new Mat(src.rows(),src.cols(),src.type());
        Mat tmp1 = new Mat(src.rows(),src.cols(),src.type());
        Mat tmp2 = new Mat(src.rows(),src.cols(),src.type());
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*1+1, 2*1+1), new Point(1,1));
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(src, src, 70, 255, Imgproc.THRESH_BINARY);
        Imgproc.dilate(src,dst1,element);
        Core.add(src,dst1,tmp1);
        Imgproc.erode(src, dst2, element);
        Core.add(src, dst2, tmp2);
        Core.subtract(tmp1, tmp2,kontur);
        imwrite( "zad6c.png", kontur );
        System.exit(0);
    }
    
    public static void zad7(){
        Mat src=imread("literki.png", Imgproc.COLOR_RGB2GRAY);
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Mat tmp = new Mat(src.rows(),src.cols(),src.type());
        Mat eroded = new Mat(src.rows(),src.cols(),src.type());
        
        Mat element = Imgproc.getStructuringElement(MORPH_CROSS, new Size(3,3));
        Imgproc.threshold(src, src, 10, 255, Imgproc.THRESH_BINARY);
        
        boolean done;
        do{
           Imgproc.erode(src,eroded,element);
           Imgproc.dilate(eroded,tmp,element);
           Core.subtract(src, tmp, tmp);
           Core.bitwise_or(dst, tmp, dst);
           eroded.copyTo(src);
           
           if(Core.countNonZero(src) == 0)  done=false;
           else done = true;           
        }
        while(done==true);
        imwrite( "zad7.png", src);
        System.exit(0);
    }
        /**
     * @param args the command line arguments
     */
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    public static void main(String[] args) {
        Mat img=Imgcodecs.imread("ja.jpg");
        Mat img1=Imgcodecs.imread("blackwhite.jpg");
        Mat img2=Imgcodecs.imread("dom.png");
//        zad1(img1);
//        zad2(img1);
//        zad3(img1);
//        zad4(img1);
//        zad5a(img);
//        zad5b(img);
        zad6a(img2);
        zad6b(img2);
        zad6c(img2);
//        zad7();
        // TODO code application logic here
    }
}
