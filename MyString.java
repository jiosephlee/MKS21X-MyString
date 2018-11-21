public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++){
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index){

  }

  public int length(){

  }

  public String toString(){

  }

  public CharSequence subSequence(int start, int end){
    String output = "";
    for (int i = start; i < end; i++){
      output += data[i];
    }
    return output;
  }
}
