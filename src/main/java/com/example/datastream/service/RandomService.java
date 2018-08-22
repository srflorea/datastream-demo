package com.example.datastream.service;

import org.springframework.stereotype.Service;

/**
 * Service for generating random numbers
 * @author stefan
 *
 */
@Service
public class RandomService {

	/**
	 * Method for generating a random number between a minimum and a maximum
	 * @param min
	 * @param max
	 * @return
	 */
	public int getRandomInt(int min, int max) {
	    return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
	}
}
