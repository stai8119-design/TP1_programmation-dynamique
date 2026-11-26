package dao;

public class DaoDBImpl implements IDao {
    @Override
    public double getValue() {
        System.out.println("Exécution de DaoDBImpl:");
        return 500.0;
    }
}