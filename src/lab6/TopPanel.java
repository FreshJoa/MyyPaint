package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TopPanel extends JPanel implements ActionListener {
	
	
	JLabel sizeLineLabel;
	JComboBox<String> sizeLine;
	JButton changeColor;
	static Color lineColor;
	Window window;
	String pix1;
	String pix5;
	String pix10;
	static int pixel=1;
	JLabel drawLabel;
	
	public TopPanel(Window window) {
		this.window=window;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		pix1=new String("1x pixel");
		pix5=new String("5x pixel");
		pix10=new String("10x pixel");
		sizeLine=new JComboBox<>();
		sizeLine.addItem(pix1);
		sizeLine.addItem(pix5);
		sizeLine.addItem(pix10);
		drawLabel=new JLabel("Options");
		sizeLineLabel=new JLabel("Line size");
		drawLabel.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 20));
		sizeLineLabel.setPreferredSize(new Dimension(80, 50));
		
		changeColor=new JButton("Change Color");
		sizeLine.setPreferredSize(new Dimension(100,30));
		add(sizeLineLabel);
		add(sizeLine);
		add(changeColor);
		add(drawLabel);
		setBackground(Color.pink);
		setBorder(BorderFactory.createBevelBorder(0));
		
		sizeLine.addItemListener(pixx);
		
		
		
		/*changeColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lineColor=JColorChooser.showDialog(null, "Choode line color", lineColor);
				Drawing.setLineColor(lineColor);
				
			}
			//window.paintPanel.repaint();
		});
		*/
		
		changeColor.addActionListener(this);
		
		
	}
	ItemListener pixx=new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem()==sizeLine.getItemAt(0)) {
				pixel=1;
				
			}
			 if(e.getItem()==sizeLine.getItemAt(1)) {
					pixel=5;
					
				}
			if(e.getItem()==sizeLine.getItemAt(2)) {
					pixel=10;
					
				}
				
			
		}
	};
/*
	*ctionListener pixx=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==pix1.to)
			pixel=1;
			
		}
			else if(e.getSource()==pix5) {
				pixel=5;
				
			}
			else if(e.getSource()==pix10) {
				pixel=10;
				
			}
			window.paintPanel.repaint();
	}
	};
	*/
	private void ActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	public TopPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public TopPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public TopPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==changeColor) {
			lineColor=JColorChooser.showDialog(null, "Choode line color", lineColor);
			
		}
	
		
	}

}


