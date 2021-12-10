package com.example;


import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.HelloRequest;
import org.example.SimpleGrpc;
import org.springframework.stereotype.Service;

@Service
public class FoobarService {

   @GrpcClient("local-grpc-client")
   private SimpleGrpc.SimpleBlockingStub myServiceStub;

    public String receiveGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
             .build();
        return myServiceStub.sayHello(request).getMessage();

   }

}
