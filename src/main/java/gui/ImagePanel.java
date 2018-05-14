package gui;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

  
	private static final long serialVersionUID = 1L;
	private BufferedImage image;

    public ImagePanel(String imgPath) {
       try {                
          image = ImageIO.read(new File(imgPath));
          System.out.println("Imagem aberta!" + imgPath);
       } catch (IOException ex) {
          System.out.println("Image could not be read");
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}
