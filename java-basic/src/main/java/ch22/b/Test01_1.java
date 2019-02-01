//바이너리 데이터 입출력 - FileOutPutStream 클래스 사용법
package ch22.b;

import java.io.FileOutputStream;

public class Test01_1 {
	public static void main(String[] args) {
		//바이너리 데이터? 전용프로그램없이 직접 편집은 불가능하다.
		//=>character set(문자표) 규칙에 따라 작성한 파일이 아닌 파일
		//메모장으로 편집이 불가능한 파일
		//=>보통 전용 프로글맹르 이용해서 편집하는 파일.
		//=>예) .hwp, .gif, .jpeg,.mp3,.mp4,.ppt,.xls,.doc
		//.class, .swf, .avi 등 
		//
		//텍스트 데이터?
		//=>특정 character set(문자표) 규칙에 따라 작성한 파일.
		//메모장으로 편집 가능
		//예).txt,.c,.cpp,.java,.xml,.html,.css,.js,
		//.py,.docx,.xlsx,.pptx 등
		//
		//Java I/O API(java.io 패키지)
		//=>바이너리 입출력 과 관련된 데이터: INputStream(읽), OutPutStream(쓰)
		//=>트게스트 입출력: Reader, Writer
		
		//바이너리 데이터 출력
		//FileOutPutStream 클래스를 사용한다.
		try {
			//1.데이터 출력을 담당할 객체를 생성한다.
			FileOutputStream out = new FileOutputStream("data.bin");
			
			//2.데이터를 출력한다,
			//=>write(int) : 파라미터의 타입이 int라고 해서 4바이트를 출력하는 것이 아니다.
			//오직 1바이트만 출력한다.
			//1바이트를 출
			out.write(2);
			out.write(40);
			out.write(100);
			out.write(101);
			out.write(102);
			out.write(121);
			out.write(127);
			out.write(0x11223344);
			out.write(0x55667788);//맨 끝 1바이트만 출력한다.
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력완료");
		
	}
}
