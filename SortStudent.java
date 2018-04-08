/**
 * @(#)SortStudent.java
 *
 *
 * @author 
 * @version 1.00 2018/4/8
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortStudent
{

  private static final String FILENAME = "StudentInfo.txt";
  List<Student> studentList = new ArrayList<Student>();

  public void getFile() {

    BufferedReader br = null;
    FileReader fr = null;

    try {

      //br = new BufferedReader(new FileReader(FILENAME));
      fr = new FileReader(FILENAME);
      br = new BufferedReader(fr);

      String sCurrentLine;

      while((sCurrentLine = br.readLine()) != null) {
        System.out.println(sCurrentLine);
        String[] stuInfo = sCurrentLine.toString().split("\\|\\|\\|");

        if(stuInfo.length != 3) {
          System.out.println("Invalid Student Info");
          continue;
        }

        Student stu = new Student(Integer.parseInt(stuInfo[0]), stuInfo[1], Double.parseDouble(stuInfo[2]));
        studentList.add(stu);

      }
    } catch(IOException e) {
      e.printStackTrace();
    } finally {

      try {
        if(br != null)
          br.close();
        if(fr != null)
          fr.close();
      } catch(IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  public void sortStudent() {
    System.out.println("**********************");

    Collections.sort(studentList, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {

        if(s2.getstuGpa() > s1.getstuGpa()) {
          return 1;
        } else if(s2.getstuGpa() < s1.getstuGpa()) {
          return -1;
        }

        if(s1.getstuName().equals(s2.getstuName())) {
          if(s2.getstuId() < s1.getstuId()) {
            return 1;
          } else if(s2.getstuId() > s1.getstuId()) {
            return -1;
          }
        }
        return s1.getstuName().compareTo(s2.getstuName());
      }
    });

    for(Student st : studentList) {
      System.out.println(st.getstuName() + "::" + st.getstuGpa() + "::" + st.getstuId());
    }

  }

  public static void main(String[] args) {

    SortStudent p = new SortStudent();
    p.getFile();
    p.sortStudent();

  }
}

class Student {
  private int stuId;
  private String stuName;
  private double stuGpa;

  public Student(int stuId, String stuName, double stuGpa) {
    super();
    this.stuId = stuId;
    this.stuName = stuName;
    this.stuGpa = stuGpa;
  }

  public int getstuId() {
    return stuId;
  }

  public String getstuName() {
    return stuName;
  }

  public double getstuGpa() {
    return stuGpa;
  }
}