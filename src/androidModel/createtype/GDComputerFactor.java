package androidModel.createtype;

public class GDComputerFactor extends Factory{
    @Override
    public <T extends Computer> T createComputer(Class<T> clz) {
        Computer computer = null;
        String classname = clz.getName();
        try {
            computer = (Computer) Class.forName(classname).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)computer;
    }
}
