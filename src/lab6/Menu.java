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
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.omg.CORBA.portable.InputStream;

import com.sun.glass.ui.MenuItem;

import java.net.URL;

public class Menu extends JMenu implements ActionListener {

	Window window;
	JMenuItem newDrawing;
	JMenuItem saveDrawing;
	// JMenuItem importPcture;
	JMenuItem pictureFromInternet;
	JMenuItem pictureFromFile;
	JMenu submenu;
	BufferedImage image;
	PaintPanel paintPanel;
	String link;

	public Menu(Window window, PaintPanel paintPanel) {
		this.window = window;
		this.paintPanel = paintPanel;
		setText("Menu");
		submenu = new JMenu("Import picture");
		newDrawing = new JMenuItem("New drawing");
		saveDrawing = new JMenuItem("Save drawing");
		pictureFromFile = new JMenuItem("Picture from file");
		pictureFromInternet = new JMenuItem("Picture from Internet");

		pictureFromFile.addActionListener(this);
		saveDrawing.addActionListener(this);
		newDrawing.addActionListener(this);

		pictureFromInternet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				link = (String) JOptionPane.showInputDialog(window, "give the source:\n", "Picture from Internet",
						JOptionPane.PLAIN_MESSAGE, null, null, "text");

				JOptionPane.showMessageDialog(window, "Wrote: \n" + link);
				try {

					URL url = new URL(link);
					BufferedImage c = ImageIO.read(url);
					paintPanel.setBackgroudImage(c);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		add(newDrawing);
		add(saveDrawing);
		add(submenu);
		submenu.add(pictureFromFile);
		submenu.add(pictureFromInternet);
	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == newDrawing) {
			window.paintPanel.image = null;
			window.paintPanel.drawing = null;
			window.paintPanel.drawings.clear();
			window.paintPanel.repaint();

		} else if (object == saveDrawing) {
			saveFile(paintPanel);

		} else if (object == pictureFromFile) {
			openFile(paintPanel);
		}

	}

	public void saveFile(PaintPanel paintPanel) {
		JFileChooser chooser = new JFileChooser();

		int returnVal = chooser.showDialog(null, "Choose");
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
