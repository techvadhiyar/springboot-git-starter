package edu.lab.gitdemo.resource;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.lab.gitdemo.model.Greeting;

@RestController
public class GreetingResource {

	private static final String template = "Greetings, %s!";
    private final AtomicLong counter = new AtomicLong(); // stateful counter...
    
    Logger logger = LoggerFactory.getLogger(GreetingResource.class.getName());	

    @GetMapping("/api/greetings/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	logger.debug("greeting: entered...");
    		
    	Greeting greetingObject = null;
		// the counter value odd (i.e. 1, 3, 5, 7, ...)
        long newCounter = 0; //initialize
        // newCounter = counter.get() * counter.incrementAndGet();
        newCounter = counter.incrementAndGet();
        if (newCounter % 2 != 0) {
        	String templateWithName = String.format(template, name);
        	greetingObject = new Greeting(newCounter, templateWithName);
        }
        
        logger.debug("greeting: exiting...");
    	
        return greetingObject;
    }
	
}