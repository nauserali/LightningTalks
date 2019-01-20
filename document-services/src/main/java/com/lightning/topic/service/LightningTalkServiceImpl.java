package com.lightning.topic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightning.topic.model.TopicProposal;
import com.lightning.topic.repository.LightningTopicDateRegistryRepository;
import com.lightning.topic.repository.TopicProposalRepository;
import com.lightning.topic.utility.CurrentDttm;


@Service
public class LightningTalkServiceImpl implements  LightningTalkService{
	
	@Autowired
	private TopicProposalRepository topicProposalRepository;
	
	@Autowired
	private LightningTopicDateRegistryRepository lightningTopicDateRegistryRepository;
	
	public List<String> retrieveTopicProposalsForUpcomingTalk(long lightningTopicDateRegistryId){
		
		 List<String> result = new ArrayList<String>();
		 List<TopicProposal> topicProposals = topicProposalRepository.findByLightningTopicDateRegistryId(lightningTopicDateRegistryId);
		 
		 for(TopicProposal topicProposal : topicProposals) {
			 result.add(topicProposal.getTopic());
			 result.add(topicProposal.getTopicDesc());
		 }
		 
		 return result;
	}
	
	
	
	public TopicProposal submitTopicProposal(TopicProposal topicProposal) {
		
		TopicProposal topicProp = new TopicProposal();
		CurrentDttm currentDttm = new CurrentDttm();
		
		topicProp.setDateOfLightningTalk(topicProposal.getDateOfLightningTalk());
		topicProp.setEmail(topicProposal.getEmail());
		//get current system datetime against submission date
		topicProp.setSubmissionDttm(currentDttm.getCurrentDttm());
		topicProp.setTopic(topicProposal.getTopic());
		topicProp.setTopicDesc(topicProposal.getTopicDesc());
		topicProp.setLightningTopicDateRegistry_id(topicProposal.getLightningTopicDateRegistry_id());
		
		
		
		topicProposalRepository.save(topicProp);
		
		return topicProposal;
		
		
	}

}
