import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class StockInsightFrame extends JFrame
{
	

	private JLabel stockLabel;
	private JTextField stockField;
	private JButton button;
	private JLabel currentPriceLabel;
	public JPanel panel;
	private JPanel backgroundPanel;
	private JLabel stockName;
	public static BackgroundPanel background;
	
	public static BackgroundPanel getBackgroundPanel()
	{
		return background;
	}
	public StockInsightFrame()
	{
		createSearchBar();
		createButton();
		createPanel();
		setSize(1920,1080 );
		setTitle("Stock Insight");
		setFont(new Font("helvetica", 250, 250));
	}
	
	
	public void createSearchBar()
	{
		stockLabel = new JLabel("Stock: ");
		stockLabel.setFont(new Font("helvetica", Font.BOLD, 100));
		stockLabel.setForeground(Color.WHITE);
		stockLabel.setBorder(new LineBorder(Color.white, 5));
		stockLabel.setPreferredSize(new Dimension(350,100));
		stockLabel.setBackground(Color.LIGHT_GRAY);
		stockLabel.setOpaque(true);
		stockField = new JTextField();
		stockField.setFocusable(true);
		stockField.setPreferredSize(new Dimension(500,100));
		stockField.setText("Enter ticker-symbol");
		stockField.setFont(new Font("Serif", Font.PLAIN, 50));
		class MousePressListener implements MouseListener
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				stockField.setText("");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		stockField.addMouseListener(new MousePressListener());
	
		   stockField.addKeyListener(new KeyAdapter()
		    {
		      public void keyPressed(KeyEvent e)
		      {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER)
		        {
		        	
		        	
		        	panel.removeAll();
		        	
					panel.add(new ClassInfoPanel(stockField.getText()));
					revalidate();
					repaint();
					
		        }
		      }
		    });
		    
	}
		
	public void createButton()
	{
		button = new JButton("Search");
		button.setPreferredSize(new Dimension(300,100));
		button.setFont(new Font("Serif", Font.PLAIN, 50));
		class SearchStockListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				panel.removeAll();
				panel.add(new ClassInfoPanel(stockField.getText()));
				revalidate();
				repaint();
			}
		}
		button.addActionListener(new SearchStockListener());
	}
	public void createPanel()
	{
		GridBagConstraints c = new GridBagConstraints();
		panel = new AbovePanel();
		backgroundPanel = new BellowPanel();
		backgroundPanel.setLayout(new BorderLayout());
		panel.add(stockLabel);
		panel.add(stockField);
		panel.add(button);
		backgroundPanel.add(panel, BorderLayout.CENTER);
		add(backgroundPanel);
	}
}