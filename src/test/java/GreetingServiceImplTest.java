import static org.junit.jupiter.api.Assertions.assertEquals;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.inprocess.InProcessChannelBuilder;
import java.util.Optional;
import org.grpcmock.GrpcMock;
import org.grpcmock.junit5.InProcessGrpcMockExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InProcessGrpcMockExtension.class)
public class GreetingServiceImplTest {

  protected ManagedChannel serverChannel;

  @BeforeEach
  void setupChannel() {
    serverChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
        .usePlaintext()
        .build();
  }

  @AfterEach
  void shutdownChannel() {
    Optional.ofNullable(serverChannel).ifPresent(ManagedChannel::shutdownNow);
  }

  @Test
  void should_test_default_extension_resetting_after_test_second() {
    HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(serverChannel);

    ObjectResponse response = stub.greeting(
        ObjectRequest.newBuilder().setFirstName("Alex").setLastName("Pavlidis").build());

    assertEquals(response.getMessage(), "Hello 👋, Alex Pavlidis");
  }

}


