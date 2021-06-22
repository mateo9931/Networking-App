package edu.escuelaing.arsw.Networking.calcnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {



    /**
     * Clase Servidor que conecta al cliente y realiza calculo de sin, cos , tan al numero ingresado
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Double valorcalc;
        Double resultado = 0.0;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        int flag = 3;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:" + inputLine);

            if( inputLine.equals("fun:sin")){
                flag=2;
            }
            else if( inputLine.equals("fun:cos")){
                flag=3;
            }
            else  if( inputLine.equals("fun:tan")){
                flag=4;
            }
            else{
                valorcalc=Double.parseDouble(inputLine);

                if(flag==2){
                    resultado=calculadora.calcSin(valorcalc);
                }
                if(flag==3){
                    resultado=calculadora.calcCos(valorcalc);
                }
                if(flag==4){
                    resultado=calculadora.calcTan(valorcalc);
                }
            }
            out.println(resultado);
            if (inputLine.equals("")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}