package com.abhinav.demo.controllers;

import com.abhinav.demo.proto_gen.ping_pong.PingPongServiceGrpc;
import com.abhinav.demo.proto_gen.ping_pong.Request;
import com.abhinav.demo.proto_gen.ping_pong.Response;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

/**
 * @author Abhinav Tripathi 17/08/20
 */
@Slf4j
@GRpcService
public class PingPongGrpcController extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void ping(Request request, StreamObserver<Response> responseObserver) {
        log.info("Payload Received : " + request.getPayload());
        Response response = Response.newBuilder().setMessage("PONG").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
