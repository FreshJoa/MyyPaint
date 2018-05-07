package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import sun.java2d.loops.DrawLine;

public class PaintPanel extends JPanel {
	Window window;

	BufferedImage image;
	int width, height;
	Graphics2D g2d;
	ArrayList<Drawing> drawings = new ArrayList<>();
	Drawing drawing = null;
	TopPanel topPanel;
	Menu menu;

	public PaintPanel(Window window, MouseListener mouseListener, Menu menu) {

		super();
		this.window = window;
		this.menu = menu;
		setBackground(Color.WHITE);

	}

	public void setBackgroudImage(BufferedImage imagee) {

		image = imagee;
		repaint();

	}

	public PaintPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public PaintPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PaintPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintComponent(Graphics g) {

		if (image == null) {
			int w=this.getWidth();
			int h=this.getHeight();
			image = (BufferedImage) this.createImage(w/2, h/2);
			Graphics2D gc = image.createGraphics();
			gc.setColor(Color.white);
			
			gc.fillRect(0,0, w, h);
		}

		Graphics2D g2d = (Graphics2D) g;
		int x = (this.getWidth() - image.getWidth(null)) / 2;
		int y = (this.getHeight() - image.getHeight(null)) / 2;
		g2d.drawImage(image, x, y, this);

		/*
		 * super.paintComponent(g);
		 * 
		 * Graphics2D g2d = (Graphics2D) g; if (image != null) { int x =
		 * (this.getWidth() - image.getWidth(null)) / 2; int y = (this.getHeight() -
		 * image.getHeight(null)) / 2; g2d.drawImage(image, x, y, null); }
		 */
		for (int i = 0; i < drawings.size(); i++) {
			drawings.get(i).draw(g2d);
		}
		if (drawing != null) {
			drawing.draw(g2d);
		}

	}

}
