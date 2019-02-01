package design_pattern.after;

public class LessonListCommand implements Command {
	@Override
	public void execute() {
		System.out.println("회원변경처리");
	}
}
