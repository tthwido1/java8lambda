import java.util.*;

public class ThisReference3 {

    public static void main(String[] args) {

        ThisReference3 thisReference = new ThisReference3();
        thisReference.execute();
    }

    public void execute() {
        // value of this inside lambda is equal to value of this here
        System.out.println("value of this outside lambda: " + this);

        Dummy dummy = new Dummy();
        dummy.doSomething(10, a -> {
            System.out.println("value of this inside lambda: " + this);
            // this here refers to `ThisReference3` and not `Dummy` object
            // this here refers to the instance on which the lambda is called
        });
    }

    @Override
    public String toString() {
        return "Object of type ThisReference3";
    }
}

class Dummy {

    public void doSomething(int a, Process process) {
        process.process(a);
    }

    @Override
    public String toString() {
        return "Object of type Dummy";
    }
}

interface Process {
    void process(int a);
}
