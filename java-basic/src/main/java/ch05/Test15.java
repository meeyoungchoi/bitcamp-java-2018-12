
//반복문을 배열과 결합해서 사용

package ch05;

public class Test15 {
  

  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
//         i: 배열의 인덱스 번호    
    for (String name : names) {
   
        System.out.print(name + " ");
        
     
    }
    System.out.println();
      
    for (int i =0; i < names.length; i+=2) {
      
        System.out.print(names[i] + " ");
        
     
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
       
     
   
   

   
    





