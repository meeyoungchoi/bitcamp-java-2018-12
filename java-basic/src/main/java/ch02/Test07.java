//부동소수점을 메모리에 저장하는 방법
package ch02;

public class Test07{
  static final float f=12.375f;

    public static void main(String[] args){
      
      //'가' 문자를 출력
      System.out.println(0xac00); //utf-16 코드값을 지정한다.
      //해당 숫자가 utf-16의 문자 코드임을 알려주지 않으면 println()은
      //그냥 일반 숫자인 줄 알고 10진수로 출력한다.
      
      //해결책?
      //숫자앞에 (char)를 붙여 이 숫자가 평범한 숫자가 아니라 
      //문자의 utf-16 코드 값임을 알려줘라.
      //utf-16은 2바이트 크기를 갖는다.
      //코드의 값은 0~65535이다.
      //문자코드 이므로 음수가 없다.
      //참고 숫자 2바이트의 범위는 -32768~ 32767 이다.
      System.out.println((char)0xac00);
      
      
      
      //문자의 코드를 알지 못한다면 작은 따옴표('')를 이용할 수 있다.
      //'가'?
      //한글 '가'의 utf-16 값을 리턴한다.
      //또한 이 값이 문자의 코드 값임을 알려준다.
      System.out.println('가');
      
      System.out.println('가' + 2);//2바이트 숫자가 리턴된다 '가':가라는 문자의 코드값을 리턴한다.
      System.out.println((char)('가' + 2));
      
      //작은 따옴표 안에 직접 유니코드(utf-16)를 표기할 수 있다.
      System.out.println('\uac00');
      
      //작은 따옴표 안에 직접 유니코드를 지정하는 경우?
      //특수 문자를 출력하고 싶을 때
      //코드에 해당하는 문자를 콘솔 창에 출력할 때는
      //콘솔 창에서 사용하는 폰트에서 해당 문자를 찾는다.
      //즉, 사용하는 폰트가 무엇이냐에 따라 출력하는 문자의 모양이 다를 수 있다.
      System.out.println('\u32d4');

      //https://ko.wikipedia.org/wiki/ASCII
      //cr lf space 느낌표 # $ % & + ? = @ 등 
      // 0 1
      
      //https://ko.wikipedia.org/wiki/ISO/IEC_8859
      //ISO/IEC 8859-1
      //아스키 문자에 유럽 문자까지 포함하는 국제 표현 문자 인코딩 규칙이다.
      //라틴-1 
      //서유럽
      //가장 널리 쓰이며 대부분의 서유럽 언어를 지원한다. 네덜란드어(일부[* 1]), 노르웨이어, 덴마크어, 독일어, 로만슈어, 스웨덴어 스코틀랜드 게일어, 
      //아이슬란드어, 아일랜드어, 에스파냐어, 영어, 이탈리아어, 페로어, 포르투갈어, 프랑스어(일부[* 2]), 핀란드어(일부[* 2]), 동유럽의 알바니아어, 
      //아프라카의 스와힐리어, 아프리칸스어. 유로 기호(€)와 대문자 "Ÿ"는 개정판인 ISO 8859-15에 추가되었다. IANA의 문자 집합 ISO-8859-1에 대응하며, HTML 
      //문서의 기본 인코딩이다.
      
      //https://ko.wikipedia.org/wiki/EUC-KR
      /*
       * 
       * EUC-KR은 KS X 1001와 KS X 1003을 사용하는 8비트 문자 인코딩, EUC의 일종이며 
       * 대표적인 한글 완성형 인코딩이기 때문에 보통 완성형이라고 불린다.
       * 
       * https://ko.wikipedia.org/wiki/%ED%95%9C%EA%B8%80_%EC%83%81%EC%9A%A9_%EC%A1%B0%ED%95%A9%ED%98%95_%EC%9D%B8%EC%BD%94%EB%94%A9
       * 
       * http://unicode.org/Public/MAPPINGS/VENDORS/MICSFT/WINDOWS/CP949.TXT
       * 
       * 
       * 
       * http://younghwakim.blogspot.com/2013/08/d19-tomcat-servlet.html
       * 왜 꺠지냐면 jvm은 utf-16으로 다루는데 utf-16을 utf-8로 바꿔야한다. 
       * 
       * TF-8은 여러 표준 문서에서 다른 방법으로 정의되어 있지만, 일반적인 구조는 모두 동일하다고 볼 수 있다.

유니코드 코드 포인트를 나타내는 비트들은 여러 부분으로 나뉘어서, UTF-8로 표현된 바이트의 하위 비트들에 들어 간다. U+007F까지의 문자는 7비트 ASCII 문자와 동일한 방법으로 표시되며, 그 이후의 문자는 다음과 같은 4바이트까지의 비트 패턴으로 표시된다. 7비트 ASCII 문자와 혼동되지 않게 하기 위하여 모든 바이트들의 최상위 비트는 1이다.

코드 범위(십육진법) UTF-16BE 표현(이진법)    UTF-8 표현(이진법)   설명
000000-00007F   00000000 0xxxxxxx   0xxxxxxx    ASCII와 동일한 범위
000080-0007FF   00000xxx xxxxxxxx   110xxxxx 10xxxxxx   첫 바이트는 110 또는 1110으로 시작하고,
나머지 바이트들은 10으로 시작함
000800-00FFFF   xxxxxxxx xxxxxxxx   1110xxxx 10xxxxxx 10xxxxxx
010000-10FFFF   110110yy yyxxxxxx 110111xx xxxxxxxx 11110zzz 10zzxxxx 10xxxxxx 10xxxxxx UTF-16 
서러게이트 쌍 영역 (yyyy = zzzzz - 1).
UTF-8로 표시된 비트 패턴은 실제 코드 포인트와 동일하다.

       * 
       * 
       * 
       * 
       * 
       * */
    }
}