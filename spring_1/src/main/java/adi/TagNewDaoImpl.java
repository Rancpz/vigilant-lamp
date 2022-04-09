package adi;

public class TagNewDaoImpl implements TagDao {

    @Override
    public void save(String name) {
        System.out.println("TagNewDaoImpl" + name);
    }
}
