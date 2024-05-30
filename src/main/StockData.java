package main;

import java.text.DecimalFormat;

public class StockData 
{
	public static double stockValues[][];
	
	public StockData()
	{
		stockValues = new double[10][120];
		setValues();
	}

	private void setValues() 
	{
		
		//double[] tMobile = {15.48, 11.32, 12.48, 14.20, 15.46, 17.80, 16.54, 18.28, 18.00, 21.20, 20.96, 24.74, 25.52, 26.16, 28.84, 
		//		32.56, 33.92, 35.58, 34.32, 32.06, 22.30, 17.30, 15.76, 16.66, 17.82, 17.82, 20.60, 18.02, 14.52, 12.28, 12.14, 17.66,
		//		19.40, 23.50, 20.40, 21.36, 20.00, 20.20, 19.64, 21.86, 17.53/*?*/, 16.25, 20.31/*?*/, 21.76, 24.75, 24.30, 23.54,
		//		26.35, 27.83, 26.03, 33.03, 30.45, 30.26, 33.12, 31.77, 34.16, 33.57, 33.00, 30.61, 28.76, 29.06, 28.99, 27.10, 30.55,
		//		32.82, 31.76, 34.12, 39.04, 38.95, 40.69, 38.82, 39.95, 37.66, 35.86, 38.86, 40.04, 37.03, 38.06, 39.36, 42.50, 43.16,
		//		46.54, 46.41, 46.54, 49.68, 54.11, 58.10, 62.26, 62.66, 64.20, 67.83, 67.42, 60.74, 62.10, 64.78, 61.34, 60.14, 60.35,
		//		63.90, 64.70, 60.78, 60.40, 60.77, 56.00, 59.46, 59.95, 65.74, 70.71, 68.96, 68.50, 62.87, 69.46, 72.39, 69.54, 73.14,
		//		73.62, 74.67, 79.99, 77.90, 78.88};
		
		stockValues[0][0] = 10.0;
		stockValues[1][0] = 50.0;
		stockValues[2][0] = 100.0;
	
		
		double stockMult = random();
		int swap;
		
		for(int a = 0; a<3; a++)
		{
			for(int i = 1; i<120; i++)
			{
				swap = (int)(Math.random()*2 + 1);
				stockMult = random();
				int ran;

				
				if(swap == 1)
				{
					if(stockMult<0.05)
					{
						stockValues[a][i] = round(stockValues[a][i-1] * (stockMult+1));	
					}
					else if(stockMult < 0.15)
					{
						ran = (int)(Math.random()*2+1);
							if(ran == 2)
							{
								i--;
								continue;
							}
							stockValues[a][i] = round(stockValues[a][i-1] * (stockMult+1));
					}
					else if(stockMult < 0.25)
					{
						ran = (int)(Math.random()*4+1);
						if(ran == 4)
						{
							stockValues[a][i] = round(stockValues[a][i-1] * (stockMult+1));
						}
						else
						{
							i--;
							continue;
						}
							
					}
					else
					{
						ran = (int)Math.random() * 10 + 1;
						if(ran == 10)
						{
							stockValues[a][i] = round(stockValues[a][i-1] * (stockMult+1));
						}
						else
						{
							i--;
							continue;
						}
					}
				}
				
				if(swap == 2)
				{
					if(stockMult>0.95)
					{
						stockValues[a][i] = round(stockValues[a][i-1] * stockMult);	
					}
					else if(stockMult > 0.85)
					{
						ran = (int)(Math.random()*2+1);
							if(ran == 2)
							{
								i--;
								continue;
							}
							stockValues[a][i] = round(stockValues[a][i-1] * stockMult);
					}
					else if(stockMult > 0.75)
					{
						ran = (int)(Math.random()*4+1);
						if(ran == 4)
						{
							stockValues[a][i] = round(stockValues[a][i-1] * stockMult);
						}
						else
						{
							i--;
							continue;
						}
							
					}
					else
					{
						ran = (int)Math.random() * 10 + 1;
						if(ran == 10)
						{
							stockValues[a][i] = round(stockValues[a][i-1] * stockMult);
						}
						else
						{
							i--;
							continue;
						}
					}
				}
			}
		}
	}
		
		
		
		
		
	
	
	public static double[][] getStockValues()
	{
		return stockValues;
	}
	
	public double random()
	{
		double a = (double)(Math.random());
		while(round(a)==0.0 || round(a) == 1.0)
		{
			a = (double)(Math.random());
		}
		return round(a);
	}
	
	public static double round(double a)
	{
		double acc = 20;
	    String fmt = "%.2f";
	    a *= acc;
	    a = Math.ceil(a);
	    a /= acc;
	    return Double.parseDouble(String.format(fmt, a));
	}
	
	
}