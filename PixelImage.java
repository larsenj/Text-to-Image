/*
 * Author: Jon Larsen
 * Class takes an array of integers and a number for scale and creates a 
 * pixellated image at that scale
 */

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PixelImage extends JPanel
{
    //ctor
    public PixelImage(ArrayList<Integer> btArr, int scale)
    {
        int numSquares = btArr.size()/3;
        int size = (int)Math.sqrt(numSquares);

        BufferedImage bi = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        int btIndex = 0;
        for(int y = 0; y < size; y++)
        {
            for(int x = 0; x < size; x++)
            {
                Color color = new Color(btArr.get(btIndex), btArr.get(btIndex + 1), btArr.get(btIndex + 2)) ;
                int colorValue = color.getRGB();
                bi.setRGB(x, y, colorValue);
                btIndex += 3;
            }//end for x
        }//end for y

        Image bii = bi.getScaledInstance(size*scale, size*scale, BufferedImage.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(bii);
        add(new JLabel(icon));

    }

}//end class
