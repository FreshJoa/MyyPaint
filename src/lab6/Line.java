package lab6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Line extends Drawing {

	public Line() {
		super();
	}

	public void addPoint(int x, int y) {
		xList.add(x);
		yList.add(y);
	}

	public void draw(Graphics2D g2d) {

		g2d.setColor(colorLine);
		g2d.setStroke(new BasicStroke(sizeLine));
		g2d.drawLine(xList.get(0), yList.get(0), xList.get(1), yList.get(1));

	}
}
