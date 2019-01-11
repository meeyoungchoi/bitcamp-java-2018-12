
package bitcamp.lms;



public class App {


  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);


    int[] number = new int[100]; //번호명
    String[] name=new String[100]; //과목명
    String[] content=new String[100]; //과목내용
    String[] start=new String[100]; //시작일
    String[] finish=new String[100];//종료일
    String[] total=new String[100];//총시equalsIgnoreCase간
    String[] study=new String[100];//일학습시간

    int i = 0;//배열의요소 값equalsIgnoreCase


 
    while (true) {
      System.out.print("번호를 입력하세요:");
      number[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("수업명:");
      name[i]=keyboard.nextLine();
      //Resource leak: 'keyboard' is never closed=>에러발생
      //문을 닫아주세요.
      //수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
      System.out.print("수업내용:");
      content[i]=keyboard.nextLine();

      // System.out.println();

      //시작일? 2019-01-02
      System.out.print("시작일? ");
      start[i]=keyboard.nextLine();
      //System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n ",today);
      //Date star int[] number=new int[100];
     
      //문자열을 날짜 형태의 데이터로 바꾼다.
      //날짜형태의 데이터는 String으로 받을수 없다.
      //값을 담을수 있는 메모리를 준비해야한다.
      //Date이라는 데이터 타입의 값이 놓임으로
      //Resource leak: 'keyboard' is never closed=
      //Date이라는 값을 담을수 있는 Date이라는 그릇을 준비해야 한다.
      //String startDate=keyboard.next();

      //종료일? 2019-05-28
      System.out.print("종료일?");
      finish[i]=keyboard.nextLine();


      //System.out.printf("2019-08-05");

      //총수업시간? 1000
      System.out.print("총수업시간?");
      total[i]=keyboard.nextLine();
      //int totalHours=Integer.parseInt(keyboard.nextLine());
      //숫자그릇이 필 int[] numbetr.equalsIgnoreCase("n") || str.eqr=new int[100];

      //일수업시간? 8
      System.out.print("일수업시간?");
      study[i]=keyboard.nextLine(); 
      //Resource leak: 'keyboard' is never closed=

      //이를 사용한 후에는 닫아줘야 한다.
      //프로그램을 닫는순간 운영체제가 회수한다.

      //계속 입력하시겠습니까?(Y/n) y    <== Y, y, 그냥 엔터를 치면 계속 입력한다.
      
      
      i++;
      System.out.print("계속 입력하시겠습니까?(y/n)");
        String str=keyboard.nextLine();
        if(!str.equalsIgnoreCase("y" ) && !str.equalsIgnoreCase(" ")) {
          break;
        }
        
     System.out.println();
     
          }
     
    keyboard.close();
    
    System.out.println();

    int j = 0; //해당내용(번호, 과목명, 과목내용, 종료일, 총시간, 일학습시간)이 입력된 횟수
  
    while(j < i) {
    System.out.printf("%d, ",number[j]);
    System.out.printf("%s, ",name[j]);
    System.out.printf("%s, ",content[j]);
    System.out.printf("%s, ",start[j]);
    System.out.printf("%s, ",finish[j]);
    System.out.printf("%s, ", total[j]);
    System.out.printf("%s\n", study[j]);
    
    j++;
    }
  


    //Resource leak: 'keyboard' is never closed=


    
  
    //}
    //Resource leak: 'keyboard' is never closed=
  
        }
  }


  


  


    
        
     
      
      /*
       * 
1, 자바 프로젝트 실습     , 2019-01-02 ~ 2019-05-28, 1000
2, 자바 프로그래밍 기초    , 2019-02-01 ~ 2019-02-28,  160
3, 자바 프로그래밍 고급    , 2019-03-02 ~ 2019-03-30,  160
```
       */
  
    
    








/**
 * 
### 작업1) 여러 개의 수업 내용을 입력 받아 출력하라.

App.java 실행 결과

목록으로 출력할 항목은 `번호,수업명,시작일~종료일,총수업시간`이다.

```
번호? 1
수업명? 자바 프로젝트 실습
수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
시작일? 2019-01-02
종료일? 2019-05-28
총수업시간? 1000
일수업시간? 8

계속 입력하시겠습니까?(Y/n) y    <== Y, y, 그냥 엔터를 치면 계속 입력한다.

번호? 2
수업명? 자바 프로그래밍 기초
수업내용? 자바 언어 기초 문법을 학습하기
시작일? 2019-02-01
종료일? 2019-02-28
총수업시간? 160
일수업시간? 8

계속 입력하시겠습니까?(Y/n) y

번호? 3
수업명? 자바 프로그래밍 고급
수업내용? 디자인 패턴과 리랙토링 기법 학습하기
시작일? 2019-03-02
종료일? 2019-03-30
총수업시간? 160
일수업시간? 8

계속 입력하시겠습니까?(Y/n) n    <== Y, y, 그냥엔터 외에 기타 문자 입력하면 멈춘다.

1, 자바 프로젝트 실습     , 2019-01-02 ~ 2019-05-28, 1000
2, 자바 프로그래밍 기초    , 2019-02-01 ~ 2019-02-28,  160
3, 자바 프로그래밍 고급    , 2019-03-02 ~ 2019-03-30,  160
```

 * 
 * 
 * 
 * 
 * 
 */