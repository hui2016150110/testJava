package androidModel.createtype;

public abstract class Factory {
    public abstract <T extends Computer> T createComputer(Class<T> clz);
}
