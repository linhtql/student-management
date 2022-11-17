package service;

import java.util.List;

import dao.LopHocDAO;
import dao.LopHocDAOImpl;
import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;

public class LopHocServiceImpl implements LopHocService {
	private LopHocDAO lophocDAO = null;

	public LopHocServiceImpl() {
		this.lophocDAO = new LopHocDAOImpl();
	}

	@Override
	public List<LopHoc> getList() {
		// TODO Auto-generated method stub
		return lophocDAO.getList();
	}

	@Override
	public int createOrUpdate(LopHoc lopHoc) {
		return lophocDAO.createOrUpdate(lopHoc);
	}

	@Override
	public int delete(LopHoc lopHoc) {
		return lophocDAO.delete(lopHoc);
	}

}
