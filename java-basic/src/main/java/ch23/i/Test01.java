package ch23.i;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Test01 {
  public static void main(String[] args) throws Exception {
    String str = "ABC012가각간";
    
    byte[] bytes = str.getBytes("UTF-8");
    
    //Base64
    //=>바이너리 데이터를 문자화 시킨다.
    //=>바이너리 값을 6ㅂ비트식 잘라서(2의 6승)
    //64진수로 만든 후 Base64 표에 정의된 대로 해당 값을 문자료 변환한다.
    //=>보통 바이너리 데이터를 텍스트로 전송하고 싶을 때 만힝 사용한다.
    //=>ABC012가간
    //   414243303132EAB081(UTF-8 코드)
    //    4142 ==> 0100000101000010 (2진수)
    // 010000 010100 0010 (6비트씩 자른 것)
    // 6비트로 자른것을 다시 10진수로 표현하면  ==> 16  20 
    //16을 Base64 코드표에 따라 문자로 바꾸면 ==> q
    //20을 Base64 코드표에 따라 문자로 바꾸면 ==> u
    //...
    //이런식으로 문자열을 Base64로 바꾸면 결과는 다음과 같다.
    //QUJDMDEy6rCA6rCB6rCE
    //언제 쓰는가?
    //바이너리 데이터를 문자화시켜서 전송해야 하는 경우
    //암호의 전제조건은 단방향성 이어야 한다.
    //그런데 값이 들어왔는데 다시 원본깞이 나온다면 그건 암호가 될수 없다.
    //그래서 공개키로 암호화 시키고 개인키로 암호를 푼다.
    //베이스64 -> 인코딩 -> 받는사람은 base64를 디코딩한다.
    Encoder encoder = Base64.getEncoder();
    byte[] base64Bytes= encoder.encode(bytes);
    
    System.out.println(new String(base64Bytes));
    
    //Base64 디코딩
    //=>Base64 코드를 원래의 바이너리 값으로 변환한다.
    //
    Decoder decoder = Base64.getDecoder();
    byte[] bytes2 = decoder.decode(base64Bytes);
    
    System.out.println(new String(bytes2,"UTF-8"));
  
    
  }

}
