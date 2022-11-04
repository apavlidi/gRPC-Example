# gRPC-Example
A simple example Java API exposed through gRPC.
The server also supports reflection so clients can get the information of the api exposed by the grpc server.
The project also contains `spotless` to ensure code standards and formatting.

### Contract
There is only one unary operation.

```
message ObjectRequest{
  string firstName = 1;
  string lastName = 2;
}

message ObjectResponse {
  string message = 1;
}

service HelloService {
  rpc greeting(ObjectRequest) returns (ObjectResponse);
}
```
#### Request
```
{
  "firstName": "Alexis",
  "lastName":" Pavlidis"
}
```

#### Response
The server will return the following message: `Hello 👋, Alexis Pavlidis`.
