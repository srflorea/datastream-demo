package com.example.datastream.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.datastream.controller.response.StreamResponse;
import com.example.datastream.model.MyObject;
import com.example.datastream.service.StreamService;

@RestController
public class StreamController {

	@Autowired
	private StreamService streamService;

	/**
	 * Endpoint that retrieves a stream of objects together with the current date
	 * @param delay shows if the call should be dalayed with a random number of seconds or not
	 * @return the stream of data in http response entity
	 */
	@GetMapping(path = "getData")
	public ResponseEntity<StreamResponse> getData(
			@RequestParam(required = false) boolean delay) {

		Date date = new Date();

		long timeToDelay = 0;
		if (delay == true) {
			timeToDelay = (long) (Math.floor(Math.random() * 10) * 1000);
		}

		/* sleep for random number of seconds if required */
		try {
			Thread.sleep(timeToDelay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/* generate a new stream of objects */
		List<MyObject> data =
				streamService.generateNewStream();

		StreamResponse response = new StreamResponse(date, data);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
