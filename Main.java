import java.util.*;
import java.io.*;

class Main 
{
  static ArrayList<Person> people;
  static FileWriter data;
  static BufferedWriter writer; 
  static FileReader file; 
  static BufferedReader bReader;

  public static void main (String[] args)
  {
    people = new ArrayList<Person>();
    String name = " ", age = " ", color = " ";

    people.add(new Person("Maria", 22, "green"));
    people.add(new Person("A", 87, "pink"));
    people.add(new Person("B", 13, "yellow"));
    people.add(new Person("C", 55, "black"));
    people.add(new Person("D", 4, "green"));

    System.out.println(people.get(1).getName());

    try 
    {
      data = new FileWriter("data.txt");
      writer = new BufferedWriter(data);

      for(int i=0; i<people.size(); i++)
      {
        writer.write(people.get(i).getName());
        writer.newLine();
        writer.write(Integer.toString(people.get(i).getAge()));
        writer.newLine();
        writer.write(people.get(i).getColor());
        writer.newLine();

        writer.flush();
      }

      writer.close();
    }

    catch(IOException exception)
    {
      System.out.println("An error occurred: " + exception);
    }
    try
    {
      file = new FileReader("data.txt");
      bReader = new BufferedReader(file);

      while(bReader.ready())
      {
        name = bReader.readLine();
        age = bReader.readLine();
        color = bReader.readLine();

        System.out.printf("%-10s %-10s %-10s %n", name, age, color);
      }
      bReader.close();

    }
    catch(IOException exception)
    {
      System.out.println("An error occurred " + exception);
    }
  }
}