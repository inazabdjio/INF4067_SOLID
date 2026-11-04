package isp;

interface WorkerBadInterface {
    void work();
    void eat();
}

class HumanWorkerBad implements WorkerBadInterface {
    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }

    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}

class RobotWorkerBad implements WorkerBadInterface {
    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }

    @Override
    public void eat() {
        System.out.println("l'on ne doit pas faire manger un robot");
        throw new UnsupportedOperationException("Les Robots ne mangent pas");
    }
}

public class WorkerBad {
    public static void main(String[] args) {
        WorkerBadInterface human = new HumanWorkerBad();
        human.work();
        human.eat();

        WorkerBadInterface robot = new RobotWorkerBad();
        robot.work();
        
        // Ceci va déclencher l'exception car un robot ne mange pas, 
        // illustrant le problème d'une interface trop large (Big Interface).
        try {
            robot.eat();
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception attrapée : " + e.getMessage());
        }
    }
}