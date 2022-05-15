package com.dw.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class TestLambda implements RequestHandler<Object, Object> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    @Override
    public Object handleRequest(Object o, Context context)
    {
        System.out.println("Welcome to lambda function");
        return null;
    }

}
