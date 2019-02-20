
package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<E> {

  protected List<E> list;//읽어들인 데이터를 리스트 저장
  protected String filepath;//리스트에 있는걸 파일에 젖아
  //서브클래스에서 사용하라고 만든 필드이므로 protected붙인다.
  
  
  @SuppressWarnings("unchecked")
  public void loadData() {//파일패스가 들어있다는 가정하에 호출
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream(this.filepath)))) {
      
      list = (List<E>) in.readObject();
      
    } catch (Exception e) {
      list = new ArrayList<E>();
      throw new RuntimeException("데이터 파일 로딩 오류!", e);
    }
  }
  
  public void saveData() throws Exception {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(this.filepath)))) {
    
      out.writeObject(list);
      
    } catch (Exception e) {
      throw new Exception("데이터 파일 저장 오류!", e);
    }
  }

}







