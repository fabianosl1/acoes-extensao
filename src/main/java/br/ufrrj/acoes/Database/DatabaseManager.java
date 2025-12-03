package br.ufrrj.acoes.Database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Properties;

public class DatabaseManager {
    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager() {
        if (factory == null) {
            factory = create();
        }

        return factory.createEntityManager();
    }

    private static EntityManagerFactory create() {
        Properties properties = new Properties();

        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (url != null && user != null && password != null) {
            properties.setProperty("jakarta.persistence.jdbc.url", url);
            properties.setProperty("jakarta.persistence.jdbc.user", user);
            properties.setProperty("jakarta.persistence.jdbc.password", password);
        }

        return  Persistence.createEntityManagerFactory("jpa", properties);
    }
}
