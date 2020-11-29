package cucumber;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static java.lang.System.setProperty;

public class AvitoSiteTest

{
    public WebDriver driver;

    @Before
    public  void setUp () throws InterruptedException
    {
        setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }

    @Допустим("Мы находимся на главной странице сайта")
    public  void openSite ()
    {
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/");
        //out.println(driver.getPageSource());
    }

    @ParameterType(".*")
    public AdsCategory a_category(String a_category) {
        return AdsCategory.valueOf(a_category);
    }

    @И("выбран тип значения категории поиска {a_category}")
    public void selectAdsCategory(AdsCategory a_category) throws InterruptedException
    {
        Thread.sleep(2000);
        //driver.findElement(By.id("a_category")).click();
        driver.findElement(By.xpath(a_category.type)).click();
    }

    @Также("^выполнен поиск по значению (.*)")
    public void inputPrinter(String request) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("search")).sendKeys(request);
    }

    @Тогда("выбран тип значения категории региона")
    public void setRegion() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='main-select-2pf7p main-location-3j9by']")).click();
        Thread.sleep(1000);
    }

    @Тогда("^теперь выполнен поиск по значению (.*)")
    public void inputCity(String city) throws InterruptedException {
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys(city);
        Thread.sleep(8000);
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
    }

    @И("использована кнопка показать объявления")
    public void showAds() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        Thread.sleep(1000);
    }

    @И("активирован чекбокс 'С Авито Доставкой'")
    public void activateDelivery() throws InterruptedException
    {
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']"));
        if (!checkBox.isSelected()) {
            checkBox.click();
            Thread.sleep(2000);
        }
    }

    @И("использована кнопка тип сортировки")
    public void selectButtonSort () throws InterruptedException
    {
        driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")).click();
        Thread.sleep(1000);
    }

    @ParameterType(".*")
    public SortCategory s_category(String s_category) {
        return SortCategory.valueOf(s_category);
    }

    @И("выбран тип значения категории сортировки {s_category}")
    public void selectSortCategory(SortCategory s_category) throws InterruptedException
    {
        Thread.sleep(2000);
        //driver.findElement(By.id("s_category")).click();
        driver.findElement(By.xpath(s_category.type)).click();
    }

    @И("^получено значение первых (\\d+) позиций") // {int},{word}(захватывает одно слово),{string}(захватывает слово в кавычках)
    public void getInfo(Integer quantity) {
        List<WebElement> printers = driver.findElements(By.xpath("//div[@class='item_table-wrapper']"));
        for (int i = 0; i < quantity; i++) {
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-title-row']/h3/a")).getText());
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-price-row']/span[@class='snippet-price ']")).getText());
        }
    }

    @Тогда("закрыть браузер")
    public void closeBrowser()
    {
        driver.quit();
    }
}











