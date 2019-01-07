
package bitcamp.lms;

import java.util.Date;

public class App {
   

    public static void main(String[] args) {
     
        java.util.Date today=new java.util.Date();
      
       //번호? 1
      java.util.Scanner keyboard=new java.util.Scanner(System.in);
      System.out.printf("번호를 입력하세요:");
      int number=keyboard.nextInt();
      //
      keyboard.nextLine();
        
        //수업명? 자바 프로젝트 실습
      System.out.printf("수업명? ");
      String name=keyboard.nextLine();
      //Resource leak: 'keyboard' is never closed=>에러발생
      //문을 닫아주세요.
      
      //수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
      System.out.printf("수업내용? ");
      String content=keyboard.nextLine();
      
      
      //시작일? 2019-01-02
      System.out.printf("시작일? ");
      System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS \n",today);
      //Date startDate=Date.valueOf(keyboard.nextLine());
      //문자열을 날짜 형태의 데이터로 바꾼다.
      //날짜형태의 데이터는 String으로 받을수 없다.
      //값을 담을수 있는 메모리를 준비해야한다.
      //Date이라는 데이터 타입의 값이 놓임으로
      //Date이라는 값을 담을수 있는 Date이라는 그릇을 준비해야 한다.
      //String startDate=keyboard.next();
      
     //종료일? 2019-05-28
      System.out.printf("종료일?");
     String finish=keyboard.nextLine();
     //System.out.printf("2019-08-05");
      
      //총수업시간? 1000
      System.out.printf("총수업시간?");
      String total=keyboard.nextLine();
      //int totalHours=Integer.parseInt(keyboard.nextLine());
      //숫자그릇이 필요하므로 int 라는 숫자메모리를 준비했다.
      
      
      //일수업시간? 8
      System.out.printf("일수업시간?");
      String study=keyboard.nextLine();
      
     //사용후 키보드를 닫아줘야 한다.
     //닫아야하는 도구는 close라는 메소드를 갖고있다.
      //이를 사용한 후에는 닫아줘야 한다.
      //프로그램을 닫는순간 운영체제가 회수한다.
      keyboard.close();

    }
}


/**
 * 
 * 번호? 1
수업명? 자바 프로젝트 실습
수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
시작일? 2019-01-02
종료일? 2019-05-28
총수업시간? 1000
일수업시간? 8
 * 
 * 
 * 
 * 
 * 
 */