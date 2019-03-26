package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.lang.*;
import java.util.List;
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ironman\\Desktop\\geckodriver.exe");
		String url = "https://www.youtube.com/watch?v=59WpjC9JpBU";

	    WebDriver driver = new FirefoxDriver();

	    // Navigate to URL
	   
	    driver.get(url);
	    JavascriptExecutor js;
	    if (driver instanceof JavascriptExecutor) {
	        js = (JavascriptExecutor)driver;
	        Thread t = Thread.currentThread();
	        WebElement body = driver.findElement(By.tagName("body"));
	        
	        try {
	        	
	        	t.sleep(5000);
	        }catch(Exception e) {
	        	System.out.println("error time sleep");
	        }
	        
	        String tmp ="-1";
	        String current;
	        boolean condition = false; 
	        do {
	        	body.sendKeys(Keys.PAGE_DOWN);
	        	try {
		        	
		        	t.sleep(5000);
		        }catch(Exception e) {
		        	System.out.println("error time sleep");
		        }
	        	current = String.valueOf(js.executeScript("return window.pageYOffset;"));
	        	System.out.println("\n current scroll" + current);
	        	condition = !current.equals(tmp);
	        	tmp = current;
	        }while(condition);
		      
	       
	        
	    };
	    
	    
	   
	    String html = driver.getPageSource();
	    Document js1 = Jsoup.parse(html);
	    Element e0 =  js1.getElementsByTag("body").first();
	    Element list = e0.getElementsByTag("ytd-app").first().getElementById("content").getElementById("page-manager").getElementsByTag("ytd-watch-flexy").first().getElementById("columns").getElementById("primary").getElementById("primary-inner").getElementById("comments").getElementById("sections").getElementById("contents");
	    List<Element> ListComment = list.getElementsByTag("ytd-comment-renderer");
	   
	    int count = 0;
	    for(Element e : ListComment) {
	    	count++;
	    	System.out.println("comment "+ count + "   : " + e.getElementById("comment").getElementById("body").getElementById("main").getElementById("expander").getElementById("content").getElementById("content-text").ownText() );
	    	System.out.println("\n\n");
	    }
	    driver.quit();
	}

}
