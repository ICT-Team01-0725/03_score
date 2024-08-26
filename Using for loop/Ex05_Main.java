package com.ict.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

// [ Role of Ex05_Main ]
// ---> 학생 정보를 입력 & 결과 출력 

// [ Feature ]
// 정보 입력을 받은 후, HashSet에 저장
// 3명의 정보를 모두 입력받으면, 총점 기준으로 순위를 계산 & 출력
// 각 학생의 정보 입력될 때마다, '이름, 국어, 영어, 수학 점수, 총점, 평균, 학점' 출력
// 학생 정보가 모두 입력된 후(학생 3명)에는 순위를 계산해 출력한 뒤, 종료 메시지를 출력

public class Ex05_Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<Ex05_Student> studentSet = new HashSet<>();
        ArrayList<Ex05_Student> studentList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {								// 입력받는 학생수를 3명으로 설정
            System.out.println("학생 " + i + "의 정보를 입력하세요.");		// 이름을 입력받기 전, 정보구분을 위해 순서대로 학생번호 출력
            System.out.print("이름: ");
            String name = scan.nextLine();
            System.out.print("국어 점수: ");
            int scoreKor = scan.nextInt();
            System.out.print("영어 점수: ");
            int scoreEng = scan.nextInt();
            System.out.print("수학 점수: ");
            int scoreMath = scan.nextInt();
            scan.nextLine();										// Console 입력 후, Enter값(개행문자)	가져오고 종료		
            
            Ex05_Student student = new Ex05_Student(name, scoreKor, scoreEng, scoreMath);
            studentSet.add(student);
            studentList.add(student);

            System.out.println(student.toString());
            System.out.println();									// 학생간 정보 보기 쉽게 구분되도록 줄바꿈
        }

        // 총점을 기준 순위 계산을 위해 Collections.sort 이용
        // Collections.sort로 오름차순 정렬
        Collections.sort(studentList, new Comparator<Ex05_Student>() {
            @Override
            public int compare(Ex05_Student s1, Ex05_Student s2) {
                return s2.getTotal() - s1.getTotal();
            }
        });

        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).setRank(i + 1);
        }

        System.out.println("최종성적:");							  
        
        for (Ex05_Student student : studentList) {
            System.out.printf("이름: %s / 총점: %d / 평균: %.2f >>> 순위: %d\n",
                    student.getName(), student.getTotal(), student.getAverage(), student.getRank());
        }
        // %s는 String, %d는 10진수, %.2f는 실수 형태 의미

        // [ 출력 예시 ]
//        	최종성적:
//        	이름: 철수 / 총점: 274 / 평균: 91.33 >>> 순위: 1
//        	이름: 영희 / 총점: 267 / 평균: 89.00 >>> 순위: 2
//        	이름: 희동 / 총점: 196 / 평균: 65.33 >>> 순위: 3
        

        System.out.println("\n수고하셨습니다.");
        scan.close();
    } 
}
