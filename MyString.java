import java.io.*;
import java.util.*;
public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;

  public static void main(String[] args) {
    try{
      MyString test = new MyString(args[0]);
      System.out.println("Testing Constructor and toString()... Expected: the inputted string \n" + test + "\n");
      System.out.println("Testing charAt() and length()... Expected: the characters of the string seperated by commas" + "\n");
      for (int x = 0; x < test.length(); x++){
        System.out.print(test.charAt(x) + ", ");
      }
      System.out.println("\nTesting subSequence() (only works if the input is longer than 2 characters)... Expected: ordered subsequences(size 2) ofthe String. Ex: cat --> ca, at, " + "\n");
      for (int i = 0; i < args[0].length() - 1; i++){
        System.out.print(test.subSequence(i,i+2) + ", ");
      }
      System.out.println("\nTesting compareTo() ... Expected: 1 , 0, -1 , error message, 1, 0, error message, -1");
      System.out.println("\nTesting");
    } catch (IndexOutOfBoundsException e){
      System.out.println("Inputted index is out of bounds");
    } catch (NullPointerException e){
      System.out.println("Object is null");
    } catch (ClassCastException e){
      System.out.println("specified object's type prevents it from being compared to this object.");
    }
  }

  public MyString (CharSequence s){
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

  public int compareTo(CharSequence o){
    int length = 0;
    if (o.length() >= length()){
      length = length();
    } else {length = o.length();}
    for(int i = 0; i < length; i++){
      if(o.charAt(i) < charAt(i)){
        return 1;
      } else if (o.charAt(i) > charAt(i)){
        return -1;}
      if (i == length - 1){
        if (length() > o.length()){
          return 1;
        }
        return -1;
      }
      }
    return 0;
    }
}
