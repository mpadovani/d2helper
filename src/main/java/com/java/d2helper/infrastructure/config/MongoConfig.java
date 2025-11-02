import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.java.d2helper.infrastructure") // Ajuste para o seu package de Repositories
public class MongoConfig {

    private final Environment environment;

    public MongoConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Profile("prod")
    public MongoClient mongoClient() {
        String mongoUri = environment.getProperty("MONGODB_URL");
        if (mongoUri != null) {
            return MongoClients.create(mongoUri);
        }
        return MongoClients.create();
    }

    @Bean
    @Profile("prod")
    public MongoTemplate mongoTemplate() {
        String databaseName = "d2helper_db";
        return new MongoTemplate(mongoClient(), databaseName);
    }
}