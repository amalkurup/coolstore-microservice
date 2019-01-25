package com.redhat.coolstore.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Arrays;
import java.util.logging.Logger;

@Configuration
public class Producers {

    Logger log = Logger.getLogger(Producers.class.getName());

    @Bean
    public Logger produceLog(org.springframework.beans.factory.InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }



    @Bean
    @ApplicationScope
    public MongoClient createMongoClient() {
        log.info("Creating MongoClient");
        String dbName = System.getenv("DB_NAME");
        if(dbName==null || dbName.isEmpty()) {
            log.info("Could not get environment variable DB_NAME using the default value of 'CatalogDB'");
            dbName = "catalogdb";
        }

        String dbServer = System.getenv("DB_SERVER");
        if(dbServer==null || dbServer.isEmpty()) {
            log.info("Could not get environment variable DB_SERVER using the default value of 'localhost'");
            dbServer = "localhost";
        }


        String dbUsername = System.getenv("DB_USERNAME");
        String dbPassword = System.getenv("DB_PASSWORD");
        if(dbUsername!=null && !dbUsername.isEmpty() && dbPassword!=null && !dbPassword.isEmpty()) {
            log.info(String.format("Connecting to MongoDB %s@%s using %s user credentials",dbName,dbServer,dbUsername));
            return new MongoClient(new ServerAddress(dbServer), Arrays.asList(MongoCredential.createCredential(dbUsername, dbName, dbPassword.toCharArray())));
        } else {
            log.info(String.format("Connecting to MongoDB %s@%s without authentication",dbName,dbServer));
            return new MongoClient(dbServer);
        }

    }
}
