package patterns.сreational.factorymethod;

public class CppDevFactory implements DeveloperFactory {
    @Override
    public Developer createDev() {
        return new CppDev();
    }
}
