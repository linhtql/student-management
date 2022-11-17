package service;

import java.util.List;

import bean.KhoaHocBean;
import bean.LopHocBean;
import dao.ThongKeDAO;
import dao.ThongKeDAOImpl;

public class ThongKeServiceImpl implements ThongKeService {
	private ThongKeDAO thongkeDAO = null;

	public ThongKeServiceImpl() {
		thongkeDAO = new ThongKeDAOImpl();
	}

	@Override
	public List<LopHocBean> getListByLopHoc() {
		return thongkeDAO.getListByLopHoc();
	}

	@Override
	public List<KhoaHocBean> getListByKhoaHoc() {
		// TODO Auto-generated method stub
		return thongkeDAO.getListByKhoaHoc();
	}

}
