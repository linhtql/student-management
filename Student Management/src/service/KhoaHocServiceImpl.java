package service;

import java.util.List;

import dao.KhoaHocDAO;
import dao.KhoaHocDAOImpl;
import model.KhoaHoc;

public class KhoaHocServiceImpl implements KhoaHocService {
	private KhoaHocDAO khoahocDAO = null;

	public KhoaHocServiceImpl() {
		this.khoahocDAO = new KhoaHocDAOImpl();
	}

	@Override
	public List<KhoaHoc> getList() {
		// TODO Auto-generated method stub
		return khoahocDAO.getList();
	}

	@Override
	public int createOrUpdate(KhoaHoc khoaHoc) {
		// TODO Auto-generated method stub
		return khoahocDAO.createOrUpdate(khoaHoc);
	}

	@Override
	public int delete(KhoaHoc khoaHoc) {
		// TODO Auto-generated method stub
		return khoahocDAO.delete(khoaHoc);
	}

}
