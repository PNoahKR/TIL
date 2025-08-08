package algorithm_solving;

import java.util.Random;
import java.util.Scanner;

public class 절대상수e {
	public static void main(String[] args) {
        // Scanner와 Random 객체 생성
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("시뮬레이션 횟수를 입력하세요 (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("0보다 큰 숫자를 입력해야 합니다.");
            return;
        }

        double totalCount = 0.0;

        // n번의 시뮬레이션 반복
        for (int i = 0; i < n; i++) {
            double sum = 0.0;
            int count = 0;

            // 합이 1을 초과할 때까지 랜덤 숫자 생성 및 합산
            while (sum <= 1.0) {
                sum += random.nextDouble();
                count++;
            }
            totalCount += count;
        }

        // 평균 계산
        double averageCount = totalCount / n;

        // 결과 출력
        System.out.println("------------------------------------");
        System.out.printf("총 %d번의 시뮬레이션을 진행했습니다.\n", n);
        System.out.printf("합이 1을 초과할 때까지 더해진 숫자의 평균 개수: %.4f\n", averageCount);
        System.out.println("자연 상수 e의 실제 값: 2.718281828459045");
        System.out.printf("시뮬레이션 평균과 e의 오차: %.4f\n", Math.abs(averageCount - Math.E));

        // 스캐너 닫기
        scanner.close();
    }
}
