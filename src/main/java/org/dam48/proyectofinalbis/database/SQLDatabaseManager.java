package org.dam48.proyectofinalbis.database;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SQLDatabaseManager {
    private static final String SSH_HOST = "mvs.sytes.net";
    private static final int SSH_PORT = 11160;
    private static final String SSH_USER = "sshuser";
    private static final String SSH_PRIVATE_KEY = "C:\\Users\\blanq\\Documents\\acceso_remoto\\proyectofinal\\id_rsa";
    private static final String DB_HOST = "127.0.0.1";
    private static final int DB_PORT = 5432;
    public static final int LOCAL_PORT = 5434;

    private static Session sshSession; // Sesión SSH

    /**
     * Establece un túnel SSH a PostgreSQL.
     */
    public static void connectSSH() {
        try {
            JSch jsch = new JSch();
            jsch.addIdentity(SSH_PRIVATE_KEY);

            // Configurar sesión SSH
            sshSession = jsch.getSession(SSH_USER, SSH_HOST, SSH_PORT);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(config);
            sshSession.connect();

            // Establecer reenvío de puertos
            sshSession.setPortForwardingL(LOCAL_PORT, DB_HOST, DB_PORT);
        } catch (Exception e) {
            throw new RuntimeException("Error estableciendo túnel SSH", e);
        }
    }

    /**
     * Cierra la conexión SSH.
     */
    public static void disconnectSSH() {
        if (sshSession != null && sshSession.isConnected()) {
            sshSession.disconnect();
            System.out.println("Túnel SSH cerrado.");
        }
    }
}


