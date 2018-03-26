package lab6;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.glass.ui.MenuItem;

public class Menu extends JMenu implements ActionListener {

	Window window;
	JMenuItem newDrawing;
	JMenuItem saveDrawing;
	JMenuItem importPcture;
	BufferedImage image;
	PaintPanel paintPanel;

	public Menu(Window window, PaintPanel paintPanel) {
		this.window = window;
		this.paintPanel = paintPanel;
		setText("Menu");
		newDrawing = new JMenuItem("New drawing");
		saveDrawing = new JMenuItem("Save drawing");
		importPcture = new JMenuItem("Import picture");

		importPcture.addActionListener(this);
		saveDrawing.addActionListener(this);
		newDrawing.addActionListener(this);

		add(newDrawing);
		add(saveDrawing);
		add(importPcture);
	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == newDrawing) {
			window.paintPanel.drawing=null;
			window.paintPanel.drawings.clear();
			window.paintPanel.repaint();

		} else if (object == saveDrawing) {
			saveFile(paintPanel);

		} else if (object == importPcture) {
			openFile(paintPanel);
		}
	}

	public void saveFile(PaintPanel paintPanel) {
		JFileChooser chooser = new JFileChooser();

		//int result = chooser.showOpenDialog(null);

		//inal JFileChooser fc = new JFileChooser();
		int returnVal = chooser.showDialog(null, "Wybierz");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedImage image = new BufferedImage(window.paintPanel.getWidth(), window.paintPanel.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g2im = image.createGraphics();
			window.paintPanel.paintComponent(g2im);
			try {
				ImageIO.write(image, "jpeg", chooser.getSelectedFile());

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

		}
	

	}

	public void openFile(PaintPanel paintPanel) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic files", "jpg", "gif", "png", "bmp");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedImage image = null;
			try {
				System.out.println(chooser.getSelectedFile());
				image = ImageIO.read(chooser.getSelectedFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			paintPanel.setBackgroudImage(image);

		}

	}
}
