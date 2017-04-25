package tw.gov.thb.onebox.service;

import java.util.List;

import com.sa.sdk.response.ProfileSearchResult;

public interface SocialAnalyticsService {
	
	public List<ProfileSearchResult> searchProfile(String query);

}
