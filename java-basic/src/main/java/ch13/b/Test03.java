//기능 확장하기 -score 클래스에  음악과 밀술 과목을 추가하기2
package ch13.b;



public class Test03 {

  public static void main(String[] args) {
    //
    Score3 s = new Score3();
    s.setName("홍길동");
    s.setKor(100);//socre의 메서드
    s.setEng(100);//score의 메서드
    s.setMath(100);//score의 메서드
    s.setMusic(100);//score3의 메서드
    s.setArt(100);//score3의 메서드
    System.out.printf("%s: %d(%.1f)\n",s.getName(), s.getSum(), s.getAver());

  }

}
