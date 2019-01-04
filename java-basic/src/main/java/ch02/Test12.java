//콘솔로 출력하기3- 형식을 갖춰서 날짜 값 출력하기
package ch02;



public class Test12{
  public static void main(String[] args){
   //현재 날짜 및 시각 정보를 생성한다. 
    //java.lang 패키지의 멤버를 사용할 때는 그냥 이름을 지정하면 된다.
    //그 외 다른 패키지의 멤버를 사용할 때는 반드시 패키지 이름을 함께 지정해야 한다.
    
   java.util.Date today=new java.util.Date();  //밀리초 까지만 생성한다.
   
   //%t[날짜 및 시간 옵션]Y
   //날짜 및 시간 옵션
   //Y: 날짜 및 시간 데이터에서 년도를 추출하여 4자리로 표현한다.
   //y: 날짜 및 시간 데이터에서 년도를 추출하여 뒤에 2자리로 표현한다.
   //System.out.printf("%tY, %ty\n",today);
   System.out.printf("%1$tY, %1$ty\n",today);
   
   //B: 날짜 시간 데이터에서 월을 추출하여 전체 이름으로 표현한다. 예)JANUARY
   //B: 날짜 시간 데이터에서 월을 추출하여 단축 이름으로 표현한다. EX)JAN
   System.out.printf("%1$tB, %1$tb\n",today);
    
   
   //M: 날짜 시간 데이터에서 월을 추출하여 2자리 숫자로 표현한다.
   //m: 날짜 시간 데이터에서 월을 추출하여 1자리 숫자로 표현한다.
   System.out.printf("%1$tm\n",today);
   
   //d: 날짜 시간 데이터에서 일을 추출하여 두자리 숫자로 표현한다.
   System.out.printf("%1$td %1$te \n",today);
   
   
   
   //요일 출력
   //A: 날짜 시간 데이터에서 요일을 추출하여 긴 이름으로 표현한다.
 //a: 날짜 시간 데이터에서 요일을 추출하여 짧은 이름으로 표현한다.
   System.out.printf("%1$tA %1$ta \n",today);
   
   //H:24시
   //I:12시
   System.out.printf("%1$tH %1$tI \n",today);
   
   //분:M
   
   System.out.printf("%1$tM \n",today);
   
   //S
   //l:밀리초  N:나노초
   System.out.printf("%1$tS \n",today);
   System.out.printf("%1$tL \n",today);
   System.out.printf("%1$tN \n",today);
   
   //오전 오후
   //p
   //t:am ,pm
   //T: AM, PM
   //한글은 대소문자가 없으므로 의미가 없다.
   System.out.printf("%1$tp \n",today);
   System.out.printf("%1$Tp \n",today);
   
   //yy mm dd 시 분 초 출력  -2019 01 04 12 4 30
   System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",today);
   
   
   
  
   
   
        }
    }









/**


*/