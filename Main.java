package basics;

class Person {
    String name;
    int age;

   public Person(String name, int age) {
       this.name = name;
       this.age = age;
   }
   @Override
   public String toString() {
       return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
   }
}
public class Main {
   public static void main(String[] args) {
       // Declare and create an array of Person objects
       Person[] people = new Person[3];

       // Initialize the array elements with Person objects
       people[0] = new Person("Alice", 25);
       people[1] = new Person("Bob", 30);
       people[2] = new Person("Charlie", 28);

       // Access and print the array elements
       for (int i = 0; i < people.length; i++) {
           System.out.println("Person at index " + i + ": " + people[i]);
       }
   }

}


