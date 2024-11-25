package patterns.сreational.factorymethod;

public class Program {
    public static void main(String[] args) {
        //1.Неудобно, нужно добавлять много кода, рефакторинга, изменять сущ. код
        JavaDev javadev = new JavaDev();
        javadev.write();
        CppDev cppDev = new CppDev();
        cppDev.write();

        //2. Через интерфейсы, удобнее чем предыдущее, но мы так же должны в клиенте создавать разработчиков
        Developer developer = new JavaDev();
        developer.write();
        developer = new CppDev();
        developer.write();

        //3. Через новую сущность фабричный метод. Теперь чтобы создать и использовать разработчика
        // нам нужно всего лишь создать и использовать фабрику.
        DeveloperFactory developerFactory = new JavaDevFactory();
        Developer developer1 = developerFactory.createDev();
        developer1.write();

        //4. Еще лучще реализациия фабричного метода через дополнительный метод,
        //который будет возвращать фабрику.
        Developer developer2 = createFactory("java").createDev();
        developer2.write();
    }

    private static DeveloperFactory createFactory(String string) {
        DeveloperFactory developerFactory = null;
        switch (string) {
            case "java":
                developerFactory = new JavaDevFactory();
                break;
            case "cpp":
                developerFactory = new CppDevFactory();
                break;
        }
        return developerFactory;
    }
}
