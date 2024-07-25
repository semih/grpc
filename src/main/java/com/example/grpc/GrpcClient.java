package com.example.grpc;


import com.example.grpc.GreeterGrpc.GreeterBlockingStub;
import com.example.grpc.HelloWorldProto.HelloReply;
import com.example.grpc.HelloWorldProto.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloReply response = stub.sayHello(HelloRequest.newBuilder()
                .setName("World")
                .build());

        System.out.println("Response: " + response.getMessage());
        channel.shutdown();
    }
}