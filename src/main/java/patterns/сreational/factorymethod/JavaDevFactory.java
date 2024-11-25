package patterns.сreational.factorymethod;

public class JavaDevFactory implements DeveloperFactory {
    @Override
    public Developer createDev() {
        return new JavaDev();
    }
}
