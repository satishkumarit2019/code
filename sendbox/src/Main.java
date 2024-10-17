import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        List intlist = Arrays.asList(3,4);
        intlist.forEach(System.out::println);
        List p= intlist;
       // p.add(4);
        System.out.println(p);

        Optional o=Optional.of("fsdgdfgdfg");
        String[] sss=new String[10];
        Optional ko=Optional.ofNullable(sss[8]);
        System.out.println(o.isPresent());
        System.out.println(ko.isPresent());

        Runnable r = new Runnable(){
            @Override
            public void run(){
                System.out.println("Runnable");
            }
        };

        Thread t= new Thread(r){
            @Override
            public void run(){
                System.out.println("Thread");
            }
        };

        t.start();
    }
}

class Test{

    int value;
    public int hashCode(){
        return value*42;
    }
}

abstract class ABS {

}

class KKK extends ABS {

}



abstract class III {
private int age;
private int birth;
    III(int age,int birth){
       this.age=age;
       this.birth=birth;
    }
    abstract void doEat();
    abstract void doWalk();

}

class SSS extends III {
    SSS(int age,int birth) {
        super(age,birth);
    }

    @Override
    void doEat() {

    }

    @Override
    void doWalk() {

    }
}