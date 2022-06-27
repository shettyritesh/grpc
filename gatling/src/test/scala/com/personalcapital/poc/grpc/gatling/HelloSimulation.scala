package com.personalcapital.poc.grpc.gatling

import com.github.phisgr.gatling.grpc.Predef.{grpc, managedChannelBuilder}
import com.github.phisgr.gatling.grpc.action.GrpcCallActionBuilder
import com.github.phisgr.gatling.grpc.protocol.StaticGrpcProtocol
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import org.example.{HelloReply, HelloRequest, SimpleGrpc}
import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.check.GrpcCheck.Status
import com.github.phisgr.gatling.javapb._
import io.gatling.core.Predef._
import io.gatling.core.session.Expression

import scala.concurrent.duration._

class HelloSimulation extends Simulation {

  val grpcConf: StaticGrpcProtocol = grpc(managedChannelBuilder("localhost", 9090).usePlaintext())
    .shareChannel


  val scn: ScenarioBuilder = scenario("Hello Service!!")
    .exec(_.set("data", 0))
    .during(10.second) {
      pause(500.millis)
        .exec(grpc("Hello!")
          .rpc(SimpleGrpc.getSayHelloMethod)
          .payload(HelloRequest.newBuilder().setName("anuj").build()).extract(_.getMessage.some)(_ saveAs "token")
          .check(statusCode is io.grpc.Status.Code.OK)
        )
        .exec(session => session.set("data", 1 + session("data").as[Int]))
    }

  setUp(scn.inject(atOnceUsers(1)).protocols(grpcConf))
}
