package listgenerics;

import java.util.List;

public class Test<T> {
    public static void doSomething(List<Animal> animals) {
        animals.add(new Dog());
    }

    // Wildcard
    public static void doSomething2(List<? extends Animal> animals) {
        for(Animal animal: animals) {
            System.out.println(animal);
        }
        //java will not allow to modify the animals list as we don't know what user has send ex List<Cat> and we can't add new Dog() to it
    //    animals.add();
    }
}
