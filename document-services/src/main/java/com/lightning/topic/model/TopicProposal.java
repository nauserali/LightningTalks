package com.lightning.topic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TopicProposal {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max=80, message="topic should be max of 80 characters long")
	private String topic;
	
	@Column
	private String topicDesc;
	
	@NotNull
	@Size(max=255, message="email should be max of 80 characters long")
	private String email;
	
	@Column
	private String submissionDttm;
	
	@Column
	private String dateOfLightningTalk;
	
	private String lightningTopicDateRegistry_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lightningTopicDateRegistry_id", nullable = false, insertable= false, updatable=false)
    private LightningTopicDateRegistry lightningTopicDateRegistry;
	
	
	public TopicProposal() {
	}
	
	



	public TopicProposal(Long id,
			@NotNull @Size(max = 80, message = "topic should be max of 80 characters long") String topic,
			String topicDesc,
			@NotNull @Size(max = 255, message = "email should be max of 80 characters long") String email,
			String submissionDttm, String dateOfLightningTalk) {
		super();
		this.id = id;
		this.topic = topic;
		this.topicDesc = topicDesc;
		this.email = email;
		this.submissionDttm = submissionDttm;
		this.dateOfLightningTalk = dateOfLightningTalk;
	}





	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}


	public String getSubmissionDttm() {
		return submissionDttm;
	}

	public void setSubmissionDttm(String submissionDttm) {
		this.submissionDttm = submissionDttm;
	}



	public String getDateOfLightningTalk() {
		return dateOfLightningTalk;
	}





	public void setDateOfLightningTalk(String dateOfLightningTalk) {
		this.dateOfLightningTalk = dateOfLightningTalk;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}
	
	public LightningTopicDateRegistry getLightningTopicDateRegistry() {
		return lightningTopicDateRegistry;
	}


	public void setLightningTopicDateRegistry(LightningTopicDateRegistry lightningTopicDateRegistry) {
		this.lightningTopicDateRegistry = lightningTopicDateRegistry;
	}





	public String getLightningTopicDateRegistry_id() {
		return lightningTopicDateRegistry_id;
	}





	public void setLightningTopicDateRegistry_id(String lightningTopicDateRegistry_id) {
		this.lightningTopicDateRegistry_id = lightningTopicDateRegistry_id;
	}

	

}
