package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest req, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        HelloWorldProto.HelloReply reply = HelloWorldProto.HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
