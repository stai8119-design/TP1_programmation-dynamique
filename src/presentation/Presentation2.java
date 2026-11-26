package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        int testNum = 1;

        while (scanner.hasNextLine()) {
            String daoClassName = scanner.nextLine().trim();
            if (daoClassName.isEmpty()) continue;

            if (!scanner.hasNextLine()) {
                System.out.println("Ligne metier manquante pour le test " + testNum);
                break;
            }
            String metierClassName = scanner.nextLine().trim();

            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

            Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier, dao);

            System.out.println("Test " + testNum + " [" + daoClassName + "] -> resultat = " + metier.calcul());
            testNum++;
        }

        scanner.close();
    }
}