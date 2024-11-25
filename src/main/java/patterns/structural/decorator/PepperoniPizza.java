package patterns.structural.decorator;

public class PepperoniPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Piperoni";
    }

    @Override
    public double getCost() {
        return 10;
    }
}
