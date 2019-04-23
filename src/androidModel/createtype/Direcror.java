package androidModel.createtype;

public class Direcror {
    Builder mBuilder = null;
    public Direcror(Builder builder){
        this.mBuilder = builder;
    }
    public Computer2 CreateComouter(String cpu,String mainboard,String ram){
        this.mBuilder.buildCpu(cpu);
        this.mBuilder.buildMainboard(mainboard);
        this.mBuilder.buildRam(ram);
        return this.mBuilder.create();
    }
}
