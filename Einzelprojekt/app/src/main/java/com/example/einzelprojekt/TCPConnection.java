package com.example.einzelprojekt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.net.Socket;

public class TCPConnection {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public TCPConnection(String address, int port){
        try{
            this.socket = new Socket(address, port);
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){

        }
    }

    public String readLine(){
        try{
            return reader.readLine();
        }catch (Exception e){
            return "Crashed";
        }
    }
    public void writeLine(String text){
        try{
            writer.write(text + "\r\n");
            writer.flush();
        }catch (IOException e){}
    }
}
