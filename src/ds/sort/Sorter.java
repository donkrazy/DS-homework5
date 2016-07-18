package ds.sort;

public class Sorter {

  private int[] array;
  private int MAX_LENGTH;
  private int length;


  public Sorter(int n) {
    this.array = new int[n];
    this.length = 0;
    this.MAX_LENGTH = n;
  }

  public void add(int value) {
    if(length <= MAX_LENGTH){
      this.array[length] = value;
      length++;
      System.out.println("ADD: "+value);
    }
  }

  public boolean remove(int value) {
    for (int i=0; i<length; i++ ) {
      if(value == array[i]){
        for(int j=i; j<length-1; j++){
          array[j]=array[j+1];
        }
        array[length-1]=0;
        length--;
        System.out.println("REMOVE: "+value);
        return true;
      }
    }
    System.out.println("The value does not exist");
    return false;
  }

  public void sort(String type) {
    if(type.equals("ascend")){
      qsortAsc(0, length-1);
      print();
    }
    else if (type.equals("descend")){
      qsortDsc(0, length-1);
      print();
      return;
    }
    else{
      System.out.println("error");
    }
  }



  public void top(int k, String type) {
    //TODO: 제대로 구현
    qsortAsc(0, length-1);
    if(type.equals("smallest")){
      for(int i=0; i<k; i++){
        System.out.print((array[i])+" ");
      }
    }
    else if (type.equals("largest")){
      for(int i=0; i<k; i++){
        System.out.println((array[length-1-i]));
      }
    }
  }

  public void print(){
    for ( int i : array ) {
      if(i==0){
        System.out.println("");
        break;
      }
      System.out.print(i+" ");
    }
  }

  private void swap(int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private int partition(int l, int r, int pivot){
    do{
      while(array[l]<pivot){l++;}
      while( (r!=0) && ( array[--r] > pivot )  );
      swap(l, r);
    } while(l < r);
    swap(l, r);
    return l;
  }

  private void qsortAsc(int i, int j) {
    //TODO: random pivot 잘 안된다
    //int pivotIndex = new Random().nextInt(j);
    int pivotIndex = (i+j)/2;
    swap(pivotIndex, j);
    int k = partition(i, j, array[j]);
    swap(k, j);
    if( (k-i) > 1) qsortAsc(i, k-1);
    if( (j-k) > 1) qsortAsc(k+1, j);
  }

  public void qsortDsc(int i, int j){
    //TODO: partition desc 구현
    qsortAsc(i, j);
    int a = i;
    int b = j;
    while(a < b){
      swap(a, b);
      a++;
      b--;
    }
  }



}


