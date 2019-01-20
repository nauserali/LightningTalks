package com.lightning.topic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lightning.topic.model.LightningTopicDateRegistry;


@Repository
public interface LightningTopicDateRegistryRepository extends CrudRepository<LightningTopicDateRegistry, Long>{
	
	//LightningTopicDateRegistry findByUpcomingLightningTalk(long topicProposalId);

}
