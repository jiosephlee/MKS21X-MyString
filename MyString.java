import java.io.*;
import java.util.*;
public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;

  public static void main(String[] args) {
    try{
      MyString test = new MyString(args[0]);
      System.out.println("Testing Constructor and toString()... Expected: the inputted string" + test + "\n");
      System.out.println("Testing charAt() and length()... Expected: the characters of the string seperated by commas" + "\n");
      for (int x = 0; x < test.length(); x++){
        System.out.print(test.charAt(x) + ", ");
      }
      System.out.println("Testing");
    } catch (IndexOutOfBoundsException e){
      System.out.println("Inputted index is out of bounds");
    }
  }

  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++){
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index){
    return data[index];
  }

  public int length(){
    return data.length;
  }

  public String toString(){
    String output = "";
    for (int i = 0; i < data.length; i++){
      output += data[i];
    }
    return output;
  }

  public CharSequence subSequence(int start, int end){
    String output = "";
    for (int i = start; i < end; i++){
      output += data[i];
    }
    return output;
  }
}
