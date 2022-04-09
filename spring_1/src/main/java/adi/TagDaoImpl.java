package adi;

public class TagDaoImpl implements TagDao {

    @Override
    public void save(String name) {
        System.out.println("TagDaoname = " + name);
    }
}
