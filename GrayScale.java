package kontrast;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class GrayScale {
  
 BufferedImage image;
 int width;
 int height;
 
 
public GrayScale () {

 try {
   
 File input = new File("Obraz.jpg");
 image = ImageIO.read(input);
 width = image.getWidth();
 height = image.getHeight();


 for(int i=0; i<height; i++){
 for(int j=0; j<width; j++){

 Color c = new Color(image.getRGB(j, i));
     
 
 int red = (int)(c.getRed());
 int green = (int)(c.getGreen());
 int blue = (int)(c.getBlue());

 int x, y, z;
 
 x = -50;
 y = 200;
 z = 10;

 if ( i>=100 && i<=500 && j>=123 && j<=800 )
   
 {
     
 x = 800; //R
 y = 630; //G
 z = 700; //B

 
 }
   
 if (red + x >= 0 && red + x <= 255) red = red + x;
 else red = red;

 if (green + y >= 0 && green + y <= 255) green = green + y;
 else green = green;

 if (blue + z >= 0 && blue + z <= 255) blue = blue + z;
 else blue = blue;
     
 Color newColor = new Color(red, green,blue);
 image.setRGB(j,i,newColor.getRGB());

 } 
 }
   
 File ouptut = new File("Obrazek.jpg");
 ImageIO.write(image, "jpg", ouptut);

 } catch (IOException e) { }
  
 }
    
    
 static public void main(String args[]) throws Exception
 {
 GrayScale obj = new GrayScale();
 }
}