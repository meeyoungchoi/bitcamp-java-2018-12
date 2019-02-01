package design_pattern.after;

public class BoardAddCommand implements Command {
	@Override
	public void execute() {
		System.out.println("게시물변경처리");
	}
}
