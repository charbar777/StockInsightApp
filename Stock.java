import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Stock 
{
	private String ticker;
	private String currentPrice;
	private String allData;
	public Stock(String tickerIn)
	{
		ticker = tickerIn;
		currentPrice = getCurrentPriceFromYahooFinance(tickerIn);
	}
	public String getStockData(String tickerIn)
	{
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		HtmlPage myPage;
		try 
		{
			myPage = webClient.getPage("https://finance.yahoo.com/quote/" + tickerIn + "?p=" + tickerIn);
			String pageSource = myPage.asXml();
			String pageText = myPage.asText();
			return pageText;
		} 
		catch (FailingHttpStatusCodeException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Incorrect Ticker Symbol";
	}
	public String getCurrentPriceFromYahooFinance(String tickerIn)
	{
		String pageText = getStockData(tickerIn);
		int location = 0;
		for(int i = 0; i<pageText.length()/2; i++)
		{
			if(pageText.substring(i, i+9).equalsIgnoreCase("Watchlist"))
			{
				location = i + 10;
				
			}
			
		
		}
		if(location != 0)
			return pageText.substring(location, location + 7);
		else
			return "Stock price not found";
	}
	public String returnCurrentPrice()
	{
		return currentPrice;
	}
	public String getAllData(String tickerIn)
	{
		String pageText = getStockData(tickerIn);
		int startLocation = 0;
		int endLocation = 0;
		for(int i = 0; i<pageText.length()/2; i++)
		{
			if(pageText.substring(i, i+4).equalsIgnoreCase("Open"))
			{
				startLocation = i;
				
			}
		}
		for(int i = 0; i<pageText.length(); i++)
		{
			if(pageText.substring(i, i+8).equalsIgnoreCase("Earnings"))
			{
				endLocation = i-1;
				break;
			}
		}
		if(startLocation != 0 && endLocation !=0)
			return pageText.substring(startLocation, endLocation);
		else
			return "Stock price not found";
	}
}

	

