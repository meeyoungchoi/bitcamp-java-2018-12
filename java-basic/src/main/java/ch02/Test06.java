//부동소수점을 메모리에 저장하는 방법
package ch02;

public class Test06{
  static final float f=12.375f;

    public static void main(String[] args){

        //9876.54345678
      System.out.println(9876.54345678);//
      System.out.println(0.1f * 0.1f); //예상값과 다르게 결과값이 나온다.
      //부동소주점을 이진수로 바꿀 때 아~~주 작은 수의 오차가 있을 수 있다.

      //그래서 부동수수점을 비교할떄 정수 비교할때 처럼 단순하게 비교하면
      //원하는 결과를 얻을 수 없다.
      //다음의 결과를 보라!
      System.out.println(0.1f * 0.1f==0.01f);//false
      
      //해결방안
      //예상한 결과의 오차가 부동소수점에서 인정하는 오차 이하의 값이면 같은 것으로 취급하라
      System.out.println((0.1f * 0.1f - 0.01f) <= Float.POSITIVE_INFINITY);
      System.out.println((0.2f * 0.2f - 0.02f) <= Float.POSITIVE_INFINITY);
      //System.out.println(Float.POSITIVE_INFINITY);//0.0000.....1을 의미한다.
      
      
      
      
      //9876.54345678f
      //4바이트에 담으려고 줄어든다.
      //유효자릿수 7자리까지 유효하다.
      System.out.println(9876.54345678f); //=>9876.543
  
    }
}