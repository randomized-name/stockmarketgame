package main;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Mainframe
{
	private static JFrame frame;
	private static JPanel panel;
	private static GridBagConstraints gbc;
	static Thread thread;
	static int count = 0;
	private JLabel stock1Display;
	private JLabel stock2Display;
	private JLabel stock3Display;
	private static JLabel moneyDisplay;
	private static JLabel purseDisplay;
	private static JLabel day;
	private static JPanel end;
	StockHandler stockHandler;
	MoneyHandler moneyHandler;
	
	public Mainframe()
	{
		StockData data = new StockData();
		panel = new JPanel();
		stockHandler = new StockHandler();
		gbc = new GridBagConstraints();
		this.initialize();
	}
	
	private void initialize()
	{
		
		
		frame = new JFrame();
		frame.setTitle("Daytrading Simulator");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		panel.setLayout(new GridBagLayout());
		
		
		
		panel.setBackground(Color.GRAY);
		
		stock1Display = new JLabel("0");
		stock1Display.setFont(new Font("Serif", Font.BOLD, 20));
		stock2Display = new JLabel("0");
		stock2Display.setFont(new Font("Serif", Font.BOLD, 20));
		stock3Display = new JLabel("0");
		stock3Display.setFont(new Font("Serif", Font.BOLD, 20));
		moneyDisplay = new JLabel("0");
		moneyDisplay.setFont(new Font("Serif", Font.BOLD, 65));
		moneyDisplay.setForeground(Color.green.darker());
		purseDisplay = new JLabel("Purse: 500.00");
		purseDisplay.setFont(new Font("Serif", Font.BOLD, 30));
		purseDisplay.setForeground(Color.magenta.darker());

		
		buyStock();
		sellStock();
		
		moneyHandler = new MoneyHandler();
		
		updateData();
		
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		
		gbc.gridx = 0;
		gbc.gridy = 5;

		panel.add(stock1Display,gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(stock2Display,gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		panel.add(stock3Display,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		panel.add(moneyDisplay,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 1;
		panel.add(purseDisplay,gbc);
		
		day = new JLabel("day");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth=0;
		gbc.gridheight=1;
		panel.add(day, gbc);
		
		
		
		frame.add(panel);
		
		
		
		frame.setVisible(true);
		
	}
	
	public static void updateData() // changes stock value every 10 seconds
	{
		
		JLabel stock1Value = new JLabel("10");
		stock1Value.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel stock2Value = new JLabel("50");
		stock2Value.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel stock3Value = new JLabel("100");
		stock3Value.setFont(new Font("Serif", Font.BOLD, 20));
		
		gbc.insets = new Insets(10,10,10,10);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(stock1Value, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(stock2Value, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(stock3Value, gbc);
		
		thread=new Thread(){
			@Override
	          public void run() {
				while(true)
				{	
	              try{
	            	  StockHandler.getStock1().updateValue(StockHandler.getStock1().getStockData()[count]);
	                  stock1Value.setText(format(StockHandler.getStock1().getStockData()[count]));
	                  
	                  if(count!=0)
	                  {
		                  if(StockHandler.getStock1().getStockData()[count] >= StockHandler.getStock1().getStockData()[count-1])
		                  {
		                	  stock1Value.setBackground(Color.GREEN);
		                	  stock1Value.setForeground(Color.GREEN);
		                  }
		                  else
		                  {
		                	  stock1Value.setBackground(Color.RED);
		                	  stock1Value.setForeground(Color.RED);
		                  }
	                  }
	                  if(count==0)
	                	  day.setText("Day 1");
	                  if(count==23)
	                	  day.setText("Day 2");
	                  if(count==47)
	                	  day.setText("Day 3");
	                  if(count==71)
	                	  day.setText("Day 4");
	                  if(count==95)
	                	  day.setText("Day 5");
	                  
	                  
	                  
	                  StockHandler.getStock2().updateValue(StockHandler.getStock2().getStockData()[count]);
	                  stock2Value.setText(format(StockHandler.getStock2().getStockData()[count]));
	                  
	                  if(count!=0)
	                  {
		                  if(StockHandler.getStock2().getStockData()[count] >= StockHandler.getStock2().getStockData()[count-1])
		                  {
		                	  stock2Value.setBackground(Color.GREEN);
		                	  stock2Value.setForeground(Color.GREEN);
		                  }
		                  else
		                  {
		                	  stock2Value.setBackground(Color.RED);
		                	  stock2Value.setForeground(Color.RED);
		                  }
	                  }
	                  
	                  StockHandler.getStock3().updateValue(StockHandler.getStock3().getStockData()[count]);
	                  stock3Value.setText(format(StockHandler.getStock3().getStockData()[count]));
	                  
	                  if(count!=0)
	                  {
		                  if(StockHandler.getStock3().getStockData()[count] >= StockHandler.getStock3().getStockData()[count-1])
		                  {
		                	  stock3Value.setBackground(Color.GREEN);
		                	  stock3Value.setForeground(Color.GREEN);
		                  }
		                  else
		                  {
		                	  stock3Value.setBackground(Color.RED);
		                	  stock3Value.setForeground(Color.RED);
		                  }
	                  }
	                  
	                  MoneyHandler.setMoney(StockHandler.getStock1().getValue() * StockHandler.getStock1().getCount()
	                		  + StockHandler.getStock2().getValue() * StockHandler.getStock2().getCount()
	                		  + StockHandler.getStock3().getValue() * StockHandler.getStock3().getCount()
	                		  );
	                  moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                  
	                  purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	                  
	                  Thread.sleep(5000);
	                  count++;
	                  
	                  if(count > 119)
	                  {
	                	  endgame();
	                	  break;
	                  }
	                  
		              if(MoneyHandler.getMoney() + MoneyHandler.getPurse() >= 1000)
		          	  {
		                  endgame();
		                  break;
		          	  }
	                  
	                  
	              } catch(InterruptedException v){System.out.println(v);}
	              
	          }
			}
	      };
	      thread.start();
		
		

	}
	
	private static void endgame()
	{
		frame.getContentPane().removeAll();
		end = new JPanel();
		end.setLayout(new BorderLayout());
		JLabel text;
		
		if(MoneyHandler.getMoney() + MoneyHandler.getPurse() >= 1000)
		{
			end.setBackground(Color.WHITE);
			text = new JLabel("<html><center>Yay! <br>You won! <br>Good job!");
			text.setFont(new Font("Monospaced", Font.BOLD, 70));
		}
		else
		{
			end.setBackground(Color.BLACK);
			text = new JLabel("<html><center>Oops. <br>You failed. <br>You should hide now.<br> The Mafia is out for you.");
			text.setForeground(Color.WHITE);
			text.setFont(new Font("Monospaced", Font.BOLD, 40));
		}
		end.add(text);
		frame.add(end);
		frame.setVisible(true);
	}
	
	private void buyStock()
	{
		JButton buyButton = new JButton("Buy Stock");
		
		gbc.insets = new Insets(10,10,10,10);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		buyButton.setPreferredSize(new Dimension(100,50));
		buyButton.setFont(new Font("Arial", Font.BOLD, 15));
		buyButton.setMargin(new Insets(1,1,1,1));
		buyButton.setForeground(Color.BLUE);
		buyButton.setBackground(Color.BLUE);
		panel.add(buyButton, gbc);
		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(StockHandler.getStock1().getValue() <= MoneyHandler.getPurse())
				{
					MoneyHandler.updatePurse(-1*(StockHandler.getStock1().getValue()));
					StockHandler.getStock1().buyStock();
					MoneyHandler.updateMoney(StockHandler.getStock1().getValue());
					moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	
	                stock1Display.setText(Integer.toString((int)StockHandler.getStock1().getCount()));				}
				}
			}
			
		
		
		);
		
		JButton buyButton1 = new JButton("Buy Stock");
		gbc.gridx = 1;
		gbc.gridy = 3;
		buyButton1.setPreferredSize(new Dimension(100,50));
		buyButton1.setFont(new Font("Arial", Font.BOLD, 15));
		buyButton1.setMargin(new Insets(1,1,1,1));
		buyButton1.setForeground(Color.BLUE);
		buyButton1.setBackground(Color.BLUE);
		panel.add(buyButton1, gbc);
		buyButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(StockHandler.getStock2().getValue() <= MoneyHandler.getPurse())
				{
					MoneyHandler.updatePurse(-1*(StockHandler.getStock2().getValue()));
					StockHandler.getStock2().buyStock();
					MoneyHandler.updateMoney(StockHandler.getStock2().getValue());
					moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	                stock2Display.setText(Integer.toString((int)StockHandler.getStock2().getCount()));				}
			}
			
		}
		
		);
		
		JButton buyButton2 = new JButton("Buy Stock");
		gbc.gridx = 2;
		gbc.gridy = 3;
		buyButton2.setPreferredSize(new Dimension(100,50));
		buyButton2.setFont(new Font("Arial", Font.BOLD, 15));
		buyButton2.setMargin(new Insets(1,1,1,1));
		buyButton2.setForeground(Color.BLUE);
		buyButton2.setBackground(Color.BLUE);
		panel.add(buyButton2, gbc);
		buyButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(StockHandler.getStock3().getValue() <= MoneyHandler.getPurse())
				{
					MoneyHandler.updatePurse(-1*(StockHandler.getStock3().getValue()));
					StockHandler.getStock3().buyStock();
					MoneyHandler.updateMoney(StockHandler.getStock3().getValue());
					moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	                stock3Display.setText(Integer.toString((int)StockHandler.getStock3().getCount()));				}
	            }
			
			
		}
		
		);
	}
	
	private void sellStock()
	{
		JButton sellButton = new JButton("Sell Stock");
		gbc.gridx = 0;
		gbc.gridy = 4;
		sellButton.setPreferredSize(new Dimension(100,50));
		sellButton.setFont(new Font("Arial", Font.BOLD, 15));
		sellButton.setMargin(new Insets(1,1,1,1));
		sellButton.setForeground(Color.BLUE);
		sellButton.setBackground(Color.BLUE);
		panel.add(sellButton, gbc);
		sellButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(StockHandler.getStock1().getCount() > 0)
				{
					MoneyHandler.updatePurse((StockHandler.getStock1().getValue()));
					StockHandler.getStock1().sellStock();
					MoneyHandler.updateMoney(-1*(StockHandler.getStock1().getValue()));
					moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	                stock1Display.setText(Integer.toString((int)StockHandler.getStock1().getCount()));				}
			}
			
		}
		
		);
		
		JButton sellButton1 = new JButton("Sell Stock");
		gbc.gridx = 1;
		gbc.gridy = 4;
		sellButton1.setPreferredSize(new Dimension(100,50));
		sellButton1.setFont(new Font("Arial", Font.BOLD, 15));
		sellButton1.setMargin(new Insets(1,1,1,1));
		sellButton1.setForeground(Color.BLUE);
		sellButton1.setBackground(Color.BLUE);
		panel.add(sellButton1, gbc);		
		sellButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StockHandler.getStock2().getCount() > 0)
				{
					StockHandler.getStock2().sellStock();
					MoneyHandler.updatePurse((StockHandler.getStock2().getValue()));
					MoneyHandler.updateMoney(-1*(StockHandler.getStock2().getValue()));
					moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	                stock2Display.setText(Integer.toString((int)StockHandler.getStock2().getCount()));				}
			}
			
		}
		
		);
		
		JButton sellButton2 = new JButton("Sell Stock");
		gbc.gridx = 2;
		gbc.gridy = 4;
		sellButton2.setPreferredSize(new Dimension(100,50));
		sellButton2.setFont(new Font("Arial", Font.BOLD, 15));
		sellButton2.setMargin(new Insets(1,1,1,1));
		sellButton2.setForeground(Color.BLUE);
		sellButton2.setBackground(Color.BLUE);
		panel.add(sellButton2, gbc);		
		sellButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StockHandler.getStock3().getCount() > 0)
				{
					StockHandler.getStock3().sellStock();
					MoneyHandler.updatePurse((StockHandler.getStock3().getValue()));
					MoneyHandler.updateMoney(-1*(StockHandler.getStock3().getValue()));
					moneyDisplay.setText(format(MoneyHandler.getMoney()));
	                purseDisplay.setText("Wallet: " + format(MoneyHandler.getPurse()));
	                stock3Display.setText(Integer.toString((int)StockHandler.getStock3().getCount()));				}
			}
			
		}
		
		);
	}
	
	public static String format(double num) {
	    double acc = 20;
	    String fmt = "%.2f";
	    num *= acc;
	    num = Math.ceil(num);
	    num /= acc;
	    return String.format(fmt, num);
	}

	

	

}