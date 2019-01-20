package com.lightning.topic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lightning.topic.model.TopicProposal;


@Repository
public interface TopicProposalRepository extends CrudRepository <TopicProposal, Long>{
	
	List<TopicProposal> findByLightningTopicDateRegistryId(long lightningTopicDateRegistryId);

}
