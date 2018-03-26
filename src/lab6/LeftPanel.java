package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javafx.scene.layout.Border;

public  class LeftPanel extends JPanel implements ActionListener {

	ImageButton straightLine;
	ImageButton circle;
	ImageButton pencil;
	ImageButton emptySquare;
	ImageButton filledSqare;
	ImageButton rubber;
	Window window;

	public static String strightLineText = "Stright Line";
	public static String circleText = "Circle";
	public static String pencilText = "Pencil";
	public static String emptySquareText = "Empty Square";
	public static String filledSqareText = "Filled Sqare";
	public static String rubberText = "Rubber";

	public LeftPanel(Window window) throws IOException {
		this.window = window;

		setLayout(new GridLayout(6, 1, 10, 10));
		straightLine = new ImageButton("line.jpg");
		circle = new ImageButton("circle.jpg");
		pencil = new ImageButton("pencil2.jpg");
		emptySquare = new ImageButton("emptysquared.jpg");
		filledSqare = new ImageButton("fullsquared.jpg");
		rubber = new ImageButton("rubber2.png");
		straightLine.addActionListener(this);
		circle.addActionListener(this);
		pencil.addActionListener(this);
		emptySquare.addActionListener(this);
		filledSqare.addActionListener(this);
		rubber.addActionListener(this);

		add(straightLine);
		add(pencil);
		add(circle);
		add(emptySquare);
		add(filledSqare);
		add(rubber);
		setBorder(BorderFactory.createBevelBorder(0));
		setPreferredSize(new Dimension(100, 500));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == straightLine) {
			window.topPanel.drawLabel.setText(strightLineText);

		}
		if (object == circle) {
			window.topPanel.drawLabel.setText(circleText);

		}
		if (object == pencil) {
			window.topPanel.drawLabel.setText(pencilText);

		}
		if (object == emptySquare) {
			window.topPanel.drawLabel.setText(emptySquareText);

		}
		if (object == filledSqare) {
			window.topPanel.drawLabel.setText(filledSqareText);

		}
		if (object == rubber) {
			window.topPanel.drawLabel.setText(rubberText);

		}
	}

}
