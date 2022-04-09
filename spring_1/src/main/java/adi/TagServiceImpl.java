package adi;

public class TagServiceImpl implements TagService {
    private TagDao tagDao;


    @Override
    public void save(String name) {
        System.out.println("TagServiceImpl name + " + name);
        tagDao.save(name);
    }

    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }
}
