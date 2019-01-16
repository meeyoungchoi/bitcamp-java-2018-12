package ch13.b;

import ch13.Score;

//기존의 SCORE 클래스를 상속 받는다.
//=>상속을 받는다는 것은 기존~~~~~~~~~~~~~~
//=>상속 받은 메서드 중에서 변경할 게 있으면 재정의 한다.
//=>이것을 "오버라이딩"이라 부른다.
//=>예) compute()

public class Score3 extends Score{

  private String name;
  

  private int music;
  private int art;


  private int sum;


  private float aver;


 

public void setMusic(int music) {
  if (music >= 0 && music <= 100) 
    this.music = music;
    this.compute();//이 클래스에 새로 추가한 계한 메서드를 호출한다.
  
}



public int getMusic() {
  return this.music;
 
}


public void setArt(int art) {
 if (art >= 0 && art <= 100)
   this.art = art;
   this.compute();
  
}

public int getArt() {
  return this.art;
  
  }

//수퍼 클래스의 메서드 중에서 현재 클래스의 역할과 맞지 않는 겨우
//서브 클래스의 역할에 맞춰서 재정의 해도 된다.
@Override
protected void compute() {
  //기존 계산 메서드를 호출해서 국 영 수 세 과목의 합계와 평균을 계산한다.
  //=>재정의 하기 전의 메서드를 호출할 때는 super 이용한다.
  super.compute(); 
  
  this.sum += this.art + this.music;
  this.aver = this.sum/5f;
  
    }
}