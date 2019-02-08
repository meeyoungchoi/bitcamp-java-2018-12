package com.eomcs.context;

import java.util.Map;

public interface ApplicationContextListener {//Observer가 갖춰야 할 규칙을 정의한다.
  default void contextInitialized(Map<String,Object> context) {}
  default void contextDestroyed(Map<String,Object> context) {}
}
