//getter/setter를 적용하면 좋은 이유

package ch12.b;

public class Test04 {

  public static void main(String[] args) {
    Score2 s1 = new Score2();
    
    //다른 필드의 값은  모두 setter를 통해서 설정하는데 name필드만 직접 설정한다면
    //프로그래밍의 일관성이 없어 유지보수가 불편하다.
    //그래서 굳이 setter나 getter가 필요없는 필드라도
    //다른 필드와의 일관성을 위해 gette/setter를 만든다.
    //s1.name = "홍길동";
    
    s1.setName("홍길동");
    //국 영 수 점수를 직접 변경할 수 없다. 
    //s1.kor = 100;
    //s1.eng = 90;
    //s1.math = 80;
    //s1.compute();
    
    //오직 setter를 통해서만 점수를 설정할 수 있다.
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);
    
    //점수를 설정할 때 내부에서 compute()를 호출하기 때문에 따로 호출할 필요가 없다.
    //또한 compute()는 private으로 비공개 되었다.
    //s1.compute();
   
    System.out.printf("%s: 총점=%d, 평균=%.1f\n",s1.getName(), s1.getSum(), s1.getAver());
    
    //언제든 어떤 과목의 점수를 바꾸더라도 합계와 평균은 자동 계산되어 옳은 값ㅇ르 가진다.
    s1.setKor(70);
    System.out.printf("%s: 총점=%d, 평균=%.1f\n",s1.getName(), s1.getSum(), s1.getAver());
    
    s1.setEng(-200);
    System.out.printf("%s: 총점=%d, 평균=%.1f\n",s1.getName(), s1.getSum(), s1.getAver());

    //이유2.
    //만약 국,영,수 점수를 유효하지 않은 값으로 변경한다면/ 

    
    //제대로 계산까지 한다.
    //s1.compute();
    
    //이번에는 점수를 변경한 후 compute()를 호출하여 제대로 계산까지 했지만,
    //우리가 예상하는 결과와 다르게 나온다.
    //이유는? 점수를 설정할 때 이미 유효하지 않은 값을 설정했기 때문이다.
    //
    
    
    //해결책?
    //점수를 직접 변경하게 하지 말고 메서드를 통해 변경하게 만들라!
    //=> 1. 유효하지 않은 값을 넣지 못하도록 막을 수 있다.
    //=> 2. 점수를 변경한 후 자동으로 계산하게 할 수 있다.
    //test04를 확인하라
  }

}



