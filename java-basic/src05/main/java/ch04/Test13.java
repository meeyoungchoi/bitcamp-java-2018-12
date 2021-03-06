// 비트연산자: &, | 
//용도: 영상처리,이미지 프로세싱 분야에서 사용된다.

package ch04;

public class Test13 {

  public static void main(String[] args) {
   
    // & 둘다 1일때만 1
    // | 둘중 한개라도 1이면 1이다.
    int a=0xca; //0000 0000 0000 0000 0000 0000 1100 1010
    int b=0x66; //0000 0000 0000 0000 0000 0000 0110 0110
    System.out.println(a & b);
    //                 0000    0000 0000 0000 0000 0000 0100 0010
    
    System.out.println(a | b);
    //둘중 하나가 1이면 1이다.
    //둘다 1이면 1이다.
    
    //^: 두개의 비트가 다르면 1
    
    System.out.println(a ^ b); //0xac=172
    // 0000 0000 0000 0000 0000 0000 1010 1100
    
    //~ -> 모든 비트를 반대 값으로 바꾼다.
    System.out.println(~a);
    //0000 0000 0000 0000 0000 0000 1100 1010를 음수취하려면 1->0 0->1
    //    음수    1111 1111 1111 1111 1111 1111 1111 0011 0101 =>0xffffff35=201
    //=>1111 1111 1111 1111 1111 1111 1111 0011 0101이거가 음수여서 양수로 바꾸기 위해 제일처음 오른쪽 1은 만나도 그대로 1이되고
    //나머지 비트는 전부 반전 시켜서 나온 결과: (양수)0000 0000 0000 0000 0000 0000 1100 1011=203  여기에서 -1을 해줘야 한다.                                                   +1
    //1111 1111 1111 1111 1111 1111 0011 0101 =>0000 0000 0000 0000 0000 0000 1100 1011의 음수값
    //
    //                                                  1100 1001
    
    //&활용: 특정 값을 차단하고 특정 값만 통과 시킬때 
    int data=0b1111_1111_1111_1111;
    System.out.println(Integer.toBinaryString(data &0b0000_1111_1100_0000));
    //1111_1001_0111_1111
    // & 0000_1111_1100_0000 
    //   0000_1001_0100_0000
    //1로 된것만 통과하고 나머지는 차단시킨다.
    //예) 그림의 한 픽셀에서 빨강 색을 제거하고 싶다.
    int pixel=0x003f4478; //각 바이트의 값이 00rrggbb라고 가정하자
    // 00000000_00111111_01000100_01111000
    //=>이 점에서 빨간색을 뽑아내고 싶을 때 and연산자를 사용한다.
    System.out.println(pixel & 0x0000ffff);
    //  00000000_00111111_01000100_01111000
    //& 00000000_00000000_11111111_11111111
    //  00000000_00000000_01000100_01111000
  }

}


/***
 
 *
 * 
 * 
 * *
 */



