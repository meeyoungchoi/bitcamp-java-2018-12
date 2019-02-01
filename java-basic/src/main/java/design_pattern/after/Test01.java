package design_pattern.after;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//Command 패턴
		//
		//
		//나중에 명령어가 추가되면 그 명령어를 처리할 클래스를 추가하면 된다.
		//
		HashMap<String,Command> commandMap = new HashMap<>();
		commandMap.put("/board/add", new BoardAddCommand());
		commandMap.put("/board/list", new BoardListCommand());
		commandMap.put("/board/delete", new BoardDeleteCommand());
		commandMap.put("/board/detail", new BoardDetailCommand());
		
		commandMap.put("/member/add", new MemberAddCommand());
		commandMap.put("/member/list", new MemberListCommand());
		commandMap.put("/member/delete", new MemberDeleteCommand());
		commandMap.put("/member/detail", new MemberDetailCommand());
		
		commandMap.put("/lesson/add", new LessonAddCommand());
		commandMap.put("/lesson/list", new LessonListCommand());
		commandMap.put("/lesson/delete", new LessonDeleteCommand());
		commandMap.put("/lesson/detail", new LessonDetailCommand());
		
		commandMap.put("hello", new HelloCommand());
		
		while (true) {
			System.out.print("명령");
			String input = keyboard.nextLine();
			
			//
			Command command = commandMap.get(input);
			
			if (command != null ) {
				//명령어 사용 규칙에 따라 메서드를 호출한다.
				command.execute();
			}	else if ("quit".equals(input)) {
				break;
			} else {
				System.out.println("처리할수 없는 명령어 입니다.");
			}
			System.out.println();
		}
		keyboard.close();
	}
}
