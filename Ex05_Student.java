package com.ict.day16;

// [ Role of Ex05_Student ]
// ---> 학생의 이름과 국어, 영어, 수학 점수를 저장

// [ Feature ]
// 각 점수를 이용하여 총점, 평균, 학점, 순위를 계산하는 내부 클래스 설정


public class Ex05_Student {
    private String name;
    private int scoreKor, scoreEng, scoreMath;
    private int total;
    private double avg;
    private String grade;
    private int rank;

    public Ex05_Student(String name, int scoreKor, int scoreEng, int scoreMath) {
        this.name = name;
        this.scoreKor = scoreKor;
        this.scoreEng = scoreEng;
        this.scoreMath = scoreMath;
        calTotal();
        calAverage();
        calGrade();
    }

    // 1. 내부 클래스 (총점 계산)
    private void calTotal() {
        this.total = scoreKor + scoreEng + scoreMath;
    }

    // 2. 내부 클래스 (평균 계산)
    private void calAverage() {
        this.avg = this.total / 3.0;
    }

    // 3. 내부 클래스 (학점 계산)
    private void calGrade() {
        if (avg >= 90) {
            this.grade = "A";
        } else if (avg >= 80) {
            this.grade = "B";
        } else if (avg >= 70) {
            this.grade = "C";
        }else {
            this.grade = "F";
        }
    }

    // 순위 메서드
    public void setRank(int rank) {
        this.rank = rank;
    }

    // getter 설정
    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return avg;
    }

    public String getGrade() {
        return grade;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("이름: %s, 국어: %d, 영어: %d, 수학: %d, 총점: %d, 평균: %.2f, 학점: %s",
                name, scoreKor, scoreEng, scoreMath, total, avg, grade);
    }
    // %s는 String, %d는 10진수, %.2f는 실수 형태 의미
}
