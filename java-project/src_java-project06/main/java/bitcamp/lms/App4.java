
package bitcamp.lms;



public class App4 {


  public static void main(String[] args) {
    

    java.util.Scanner keyboard = new java.util.Scanner(System.in);

      
    //1. 배열 변수를 만들어야 한다.
    int[] number=new int[5];
    String[] name=new String[5];
    String[] content=new String[5];
    String[] start=new String[5];
    String[] finish=new String[5];
    String[] total=new String[5];
    String[] study=new String[5];
    
    //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
    int i=0;
    
      while(i < 5) {
    
      

      System.out.print("번호를 입력하세요:");
      number[i] =Integer.parseInt(keyboard.nextLine());

      
      System.out.print("수업명:");
      name[i]=keyboard.nextLine();
    
      System.out.print("수업내용:");
      content[i]=keyboard.nextLine();
    
    
      System.out.print("시작일? ");
      start[i]=keyboard.nextLine();
    
      System.out.print("종료일?");
      finish[i]=keyboard.nextLine();

      System.out.print("총수업시간?");
      total[i]=keyboard.nextLine();
    

      //System.out.print("일수업시간?");
      //study[i]=keyboard.nextLine(); 
      
      i++;
      
      System.out.println();
      System.out.println("계속 입력하시겠습니까:(y/n)");
      String input=keyboard.nextLine();
      
      if((!input.equalsIgnoreCase("y")) && (!input.equals(""))) {
        break;
              }//if문 끝
     
          }//while문 끝

      
      //입력된 번호, 과목명, 과목내요, 시작일, 종료일, 총 시간을 한줄에 보여줘야 한다.
      int j=0;
      
      while(j < i) {
        System.out.printf("%d, ", number[j]);
        System.out.printf("%s, ", name[j]);
        System.out.printf("%s, ", content[j]);
        System.out.printf("%s ~ %s, ", start[j], finish[j]);
        System.out.printf("%s, \n", total[j]);
        
        j++;
      }
      
      }//main끝
   }//class 끝]);
        
  


  


  


    
        
     
      
 