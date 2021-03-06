package ch30.f;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 지정된 객체의 메서드를 호출할 때,
// 메서드 호출 전이나 후에 어떤 작업을 수행하는 일을 한다.

// XML 설정을 사용할 때는 이 클래스의 객체 생성을 XML에서 했기 때문에 
// @Component 애노테이션을 붙이지 않았다.
// 이제는 XML에서 이 클래스의 객체를 만들지 않기 때문에 이 애노테이션을 붙여야 한다.
@Component

// 이 클래스가 AOP 기능을 수행하는 클래스임을 표시해야 한다.
@Aspect
public class MyAdvice {
  
  /*
 	
   */
  @Pointcut("execution(* ch30.f.X.*(..))")
  public void CalculatorOperation() {}
  
  /*
   <aop:after 
     pointcut-ref="pointcut1" method="doAfter" />
   */
  @After(pointcut="execution(* ch30.f.X.*(..))")
  public void doAfter() {
    System.out.printf("%s.doAfter()\n", this.getClass().getName());
  }
  
  /*
   <aop:after-returning pointcut-ref="pointcut1"
          returning="rv" 
          method="doAfterReturning" />
   */
  @AfterReturning(
      pointcut="execution(* ch30.f.X.*(..))", 
      returning="rv")
  public void doAfterReturning(Object rv) {
    System.out.printf("%s.doAfterReturning()\n", this.getClass().getName());
    System.out.printf("  => %d\n", rv);
  }
  
  /*
   <aop:after-throwing pointcut-ref="pointcut1"
          throwing="err"
          method="doAfterThrowing" />
   */
  @AfterThrowing(
      pointcut="execution(* ch30.f.X.*(..))", 
      throwing="err")
  public void doAfterThrowing(Exception err) {
    System.out.printf("%s.doAfterThrowing()\n", this.getClass().getName());
    System.out.printf("  => %s\n", err.getMessage());
  }
}





