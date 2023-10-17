package com.example;

import io.micronaut.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;


//https://github.com/micronaut-projects/micronaut-test/issues/832 //todo: wamy this is big down for micronaut
public final class SqlUtils {
    private SqlUtils() {
    }

    public static void load(Connection connection,
                            ResourceLoader resourceLoader,
                            String path) throws IOException, SQLException {
        Optional<URL> resource = resourceLoader.getResource(path);
        if (resource.isPresent()) {
            try (InputStream in = resource.get().openStream()) {
                String sql = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                try(Statement statement = connection.createStatement()) {
                    statement.execute(sql);
                }
            }
        }
    }
}