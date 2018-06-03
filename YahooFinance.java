import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class YahooFinance
{
	public static void main(String[] args)
	{
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		HtmlPage myPage;
		try 
		{
			myPage = webClient.getPage("https://finance.yahoo.com/quote/" + "TSLA" + "?p=" + "TSLA");
			String pageSource = myPage.asXml();
			String pageText = myPage.asText();
			System.out.println(pageText);
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
		
	}
	}

