package java8;


import java.util.Optional;

public class Optional121323 {
        public static void main(String[] args) {
            // Using Optional.of()
            Optional<String> nonEmptyOptional = Optional.of("Hello, World");

            // Using Optional.empty()
            Optional<String> emptyOptional = Optional.empty();

            // Using Optional.ofNullable()
            Optional<String> nullableOptional = Optional.ofNullable(null); // empty
            Optional<String> nonNullOptional = Optional.ofNullable("Non-null value");

            System.out.println("Non-empty Optional: " + nonEmptyOptional);
            System.out.println("Empty Optional: " + emptyOptional);
            System.out.println("Nullable Optional: " + nullableOptional.orElse("Hi"));
            System.out.println("Non-null Optional: " + nonNullOptional.orElse("Hello"));
        }
    }

