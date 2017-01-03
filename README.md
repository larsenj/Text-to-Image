# Text-to-Image
Java program that takes a text file and converts each character into two bytes.
It then creates an image pixel-by-pixel using every three bytes to determine
the color of the pixel.

Usage: "java Main [filename] [scale values T/F] [scale size#]"

"scale values" defaults to false, but can take a "1" or "true" to scale the 
integer derived from the byte to a value between 0 and 255.

"scale size" is a number to scale the size of the image by.

