package tw.gov.thb.onebox.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sa.sdk.builder.SAApi;
import com.sa.sdk.builder.ServiceBuilder;
import com.sa.sdk.request.QueryRequest;
import com.sa.sdk.response.ProfileSearchResponse;
import com.sa.sdk.response.ProfileSearchResult;

public class SocialAnalyticsServiceImpl implements SocialAnalyticsService {

	private Logger log = Logger.getLogger(getClass());
	
	private String appKey;
	private String appSecret;
	private String apiUrl;
	private String profile;
	
	private SAApi api = new SAApi() {
		@Override
		public String getAPIUrlAddress() {
			return apiUrl;
		} 
	};
	
	public List<ProfileSearchResult> searchProfile(String query) {
		List<ProfileSearchResult> list = new ArrayList<ProfileSearchResult>();
		
		try {
			ServiceBuilder sb = new ServiceBuilder(api, appKey, appSecret);
			QueryRequest request = (QueryRequest) sb.build(QueryRequest.class);
			ProfileSearchResponse result = request.getProfileSearchResponse(profile, query, null, 1, 20, "pDate", "TW");
			list = result.getResult();
		} catch (Exception ex) {
			log.error("searchProfile", ex);
		}
		
		return list;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
		
}
