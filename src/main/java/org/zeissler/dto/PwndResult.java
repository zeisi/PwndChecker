package org.zeissler.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PwndResult {

	@JsonProperty("Title")
	private String Title;
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("Domain")
	private String Domain;
	@JsonProperty("BreachDate")
	private String BreachDate;
	@JsonProperty("AddedDate")
	private String AddedDate;
	@JsonProperty("PwnCount")
	private Integer PwnCount;
	@JsonProperty("Description")
	private String Description;
	@JsonProperty("DataClasses")
	private List<String> DataClasses = new ArrayList<String>();
	@JsonProperty("IsVerified")
	private Boolean IsVerified;
	@JsonProperty("IsSensitive")
	private Boolean IsSensitive;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public String getBreachDate() {
		return BreachDate;
	}
	public void setBreachDate(String breachDate) {
		BreachDate = breachDate;
	}
	public String getAddedDate() {
		return AddedDate;
	}
	public void setAddedDate(String addedDate) {
		AddedDate = addedDate;
	}
	public Integer getPwnCount() {
		return PwnCount;
	}
	public void setPwnCount(Integer pwnCount) {
		PwnCount = pwnCount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<String> getDataClasses() {
		return DataClasses;
	}
	public void setDataClasses(List<String> dataClasses) {
		DataClasses = dataClasses;
	}
	public Boolean getIsVerified() {
		return IsVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		IsVerified = isVerified;
	}
	public Boolean getIsSensitive() {
		return IsSensitive;
	}
	public void setIsSensitive(Boolean isSensitive) {
		IsSensitive = isSensitive;
	}
	
}
