package qztc.sxl.msmcodeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtil {

	private static Socket  socket = null;
	private static ServerSocket sc = null;
	/*
	private Socket getSoket(){

		if (socket == null){
			try {
				sc = new ServerSocket(15311);
				System.out.println("server start!");
				while(true){
				socket = sc.accept();


				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return socket;
	}*/
}
