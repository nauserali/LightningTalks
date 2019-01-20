package com.lightning.topic.service;

import java.util.List;

import com.lightning.topic.model.TopicProposal;

public interface LightningTalkService {

	public TopicProposal submitTopicProposal(TopicProposal topicProposal);
	
	public List<String> retrieveTopicProposalsForUpcomingTalk(long lightningTopicDateRegistryId);
}
