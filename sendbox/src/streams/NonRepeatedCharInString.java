package streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRepeatedCharInString {
    public static void main(String[] args) {
        String input = "teesInpu";

        Map<Character,Character> charl = input.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toMap(c->c,c->c,(key,j)->key));
        System.out.println("charl-->"+charl);

        Map<String,String> map=new HashMap<String,String>();
        map.put("K","VV");
        map.put("K","VV");
        System.out.println("map->"+map);
        

        // Step 1: Use Streams to create a frequency map
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c) // Convert each int to a char
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Step 2: Find the first non-repeated character
        frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Keep only characters with count 1
                .map(Map.Entry::getKey) // Extract the character
                .findFirst() // Get the first non-repeated character
                .ifPresent(System.out::println); // Print the result

        List<City> cities = Arrays.asList(
                new City("One",1),
                new City("Two",2),
                new City("Three",3),
                new City("Four",4),
                new City("Five",5),
                new City("Five",5));
        //ties.add(new City("Six","6"));
        Map<Integer,List<City>> cityy= cities.stream().collect(Collectors.groupingBy(City::getTemp));
        System.out.println("cityy:: "+cityy);


        // Fidn the sum of integers in the array
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().reduce(Integer::sum).orElse(0);
        System.out.println("sum::-> "+sum);
        //Given a list of strings, find all the strings that start with the letter "a" and convert them to uppercase using Java Streams.
        List<String> words = Arrays.asList("apple", "banana", "avocado", "grape", "apricot");
        List<String> upperCaseWords= words.stream().filter(s->s.startsWith("a")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("upperCaseWords:: "+upperCaseWords);

        //Given a list of integers, find the second highest number using Java Streams.
        List<Integer> numbers1 = Arrays.asList(3, 9, 2, 15, 6, 7, 10,1000,999,3432434,232323,4545);
        Integer kk = numbers1.stream().sorted(Comparator.reverseOrder()).skip(20).findFirst().orElse(0);
        System.out.println("kk-->"+kk);

        //Given a list of strings, group them by their length using Java Streams.
        List<String> words1 = Arrays.asList("apple", "bat", "cat", "banana", "dog", "elephant");
        words1.stream().collect(Collectors.groupingBy(String::length)).forEach((k,v)->System.out.println("Length:: "+k+"  Words::"+v));

        //Given a list of integers, find the second highest number using Java Streams.
        List<Integer> numbers3 = Arrays.asList(3, 9, 2, 5, 6, 8);
        numbers3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        //Given a list of integers, create a new list containing the squares of all the even numbers in the original list.
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers4Result= numbers4.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println("numbers4Result:: "+numbers4Result);

        //Given a list of strings, filter out all strings that have a length less than 3, and convert the remaining strings to uppercase.
        List<String> words3 = Arrays.asList("a", "to", "cat", "hello", "hi");
        List<String> upperCaseWords12= words3.stream().filter(s->s.length()>2).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseWords12);


        //Given a list of integers, find the sum of the squares of all the unique numbers in the list.
        List<Integer> numbers5 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Integer result33= numbers5.stream().distinct().map(n->n*n).reduce(0,(Integer::sum));
        System.out.println("result33--> "+result33);

        //Given a list of strings, write a code snippet to find the longest string in the list.
        List<String> wordsasas = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grapefruit");
        wordsasas.stream().reduce((s1,s2)->{
            if(s1.length()>=s2.length()){
                return s1;
            }else {
                return s2;
            }
        }).ifPresent(System.out::println);


        //Given a list of integers, calculate the average value of all the numbers in the list using Java Streams.
        List<Integer> numbers34543 = Arrays.asList(10, 20, 30, 40, 50);
        double resultff = numbers34543.stream().mapToInt(Integer::intValue).average().orElse(0.0);


        //Given a string, count the number of vowels (a, e, i, o, u) in that string using Java Streams.
        String inputsdsd = "Hello, how are you?";

        List<Integer> numberscdc = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1, 7);
        List<Integer> un = numberscdc.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet().stream().filter(e->e.getValue()==1).map(en->en.getKey()).collect(Collectors.toList());
        System.out.println("un:: "+un);


        //Given a list of integers, write a Java Stream code to find the second largest number in the list. If there is no second largest number (like when all numbers are the same), return
        Integer ll = numberscdc.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        OptionalDouble average= numberscdc.stream().filter(n->n%2==0).mapToInt(n->n).average();


        //Given a list of Employee objects, each with properties name, age, and salary, write a Java Stream code to find the average salary of employees who are older than 30,
        //grouped by their age. Return a map where the key is the age and the value is the average salary of employees of that age.

        List<Employee> employees= Arrays.asList(
                new Employee("One",30, 2000),
                new Employee("222",20, 1500),
                new Employee("333",35, 3000),
                new Employee("444",20, 1500),
                new Employee("555",15, 1000),
                new Employee("666",50, 5000),
                new Employee("777",40, 4000),
                new Employee("777",40, 2000),
                new Employee("888",23, 2300)
                );
        Map<Integer,Double> mm= employees.stream().filter(e->e.getAge()>30).collect(Collectors.groupingBy(Employee::getAge,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("mn:: "+mm);
//Given a list of Transaction objects, where each transaction has a category (String), amount (double), and date (LocalDate), write a
// Java Stream code that calculates the total amount spent in each category for transactions made in the last month.
// The result should be a Map<String, Double> where the key is the category and the value is the total amount spent in that category.
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Groceries", 50.0, LocalDate.now().minusDays(10)),
                new Transaction("Utilities", 75.0, LocalDate.now().minusDays(20)),
                new Transaction("Groceries", 100.0, LocalDate.now().minusDays(5)),
                new Transaction("Entertainment", 150.0, LocalDate.now().minusDays(15)),
                new Transaction("Utilities", 200.0, LocalDate.now().minusDays(25))
        );

        Map<String,Double> resultll = transactions.stream().filter(t->t.getDate().getMonth().equals(LocalDate.now().getMonth().minus(1))).collect(Collectors.groupingBy(Transaction::getCategory, Collectors.averagingDouble(Transaction::getAmount)));
        System.out.println("resultll:: "+ resultll);

        List<Integer> listInt=Arrays.asList(1,3,4,7,4,2,7,2,8,5,5);
        System.out.println("Duplicate int");
        listInt.stream().collect(Collectors.groupingBy(a->a,Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).forEach(e->System.out.println(e.getKey()));

        Set<Integer> set = new HashSet<>(listInt);

        List<String>  strlst=Arrays.asList("apple", "banana", "pear", "kiwi", "grape", "mango","a","b","c","d","e");
        strlst.stream().collect(Collectors.groupingBy(s -> (long) s.length(), Collectors.counting())).forEach((key, value) -> System.out.println(key + "  " + value));

        List<List<Integer>> numbers1212 = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), Arrays.asList(1, 6));
        Set<Integer> flatMap= numbers1212.stream().flatMap(l->l.stream()).collect(Collectors.toSet());
        System.out.println("flatMap-->"+flatMap);

        List<String> wordssss = Arrays.asList("apple", "ant", "banana", "ball", "cat", "car");
        wordssss.stream().collect(Collectors.groupingBy(w->w.charAt(0))).forEach((k,v)->System.out.println(k+" :: "+v));


        List<Integer> numberskkk = Arrays.asList(5, 3, 9, 1, 4, 9, 8);
        numberskkk.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);


        List<String> wordspo = Arrays.asList("apple", "banana", "grapefruit", "kiwi", "mango");
        wordspo.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        //a, e, i, o, u
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toSet()).forEach(System.out::println);

        List<String> wordssssss = Arrays.asList("apple", "banana", "cherry", "date");
        wordssssss.stream().collect(Collectors.toMap(w->w, String::length)).forEach((k, v)->System.out.println( k+" :: "+v));


        List<String> wordsfggeg = Arrays.asList("level", "world", "radar", "java", "madam");
        wordsfggeg.stream().filter(w->w.contentEquals(new StringBuilder(w).reverse())).forEach(System.out::println);

        String inputsssswdwd = "Hello World";
        inputsssswdwd.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).forEach((k,v)->System.out.println(k+"::"+v));

        List<Integer> numbersntnthn = Arrays.asList(10, 20, 4, 45, 99, 99, 45);
        numbersntnthn.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

    }

    public String reverse(String str){
        StringBuilder s = new StringBuilder(str);
return s.toString();


    }
}


class City {
    private String name;
    private int temp;
    City(String name,int temp){
        this.name=name;
        this.temp=temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "City: "+ this.getName()+" :temp: "+this.getTemp();
    }
}


class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor, getters and setters
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}


class Transaction {
    private String category;
    private double amount;
    private LocalDate date;

    public Transaction(String category,double amount,LocalDate date) {
        this.category = category;
        this.date = date;
        this.amount = amount;
    }

    public Transaction(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    // Constructor, Getters, and Setters
}