package practice;
import java.util.*;
public class Comparator23423434 {
        String name;
        int age;
        public Comparator23423434(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
        public static void main(String[] args) {
            List<Comparator23423434> people = new ArrayList<>();
            people.add(new Comparator23423434("Alice", 25));
            people.add(new Comparator23423434("Bob", 22));
            people.add(new Comparator23423434("Charlie", 30));
// Sort by name using a Comparator (alphabetical order)
            Comparator<Comparator23423434> byName = Comparator.comparing(p -> p.name);
            Collections.sort(people, byName);
            System.out.println("Sorted by name: " + people); // Output: [Alice (25), Bob (22), Charlie (30)]
// Sort by age in descending order using a Comparator
            Comparator<Comparator23423434> byAgeDescending = (p1, p2) -> Integer.compare(p2.age, p1.age);
            Collections.sort(people, byAgeDescending);
            System.out.println("Sorted by age descending: " + people); // Output: [Charlie (30), Alice (25), Bob (22)]
        }
    }

