/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import zad2.Imgcodecs;

/**
 *
 * @author idek PL
 */
public class Zad2 {
    static {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        // Mat img3 = Imgcodecs.imread("E:\Pliki\Pulpit\Lenna.png");
        Mat img1;
        img1 = Imgcodecs.imwrite("E:\\Pulpit\\szkolne projekty\\III semestr\\Przetwarzanie obrazów\\lab1\\zad1\\Lenna.png");
        // zad 3
    }
    
}
