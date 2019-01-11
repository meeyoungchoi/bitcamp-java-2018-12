
//반복문을 배열과 결합해서 사용

package ch05;

public class Test15 {
  

  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
//         i: 배열의 인덱스 번호    
    for (String name : names) {//names:배열의이름, String name: names라는 배열에서 각각의 배열요소
   
        System.out.print(name + " ");//홍길동, 임꺽정, 유관순 안중근, 윤봉길, 김구
        
     
    }
    System.out.println();
      
    for (int i =0; i < names.length; i+=2) {//i=i+2
      
        System.out.print(names[i] + " ");//[0]:홍길동 [2]:유관순 [4]:윤봉길
        
     
    }
  }
}

/*
 *for 반복문
 *배열과 함께 사용할때 유용하다.
 *
 *for(변수초기화; 조건; 변수증가문)
 * 문장1;
 * 
 * for(변수초기화; 조건; 변수증가문)
 * 문장1;
 * 
 * for(변)
 * 
 * 
 * 
 * 
 * *
 */
       
     
   
   

   
    





