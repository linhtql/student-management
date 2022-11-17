package dao;

import java.util.List;

import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;

public interface LopHocDAO {
	public List<LopHoc> getList();

	public int createOrUpdate(LopHoc lophoc);

	public int delete(LopHoc lophoc);

}
