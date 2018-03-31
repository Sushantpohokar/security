package com.aws;

import com.amazonaws.services.lambda.runtime.Context;
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LambdaMethodHandler lh=new LambdaMethodHandler();
		lh.handleRequest("sushant", context);

	}

}
