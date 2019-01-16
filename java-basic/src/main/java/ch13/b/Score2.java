package ch13.b;

import ch13.Score;

//기존의 SCORE 클래스를 상속 받는다.
//=>상속을 받는다는 것은 기존~~~~~~~~~~~~~~
public class Score2 extends Score{

  private String name;
  

  private int music;
  private int art;


  private int sum;


  private float aver;


 

public void setMusic(int music) {
  if (music >= 0 && music <= 100) 
    this.music = music;
    this.compute2();//이 클래스에 새로 추가한 계한 메서드를 호출한다.
  
}



public int getMusic() {
  return this.music;
 
}


public void setArt(int art) {
 if (art >= 0 && art <= 100)
   this.art = art;
   this.compute2();
  
}

public int getArt() {
  return this.art;
  
  }


protected void compute2() {
  //기존 계산 메서드를 호출해서 국 영 수 세 과목의 합계와 평균을 계산한다.
  this.compute(); 
  
  this.sum += this.art + this.music;
  this.aver = this.sum/5f;
  
    }
}