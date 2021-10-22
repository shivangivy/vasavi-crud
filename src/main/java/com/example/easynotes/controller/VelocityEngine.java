/**
 * 
 */
package com.example.easynotes.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * @author Electem2
 *
 */
@Component
public class VelocityEngine extends org.apache.velocity.app.VelocityEngine implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	public VelocityEngine() {
		super();

		final Properties velocityProperties = new Properties();
		try {
			velocityProperties
					.load(new ClassPathResource("velocity/velocity.properties")
							.getInputStream());
		} catch (IOException e) {
			//throw Throwables.propagate(e);
		}
		init(velocityProperties);
	}
	
}
