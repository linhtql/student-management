package service;

import java.util.List;

import dao.HocVienDAO;
import dao.HocVienDaoImpl;
import model.HocVien;

public class HocVienServiceImpl implements HocVienService {
	private HocVienDAO hocvienDAO = null;

	public HocVienServiceImpl() {
		this.hocvienDAO = new HocVienDaoImpl();
	}

	@Override
	public List<HocVien> getList() {
		// TODO Auto-generated method stub
		return hocvienDAO.getList();
	}

	@Override
	public int createOrUpdate(HocVien hocVien) {
		// TODO Auto-generated method stub
		return hocvienDAO.createOrUpdate(hocVien);
	}

	@Override
	public int delete(HocVien hocvien) {
		// TODO Auto-generated method stub
		return hocvienDAO.delete(hocvien);
	}

}
