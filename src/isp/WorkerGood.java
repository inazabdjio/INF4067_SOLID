package isp;

// 1. Interfaces définies dans le cours
interface Workable {
    void work();
}

interface Eatable extends Workable {
    void eat();
}

// 2. Classes d'implémentation
class HumanWorkerGood implements Eatable {
    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }

    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}

class RobotWorkerGood implements Workable {
    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }
}

// 3. Classe Main strictement conforme au support de cours (page 39)
public class WorkerGood {
    public static void main(String[] args) {
        HumanWorkerGood human = new HumanWorkerGood();
        human.work();
        human.eat();

        RobotWorkerGood robot = new RobotWorkerGood();
        robot.work();
    }
}