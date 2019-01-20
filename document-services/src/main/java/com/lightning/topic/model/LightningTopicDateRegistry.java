package com.lightning.topic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LightningTopicDateRegistry {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="lightningSessionDate")
	private String lightningSessionDate;
	
	@Column(name="year")
	private String year;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "lightningTopicDateRegistry")
    private List<TopicProposal> topicProposals;
	
	public LightningTopicDateRegistry() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLightningSessionDate() {
		return lightningSessionDate;
	}

	public void setLightningSessionDate(String lightningSessionDate) {
		this.lightningSessionDate = lightningSessionDate;
	}

	public List<TopicProposal> getTopicProposals() {
		return topicProposals;
	}

	public void setTopicProposals(List<TopicProposal> topicProposals) {
		this.topicProposals = topicProposals;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	


}
