package main;

public class MoneyHandler 
{
	private static double money;
	private static double purse;
	
	public MoneyHandler()
	{
		money = 0;
		purse = 500;
	}
	 
	public static void setMoney(double s)
	{
		money = s;
		money = StockData.round(money);
	}
	
	public static void updateMoney(double s)
	{
		money+=s;
		money = StockData.round(money);
	}
	
	public static double getMoney()
	{
		money = StockData.round(money);
		return money;
	}
	
	public static double getPurse()
	{
		purse = StockData.round(purse);
		return purse;
	}
	
	public static void updatePurse(double v)
	{
		purse+= v;
	}
	
	
}