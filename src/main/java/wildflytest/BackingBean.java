package wildflytest;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@RequestScoped // これないと BackingBeanTest で nullpo
public class BackingBean {
  @Inject Logic logic; // これコメント外すと Deploy Error WELD-001408
  
  public String hello(String name) {
    System.out.println(String.format("Hello, %s!", name));
    return String.format("Hello, %s!", name);
  }
}
