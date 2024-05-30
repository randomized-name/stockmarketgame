package main;

import java.util.ArrayList;

public class StockHandler 
{
	private static Stock stock1;
	private static Stock stock2;
	private static Stock stock3;
	private static Stock[] stocks;
	ArrayList<String> names;
	
	public StockHandler()
	{
		names = new ArrayList<String>();
		setNames();
		stock1 = new Stock(getName(), 10.0, 0);
		stock2 = new Stock(getName(), 50.0, 1);
		stock3 = new Stock(getName(), 100.0, 2);
	}
	
	public static Stock getStock1()
	{
		return stock1;
	}
	
	public static Stock getStock2()
	{
		return stock2;
	}
	
	public static Stock getStock3()
	{
		return stock3;
	}
	
	public static Stock[] getStocks()
	{
		return stocks;
	}
	
	private void setNames()
	{
		names.add("Mo's Ties");
		names.add("Elon's Tires");
		names.add("Lew Bros' Construction");
		names.add("Job Technologies");
		names.add("Burt's Electronics");
		names.add("Selena's Cosmetics");
		names.add("Mario Plumbing");
		names.add("Patriot Aviation");
		names.add("Beesos Deals");
		names.add("Get Rich Quik Stock Advice");
	}
	
	private String getName()
	{
		int ran;
		ran = (int)(Math.random()*names.size());
		String a = names.get(ran);
		names.remove(ran);
		return a;
	}
}