package dao;

public class DaoImplV2 implements IDao {
    @Override
    public double getValue() {
        System.out.println("Exécution de DaoImplV2:");
        return 120.5;
    }
}