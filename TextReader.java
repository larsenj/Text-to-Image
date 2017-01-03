/*
 * Author: Jon Larsen
 * Class to read text from file, convert the characters into 2-byte values,
 * then convert the bytes into integers
 */

import java.io.*;
import java.util.*;

public class TextReader
{
    private static final int MIN_BYTE = 32;     //min value of bytes we'll see
    private static final int MAX_BYTE = 126;    //max value of bytes we'll see
    private static final int MIN_COLOR = 0;     //min color value
    private static final int MAX_COLOR = 255;   //max color value
    
    //ctor
    public TextReader(){};

    //generate - takes filename and bool indicating is should scale, returns array
    public ArrayList<Integer> generate(String filename, boolean scale)
    {
        //arraylist to hold the integers
        ArrayList<Integer> byteArray = new ArrayList<Integer>();
        
        //read the file into the ArrayList
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = " ";
            
            //read in each line
            while((line = in.readLine()) != null)
            {
                //convert the string into an array of bytes
                byte bt[] = line.getBytes("UTF-16LE");

                //iterate through the array of bytes... 
                for(int i = 0; i < bt.length; i++)
                {
                    //...converting to int...
                    int j = bt[i];
                    
                    //...scaling if needed...
                    if(scale && j != 0)
                    {
                        j = scaleNum(j);
                    }
                    
                    //...adding to arraylist
                    //note: I sometimes get negative numbers, possibly related 
                    //to endianess. Current solution is to use absolute value
                    byteArray.add(Math.abs(j));
                }//end for i

            }//end while
            in.close();
        }catch (Exception e){}
 
        return byteArray; 
    }//end generate

    //scale the given int to a value within the valid color valules - prevents
    //the colors from clustering around greens and purples
    public int scaleNum(int num)
    {
        int numerator = (MAX_COLOR - MIN_COLOR) * (num - MIN_BYTE);
        int denominator = MAX_BYTE - MIN_BYTE;
        return numerator / denominator + MIN_COLOR;
    } 

}//end class
