package io.github.tiagoadmstz.eddz.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "eddz")
public class EddzConfiguration {

    private String reportsPath;
    private String reportsLogo;

}
