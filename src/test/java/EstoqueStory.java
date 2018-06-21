import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EstoqueStory
{

	static WebDriver driver;

	WebElement quantidade, valorUnitario, valorTotal;

	@Given("estou na lista de compras")
	public void naListaDeCompras()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver");
		driver = new ChromeDriver();
		driver.get("file:///home/ptlab01/Downloads/estoque/src/main/webapp/lista-compras.html");
	}

	@When("informo que adquiri $units unidades")
	public void informaUnidades(int units)
	{
		quantidade = driver.findElement(By.id("quantidade"));
		quantidade.sendKeys(String.valueOf(units));
	}

	@When("informo que o custo por unidade foi de $reais reais")
	public void informaCusto(int reais)
	{
		valorUnitario = driver.findElement(By.id("valorUnitario"));
		valorUnitario.sendKeys(String.valueOf(reais));
		valorUnitario.sendKeys(Keys.ENTER);
	}

	@Then("o valor total apresentado sera de $reais reais")
	public void verificaValorApresentado(String reais)
	{
		valorTotal = driver.findElement(By.id("valorTotal"));
		Assert.assertEquals(reais, valorTotal.getAttribute("value"));
		driver.close();
		driver.quit();
	}

}