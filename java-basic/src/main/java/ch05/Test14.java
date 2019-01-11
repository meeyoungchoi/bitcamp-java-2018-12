
//do while 반복문

package ch05;

public class Test14 {
  

  public static void main(String[] args) {
    //변수초기화 시키는 문장에 여러 개의 변수를 선언 할 수 있다.
    //변수 증가문에 여러 개의 문장을 작성할 수 있다.
      for (int i = 1 , j = 1 , k = 1; i <= 10; i++ )
        System.out.printf( "(%d,%d,%d) ", i, j, k);//(1,1,1),(2,1,1),(3,1,1),(4,1,1),(5,1,1),(6,1,1),(7,1,1),(8,1,1,),(9,1,1),(10,1,1)
      System.out.println();
      
      //for 문의 충접
      for (int i =1; i < 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");//i:1,j:1=>j:1 , i:2,j:2=>j:2 ,i:3,j:3=>j:3, i:4,j:4=>j:4 , i:5,j:5=>j:5 , i:6,j:6=>j:6, i:7,j:7=>j:7
                                        //i:8,j:8=>j:8, i:9,j:9=>j:9, i:10,j:10=>j:10
        }
        System.out.println();
      }
      System.out.println("======================================");
      
     
    
      for (int i = 1 , j = 1 , k = 1; i <= 10; i++)
        System.out.printf( "(%d,%d,%d) ", i, j, k);
      System.out.println();//(1,1,1) (2,1,1) (3,1,1) (4,1,1) (5,1,1) (6,1,1) (7,1,1) (8,1,1) (9,1,1) (10,1,1)
      
     
      //break 라벨명;
      loop1: //break의 라벨을 loop1이라고 했다.
      for (int i =1; i < 10; i++) {//1 2 3 4 5
        for (int j = 1; j <= i; j++) {//1 2 3 4 5
          System.out.print(j + " ");//1,2,3,4,5==>if문을 빠져나간다.
          if (j == 5)
            break loop1;//break가  라벨로 지정한 문장을 나간다.
        }
        System.out.println();
      }
      System.out.println("======================================");
    
  
      for (int i =1; i < 10; i++) {//1 2
        for (int j = 1; j <= i; j++) {//1 2
          
      if (j % 2 == 0)//1 3 5 7 9
        continue;//break가  라벨로 지정한 문장을 나간다.
      System.out.print(j + " ");
    }
    System.out.println();
  }
  System.out.println("======================================");
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
       
     
   
   

   
    





