/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_340_805398;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO: write your method


/**
 *
 * @author 805398
 */
public class Java_340_805398 {

    /**
     * @param args unused
     */
    public static void main(String[] args) {
        //Challenge 2: Setup a Scanner to read the file
        try{
            File file = new File("input340.txt");
            File file2 = new File("output340.txt");
            Scanner sc = new Scanner(file);
            PrintWriter output = null;
            output = new PrintWriter(file2);
            String[] ISBN = new String[12];
            for(int i = 0; i < 12; i++){
            ISBN[i] = sc.nextLine();
            }
            for( int i = 0; i < 12; i++){
                String lines = ISBN[i];
                ISBNCheck(ISBN, lines);
                if( ISBNCheck(ISBN, lines) ){
                    System.out.println("Book :" + (i+1) + ": It's Valid");
                }
                else if( !ISBNCheck(ISBN, lines) ) {
                    System.out.println("Book :" + (i+1) + ": It's Invalid");
                    output.println( ISBN[i] );
                }
            }
            output.close();
            } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public static boolean ISBNCheck(String[] ISBN, String lines) {
        
        int[] weights = new int[10];
        
        int num = 10;
        
        for (int i = 0; i < 10; i++) {
            weights[i] = num;
            num -= 1;
        }
        
        int[] values = {
            Integer.parseInt(lines.substring(0,1)),
            Integer.parseInt(lines.substring(1,2)),
            Integer.parseInt(lines.substring(2,3)),
            Integer.parseInt(lines.substring(3,4)),
            Integer.parseInt(lines.substring(5,6)),
            Integer.parseInt(lines.substring(6,7)),
            Integer.parseInt(lines.substring(7,8)),
            Integer.parseInt(lines.substring(8,9)),
            Integer.parseInt(lines.substring(10,11))
        };
        
        int sum = 0;
        
        for (int i = 0; i < values.length; i++) {
            sum += weights[i] * values[i];
        }
        
        if( lines.substring(11,12).equals("X") ){
            sum += weights[9] * 10;
        }
        
        else if ( !(lines.substring(11,12).equals("X")) ){
            sum += weights[9] * Integer.parseInt(lines.substring(11,12));
        }
        
        return (sum % 11 == 0);
    }  
}


