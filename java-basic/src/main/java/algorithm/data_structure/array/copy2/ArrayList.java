package algorithm.data_structure.array.copy2;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ArrayList<E> {
  static final int DEFAULT_SIZE = 5;

  private static final Object[] Object = null;
  
  Object[] arr;
  int size;

  private java.lang.Object[] temp;

  
  
  public ArrayList() {
    this(0);
  }
  
  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else 
      arr = new Object[DEFAULT_SIZE];
  }
  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      list[i] = this.arr[i];
    }
    return list;
  }
  
  public void add(Object value) {
    //현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라
   if(this.size == arr.length)
     increase();
   
  arr[this.size++] = value;
  }
  
  public int insert(int index, Object value) {
   if (index < 0 || index >= size) //맨끝에 삽입
     return -1;
   
   if(this.size == arr.length)
      increase();
   for (int i = size - 1;  i >= index; i--)
      this.arr[i + 1] = this.arr[i];
    
   this.arr[index] =  value;
   size++;
   
   return 0;
   }
  
  @SuppressWarnings({"unchecked"})
  public Object set(int index, Object value) {
    //유효 범위가 아니면 null을 리턴하라
    if (index < 0 || index >= size)
    return null;
    
    Object old= this.arr[index];
    this.arr[index] = value;
    return old;
    
  }
  
  public Object get(int index) {
    ///유효 인덱스(현재 배열의 데이터가 저장된 방번호)가 아니면 null을 리턴하라
    if (index < 0 || index >= size) 
     return null;
    
    return  this.arr[index];

    
   }
  
  public Object remove(int index) {
    ///유효 인덱스(현재 배열의 데이터가 저장된 방번호)가 아니면 삭제하지 마라
    if (index < 0 || index >= size)
    return null;
    
    E obj = (E) arr[index];
    
    for (int i = index; i < size - 1; i++)
      arr[i] = arr[i + 1];
    
    size--;
    
    return obj;
    
  }
  
  public int size() {
    return this.size;
  }
  
  private void increase() {
    if (this.size == arr.length) {
      int originSize = arr.length;
       int newSize = originSize + (originSize >> 1);
       Object[] temp = new Object[newSize];
       for (int i = 0; i < this.arr.length; i++) {
         temp[i] = this.arr[i];
       }
       arr = temp;
    }
  }
}
 

