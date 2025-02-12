package org.dam48.proyectofinalbis;

import org.dam48.proyectofinalbis.database.SQLDatabaseManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinalBisApplication {

    public static void main(String[] args) {

        // Establecer el túnel SSH
        try {
            SQLDatabaseManager.connectSSH();
        } catch (Exception e) {
            System.err.println("No se pudo abrir el túnel SSH: " + e.getMessage());
            System.exit(1); // Detiene la aplicación si falla la conexión SSH
        }

        // Iniciar Spring Boot después de abrir el túnel
        SpringApplication.run(ProyectoFinalBisApplication.class, args);

        // Cerrar el túnel cuando Spring Boot se detenga
        Runtime.getRuntime().addShutdownHook(new Thread(SQLDatabaseManager::disconnectSSH));

    }
}