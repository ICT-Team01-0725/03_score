package com.ict.day16;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

public class Ex99_Main {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		HashSet<Ex99> k = new HashSet<Ex99>();
		esc : while(true) {
			try{
				System.out.println("이름 : ")	;
				String name = scan.next();
				System.out.println("국어 : ");
				int kor = scan.nextInt();
				System.out.println("영어 : ");
				int eng = scan.nextInt();
				System.out.println("수학 : ");
				int math = scan.nextInt();
				k.add(new Ex99(name, kor, eng, math));
				while(true) {
					System.out.println("계속 하시겠습니까?(Y/N)");
					String tmp = scan.next();
					if (tmp.equalsIgnoreCase("y")){
						continue esc;
					}else if(tmp.equalsIgnoreCase("n")) {
						break esc;
					}else {
						System.out.println("Y 또는 N을 입력하세요");
					}
				}
			}catch(InputMismatchException e){
				System.out.println("올바른 값을 입력하세요");
				scan.nextLine();
				continue esc;
			}
		}
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		Iterator<Ex99> it = k.iterator();
		while (it.hasNext()) {
			// 형변환을 하는 이유 .next()의 결과는 Object이다
			Ex99 ex99 = it.next();
			System.out.print(ex99.getName()+"\t");
			System.out.print(ex99.getKor()+"\t");
			System.out.print(ex99.getEng()+"\t");
			System.out.print(ex99.getMath()+"\t");
			System.out.print(ex99.getSum()+"\t");
			System.out.print(ex99.getAvg()+"\t");
			System.out.print(ex99.getHak()+"\t");
			System.out.println();
		}
		
		
		
	}
}
