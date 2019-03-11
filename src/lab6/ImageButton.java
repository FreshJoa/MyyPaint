package lab6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {

	BufferedImage buttonIcon;
	
	
	public ImageButton(String path) throws IOException {
		buttonIcon = ImageIO.read(new File(path));
		////
		this.setIcon(new ImageIcon(buttonIcon));
		
	}
	
}
