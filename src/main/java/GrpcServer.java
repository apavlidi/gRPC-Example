import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import java.io.IOException;

public class GrpcServer {
  public static void main(String[] args) throws IOException, InterruptedException {
    Server server =
        ServerBuilder.forPort(50052)
            .addService(new HelloServiceImpl())
            .addService(ProtoReflectionService.newInstance()) // this is for reflection
            .build();

    server.start();
    server.awaitTermination();
  }
}
