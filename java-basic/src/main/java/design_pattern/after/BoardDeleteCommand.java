package design_pattern.after;

public class BoardDeleteCommand implements Command {
	@Override
	public void execute() {
		System.out.println("게시물 입력 처리");
	}
}
