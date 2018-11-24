import java.io.*;
import java.util.*;
public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;

  public static void main(String[] args) {
    try{
      MyString test = new MyString(args[0]);
      System.out.println("Testing Constructor and toString()... Expected: the inputted string \n \n" + test + "\n");
      System.out.println("Testing charAt() and length()... Expected: the characters of the string seperated by commas" + "\n");
      for (int x = 0; x < test.length(); x++){
        System.out.print(test.charAt(x) + ", ");
      }
      System.out.println("\n \nTesting subSequence() (only works if the input is longer than 2 characters)... Expected: ordered subsequences(size 2) ofthe String. Ex: cat --> ca, at, " + "\n");
      for (int i = 0; i < args[0].length() - 1; i++){
        System.out.print(test.subSequence(i,i+2) + ", ");
      }
      MyString one = new MyString("yolo");
      MyString two = new MyString("yo");
      System.out.println("\n \nTesting compareTo() ... Expected: 1 , 0, -1" );
      System.out.println(one.compareTo(two));
      System.out.println(two.compareTo(two));
      System.out.println(two.compareTo(one));

      // Sandbox for Testing exceptions
      MyString yo = new MyString("yolo");
      MyString yol = new MyString(null);
      yol.compareTo(yo);
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("please input an argument");
    }
  }

  public MyString (CharSequence s){
    if (s == null){
      System.out.println("Object cannot be null");
      System.exit(0);
    }
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++){
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index){
    if (index >= length() || index < 0){
      System.out.println("Index is out of bounds");
      System.exit(0);
    }
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
    if (start < 0 || start >= length() || end < 0 || end > length()){
      System.out.println("Index is out of bounds");
      System.exit(0);
    }
    String output = "";
    for (int i = start; i < end; i++){
      output += data[i];
    }
    return output;
  }

  public int compareTo(CharSequence o){
    if (this == null){
      System.out.println("Object cannot be null");
      System.exit(0);
    }
    //finding the shortest length so that we only loop through up to the shortest word
    int length = 0;
    if (o.length() >= length()){
      length = length();
    } else {length = o.length();}
    //starting at the start of each word
    for(int i = 0; i < length; i++){
      //if character @ i is greater than other, than the entire string is greater
      if(o.charAt(i) < charAt(i)){
        return 1;
      } else if (o.charAt(i) > charAt(i)){
        return -1;}
      // if we are at the last letter of the shortest word and its still the same, the longer word is greater
      if (i == length - 1){
        if (length() > o.length()){
          return 1;
        } else if (length() < o.length()){
          return -1;
        }
      }
      }
    // if not they're equal
    return 0;
    }
}
