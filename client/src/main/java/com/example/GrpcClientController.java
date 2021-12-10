package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Optional demo controller making the grpc service accessible via browser requests.
 */
@RestController
public class GrpcClientController {

    @Autowired
    private FoobarService foobarService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Ritesh") final String name) {
        return this.foobarService.receiveGreeting(name);
    }

}