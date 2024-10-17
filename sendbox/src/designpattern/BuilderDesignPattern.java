package designpattern;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        // Creating an object using the Builder pattern
        SomeComplexClass someComplexClass = new SomeComplexClass.Builder()
                .setName("John Doe")
                .setAddress("Yamunapuram")
                .setLandmark("Near Sai Baba")
                .setCity("Bulandshahar")
                .setPinCode("202112")
                .build();
        System.out.println(someComplexClass);
    }
}



