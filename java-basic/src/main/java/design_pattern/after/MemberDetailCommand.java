package design_pattern.after;

public class MemberDetailCommand implements Command {
	@Override
	public void execute() {
		System.out.println("회원변경처리");
	}
}
