package sdi;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao;
    private String[] qqs;
    private List<String> list;
    private Map<String, String> map;
    private Properties properties;

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public void save(String name) {
        System.out.println("DeptServiceImpl name = " + name);
        for (String q : qqs) {
            System.out.println(q);
        }
        for (String q : list) {
            System.out.println(q);
        }
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public void setQqs(String[] qqs) {
        this.qqs = qqs;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
