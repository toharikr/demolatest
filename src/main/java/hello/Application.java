package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.applicationinsights.TelemetryClient;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.applicationinsights.telemetry.Duration;

@SpringBootApplication
@RestController
public class Application {
     
    @Autowired
     TelemetryClient telemetryClient;
    
    @RequestMapping("/")
    public String home() {
                 
        telemetryClient.trackEvent("Sending a custom event...");

         //trace a custom trace
         telemetryClient.trackTrace("Sending a custom trace....");

         //track a custom metric
         telemetryClient.trackMetric("custom metric", 1.0);
        return "Wlcome AKS domain";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
