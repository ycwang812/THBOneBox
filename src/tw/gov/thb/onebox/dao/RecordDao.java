package tw.gov.thb.onebox.dao;

import java.util.List;

import tw.gov.thb.onebox.model.Record;

public interface RecordDao extends BaseDao {
	
	public List<Record> findByUserNameOrderByCreateTimeDesc(String userName);

}
