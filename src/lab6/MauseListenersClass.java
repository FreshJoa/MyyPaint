package lab6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MauseListenersClass implements MouseMotionListener, MouseListener {

	PaintPanel paintPanel;
	TopPanel topPanel;
	Window window;

	public MauseListenersClass(Window window, PaintPanel paintPanel) {
		this.window = window;
		this.paintPanel = paintPanel;
		paintPanel.addMouseListener(this);
		paintPanel.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {// Wywoływany zaraz po kliknięciu przez użytkownika odsłuchanego komponentu

	}

	@Override
	public void mousePressed(MouseEvent e) {// Wywoływany zaraz po naciśnięciu przez użytkownika przycisku myszy, gdy
											// kursor znajduje się nad odsłuchanym komponentem.
		if (window.topPanel.drawLabel.getText() == window.leftPanel.strightLineText) {
			paintPanel.drawing = new Line();
			paintPanel.drawing.addPoint(e.getX(), e.getY());
		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.pencilText) {
			paintPanel.drawing = new PencilLine();
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.rubberText) {
			paintPanel.drawing = new Rubber();
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}

		if (window.topPanel.drawLabel.getText() == window.leftPanel.emptySquareText) {
			paintPanel.drawing = new Square();
			paintPanel.drawing.addPoint(e.getX(), e.getY());

		}

		if (window.topPanel.drawLabel.getText() == window.leftPanel.filledSqareText) {
			paintPanel.drawing = new FilledSquare();
			paintPanel.drawing.addPoint(e.getX(), e.getY());

		}
		
		
		if (window.topPanel.drawLabel.getText() == window.leftPanel.circleText) {
			paintPanel.drawing = new Circel();
			paintPanel.drawing.addPoint(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {// Wywoływany zaraz po tym, jak użytkownik zwolni przycisk myszy po
												// naciśnięciu myszy nad odsłuchanym komponentem.
		if (window.topPanel.drawLabel.getText() == window.leftPanel.strightLineText) {
			paintPanel.drawings.add(paintPanel.drawing);
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.pencilText) {
			paintPanel.drawings.add(paintPanel.drawing);
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			
		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.rubberText) {
			paintPanel.drawings.add(paintPanel.drawing);
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
			
		}

		if (window.topPanel.drawLabel.getText() == window.leftPanel.emptySquareText
				|| window.topPanel.drawLabel.getText() == window.leftPanel.filledSqareText) {
			paintPanel.drawings.add(paintPanel.drawing);
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}

		if (window.topPanel.drawLabel.getText() == window.leftPanel.circleText) {
			paintPanel.drawings.add(paintPanel.drawing);
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {// Wywoływana zaraz po tym, jak kursor znajdzie się w zasięgu słuchanego
											// komponentu.
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {// Wywoływana zaraz po tym, jak kursor wyjdzie z zakresu odsłuchanego
											// komponentu.
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {// Wywoływane po naciśnięciu przycisku myszy na komponencie, a następnie
											// przeciągnięciu.
		if (window.topPanel.drawLabel.getText() == window.leftPanel.strightLineText) {
			paintPanel.drawing.xList.add(1);
			paintPanel.drawing.yList.add(1);
			paintPanel.drawing.xList.add(1, e.getX());
			paintPanel.drawing.yList.add(1, e.getY());
			paintPanel.repaint();
		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.pencilText) {
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.rubberText) {
			paintPanel.drawing.addPoint(e.getX(), e.getY());
			paintPanel.repaint();
		}
		
		if (window.topPanel.drawLabel.getText() == window.leftPanel.emptySquareText
				|| window.topPanel.drawLabel.getText() == window.leftPanel.filledSqareText) {
			paintPanel.drawing.xList.add(1);
			paintPanel.drawing.yList.add(1);
			paintPanel.drawing.xList.add(1, e.getX());
			paintPanel.drawing.yList.add(1, e.getY());
			paintPanel.repaint();

		}
		if (window.topPanel.drawLabel.getText() == window.leftPanel.circleText) {
			paintPanel.drawing.xList.add(1);
			paintPanel.drawing.yList.add(1);
			paintPanel.drawing.xList.add(1, e.getX());
			paintPanel.drawing.yList.add(1, e.getY());
			paintPanel.repaint();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
