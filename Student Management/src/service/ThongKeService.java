package service;

import java.util.List;

import bean.KhoaHocBean;
import bean.LopHocBean;

public interface ThongKeService {
	public List<LopHocBean> getListByLopHoc();

	public List<KhoaHocBean> getListByKhoaHoc();

}
