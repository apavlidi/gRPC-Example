import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext()
        .build();

    HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

    ObjectResponse response = stub.greeting(
        ObjectRequest.newBuilder().setFirstName("Alex").setLastName("Pavlidis").build());

    System.out.println("This is the response form the server\n" + response);

    channel.shutdown();
  }
}
