package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Command {//인터페이스를 구현하면 새 규칙을 따르게 되있따.
  default void execute(/*ObjectInputStream in, ObjectOutputStream out*/) {
	  //이 인터페이스를 새로 구현하는 클래스가
	  //과거의 규칙을 따르지 않아도 되도록 
	  //기존 규칙도 default로 선언한다.
  }
  default void execute(ObjectInputStream in, ObjectOutputStream out) {
	//새 규칙이 추가됬다 하더라도 기존 클래스에 영향을 주지 않는다.
	  // 단점: 이 인ㅊ터페이스를 구현하는 클래스는 이 규칙(메서드)을 구현해도 되고 안해도 된다.=> 규칙을 느슨하게 만든다.
	  //하지만 기존 코드에 영향을 주지 않으면서 새 코드를 추가할수 있다.
	  
	  //이 규칙은 새로 추가한 규칙이다.
	  //그러나 기존 클래스에 영향을 끼치지 않기 위해 default로 선언했다.
  }
}
