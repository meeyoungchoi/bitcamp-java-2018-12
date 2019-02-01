package design_pattern.after;

public class BoardDetailCommand implements Command {
	@Override
	public void execute() {
		System.out.println("게시물 입력 처리");
	}
}
