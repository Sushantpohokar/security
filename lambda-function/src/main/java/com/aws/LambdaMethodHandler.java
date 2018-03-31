package com.aws;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler; 

public class LambdaMethodHandler {
	public String handleRequest(Map<String,Object> input, Context context) {
        context.getLogger().log("Input: " + input);
        System.out.println("Sushant " + input); 
        return "Hello World - " + input;
    }
}
