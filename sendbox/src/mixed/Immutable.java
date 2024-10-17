package mixed;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Immutable {
    public static void main(String[] args) {
        List lst=new ArrayList(10);
        lst.add(1,10);
        System.out.println("lst"+lst);
        System.out.println();
        OneMoreDependent obj=new OneMoreDependent("Initial");
        IAmImmutable iAmImmutable = new IAmImmutable(obj,"Fixed");
        System.out.println(iAmImmutable.getCantByChanged());
        OneMoreDependent obj2 = iAmImmutable.getOneMoreDependent();
        obj2.setChangeMe("New");
        System.out.println(obj2.getChangeMe());
        System.out.println(iAmImmutable.getOneMoreDependent().getChangeMe());
    }

}


final class IAmImmutable {
    final private OneMoreDependent oneMoreDependent;
    final private String cantByChanged;
    IAmImmutable(OneMoreDependent oneMoreDependent, String cantByChanged){
        this.oneMoreDependent=oneMoreDependent;
        this.cantByChanged=cantByChanged;
    }

    public OneMoreDependent getOneMoreDependent() {
        return new OneMoreDependent(this.oneMoreDependent.getChangeMe());
    }

    public String getCantByChanged() {
        return cantByChanged;
    }
}


class OneMoreDependent {
    private String  changeMe;
    OneMoreDependent(String  changeMe){
        this.changeMe=changeMe;
    }

    public String getChangeMe() {
        return changeMe;
    }

    public void setChangeMe(String changeMe) {
        this.changeMe = changeMe;
    }
}
