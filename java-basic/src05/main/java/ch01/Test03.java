package ch01;
/**
java doc 주석
자바 api문서를 생성할때 참고하는 주석
클래스, 변수 메서드 선언에 붙인다.
 */

 
public class Test03{
    /**
      오버라이드   
     */
    @Override //에노테이션 주석(프로그램에서 사용)
    public String toString(){
        return "ok";
    }

    public static void main(String[] args){


        System.out.println("Hello");
    }
}