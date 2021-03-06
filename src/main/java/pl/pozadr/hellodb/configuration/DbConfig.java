package pl.pozadr.hellodb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private final DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // solution if you have more DBs than 1
    // If you have only 1 DB better solution is to use application.properties file and @Autowired constructor.
    /*@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/N8Ilk2pIr1");
        dataSourceBuilder.username("N8Ilk2pIr1");
        dataSourceBuilder.password("S7OtcibDzA");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }
     */

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }


    // CREATE TABLE
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        String sql = "CREATE TABLE videos(video_id int, title varchar(255), url varchar(255), PRIMARY KEY (video_id))";
        getJdbcTemplate().update(sql);
    }

}
