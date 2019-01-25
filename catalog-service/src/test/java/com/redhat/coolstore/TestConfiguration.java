package com.redhat.coolstore;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.annotation.ApplicationScope;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.redhat.coolstore.utils.Producers;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@SpringBootApplication
@Profile("test")
public class TestConfiguration {
	private MongodExecutable mongodExecutable;
	
	private MongoClient mMongoClient;
	
	private MongoDatabase mMongoDB;
	
	Logger log = Logger.getLogger(TestConfiguration.class.getName());

    @Bean
    public Logger produceLog(org.springframework.beans.factory.InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
	
    @Bean
    @ApplicationScope
    public MongoClient createMongoClient() throws IOException {
    	
        String ip = "localhost";
        int port = 27018;
 
        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
            .net(new Net(ip, port, Network.localhostIsIPv6()))
            .build();
 
        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mMongoClient = new MongoClient(ip, port);
        mMongoDB = mMongoClient.getDatabase("catalogdb");
        mMongoDB.createCollection("products");       
        return mMongoClient;
    }
    
    @PreDestroy
    public void stopMongo() {
    	mongodExecutable.stop();
    }
}
