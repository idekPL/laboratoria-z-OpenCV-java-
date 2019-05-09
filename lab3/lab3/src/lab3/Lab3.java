/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;


import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
/**
 *
 * @author idek PL
 */
public class Lab3 {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    public static void zad1(Mat img){
        double alpha=2;
        double beta=0;
        img.convertTo(img, -1, alpha, beta);
        imshow("zad1", img);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad2(Mat img){
        double alpha=1;
        double beta=-100;
        img.convertTo(img, -1, alpha, beta);
        imshow("zad2", img);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad3(Mat img){
        Mat img1 =imread("napis.png");
        double alpha=0.5, beta = ( 1.0 - alpha );
        Core.addWeighted( img, alpha, img1, beta, 0.0, img); 
        imshow("zad3", img);
        waitKey(0);
        System.exit(0);
    }
    //dopisać wzory opisujące parametry
    public static void zad4(){
        Mat img1=imread("lenna.png");
        Mat dst=new Mat();
        Imgproc.cvtColor(img1, img1, Imgproc.COLOR_RGB2GRAY);
        Core.MinMaxLocResult mmr=Core.minMaxLoc(img1);
        
        double max = mmr.maxVal;
        double min = mmr.minVal;

        System.out.println("Wartosc maksymalna przed normalizacja: " + max);
        System.out.println("Wartosc minimalna przed normalizacja: " + min);
        imshow("zad4 przed normalizacją", img1);
        waitKey(0);
        
        Core.normalize(img1, dst, 0, 255, Core.NORM_MINMAX);    //normalizacja
        mmr = Core.minMaxLoc(dst);
        double max2 = mmr.maxVal;
        double min2 = mmr.minVal;
        System.out.println("Wartosc maksymalna po normalizacji: " + max2);
        System.out.println("Wartosc minimalna po normalizacji: " + min2);
        
        imshow("zad4 po normalizacji", dst);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad5(){
        Mat img1=imread("zad5.png");
        List <Mat> bgr = new ArrayList<>();
	Core.split(img1, bgr);   // now b is chan[0], g is chan[1]. r is chan[2];
        img1 = bgr.get(0);
        imwrite( "zad5 B.png", img1 );
        img1 = bgr.get(1);
        imwrite( "zad5 G.png", img1 );
        img1 = bgr.get(2);
        imwrite( "zad5 R.png", img1 );
        System.exit(0);
    }
    
    public static void zad6(){
        Mat img1=imread("zad5.png");
        Mat hsv = new Mat();
        Imgproc.cvtColor(img1, hsv, Imgproc.COLOR_RGB2HSV);
        List<Mat> bgr = new ArrayList<>();
        Core.split(img1, bgr);
        img1 = bgr.get(0);
        imwrite( "zad5 H.png", img1 );
        img1 = bgr.get(1);
        imwrite( "zad5 S.png", img1 );
        img1 = bgr.get(2);
        imwrite( "zad5 V.png", img1 );
        System.exit(0);
    }    
    
    public static void zad7(Mat img){
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        Mat img1= img;
        Mat img2=img;
        
        Imgproc.threshold(img1, img1, 120, 255, Imgproc.THRESH_TOZERO_INV );
        imwrite( "threshold.png", img1 );
        imshow("threshold", img1);
        waitKey(0);
        
        Imgproc.adaptiveThreshold(img2, img2, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 11, 2);
        imwrite( "adaptive_threshold.png", img2 );
        imshow("adaptive_threshold", img2);
        waitKey(0);
        System.exit(0);
    }   
    
    public static void zad8(){
        Mat img = imread("A.png");
        Mat img1 = imread("B.png");
        Mat wynik=new Mat();
        Core.add(img, img1, wynik);
        imwrite( "A+B.png", wynik );
        imshow("A+B", wynik);
        waitKey(0);
        
        Core.subtract(img, img1, wynik);
        imwrite( "A-B.png", wynik );
        imshow("A-B", wynik);
        waitKey(0);
        
        Core.subtract(img1, img, wynik);
        imwrite( "B-A.png", wynik );
        imshow("B-A", wynik);
        waitKey(0);
        
        Core.multiply(img, img1, wynik);
        imwrite( "A*B.png", wynik );
        imshow("A*B", wynik);
        waitKey(0);
        
        Core.divide(img, img1, wynik);
        imwrite( "A/B.png", wynik );
        imshow("A/B", wynik);
        waitKey(0);
        
        Core.divide(img1, img, wynik);
        imwrite( "B/A.png", wynik );
        imshow("B/A", wynik);
        waitKey(0);
        System.exit(0);
    }
    
    public static void zad9(Mat img){
        List<Mat> bgrPlanes = new ArrayList<>();  //splitujemy na trzy kanały
        Core.split(img, bgrPlanes);
        int histSize = 256; //rozdzielczość histogramu (ilość punktów)
        
        float[] range = {0, 256}; //przedział wartości rgb
        MatOfFloat histRange = new MatOfFloat(range);
        boolean accumulate = false;
       
        Mat bHist = new Mat(), gHist = new Mat(), rHist = new Mat(); //tworzymy obiekty dla trzech kanałów
       
        //obliczamy histogramy dla trzech kanałów  
        Imgproc.calcHist(bgrPlanes, new MatOfInt(0), new Mat(), bHist, new MatOfInt(histSize), histRange, accumulate);
        Imgproc.calcHist(bgrPlanes, new MatOfInt(1), new Mat(), gHist, new MatOfInt(histSize), histRange, accumulate);
        Imgproc.calcHist(bgrPlanes, new MatOfInt(2), new Mat(), rHist, new MatOfInt(histSize), histRange, accumulate);
       
        int histW = 512, histH = 300; //rozmiar zdjecia histogramu
        int binW = (int) Math.round((double) histW / histSize);
       
        Mat histImage = new Mat( histH, histW, CvType.CV_8UC3, new Scalar( 255,255,255) ); //tworzenie histogramu
       
        Core.normalize(bHist, bHist, 0, histImage.rows(), Core.NORM_MINMAX);
        Core.normalize(gHist, gHist, 0, histImage.rows(), Core.NORM_MINMAX);
        Core.normalize(rHist, rHist, 0, histImage.rows(), Core.NORM_MINMAX);
       
        float[] bHistData = new float[(int) (bHist.total() * bHist.channels())];
        bHist.get(0, 0, bHistData);
        float[] gHistData = new float[(int) (gHist.total() * gHist.channels())];
        gHist.get(0, 0, gHistData);
        float[] rHistData = new float[(int) (rHist.total() * rHist.channels())];
        rHist.get(0, 0, rHistData);
       
        for(int i = 1; i < histSize; i++) {
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(bHistData[i - 1])),
            new Point(binW * (i), histH - Math.round(bHistData[i])), new Scalar(255, 0, 0), 2);
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(gHistData[i - 1])),
            new Point(binW * (i), histH - Math.round(gHistData[i])), new Scalar(0, 255, 0), 2);
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(rHistData[i - 1])),
            new Point(binW * (i), histH - Math.round(rHistData[i])), new Scalar(0, 0, 255), 2);
        }
       
        imshow("Zdjecie", img);
        imshow("Histogram", histImage );
        waitKey(0);
        System.exit(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mat img =imread("ja.jpg");
//        zad1(img);
//        zad2(img);
//        zad3(img);   //udaje się nałożyć jedynie na obrazki tego samego typu i wielkości
//        zad4();
//        zad5();
//        zad6();
//        zad7(img);
//        zad8();
        zad9(img);
    }
    
}
