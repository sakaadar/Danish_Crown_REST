package via.pro3.danish_crown_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class DanishCrownRestApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(DanishCrownRestApplication.class, args);
  }

}
