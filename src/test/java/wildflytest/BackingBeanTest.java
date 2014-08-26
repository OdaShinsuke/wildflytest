package wildflytest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BackingBeanTest {
  @Inject
  private BackingBean hello;

  @Test
  public void testHello() throws Exception {
      assertThat(hello.hello("backpaper0"), is("Hello, backpaper0!"));
  }

  @Deployment
  public static WebArchive createDeployment() {
      return ShrinkWrap.create(WebArchive.class)
              .addClasses(BackingBean.class, Logic.class);
  }
}
