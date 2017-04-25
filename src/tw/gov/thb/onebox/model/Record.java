package tw.gov.thb.onebox.model;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {

	private static final long serialVersionUID = 3806965209952188633L;

	private long id;
	private String query;
	private String userName;
	private String ipAddr;
	private String dateTime;
	private String authType;
	private String lang;
	private String oneBoxName;
	private String apiMaj;
	private String apiMin;
	private String domain;
	private Date createTime;
	
	public Record() {
	}

	public Record(long id, String query, String userName, String ipAddr,
			String dateTime, String authType, String lang, String oneBoxName,
			String apiMaj, String apiMin, String domain, Date createTime) {
		this.id = id;
		this.query = query;
		this.userName = userName;
		this.ipAddr = ipAddr;
		this.dateTime = dateTime;
		this.authType = authType;
		this.lang = lang;
		this.oneBoxName = oneBoxName;
		this.apiMaj = apiMaj;
		this.apiMin = apiMin;
		this.domain = domain;
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getOneBoxName() {
		return oneBoxName;
	}

	public void setOneBoxName(String oneBoxName) {
		this.oneBoxName = oneBoxName;
	}

	public String getApiMaj() {
		return apiMaj;
	}

	public void setApiMaj(String apiMaj) {
		this.apiMaj = apiMaj;
	}

	public String getApiMin() {
		return apiMin;
	}

	public void setApiMin(String apiMin) {
		this.apiMin = apiMin;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiMaj == null) ? 0 : apiMaj.hashCode());
		result = prime * result + ((apiMin == null) ? 0 : apiMin.hashCode());
		result = prime * result
				+ ((authType == null) ? 0 : authType.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ipAddr == null) ? 0 : ipAddr.hashCode());
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result
				+ ((oneBoxName == null) ? 0 : oneBoxName.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (apiMaj == null) {
			if (other.apiMaj != null)
				return false;
		} else if (!apiMaj.equals(other.apiMaj))
			return false;
		if (apiMin == null) {
			if (other.apiMin != null)
				return false;
		} else if (!apiMin.equals(other.apiMin))
			return false;
		if (authType == null) {
			if (other.authType != null)
				return false;
		} else if (!authType.equals(other.authType))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (id != other.id)
			return false;
		if (ipAddr == null) {
			if (other.ipAddr != null)
				return false;
		} else if (!ipAddr.equals(other.ipAddr))
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (oneBoxName == null) {
			if (other.oneBoxName != null)
				return false;
		} else if (!oneBoxName.equals(other.oneBoxName))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", query=" + query + ", userName="
				+ userName + ", ipAddr=" + ipAddr + ", dateTime=" + dateTime
				+ ", authType=" + authType + ", lang=" + lang + ", oneBoxName="
				+ oneBoxName + ", apiMaj=" + apiMaj + ", apiMin=" + apiMin
				+ ", domain=" + domain + ", createTime=" + createTime + "]";
	}
	
}
