package design_pattern.composit;

public class File extends Node{
	String type;
	int length;
	
	public File(String title, String type, int length) {
		this.title = title;
		this.type = type;
		this.length = length;
	}
	
	@Override
	public void getFileInfo() {
		System.out.printf("파일명: %s\n",this.title);
		System.out.printf("파일명: %s\n",this.type);
		System.out.printf("파일명: %d\n",this.length);
		
	}

}
