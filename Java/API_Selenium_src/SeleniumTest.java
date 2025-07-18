import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        // chrome 브라우저를 원격 조종하기 위한 객체
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.naver.com/");
//
//
//        // 증권 HTML요소의 CSS 선택자... 아래와 같음 ㅎㅎ
//        // #shortcutArea > ul > li:nth-child(6) > a
        WebElement financeBtn = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
//

        // 현재 페이지의 핸들을 저장해두기
        String mainPage = driver.getWindowHandle();

//        // 클릭!
        financeBtn.click();

        // 기존 탭 닫기
        driver.switchTo().window(mainPage).close();

        // 모든 핸들 취득하여 finance 페이지로 핸들 스위칭
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            driver.switchTo().window(handle);
        }

//        driver.get("https://finance.naver.com/");
        WebElement inputTag = driver.findElement(By.cssSelector("#stock_items"));
//
//        // "삼성전자"를 입력하고 엔터!
        inputTag.sendKeys("삼성전자");
        inputTag.sendKeys(Keys.ENTER);

        // 주요 뉴스의 CSS 선택자
        // #content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li:nth-child(1) > span > a
        // #content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li > span > a
//        List<WebElement> elements = driver.findElements(By.cssSelector("#content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li > span > a"));
////        System.out.println(elements);
//        for(WebElement element : elements) {
//            System.out.println(element.getText());
//        }
    }
}