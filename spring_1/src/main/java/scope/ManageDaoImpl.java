package scope;

public class ManageDaoImpl implements ManageDao {
    @Override
    public void save(String name) {
        System.out.println("ManageDaoImpl" + name);
    }
}
