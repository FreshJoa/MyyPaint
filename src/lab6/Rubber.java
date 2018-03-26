package lab6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Rubber extends Drawing {

	public Rubber() {
		super();
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(15));
		for (int i = 0; i < xList.size() - 1; i++) {
			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
		}

	}

}
