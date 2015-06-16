package session10;

import session10.dao.RegionDao;
import session10.domain.Region;

/**
 * Created by IEvgen Boldyr on 15.06.15.
 * Project: proff25
 */
public class Main {

    public static void main(String[] args) {
        RegionDao dao = new RegionDao();
        //dao.newRegion(new Region("Antarctica"));
        Region region = dao.getRegion(new Long(19));
        System.out.println(region);
        region.setName("Arctica");
        System.out.println(region);
        dao.updateRegion(region);

    }
}
