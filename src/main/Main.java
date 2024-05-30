package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main 
{
	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame intro = new JFrame();
		
		intro.setName("Daytrading Simulator");
		intro.setSize(600,600);
		intro.setLocationRelativeTo(null);
		intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intro.setResizable(false);
		
		JPanel ip = new JPanel();
		ip.setLayout(new BorderLayout());
		ip.setBackground(Color.gray);
		
		JButton play = new JButton("Play");
		play.setPreferredSize(new Dimension(50,50));
		play.setFont(new Font("Serif", Font.BOLD, 30));
		
		ip.add(play, BorderLayout.SOUTH);
		
		JLabel text = new JLabel();
		text.setText("<html><center>Welcome!<br>"
				+ "Your grandma has recently gambled away all of your money!<br>"
				+ "However, you need 1000 dollars to finish off your debt to the Russian Mafia!<br>"
				+ "You have five days to transform 500 dollars into 1000 dollars!<br>"
				+ "Try your luck in the volatile and not at all realistic stock market!<br>"
				+ "Try not to lose all your money!</center></html>");
		text.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		ip.add(text, BorderLayout.CENTER);
		
		
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				intro.dispose();
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run()
					{
						Mainframe frame = new Mainframe();
					}
				});
			}
		});
		
		intro.add(ip);
		
		intro.setVisible(true);

		
		

	}
}