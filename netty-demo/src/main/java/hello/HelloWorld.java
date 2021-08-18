package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetSocketAddress;

@SpringBootApplication
public class HelloWorld {
  public static void main(String[] args) {
    SpringApplication.run(HelloWorld.class, args);
    NettyServer nettyServer = new NettyServer();
    nettyServer.start(new InetSocketAddress("127.0.0.1", 8003));
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
    return String.format("Hello %s !!!", name);
  }
}
