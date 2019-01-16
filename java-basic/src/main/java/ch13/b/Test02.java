//기능 확장하기 -score 클래스에  음악과 밀술 과목을 추가하기
package ch13.b;

import ch13.Score;

public class Test02 {

  public static void main(String[] args) {
    //Score2를 이용하여 수퍼 클래스의 기능을 호출할 수 있다.
    Score2 s = new Score2();
    s.setName("홍길동");
    s.setKor(100);//socre의 메서드
    s.setEng(100);//score의 메서드
    s.setMath(100);//score의 메서드
    s.setMusic(100);//score2의 메서드
    s.setArt(100);//score2의 메서드
    System.out.printf("%s: %d(%.1f)\n",s.getName(), s.getSum(), s.getAver());

  }

}
