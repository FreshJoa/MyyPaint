package lab6;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class FilledSquare extends Drawing {

	public FilledSquare() {
		super();
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(colorLine);
		g2d.setStroke(new BasicStroke(sizeLine));
		g2d.fillRect(Math.min(xList.get(0), xList.get(1)), Math.min(yList.get(0), yList.get(1)),
				Math.abs(xList.get(0) - xList.get(1)), Math.abs(yList.get(0) - yList.get(1)));


	}

}




//asd
