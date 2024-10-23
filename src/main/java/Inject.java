import com.dao.AdminDao;
import com.model.AdminBean;

public class Inject {
	public static void main(String[] args) {
		AdminBean admin = new AdminBean();
		admin.setAdName("venu");
		admin.setAdPhone("5645565");
		admin.setAdEmail("venu@gmail.com");
		admin.setAdUsername("Venu2000");
		admin.setAdPasssword("Reddy");
		
		AdminDao.saveAdmin(admin);
	}
}
