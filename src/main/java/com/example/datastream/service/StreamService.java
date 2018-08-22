package com.example.datastream.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datastream.model.MyObject;

/**
 * Service that generates a stream of objects
 * @author stefan
 *
 */
@Service
public class StreamService {

	@Autowired
	private RandomService randomService;

	/**
	 * Method for generating a list containing a random number of elements generated also randomly
	 * @return
	 */
	public List<MyObject> generateNewStream() {
		/* generate the length of the stream */
		int noOfObjects =
				randomService.getRandomInt(50, 100);

		/* generate the elements of the stream */
		List<MyObject> data = new ArrayList<>();
		for (int i = 0; i < noOfObjects; i ++) {
			MyObject newObject = new MyObject(
					randomService.getRandomInt(1, 3),
					randomService.getRandomInt(0,  100)
					);
			
			data.add(newObject);
		}

		return data;
	}
}
