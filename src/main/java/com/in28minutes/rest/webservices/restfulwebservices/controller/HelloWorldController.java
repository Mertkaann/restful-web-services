package com.in28minutes.rest.webservices.restfulwebservices.controller;


import com.in28minutes.rest.webservices.restfulwebservices.model.HelloWorldModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(path = "hello-world", method = RequestMethod.GET)
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping(path = "hello-world-model", method = RequestMethod.GET)
    public HelloWorldModel helloModel(){
        return new HelloWorldModel("Hello World!");
    }

    @RequestMapping(path="hello-world-parameter/{message}",method = RequestMethod.GET)
    public String helloParameter(@PathVariable String message){
        return "Hello World " + message;
    }


}
