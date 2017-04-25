package tw.gov.thb.onebox.dao;

import java.util.List;

import tw.gov.thb.onebox.model.Record;

public class RecordDaoImpl extends AbstractBaseDao implements RecordDao {

	@Override
	protected Class<Record> getEntityClass() {
		return Record.class;
	}

	public List<Record> findByUserNameOrderByCreateTimeDesc(String userName) {
		String sql = "from Record where userName = ? order by createTime desc";
		Object[] param = { userName };
		return find(sql, param);
	}

}
