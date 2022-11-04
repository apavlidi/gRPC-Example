import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void greeting(ObjectRequest request, StreamObserver<ObjectResponse> responseObserver) {
    String greeting = new StringBuilder()
        .append("Hello 👋, ")
        .append(request.getFirstName())
        .append(" ")
        .append(request.getLastName())
        .toString();

    ObjectResponse response = ObjectResponse.newBuilder()
        .setMessage(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
