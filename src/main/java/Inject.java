import java.util.List;

import com.dao.AdminDao;
import com.dao.StationDao;
import com.model.AdminBean;
import com.model.StationBean;

public class Inject {
	public static void main(String[] args) {
//		AdminBean admin = new AdminBean();
//		admin.setAdName("venu");
//		admin.setAdPhone("5645565");
//		admin.setAdEmail("venu@gmail.com");
//		admin.setAdUsername("Venu2000");
//		admin.setAdPasssword("Reddy");
//		
//		AdminDao.saveAdmin(admin);
		
		List<StationBean> allStations = StationDao.getAllStations();
		for(StationBean station: allStations) {
			System.out.println(station.getStation());
		}
	}
}
