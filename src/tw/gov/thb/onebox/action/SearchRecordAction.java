package tw.gov.thb.onebox.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.bind.ServletRequestUtils;

import tw.gov.thb.onebox.model.Record;
import tw.gov.thb.onebox.service.SearchRecordService;

public class SearchRecordAction extends Action {
	
	private Logger log = Logger.getLogger(getClass());
	
	private SearchRecordService searchRecordService;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Record record = new Record();
		record.setApiMaj(ServletRequestUtils.getStringParameter(request, "apiMaj", ""));
		record.setApiMin(ServletRequestUtils.getStringParameter(request, "apiMin", ""));
		record.setOneBoxName(ServletRequestUtils.getStringParameter(request, "oneboxName", ""));
		record.setLang(ServletRequestUtils.getStringParameter(request, "lang", ""));
		record.setIpAddr(ServletRequestUtils.getStringParameter(request, "ipAddr", ""));
		record.setDateTime(ServletRequestUtils.getStringParameter(request, "dateTime", ""));
		record.setQuery(ServletRequestUtils.getStringParameter(request, "query", ""));
		record.setAuthType(ServletRequestUtils.getStringParameter(request, "authType", ""));
		record.setUserName(ServletRequestUtils.getStringParameter(request, "userName", ""));
		record.setDomain(ServletRequestUtils.getStringParameter(request, "domain", ""));
		record.setCreateTime(new Date());
		
		log.debug("Search record: " + record.toString());
		
		searchRecordService.saveSearchRecord(record);
		
		String xml = searchRecordService.queryTop10SearchRecord(record.getUserName());
		
		log.debug("Xml: " + xml);
		
		response.setContentType("text/xml; charset=UTF-8");
		response.getWriter().print(xml);
		response.getWriter().close();
		
		return null;
	}

	public void setSearchRecordService(SearchRecordService searchRecordService) {
		this.searchRecordService = searchRecordService;
	}

}
