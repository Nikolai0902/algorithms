package patterns.structural.decorator;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }

    public static void main(String[] args) {
        Pizza pepperoniPizza = new PepperoniPizza();
        pepperoniPizza = new CheeseDecorator(pepperoniPizza);
        System.out.println(pepperoniPizza.getDescription() + ": $" + pepperoniPizza.getCost());
    }
}
