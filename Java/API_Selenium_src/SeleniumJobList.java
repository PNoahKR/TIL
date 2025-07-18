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

public class seleniumJobList {
	public static void main(String[] args) throws InterruptedException {
		
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
            "duty_step2_1000231"  // 웹개발자
        };

        for (String id : jobIds) {
            WebElement label = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("label[for='" + id + "']")
            ));
            label.click();
        }
        
        // 기존 공고 하나 기억
        WebElement oldFirstRow = wait.until(ExpectedConditions.presenceOfElementLocated(
        	    By.cssSelector("tr.devloopArea")
        	));
        
        // 4. 선택된 조건 검색 버튼 클릭
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("#dev-btn-search")
        ));
        searchBtn.click();
        
        // 기존 공고가 사라지기를 기다림 (새 리스트로 바뀐 것을 보장)
        wait.until(ExpectedConditions.stalenessOf(oldFirstRow));

        // 6. 채용공고 40개 가져오기
        List<WebElement> jobRows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.cssSelector("tr.devloopArea")
        ));

        // 최대 40개만 추출
        int maxJobs = Math.min(jobRows.size(), 40);

        // 마크다운 언어로 정리
        System.out.println("| 회사명 | 공고 제목 | 링크 | 마감일 |");
        System.out.println("|--------|------------|------|--------|");

        for (int i = 0; i < maxJobs; i++) {
            WebElement row = jobRows.get(i);

            String company = row.findElement(By.cssSelector("td.tplCo a")).getText().trim();
            WebElement titleAnchor = row.findElement(By.cssSelector("td.tplTit strong a"));
            String title = titleAnchor.getText().trim();
            String partialLink = titleAnchor.getAttribute("href").trim();
            String fullLink = partialLink.startsWith("http") ? partialLink : "https://www.jobkorea.co.kr" + partialLink;

            String deadline = "";
            try {
                deadline = row.findElement(By.cssSelector("td.odd span.date")).getText().trim();
            } catch (Exception e) {
                deadline = "마감일 정보 없음";
            }

            System.out.printf("| %s | %s | [바로가기](%s) | %s |\n", company, title, fullLink, deadline);
        }
        String[][] jobData = new String[maxJobs][4];

        for (int i = 0; i < maxJobs; i++) {
            WebElement row = jobRows.get(i);

            String company = row.findElement(By.cssSelector("td.tplCo a")).getText().trim();
            WebElement titleAnchor = row.findElement(By.cssSelector("td.tplTit strong a"));
            String title = titleAnchor.getText().trim();
            String partialLink = titleAnchor.getAttribute("href").trim();
            String fullLink = partialLink.startsWith("http") ? partialLink : "https://www.jobkorea.co.kr" + partialLink;
            String deadline = "마감일 정보 없음";

            try {
                deadline = row.findElement(By.cssSelector("td.odd span.date")).getText().trim();
            } catch (Exception ignored) {}

            jobData[i][0] = company;
            jobData[i][1] = title;
            jobData[i][2] = fullLink;
            jobData[i][3] = deadline;
        }
        
        JobListViewer.showJobTable(jobData);
	}
}
