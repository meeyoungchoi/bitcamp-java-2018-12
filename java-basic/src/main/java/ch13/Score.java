package ch13;

//계산결과에 영향을 미치는 필드에도 getter/setter를 적용한다.
//
public class Score {

  //name은 직접 접근해도 되는데, 다른 필드와 사용법을 동일하게 가져가기 위해
  //직접 접근을 막고 getter/setter를 통해 값을 다루도록 한다.
  //이렇게 하면 나중에 name에 대해 값의 유효성을 검사하는 코드를 즉시 삽입할 수 있으니까
  //유지보수에도 도움이 된다.
  //그래서 실무에서는 그냥 모든 필드를 private이나 protected로 접근을 제한한 다음에
  //setter/getter를 두는 방식으로 프로그래밍을 한다.
  //setter/getter가 필요없는 필드라도 그냥 관성적으로 그렇게 한다.
  //고민하지 말고 여러분도 그냥 이렇게 해라
  //무조건 새 데이터타입을 만들면 private이나 protected로 일단 막아라
  //setter에서 유효성을 검사하지 않더라도 그냥 마들라
  //
  private String name;
  
  //점수를 변경할 때 계싼을 다시 해야 하고, 유효하징 낳은 값을 넣지 못하도록 막아야 한다.
  //따라서 직접 접근하는 것을 막는다.
  private int kor;
  private int eng;
  private int math;
 
  //서브 클래스에서 사용할 필드는 protected로 접근을 풀어준다.
  //=>접근 범위를 넓히는 것은 기존 코드에 영향을 미치지 않는다.
  //=>접근 범위를 좁히게 되면 기존 코드에서 직접 접근하던 코드가 동작이 안될 수 있다.
  //접근 범위를 좁히게 되면 기존 코드에 영향을 준다.
 protected int sum;
 protected float aver;

 
 public void setName(String name) {

     this.name = name;
  
 }

 
 public String getName() {
   return this.name;
 }
 //대신 결과 값을 꺼낼 수있는 메서드(getter)를 제공해야 한다.
public int getKor() {
  return this.kor;
}

public void setKor(int kor) {
  if (kor >= 0 && kor <= 100) //유효한 점수인 경우에만 저장한다.
    this.kor = kor;
    this.compute(); //유효한 값이라면 다시 합계와 평균을 계산한다.
}

public int getEng() {
  return this.eng;
}

public void setEng(int eng) {
  if (eng >= 0 && eng <= 100) //유효한 점수인 경우에만 저장한다.
    this.eng = eng;
    this.compute(); //유효한 값이라면 다시 합계와 평균을 계산한다.
}

public int getMath() {
  return this.math;
}

public void setMath(int math) {
  if (math >= 0 && math <= 100) //유효한 점수인 경우에만 저장한다.
    this.math = math;
    this.compute();//유효한 값이라면 다시 합계와 평균을 계산한다.
}
 public int getSum() {
   return this.sum;
 }
 
 public float getAver() {
   return this.aver;
 }

 //서브 클래스에서 사용할 수 있도록 접근 범위를 넓힌다.
 protected void compute () {
    this.sum = this.kor + this.eng + this.math ;
    this.aver = this.sum / 3f;
  }



}


