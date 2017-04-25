package tw.gov.thb.onebox.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import tw.gov.thb.onebox.dao.RecordDao;
import tw.gov.thb.onebox.model.Record;

public class SearchRecordServiceImpl implements SearchRecordService {
	
	private Logger log = Logger.getLogger(getClass());
	
	private RecordDao recordDao;
	
	public void saveSearchRecord(Record record) {
		recordDao.save(record);
	}
	
	public String queryTop10SearchRecord(String userName) {
		List<Record> list = getTop10(recordDao.findByUserNameOrderByCreateTimeDesc(userName));
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
		sb.append("<OneBoxResults>").append("\n");
		sb.append("\t").append("<resultCode>").append("success").append("</resultCode>").append("\n");
		sb.append("\t").append("<provider>").append("SearchRecordProvider").append("</provider>").append("\n");
		
		for (Record record : list) {
			sb.append("\t").append("<MODULE_RESULT>").append("\n");
			sb.append("\t\t").append("<Field name=\"record\">").append(record.getQuery()).append("</Field>").append("\n");
			sb.append("\t").append("</MODULE_RESULT>").append("\n");
		}
		
		sb.append("</OneBoxResults>");
		
		return sb.toString();
	}
	
	private List<Record> getTop10(List<Record> list) {
		if (list == null) {
			return new ArrayList<Record>();
		} else if (list.size() <= 10) {
			return list;
		}
		
		List<Record> newList = new ArrayList<Record>();
		
		for (int i = 0; i < 10; i++) {
			newList.add(list.get(i));
		}
		
		return newList;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

}
