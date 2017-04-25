package tw.gov.thb.onebox.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.bind.ServletRequestUtils;

import com.sa.sdk.response.ProfileSearchResult;

import tw.gov.thb.onebox.service.SocialAnalyticsService;

public class SocialAnalyticsAction extends Action {
	
	private Logger log = Logger.getLogger(getClass());
	
	private SocialAnalyticsService socialAnalyticsService;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String query = ServletRequestUtils.getStringParameter(request, "query", "");
		String display = ServletRequestUtils.getStringParameter(request, "display", "");
		
		log.debug("Query: " + query + ", Display: " + display);
		
		List<ProfileSearchResult> list = socialAnalyticsService.searchProfile(query);
		
		if (display.equals("all")) {
			request.setAttribute("searchResult", list);
			return mapping.findForward("show");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
		sb.append("<OneBoxResults>").append("\n");
		sb.append("\t").append("<resultCode>").append("success").append("</resultCode>").append("\n");
		sb.append("\t").append("<provider>").append("SocialAnalyticsProvider").append("</provider>").append("\n");
		
		for (ProfileSearchResult psr : list) {
			sb.append("\t").append("<MODULE_RESULT>").append("\n");
			sb.append("\t\t").append("<Field name=\"siteName\">").append(StringEscapeUtils.escapeXml(psr.getSiteName())).append("</Field>").append("\n");
			sb.append("\t\t").append("<Field name=\"content\">").append(StringEscapeUtils.escapeXml(psr.getContent())).append("</Field>").append("\n");
			sb.append("\t\t").append("<Field name=\"link\">").append(StringEscapeUtils.escapeXml(psr.getLink())).append("</Field>").append("\n");
			sb.append("\t\t").append("<Field name=\"title\">").append(StringEscapeUtils.escapeXml(psr.getTitle())).append("</Field>").append("\n");
			sb.append("\t\t").append("<Field name=\"userName\">").append(StringEscapeUtils.escapeXml(psr.getUserName())).append("</Field>").append("\n");
			sb.append("\t").append("</MODULE_RESULT>").append("\n");
		}
		
		sb.append("</OneBoxResults>");
		
//		log.debug("Xml: " + sb.toString());
		
		response.setContentType("text/xml; charset=UTF-8");
		response.getWriter().print(sb.toString());
		response.getWriter().close();
			
		return null;
	}

	public void setSocialAnalyticsService(SocialAnalyticsService socialAnalyticsService) {
		this.socialAnalyticsService = socialAnalyticsService;
	}

}
