package designpattern;

public class SingletonPattern {
    public static void main(String[] args) {
        SingletonPattern instance = SingletonPattern.getInstance();
        System.out.println(instance.getName());
    }
    private SingletonPattern(){}
    private static final SingletonPattern instance=new SingletonPattern();

    public static SingletonPattern getInstance(){
        return instance;
    }

    public String getName(){
        return "This is Singleton";
    }


}

