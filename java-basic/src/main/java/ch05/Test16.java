
//반복문을 배열과 결합해서 사용

package ch05;

public class Test16 {
  

  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
  
    // 배열을 처음부터 끝까지 반복할때는 다음의 for문을 사용하면 편리하다.
    for (String name : names) {
   
      //배열을 꺼내서 name에 담아준다.
        System.out.print(name + " ");//홍길동 임꺽정 유관순 안중근 윤봉길 김구
        }
     
    System.out.println();
    
    //컬렉션
    java.util.ArrayList<String> list=new java.util.ArrayList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    
    for (String name : list) {
      System.out.println(name + " ");//list라는 컬렉션에 담겨있는 name변수의 요소를 출력한다.
                                          //홍길동, 임꺽정, 유관순
    }
    System.out.println();
    
    }
 }


/*
 *for (:)
 *배열 전체를 반복하거나 컬렉션 객체 전체를 반복할 때 유용하다.
 *for (배열의 항복 값을 담을 변수선언 : 배열, 컬렉션 객체 등)
 *  문장;
 *  
 *  범위를 바꾸는것이 불가능하다.
 *  배열을 처음부터 끝까지 반복할때는 다음의 for문을 사용하면 편리하다.
 *  
 * 
 * 
 * 
 * 
 * *
 */
       
     
   
   

   
    





