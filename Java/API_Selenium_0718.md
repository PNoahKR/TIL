# API(Application Programming Interface)


: 두 소프트웨어가 서로 통신할 수 있게 하는 메커니즘

## Chat GPT API KEY 생성하기

**Chat GPT API KEY:**

### Chat GPT API 활용 챗봇
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {
private static String API_KEY = null;
private static String GPT_URL = "https://api.openai.com/v1/chat/completions";

	public static void main(String[] args) throws IOException {
	      URL url = new URL(GPT_URL);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/json");
	      connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);
	      
	      JSONObject data = new JSONObject();
	      data.put("model", "gpt-4o-mini");
	      data.put("temperature", 0.7);
	      
	      JSONObject message = new JSONObject();
	      message.put("role", "user");
	      message.put("content", "hello! how are you!");
	      
	      JSONArray messages = new JSONArray();
	      messages.put(message);
	      
	      data.put("messages", messages);
	      
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	      bw.write(data.toString());
	      bw.flush();
	      bw.close();
	      
	      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      StringBuilder sb = new StringBuilder();
	      String line = null;
	      
	      while ((line = br.readLine()) != null) {
	         sb.append(line);
	      }
	      
	      System.out.println(sb.toString());
	   }
}
```

**API 요청 Client ↔ Sever**

Client → Sever : 기본적으로 HTTP 로 요청을 보내는데, 특이한 형태의 문자열(JSON 포맷)로 보내고 있다.  
Sever → Client : Json으로 응답을 보내고 있다.

JSON응답을 JSON 라이브러리를 통해서 분류해 받을 수 있다.

```java
// JOSN 문자열 -> JSON 객체 (자바에서 사용할 수 있는 타입으로 변환)
      JSONObject root = new JSONObject(sb.toString());
	      
      JSONArray choices = root.getJSONArray("choices");
	      
      JSONObject choice = choices.getJSONObject(0);
      
      JSONObject message2 = choice.getJSONObject("message");
      
      String content = message2.getString("content");
      
      System.out.println(content);
	      
// 한줄로
    String content = (new JSONObject(sb.toString()))
      .getJSONArray("choices")
      .getJSONObject(0)
      .getJSONObject("message")
      .getString("content");

System.out.println(content);
```

**최종코드**
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {
	private static String API_KEY = null;
	private static String GPT_URL = "https://api.openai.com/v1/chat/completions";
	
	public static void main(String[] args) throws IOException {
	      URL url = new URL(GPT_URL);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/json");
	      connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);
	      
	      JSONObject data = new JSONObject();
	      data.put("model", "gpt-4o-mini");
	      data.put("temperature", 0.7);
	      
	      JSONObject message = new JSONObject();
	      message.put("role", "user");
	      message.put("content", "hello! how are you!");
	      
	      JSONArray messages = new JSONArray();
	      messages.put(message);
	      
	      data.put("messages", messages);
	      
	      // chatGPT API 요청을 보내는 코드
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	      bw.write(data.toString());
	      bw.flush();
	      bw.close();
	      
	      // chatGPT API 응답을 받는 코드
	      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      StringBuilder sb = new StringBuilder();
	      String line = null;
	      
	      while ((line = br.readLine()) != null) {
	         sb.append(line);
	      }
	      
	      
	      // JOSN 문자열 -> JSON 객체 (자바에서 사용할 수 있는 타입으로 변환)
	      String content = (new JSONObject(sb.toString()))
	    		  .getJSONArray("choices")
	    		  .getJSONObject(0)
	    		  .getJSONObject("message")
	    		  .getString("content");
	      
	      System.out.println(content);
	      
	      // System.out.println(sb.toString());
	   }
}

```

**1차 고도화**
```java
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {

    private static final String API_KEY = null; // 안전한 저장 방식 추천
    private static final String GPT_URL = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-4o-mini";

    public static void main(String[] args) {
        System.out.println("ChatGPT 봇에 오신 걸 환영합니다! (exit 입력 시 종료)");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("👤 당신: ");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("챗봇을 종료합니다. 안녕히 가세요!");
                    break;
                }

                System.out.println("🤖 챗봇이 응답을 생성 중입니다...zzz");
                String response = sendMessage(userInput);
                System.out.println("\r🤖 챗봇: " + response);
            }
        }
    }

    private static String sendMessage(String messageContent) {
        try {
            URL url = new URL(GPT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 요청 설정
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setDoOutput(true);

            // 요청 본문 구성
            JSONObject message = new JSONObject();
            message.put("role", "user");
            message.put("content", messageContent);

            JSONArray messages = new JSONArray();
            messages.put(message);

            JSONObject data = new JSONObject();
            data.put("model", MODEL);
            data.put("messages", messages);
            data.put("temperature", 0.7);

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
                writer.write(data.toString());
                writer.flush();
            }

            int responseCode = connection.getResponseCode();
            InputStream is = (responseCode == 200) ? connection.getInputStream() : connection.getErrorStream();

            // 응답 읽기
            StringBuilder responseBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
            }

            if (responseCode != 200) {
                return "❗ 오류 발생: " + responseBuilder;
            }

            JSONObject responseJson = new JSONObject(responseBuilder.toString());
            return responseJson
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content")
                    .trim();

        } catch (Exception e) {
            return "❗ 오류: " + e.getMessage();
        }
    }
}
```

GPT 챗봇으로 날씨를 물어보면 정보를 못줌  
API = “개발자 설계”  
기능의 한계가 있다.

해결방안?  
→ 사이트의 HTML 가져오기

---
# Selenium

브라우저 원격 조작 가능

`WebDriver driver =  new ChromeDriver();` →크롬 브라우저를 원격 조정하기 위한 객체

### **css selector 를 찾아서 클릭**
```java
WebElement financeBtn = driver
                .findElement(By.cssSelector(
                "#shortcutArea > ul > li:nth-child(6) > a"
                ));
financeBtn.click();
```

1. **`driver.findElement(...)`**

- 설명: 웹 페이지에서 특정 요소(HTML 태그)를 찾음.
- `driver`는 ChromeDriver 같은 브라우저 컨트롤러.
- `findElement()`는 조건에 맞는 첫 번째 요소를 반환.

2. **`By.cssSelector(...)`**

- `cssSelector`는 CSS 선택자 문법으로 요소를 찾음.
- 이 선택자는 아래 구조의 요소를 가리킴:

### **삼성전자 검색 탭에 검색 후 엔터(1)**

```java
WebElement inputTag = driver.findElement(By.cssSelector("#stock_items"));

inputTag.sendKeys("삼성전자");

inputTag.sendKeys(Keys.ENTER);
```
-> 이대로 하면 로딩이 되지 않은 상태이기 때문에 텀을 넣어줘야함

```java
// 현재 페이지의 핸들을 저장해두기
String mainPage = driver.getWindowHandle();

// 클릭!
financeBtn.click();

// 기존 탭 닫기
driver.switchTo().window(mainPage).close();

// 모든 핸들 취득하여 finance 페이지로 핸들 스위칭
Set<String> handles = driver.getWindowHandles();
for(String handle : handles) {
    driver.switchTo().window(handle);
}
```

### 주요뉴스 가져오기

```java
List<WebElement> news = driver.findElements(By.cssSelector("#content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li > span > a"));
		
for (WebElement element : news) {
		System.out.println(element.getText());
}
```

## SeleniumTest 전체코드

```java
public class seleniumTest {
	public static void main(String[] args) throws InterruptedException {
		// chrome 브라우저를 원격 조정하기 위한 객체
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.naver.com/");
		
		// 증권 HTML요소의 CSS 선택자
		// #shortcutArea > ul > li:nth-child(6) > a
		//WebElement financeBtn = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		
		// 클릭
		//financeBtn.click();
		
		
		// input 태그를 선택
		// #stock_items
		
		driver.get("https://finance.naver.com/");
		
		// 현재 페이지의 핸들을 저장해두기
    String mainPage = driver.getWindowHandle();
        
    // 클릭!
    financeBtn.click();

    // 기존 탭 닫기
    driver.switchTo().window(mainPage).close();
    
    // 모든 핸들 취득하여 finance 페이지로 핸들 스위칭
    Set<String> handles = driver.getWindowHandles();
    for(String handle : handles) {
        driver.switchTo().window(handle);
    }
		
		//WebElement inputTag = driver.findElement(By.cssSelector("#stock_items"));
		
		//inputTag.click();
		//inputTag.sendKeys("삼성전자");
		//inputTag.sendKeys(Keys.ENTER);
		
		// 주요 뉴스의 css 선택자
		// #content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li > span > a
		
		List<WebElement> news = driver.findElements(By.cssSelector("#content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li > span > a"));
		//System.out.println(news);
		for (WebElement element : news) {
			System.out.println(element.getText());
		}
		
		
		
		
		// 쉬어가자
		Thread.sleep(10000);
		
		
		
	}
}
```

## SRT 예매 코드(일부)

```java
public class seleniumSRT {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etk.srail.kr/main.do");
		
		System.out.println(driver.getCurrentUrl());
		
		// 현재 페이지의 핸들을 저장해두기
		String mainPage = driver.getWindowHandle();
		
		// 모든 핸들취득
		Set<String> handles = driver.getWindowHandles();
		
		// 현재 핸들을 제외한 모든 핸들을 닫아주기 (팝업창 대응)
		for (String handle : handles) {
			if (handle.equals(mainPage)) continue; 
			driver.switchTo().window(handle).close();
		}
		
		// 메인페이지 이외의 페이지가 전부 닫혔으므로, 메인페이지로 돌아가기
		driver.switchTo().window(mainPage);
		
		System.out.println(driver.getCurrentUrl());
		
		// 출발역을 Selenium의 Select객체 형태로 취득
		Select departure = new Select(driver.findElement(By.cssSelector("#dptRsStnCd")));
		departure.selectByVisibleText("대전");
		
		// 도착역 취득
		Select arrival = new Select(driver.findElement(By.cssSelector("#arvRsStnCd")));
		arrival.selectByValue("0551");
		
		// 날짜 변경해보기
		// readonly 객체이므로 직접 값을 집어넣는건 불가능
//		WebElement calandar = driver.findElement(By.cssSelector("#search-form > fieldset > div:nth-child(10) > div > input.calendar1"));
//		calandar.sendKeys("2025.07.19");
		
		WebElement calendarBtn = driver.findElement(By.cssSelector("#search-form > fieldset > div:nth-child(10) > div > input.calendar2"));
		calendarBtn.click();
		
		//화면 전환필요
		
		// 모든 핸들 새로취득
		handles = driver.getWindowHandles();
		
		// 현재 핸들을 제외한 모든 핸들을 닫아주기 (팝업창 대응)
		for (String handle : handles) {
			if (handle.equals(mainPage)) continue; 
			driver.switchTo().window(handle);
		}
		
		// 날짜를 찾아서 클릭
		WebElement calendarClick = driver.findElement(By.cssSelector("#wrap > div.contents.etk-calendar > div.area > div.calendar.this > table > tbody > tr:nth-child(3) > td.sat > a"));
		calendarClick.click();
		
		// 메인페이지로 돌아가기
		driver.switchTo().window(mainPage);
		
		// index로 선택해보기
		Select dptTime = new Select(driver.findElement(By.cssSelector("#dptTm")));
		dptTime.selectByIndex(2);
	}
}
```

## Selenium을 이용해 자동화 프로그램 만들기
### JobKorea 채용공고 크롤러

```java
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
            "duty_step2_1000232"  // 웹개발자
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

        for (int i = 0; i < maxJobs; i++) {
            WebElement row = jobRows.get(i);

            // 회사명
            String company = row.findElement(By.cssSelector("td.tplCo a")).getText().trim();

            // 공고 제목
            WebElement titleAnchor = row.findElement(By.cssSelector("td.tplTit strong a"));
            String title = titleAnchor.getText().trim();

            // 링크
            String partialLink = titleAnchor.getAttribute("href").trim();
            String fullLink = partialLink.startsWith("http") ? partialLink : "https://www.jobkorea.co.kr" + partialLink;

            // 마감일
            String deadline = "";
            try {
                deadline = row.findElement(By.cssSelector("td.odd span.date")).getText().trim();
            } catch (Exception e) {
                deadline = "마감일 정보 없음";
            }

            // 출력
            System.out.println("회사명: " + company);
            System.out.println("공고제목: " + title);
            System.out.println("링크: " + fullLink);
            System.out.println("마감일: " + deadline);
            System.out.println("---------------");
        }
	}
}

```

