package com.PeerReviewResume.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    public static final String KEYSPACE = "demo";

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.PeerReviewResume.backend.entity"};
    }
}
