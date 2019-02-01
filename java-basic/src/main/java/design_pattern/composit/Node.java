package design_pattern.composit;

public abstract class Node {
	protected String title;
	
	public String getTitle() {
		return this.title;
	}
	
	public abstract void getFileInfo();//파일타입에 따라서 처리해라
}
