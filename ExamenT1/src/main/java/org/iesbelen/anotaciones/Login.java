package org.iesbelen.anotaciones;


import org.hibernate.loader.plan.spi.Return;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;


// usuario: usuario1
// passwd: admin <-> hashPasswd: 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
@Credencial(usuario = "usuario1",
        password = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")
// usuario: usuario2
// passwd: admin1234 <-> hashPasswd: ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270
@Credencial(usuario = "usuario2",
        password = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270")


public class Login {
    /**
     * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:
     * 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
     *
     * @param password
     * @return hash de encriptación de la password
     * @throws NoSuchAlgorithmException
     */
    Scanner sc = new Scanner(System.in);

    private String nombreLogin;
    private List<DatosCredencial> datosCredencial;

    public Login(String nombreLogin, List<DatosCredencial> datosCredencial) {
        this.nombreLogin = nombreLogin;
        this.datosCredencial = datosCredencial;
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest;

        digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] byteHash) {

        StringBuilder hexString = new StringBuilder(2 * byteHash.length);
        for (int i = 0; i < byteHash.length; i++) {
            String hex = Integer.toHexString(0xff & byteHash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public void login(Scanner sc) {
        System.out.println("Introduce una contraseña: ");
        String usuario = sc.nextLine();

        System.out.println("Introduce una contraseña: ");
        String contraseña = sc.nextLine();


    }

    public static Login cargadorContexto(Login l) {
        Credencial[] credenciales = Login.class.getAnnotationsByType(Credencial.class);

        for (Credencial c : credenciales) {
            DatosCredencial cre = null;

            cre = new DatosCredencial(c.usuario(), c.password());
            if (cre != null) {
                l.datosCredencial.add(cre);
            }

        }
        return l;
    }

}
