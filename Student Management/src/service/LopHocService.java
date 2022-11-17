package service;

import java.util.List;

import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;

public interface LopHocService {
	public List<LopHoc> getList();

	public int createOrUpdate(LopHoc lopHoc);

	public int delete(LopHoc lopHoc);

}
