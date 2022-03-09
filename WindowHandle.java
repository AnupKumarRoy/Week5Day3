package week5day3;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String parent = driver.getWindowHandle();
		driver.findElement(By.id("home")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> arrayList = new ArrayList<String>(windows);
		driver.switchTo().window(arrayList.get(1));
		driver.findElement(By.xpath("//h5[text()='Edit']/..")).click();
		driver.switchTo().window(arrayList.get(1)).close();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windows1 = driver.getWindowHandles();
		System.out.println("multiple window is "+windows1.size());
		List<String> arrayList1 = new ArrayList<String>(windows1);
		System.out.println(arrayList1.size());
		for (int i = 1; i < arrayList1.size(); i++) {
		driver.switchTo().window(arrayList1.get(i)).close();
		}
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windows2 = driver.getWindowHandles();
		List<String> arrayList2 = new ArrayList<String>(windows2);
		System.out.println(arrayList2.size());
		driver.switchTo().window(arrayList2.get(0)).close();
		driver.switchTo().window(arrayList2.get(2)).close();
		driver.switchTo().window(arrayList2.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//h5[text()='Window']/..")).click();
		WebElement findElement = driver.findElement(By.id("color"));
		findElement.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findElement));
		
	
	
	
	
	
	
	
	}

}
