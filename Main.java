/* 
 * Author: Jon Larsen
 * Program takes a text file and breaks down each character into two bytes, then
 * creates and image using every three bytes to determine the color of a pixel.
 *
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        //check for correct usage
        if(args.length < 3 || args.length > 3)
        {
            System.out.println("Usage: java Main [filename] [scale values T/F] [scale size#]");
            System.exit(1);
        }
        
        //get the file from the textSample subdirectory
        String filename = "textSamples/" + args[0];

        //scaling ensures all values are from 0 to 255, instead of just ~32 to ~120
        boolean scale = false;
        if(args[1].equals("1") || args[1].toLowerCase().equals("true"))
            scale = true;
       
        //generate the list of integers from the file 
        TextReader tr = new TextReader();
        ArrayList<Integer> wordInts = tr.generate(filename, scale);


        JFrame frame = new JFrame("TextToImage");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //get size of scale
        int imageScale = Integer.parseInt(args[2]);
        frame.getContentPane().add(new PixelImage(wordInts, imageScale));
        frame.pack();
        frame.setVisible(true); 

    }//end main
}//end class
