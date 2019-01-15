//팩토리 메서드 적용 전
package design_pattern.factory_method;

class Car2 {
  String model;
  int cc;
  boolean sunroof;
}

//인스턴스를 생성해주는 메서드를 정의한다.
//=>
class car2Factory {
  public static Car2 create(String product) {
    Car2 c = new Car2();
    
    switch (product) {
      case "tc":
        c.model = "티코";
        c.cc = 890;
        c.sunroof = false;
      break;
      case "tcg":
        c.model = "티코 골드";
        c.cc = 890;
        c.sunroof = true;
      break;
      case "sn":
        c.model = "소나타";
        c.cc = 1980;
        c.sunroof = false;
      break;
      case "sng":
        c.model = "소나타 골드";
        c.cc = 1980;
        c.sunroof = true;
        
      break;
      default:
      return null;
    } 
    return c;
  }
}
public class Test02 {

  public static void main(String[] args) {
    //인스턴스를 만들 때 사용에 적합하도록 직접 초기화 시켜야 한다.
    Car2 c1 = car2Factory.create("tc");
    Car2 c2 = car2Factory.create("tcg");
    Car2 c3 = car2Factory.create("sn");
    Car2 c4 = car2Factory.create("sng");
    Car2 c5 = car2Factory.create("ok");
 
   System.out.println(c1.model);
   System.out.println(c2.model);
   System.out.println(c3.model);
   System.out.println(c4.model);
   System.out.println(c5.model);
    
    
    
  }

}
