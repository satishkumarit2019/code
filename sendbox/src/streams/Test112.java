package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test112 {



    public static void main(String[] args) {
        List<Emp> listEmp= Arrays.asList(new Emp("Ram",  23.0),
                new Emp("Ramr",  23.0),
                new Emp("Ram1",40.4),
                new Emp("Ram2",56.6),
                new Emp("Ram3",52.0));

        listEmp.stream().filter(e->e.getAge()>50).map(e->{e.setType("Senior"); return e;}).forEach(System.out::println);

        String str = "JavaProgramPm";
        str.chars().sorted().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).forEach((k,v)->System.out.println(k+ " : " + v));
        //Arrays.stream(str.split("")).collect(Collectors.groupingBy(c->c,Collectors.counting())).forEach((k,v)->System.out.println(k+ " : " + v));
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().filter(e->e.getValue()==2).forEach((e->System.out.println(e.getKey()+ " : " + e.getValue())));
    }



}


class Emp {
String name;
Double age;
String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Emp(String name, Double age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}