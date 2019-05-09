/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;
import org.opencv.core.Core;
import static org.opencv.core.Core.flip;
import static org.opencv.core.Core.rotate;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import static org.opencv.highgui.HighGui.WINDOW_AUTOSIZE;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.namedWindow;
import static org.opencv.highgui.HighGui.waitKey;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author idek PL
 */
public class Lab2 {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void zad1(Mat img){
        Mat macierz = new Mat(2, 3, CvType.CV_64F);
        macierz.put(0, 0, 1);
        macierz.put(0, 1, 0);
        macierz.put(0, 2, 100);
        
        macierz.put(1 , 0, 0);
        macierz.put(1 , 1, 1);
        macierz.put(1, 2, 0);
        
        Mat img1 = new Mat(img.cols(),img.rows(),CvType.CV_64F);
        Size test = new Size(img.cols(),img.rows());
        //Size test2 = new Size(img.cols()*2,img.rows()*2);
        Imgproc.warpAffine(img, img1, macierz, test);
        
        namedWindow("Display Window", WINDOW_AUTOSIZE);
        imshow("Display Window", img1);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad2(Mat img){
        Mat img1 = new Mat(img.cols(),img.rows(),CvType.CV_64F);
        flip(img, img1, 1);
        namedWindow("flip around y", WINDOW_AUTOSIZE);
        imshow("flip around y", img1);
        waitKey(0);
        
        flip(img, img1, 0);
        namedWindow("flip around x", WINDOW_AUTOSIZE);
        imshow("flip around x", img1);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad3(Mat img1) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Podaj kąt: ");
        int kat = reader.nextInt();
        Mat rot = Imgproc.getRotationMatrix2D(new Point(50, 200), kat, 1);
        Imgproc.warpAffine(img1, img1, rot, new Size(img1.cols(), img1.cols()));
        namedWindow("zad3 - kąt "+kat+" stopni", WINDOW_AUTOSIZE);
        imshow("zad3 - kąt "+kat+" stopni", img1);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad4(Mat img, Mat img1) {
        Rect prostokat = new Rect(85, 40, 40, 55);
        Mat cut = new Mat(img, prostokat);
        namedWindow("zad4.1", WINDOW_AUTOSIZE);
        imshow("zad4.1", cut);
        waitKey(0);
        
        Rect prostokat1 = new Rect(new Point(85, 40), new Point(125, 95));
        Mat cut1 = new Mat(img1, prostokat1);
        namedWindow("zad4.2", WINDOW_AUTOSIZE);
        imshow("zad4.2", cut1);
        System.exit(0);
    }
    
    public static void zad5(Mat img, Mat img1) {
        double w2 = img.width()*2; double h2 = img.height()*2;
        double w4 = img.width()*4; double h4 = img.height()*4;
        
        double c2 = img1.cols()*2; double r2 = img1.rows()*2; 
        double c4 = img1.cols()*4; double r4 = img1.rows()*4;
        
        Imgproc.resize(img, img, new Size(w2, h2));
        imshow("Powiększenie x2 resize", img);
        waitKey(0);
        Imgproc.resize(img, img, new Size(w4, h4));
        imshow("Pwiększenie x4 resize", img);
        waitKey(0);
        Imgcodecs.imwrite("powiekszone resize.jpg", img);
        
        Imgproc.pyrUp(img1, img1, new Size( c2, r2 ));
        imshow("Pwiększenie x2 pyrUp", img1);
        waitKey(0);
        Imgproc.pyrUp(img1, img1, new Size( c4, r4 ));
        imshow("Pwiększenie x4 pyrUp", img1);
        waitKey(0);
        Imgcodecs.imwrite("powiekszone pyrUp.jpg", img1);
        System.exit(0);
    }
    
    public static void zad6(Mat img, Mat img1) {
        double w2 = img.width()/2; double h2 = img.height()/2;
        double w4 = img.width()/4; double h4 = img.height()/4;
        
        double c2 = img1.cols()/2; double r2 = img1.rows()/2; 
        double c4 = img1.cols()/4; double r4 = img1.rows()/4;
        
        Imgproc.resize(img, img, new Size(w2, h2));
        imshow("Pomniejszenie x2 resize", img);
        waitKey(0);
        Imgproc.resize(img, img, new Size(w4, h4));
        imshow("Pomniejszenie x4 resize", img);
        waitKey(0);
        Imgcodecs.imwrite("Pomniejszenie resize.jpg", img);
        
        Imgproc.pyrDown(img1, img1, new Size( c2, r2 ));
        imshow("Pomniejszenie x2 pyrUp", img1);
        waitKey(0);
        Imgproc.pyrDown(img1, img1, new Size( c4, r4 ));
        imshow("Pomniejszenie x4 pyrUp", img1);
        waitKey(0);
        Imgcodecs.imwrite("Pomniejszenie pyrUp.jpg", img1);
        System.exit(0);
    }
    
    public static void zad7(Mat img, Mat img1) {
        double x=16;
        double w = img.width()*x; double h = img.height()*x;
        double c = img1.cols()*x; double r = img1.rows()*x; 
        
        Imgproc.resize(img, img, new Size(w, h));
        imshow("Powiększenie x1.5 resize", img);
        waitKey(0);
        
        Imgproc.pyrUp(img1, img1, new Size(c, r));
        imshow("Powiększenie x1.5 pyrUp", img1);
        waitKey(0);
        System.exit(0);
    }
   
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mat img =imread("ja.jpg");
        Mat img1 =imread("ja.jpg");
//        zad1(img);
//        zad2(img);
//        zad3(img1);
//        zad4(img, img1);
//        zad5(img, img1);
//        zad6(img, img1);
        zad7(img, img1);
    }
    
}
