package ch22.c;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutPutStream  extends OutputStream{
	OutputStream out;
	byte[] buf = new byte[1024];
	int size = 0;
	
	
	public BufferedOutPutStream(OutputStream out) {
		this.out = out;
	}


	@Override
	public void write(int b) throws IOException {
		
		//일단 바이트 버퍼에 저장한다.
		buf[size++] =(byte)b;
		
		if (size >= 1024) {
			//버퍼가 꽉차면 파일로 내보낸다.
			out.write(buf);
			size = 0;
		
		}
		
	}
	
	//버퍼에 남아있는 데이터를 출ㄹ겨할 때 호출한다.
	public void flush() throws IOException {
		if (size > 0) {
			out.write(buf, 0, size);
		}
	}
}
