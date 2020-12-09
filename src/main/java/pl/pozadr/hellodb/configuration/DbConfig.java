package pl.pozadr.hellodb.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/N8Ilk2pIr1");
        dataSourceBuilder.username("N8Ilk2pIr1");
        dataSourceBuilder.password("S7OtcibDzA");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }
}
