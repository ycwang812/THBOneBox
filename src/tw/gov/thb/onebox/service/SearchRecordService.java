package tw.gov.thb.onebox.service;

import tw.gov.thb.onebox.model.Record;

public interface SearchRecordService {
	
	public void saveSearchRecord(Record record);
	
	public String queryTop10SearchRecord(String userName);

}
