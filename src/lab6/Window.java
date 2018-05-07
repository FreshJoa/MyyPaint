package lab6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Window extends JFrame {

	LeftPanel leftPanel;
	TopPanel topPanel;
	PaintPanel paintPanel;
	JMenuBar menuBar;
	Menu menu;
	MauseListenersClass mauseListener;

	public Window() throws IOException {
		leftPanel = new LeftPanel(this);

		topPanel = new TopPanel(this);
		paintPanel = new PaintPanel(this, mauseListener, menu);
		mauseListener = new MauseListenersClass(this, paintPanel);

		menu = new Menu(this, paintPanel);
		menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);

		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.PAGE_START);
		add(leftPanel, BorderLayout.WEST);
		add(paintPanel, BorderLayout.CENTER);

		setSize(1300, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Paint");

	}

	public Window(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Window(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Window(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() { // dzieki temu obrazki zapisane na pulpicie mają ikonki
			@Override
			public void run() {
				try {
					new Window().setVisible(true);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		});

	}

}
