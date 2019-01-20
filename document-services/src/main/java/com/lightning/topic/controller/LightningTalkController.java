package com.lightning.topic.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lightning.topic.model.TopicProposal;
import com.lightning.topic.service.LightningTalkService;
import com.lightning.topic.utility.RetrieveSystemInfo;
import org.springframework.http.HttpStatus;


@RestController
public class LightningTalkController {
	
	@Autowired
	private LightningTalkService lightningTalkService;
	
	@GetMapping("/getTopicProposalsForUpcomingTalk")
	public List<String> getTopicProposalsForUpcomingTalk(){
		
		long lightningTopicDateRegistryId = getLightningTopicDateRegistryIdForUpcomingTalk();
		return lightningTalkService.retrieveTopicProposalsForUpcomingTalk(lightningTopicDateRegistryId);
	}
	
	@PostMapping("/topicProposal")
	public ResponseEntity<List> submitTopicProposal(
			@RequestBody TopicProposal newTopicProposal) throws Exception{
		
		TopicProposal topicProposal = lightningTalkService.submitTopicProposal(newTopicProposal);
		
		if(topicProposal == null) 
			return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(topicProposal.getId()).toUri();
		
		String sysHostIp = RetrieveSystemInfo.getHostIp();
		String sysHostName = RetrieveSystemInfo.getHostName();
		String sysOs = RetrieveSystemInfo.getOSInfo();
		
		List<String> host = new ArrayList<String>();
		host.add(sysHostIp);
		host.add(sysHostName);
		host.add(sysOs);
		
		return new ResponseEntity<List>(host,HttpStatus.OK);

		//return ResponseEntity.created(location).build();
		
		
	}
	
	Long getLightningTopicDateRegistryIdForUpcomingTalk() {
		
		//TODO Database Call
		//logic to be applied to find out upcoming session
		//Assuming 
		//1 -> Feb2019 Lightning talk session
		//2 -> April 2019 Lightning talk session
		//3 -> June2019 Lightning talk session
		//4 -> Aug2019 Lightning talk session
		//5 -> Oct2019 Lightning talk session
		//6 -> Dec2019 Lightning talk session
		return (long) 3;
		
	}

}
