package lab6;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public abstract class Drawing {

	   protected ArrayList<Integer> xList; 
       protected ArrayList<Integer> yList; 
       Color colorLine;
       int sizeLine;
     //zmiana
       
	
       public void addPoint(int x, int y) {
           xList.add(x);
           yList.add(y);
        }
       
	public Drawing() {
		
		xList=new ArrayList<>();
		yList=new ArrayList<>();
		colorLine=TopPanel.lineColor;
		sizeLine=TopPanel.pixel;
		
	}
	public void update(int x, int y) {
		
			xList.add(x);
			yList.add(y);
		
	}
	public abstract void draw(Graphics2D g2d);

}
