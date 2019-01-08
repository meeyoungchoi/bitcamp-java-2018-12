//문자 제어코드:escape character 문자(문자출력을 제어하는 명령)
package ch02;

public class Test10{
  public static void main(String[] args){
      
   System.out.println("hello, \nworld"); //줄바꿈은 이 제어 문자를 사용하라
   System.out.println("hello, \rworld");
   System.out.println("hello, \b\b\b\bworld");
   System.out.println("hello, \tworld");
   System.out.println("hello, \fworld");
   System.out.println("hello, \'w'world");
   System.out.println('\'');
   System.out.println('"');
   System.out.println("hello, \\world");
   System.out.println("hello, \\\\world");
   
   
    
    
        }
    }









/**
 제어문자
 \n==\r 같다고 봐도 무방하다.
 \n:escape sequence, 줄바꿈(line feed), 0x0a
 \r:carrage return ,0x0d
 \f:form feed, 다음 폼으로 간다(그 다음 페이지부터 출력)
 \t:tab, 0x09
 \b:0x08,back space
 \': single quote, ox27
 \":double quote, 0x22
  \\: back slash, 

*/