package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreeterImpl())
                .build();

        System.out.println("Server started, listening on " + 50051);
        server.start();
        server.awaitTermination();
    }
}
