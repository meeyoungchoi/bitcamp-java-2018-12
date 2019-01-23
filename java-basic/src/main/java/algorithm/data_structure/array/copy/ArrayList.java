package algorithm.data_structure.array.copy;

public class ArrayList {
  int DEFAULT_SIZE = 5;
  
  Object[] object = null;
  
  Object[] arr;
  int size;
  
  java.lang.Object[] temp;
  
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
   if (this.size == arr.length)
     increase();
 }

 public int insert(int index, Object value) {
  if (index < 0 || index >= size)
    return -1;
  
  if (this.size == arr.length)
    increase();
  for (int i = size - 1; i >= index; i-- )
    
  this.arr[i + 1] =this.arr[i];
  size++;
  
  return 0;
  }
 
 @SuppressWarnings("unused")
public Object set(int index, Object value) {
   
   if (index < 0 || index >= size) 
     return null;
   
  Object old = this.arr[index];
   this.arr[index] = value;
  return old;
   
 }
 
 public Object get(int index) {
   if (index < 0 || index >= size)
     return null;
   
   return this.arr[index];
 }
 
 public Object remove(int index) {
   if (index < 0 || index >= size) 
     return null;
  
   return this.arr[index];
 }
 
 @SuppressWarnings("unused")
private int size() {
   return this.size;
 }
 
@SuppressWarnings("unused")
private void increase() {
  if (this.size == arr.length) {
   int originSize = arr.length;
  int newSize = originSize + (originSize >> 1);
  Object[] temp;
  temp =new Object[newSize];
  for (int i = 0; i < this.arr.length; i++) {
    temp[i] = arr[i];
    }
  arr = temp;
  }
 }
}


