package p10;

public class Test09 {
	public static void main(String[] args) {
		//String인스턴스 생성
		String s1 = new String();
		
		System.out.println(s1);
		
		String s2 = new String("Hello"); //문자열 리터럴로 String인스턴스 생성
		
		char[] chars = {'H'};
		String s3 = new String(chars);
		
		byte[] bytes = {(byte)0xb0, (byte)0xa1, (byte)0xb0, (byte)0xa2,
				0x30, 0x31, 0x32, 0x41, 0x42, 0x43};
		
		String s4 = new String(bytes);
		//한글이 깨진다.
		//생성자에 바이트 배열을 넘겨줄 때 
		//배열에 들어있는 코드 값이 어떤 문자표의 코드 값인지 알려줘야 한다.
		
		String s5 = new String(bytes, "euc-kr");
		
		bytes[] bytes2 = {(byte)0xac}
	}
}
