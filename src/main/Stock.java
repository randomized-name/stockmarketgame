package main;

public class Stock 
{
	private String name;
	private double value;
	private int count;
	private double[] stockData;
	
	public Stock(String n, double v, int stockID)
	{
		name = n;
		value = v;
		stockData = StockData.getStockValues()[stockID];
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public double[] getStockData()
	{
		return stockData;
	}
	
	public void updateValue(double val)
	{
		value=val;
	}
	
	public void buyStock()
	{
		count++;
	}
	
	public void sellStock()
	{
		count--;
	}
	
	
	

}