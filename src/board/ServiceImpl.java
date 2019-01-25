package board;

import java.util.ArrayList;

public class ServiceImpl implements Service {
	private Dao dao;
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public void addArticle(Article a) {
		dao.insert(a);
	}

	@Override
	public ArrayList<Article> getAll() {
		return dao.selectAll();
	}

	@Override
	public Article getByNum(int num) {
		return dao.selectByNum(num);
	}

	@Override
	public ArrayList<Article> getByWriter(String writer) {
		return dao.selectByWriter(writer);
	}

	@Override
	public ArrayList<Article> getByTitle(String title) {
		return dao.selectByTitle(title);
	}

	@Override
	public void editArticle(Article a) {
		dao.update(a);
	}

	@Override
	public void delArticle(int num) {
		dao.delete(num);
	}

}
