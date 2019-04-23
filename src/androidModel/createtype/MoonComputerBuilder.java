package androidModel.createtype;

public class MoonComputerBuilder extends Builder {
    private Computer2 computer2 = new Computer2();
    @Override
    public void buildCpu(String cpu) {

    }

    @Override
    public void buildMainboard(String mainboard) {

    }

    @Override
    public void buildRam(String ram) {

    }

    @Override
    public Computer2 create() {
        return computer2;
    }
}
