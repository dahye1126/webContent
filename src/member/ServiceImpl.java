package member;

public class ServiceImpl implements Service {

	private Dao dao;
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public Member getMyInfo(String id) {
		return dao.select(id);
	}

	@Override
	public void join(Member m) {
		dao.insert(m);

	}

	@Override
	public void editMyInfo(Member m) {
		dao.update(m);

	}

	@Override
	public boolean checkId(String id) {
		Member m = dao.select(id);
		if(m==null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(String id, String pwd) {
		Member m = dao.select(id);
		if(m != null && m.getPwd().equals(pwd)) {
			return true;
		}
		return false;
	}

	@Override
	public void delMember(String id) {
		dao.delete(id);

	}

}
