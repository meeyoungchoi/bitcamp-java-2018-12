package com.eomcs.lms;

import org.springframework.context.annotation.ComponentScan;

// 특정 패키지를 탐색하여 @Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성하게 만드는 애노테이션
@ComponentScan(basePackages="com.eomcs.lms")
public class AppConfig {

}






