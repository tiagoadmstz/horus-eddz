package io.github.tiagoadmstz.eddz.config;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
public class ReportBeansConfig {

    private final DataSource dataSource;

    public ReportBeansConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JRDataSource jrDataSource() {
        return new JRBeanCollectionDataSource(Collections.singletonList("data"), false);
    }
}
