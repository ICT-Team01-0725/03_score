package personal.project;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Score_Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		HashSet<Score> p1 = new HashSet<>();
		
		// 이름/국어/영어/수학 점수 입력 받기
		esc : while (true) {
			System.out.print("이름 : ");
			String name = scan.next();
			
			System.out.print("국어 점수 : ");
			int kor = scan.nextInt();
			
			System.out.print("영어 점수 : ");
			int eng = scan.nextInt();
			
			System.out.print("수학 점수 : ");
			int math = scan.nextInt();
			
			// 입력받은 이름/국어/영어/수학 save에 저장하기
			Score save = new Score(name, kor, eng, math);
			p1.add(save);
			
			// 1명 정보를 입력 받은 후 계속할지 여부 물어보기
			while (true) {
				System.out.print("계속할까요? (y/n) : ");
				String msg = scan.next();
				if (msg.equalsIgnoreCase("n")) {
					break esc;
				} else if (msg.equalsIgnoreCase("y")) {
					continue esc;
				} else {
					System.out.println("제대로 입력하세요.");
					continue;
				}
			}
		}
		
		
		
		// 위에서 정보를 받은 내용을 토대로 계산식을 for-each 문으로 출력
		for (Score k : p1) {
			// 더하기
			int sum = k.getKor() + k.getEng() + k.getMath();
			k.setSum(sum);
			
			// 평균
			double avg = (int)(k.getSum() / 3 * 10) / 10.0;
			k.setAvg(avg);
			
			// 학점
			char hak;
			
			if (avg >= 90) {
				hak = 'A';
			} else if (avg >= 80) {
				hak = 'B';
			} else if (avg >= 70) {
				hak = 'C';
			} else {
				hak = 'F';
			}
			
			k.setHak(hak);
		}
		
		// 출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t학점");
		for (Score k2 : p1) {
			System.out.print(k2.getName()+"\t");
			System.out.print(k2.getKor()+"\t");
			System.out.print(k2.getEng()+"\t");
			System.out.print(k2.getMath()+"\t");
			System.out.print(k2.getAvg()+"\t");
			System.out.println(k2.getHak()+"\t");
		}
		
	}
}
