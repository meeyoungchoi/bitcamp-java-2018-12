package design_pattern.after;

public class LessonDetailCommand implements Command {
	@Override
	public void execute() {
		System.out.println("회원변경처리");
	}
}
