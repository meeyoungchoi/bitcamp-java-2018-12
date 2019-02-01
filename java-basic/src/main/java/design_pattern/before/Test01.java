package design_pattern.before;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		CommandHandler handler = new CommandHandler();
		
		while (true) {
			System.out.print("명령");
			String input = keyboard.nextLine();
			
			if ("/board/add".equals(input)) {
				handler.addBoard();
				//스트링인스턴스의 주소가 놓인다.
			} else if ("/board/delete".equals(input)) {
				handler.deleteBoard();
			} else if ("/board/detail".equals(input)) {
				handler.detailBoard();
			}	else if ("/board/list".equals(input)) {
				handler.listBoard();
			} else if ("/lesson/list".equals(input)) {
				handler.listLesson();
			}	else if ("/lesson/delete".equals(input)) {
				handler.deleteLesson();
			}	else if ("/lesson/detail".equals(input)) {
				handler.detailLesson();
			}	else if ("/lesson/add".equals(input)) {
				handler.addLesson();
			}	else if ("/lesson/delete".equals(input)) {
				handler.deleteLesson();
			}	else if ("/member/delete".equals(input)) {
				handler.deleteMember();
			}	else if ("/member/update".equals(input)) {
				handler.deleteMember();
			}	else if ("/member/detail".equals(input)) {
				handler.detailMember();
			}	else if ("/member/add".equals(input)) {
				handler.addMember();
			}	else if ("quit".equals(input)) {
				break;
			} else {
				System.out.println("처리할수 없는 명령어 입니다.");
			}
		}
		
	}
}
