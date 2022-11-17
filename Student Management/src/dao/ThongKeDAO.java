package dao;

import java.util.List;

import bean.KhoaHocBean;
import bean.LopHocBean;

public interface ThongKeDAO {

	public List<LopHocBean> getListByLopHoc();

	public List<KhoaHocBean> getListByKhoaHoc();
}
