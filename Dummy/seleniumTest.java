import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumTest {
	public static void main(String[] args) throws InterruptedException {
		// chrome 브라우저를 원격 조정하기 위한 객체
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jobkorea.co.kr/recruit/joblist?menucode=local&localorder=1");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 1. 직무 탭 클릭
		WebElement jobTab = wait.until(ExpectedConditions.elementToBeClickable(
			    By.cssSelector("p.btn_tit")
			    ));
        jobTab.click();
        
        // 2. 'AI개발데이터' 클릭
        WebElement aiDevData = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"devSearchForm\"]/div[2]/div/div[1]/dl[1]/dd[2]/div[2]/dl[1]/dd/div[1]/ul/li[6]/label/span/span")
        ));
        aiDevData.click();

        // 3. '백엔드개발자', '프론트엔드개발자', '웹개발자' 체크박스 클릭
        String[] jobIds = {
            "duty_step2_1000229", // 백엔드개발자
            "duty_step2_1000230", // 프론트엔드개발자
            "duty_step2_1000232"  // 웹개발자
        };

        for (String id : jobIds) {
            WebElement label = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("label[for='" + id + "']")
            ));
            label.click();
        }

        // 4. 선택된 조건 검색 버튼 클릭
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("#dev-btn-search")
        ));
        searchBtn.click();
        
        
        // 5. 채용공고 리스트 가져오기
        // 결과 페이지 로드될 때까지 대기
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".list-default") // 공고 리스트 영역
        ));

        // 공고 제목 <a> 태그 가져오기
        List<WebElement> jobPostings = driver.findElements(
            By.cssSelector(".list-default .title a")
        );

        System.out.println("🔗 채용 공고 리스트 (최대 40개):");
        int count = 1;
        for (WebElement posting : jobPostings) {
            String title = posting.getText().trim();
            String link = posting.getAttribute("href");
            System.out.println(count + ". " + title + " (" + link + ")");
            count++;
        }

        // 검색 결과 페이지를 10초간 유지
        Thread.sleep(10000);
	}
}
