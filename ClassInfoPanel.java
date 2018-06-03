import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
public class ClassInfoPanel extends JPanel
{
	private JLabel stockName;
	public ClassInfoPanel(String tickerIn)
	{
		Stock stock = new Stock(tickerIn);
        setOpaque(false);
        setLayout(new GridBagLayout());
		stockName = new JLabel(tickerIn);
		stockName.setFont(new Font("Serif", 100, 100));
		stockName.setBorder(new LineBorder(Color.white, 5));
		stockName.setOpaque(true);
		stockName.setBackground(Color.LIGHT_GRAY);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK,5);
		stockName.setBorder(BorderFactory.createCompoundBorder(border1, border1));
		
		
		
		JTextArea area = new JTextArea();
		area.setFont(new Font("Serif", 40, 40));
		area.setPreferredSize(new Dimension(800,600));
		area.append("Current Price: " + stock.getCurrentPriceFromYahooFinance(tickerIn));
		area.append("\n");
		area.append(stock.getAllData(tickerIn));
		
		  
		
		
		
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK,5);
		area.setBorder(BorderFactory.createCompoundBorder(border, border));
		area.setBackground(Color.LIGHT_GRAY);
	
		JButton button = new JButton("Back");
	
		button.setPreferredSize(new Dimension(300,100));
		button.setFont(new Font("Serif", Font.PLAIN, 50));
		
		add(button );
		class BackButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				removeAll();
				
				JFrame frame = new StockInsightFrame();
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setContentPane(StockInsightFrame.getBackgroundPanel());
				frame.setResizable(true);
			}
		}
		button.addActionListener(new BackButtonListener());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 50;
        gbc.gridy = 50;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(stockName, gbc);
        
        
        gbc.gridy++;
        gbc.insets = new Insets(50, 0, 0, 0);
        add(area,gbc);
        gbc.gridy++;
        gbc.insets = new Insets(50, 0, 0, 0);
        add(button, gbc);
	}
	
}





