// 요청 핸들러의 아규먼트 - 도메인 객체(값 객체; Value Object)로 요청 파라미터 값 받기
package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_4")
public class Controller04_4 {

  // 클라이언트가 보낸 요청 파라미터 값을 값 객체에 받을 수 있다. 
  
  // => 요청 핸들러의 아규먼트가 값 객체라면, 
  //    프론트 컨트롤러는 메서드를 호출할 때 값 객체의 인스턴스를 생성한 후 
  //    요청 파라미터와 일치하는 프로퍼티에 대해 값을 저장한다.
  //    그리고 호출할 때 넘겨준다.
  //    
  // 테스트:
  //    http://.../c04_3/h1?model=sonata&maker=hyundai&capacity=5&auto=true&engine.model=ok&engine.cc=1980&engine.valve=16
  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      String model,
      String maker,
      int capacity,  // 프론트 컨트롤러가 String 값을 int로 변환해 준다.
                     // 단 변환할 수 없을 경우 예외가 발생한다.
      //boolean auto, // 프론트 컨트롤러가 String 값을 boolean으로 변환해 준다.
                   // 단 변환할 수 없을 경우 예외가 발생한다.
                   // "true", "false"는 대소문자 구분없이 true, false로 변환해 준다.
                   // 1 ==> true, 0 ==> false 로 변환해 준다. 그 외 숫자는 예외 발생!
      String createdDate,
      Car car  // 아규먼트가 값 객체이면 요청 파라미터 중에서 값 객체의 프로퍼티 이름과 일치하는
               // 항목에 대해 값을 넣어준다.
               // 값 객체 안에 또 값 객체가 있을 때는 OGNL 방식으로 요청 파라미터 값을 
               // 지정하면 된다.
               // 예) ...&engine.model=ok&engine.cc=1980&engine.valve=16
      ) {
    
    out.printf("model=%s\n", model);
    out.printf("maker=%s\n", maker);
    out.printf("capacity=%s\n", capacity);
    //out.printf("auto=%s\n", auto);
    out.printf("car=%s\n", car);
    out.printf("createdDate=%s\n", createdDate);
  }
  
  //
  //
  @GetMapping("h2") 
  @ResponseBody 
  public void handler2(
      PrintWriter out,
      //콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      //=>String ==> Car 프로퍼티 에디터를 등록하면 된다.
     @RequestParam("car") Car car
     

      ) {
    
   
    out.printf("car=%s\n", car);

  }
  
  //테스트
  // http://.../
  @GetMapping("h3") 
  @ResponseBody 
  public void handler3(
      PrintWriter out,
      //콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      //=>String ==> Car 프로퍼티 에디터를 등록하면 된다.
     @RequestParam("Engine") Engine engine
     

      ) {
    
   
    out.printf("car=%s\n", car);

  }
  
  
  class CarPropertyEditor extends PropertyEditorSupport {
    SimpleDateFormat format;
    
    public CarPropertyEditor() {
      format = new SimpleDateFormat("yyy-MM-dd");
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("CarPropertyEditor/setAsText()");
      String[] values = text.split(",");
      try {
        Car car =  new Car();
        car.setModel(values[0]);
        car.setCapacity(Integer.parseInt(values[1]));
        setValue(new Car());  //내부에 저장
       } catch (ParseException e) {
        throw new IllegalArgumentException(e);
       }
    }
 }

  
  //프로퍼이 에디터를 프론트 컨트롤러에게 적용하기
  // => 프론트 컨트롤러는 reqeust handler를 호출하기 전에
  // 넘겨줄 아규먼트 값을 준비해야 한다.
  //각 아규먼트 값을 준비할 때 
  //@InitBinder가 효시된 메서드를 호출하여 
  //프로퍼티 에디터(변환기)를 준비시킨다.
  //그리고 이 준비된 값 변환기(프로퍼티 에디터)ㄹ르 이용하여 파라미터 값을
  //request handler의 아규먼트가 원하는 타입의 값으로 바꾼다.
  //=>따라서 프로퍼티 에디터를 적용하기에
  //@InitBinder가 표시된 메서드가 적절한 지점이다.
  //즉 이 메서드에 프로퍼티 에디터를 등록하는 코드를 둔다.
  //
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    //System.out.println("Controller04_4.ok()");
    //프로퍼티 에디터를 등록하려면 그 일을 수행할 객체(WebDataBinder)가 필요하다.
    // request handler 처럼 아규먼트를 선언하여
    //프론트 컨트롤러에게 달라고 요청하라
    
    //String ==>date객체로 바꿔주는 프로퍼티 에디터 준비
    DatePropertyEditor propEditor = new DatePropertyEditor();
    
    CarPropertyEditor propEditor2 = new CarPropertyEditor();

    //WebDataBinder에 등록하기
    binder.registerCustomEditor(java.util.Date.class, //String을 Date 타입으로 바꾸는 에디터입을 지정한다.
        propEditor); //바궈주는 일을 하는 프로퍼티 에디터를 등록한다.
    
    //WebDataBinder에 등록하기
    binder.registerCustomEditor(Car.class, //String을 Date 타입으로 바꾸는 에디터입을 지정한다.
        new CarpropertyEditor); 
  }
  //PropetryEditor 만들기
  //=> 문자열을 특정 타입의 프로퍼티 값으로 변환시킬 때 사용하는 애티너이다.
  //=>java.beans.PropertyEditor 인터페이스를 구현해야 한다.
  // => PropertyEditor를 직접 구현해마녀 너무 많은 메서드를 오버라이딩 해야 하기 때문에
  //자바에서는 도우미 클래스인 PropertyEditorSupprt 클래스를 젲공한다.
  //이 클래스는 PropertyEditor를 미리 구현하였다.
  //따라서 이 클래스를 상속 받는 것이 더 낮다.
  class DatePropertyEditor extends PropertyEditorSupport {
    
    //yyyy-MM-dd 형태의 문자열을 java.util.Date 객체로 만들어주는 클래스를 준비한다.
    SimpleDateFormat format;
    
    public DatePropertyEditor() {
      //프로퍼티 에디터를 사용하는 측에서 어떤 형식의 문자열을 Date 객체로 만들 것인디
      //설정하지 않았다면 기본으로 yyyy-MM-dd형식의 문자열을 Date 객체로 만들도록 준비한다.
     
      format =new SimpleDateFormat("yyyy-MM-dd");
    }
    
    public DatePropertyEditor(SimpleDateFormat format) {
      //물론 프로퍼티 에디터를 사용하는 측에서 날짜에 대한 문자열 형식을 지정할 수도 있다.
      this.format = format;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor/setAsText()");
      // 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서 
      //문자열을 Date 객체로 바꾸기 위해 이 메서드를 호출할 것이다.
      //그러면 이 메서드에서 문자열을 프로퍼티가 원하는 타입으로 변환한 후 젖아하면 된다.
      try {
       Date date =  format.parse(text); // String ==> java.util.Date
       setValue(date);  //내부에 저장
      } catch (ParseException e) {
       throw new IllegalArgumentException(e);
      }
    }
    
    @Override
    public Object getValue() {
      System.out.println("DatePropertyEditor.getValue()");
      //이 메서드는 프로퍼티 에디터를 사용하는 축(예: 프론트 컨트롤러)에서
      //변환된 값을 꺼낼 때 호출된다/
      //이 메서드를 오버라이딩 하는 이유는 이 메서드가 호출된 것을 
      //확인하기 위함이다. 원래는 오버라이딩 해야 할 이유가 없다.
      
      return super.getValue();
    }
  }
}



