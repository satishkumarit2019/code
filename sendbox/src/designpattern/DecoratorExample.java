package designpattern;

public class DecoratorExample {
    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " = INR " + coffee.getCost());

        // Add Milk
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " = INR " + coffee.getCost());

        // Add Sugar
        coffee = new Sugar(coffee);
        System.out.println(coffee.getDescription() + " = INR " + coffee.getCost());

        // Add Caramel
        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " = INR " + coffee.getCost());

    }
}

//Base class
interface Coffee {
    String getDescription();
    double getCost();
}

//Basic coffee. concrete class
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Plain Coffee";
    }

    public double getCost() {
        return 50.0;  // INR 50 for basic coffee
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;  // Composition - Wraps a Coffee object

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}


class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 10.0;  // Adding INR 10 for milk
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public double getCost() {
        return coffee.getCost() + 5.0;  // Adding INR 5 for sugar
    }
}

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Caramel";
    }

    public double getCost() {
        return coffee.getCost() + 15.0;  // Adding INR 15 for caramel
    }
}









