package qztc.sxl.test;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
	
	public static void main(String[] args)
	{
		//Scanner in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			try (	Socket socket = getSocket();
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); ) {
				String cmd;
				socket.setSoTimeout(1000*3);
				do{
					System.out.print("client:");
					cmd = in.readLine();
					bw.write(cmd + "\r\n");
					bw.flush();
					try{
						String result = br.readLine();
						System.out.println("server:" + result);
					}catch(SocketTimeoutException toe){
						System.out.println("Timeout");
						//continue;
					}
				}while(!cmd.equals("quit"));
				break;
			} catch(ConnectException connE){
				System.out.println("Connect ERR!");
			} catch(SocketException socE){
				System.out.println("Connect Broken!");
			} catch (IOException ioE) {
				System.out.println("IOException");
				ioE.printStackTrace();
			}
		}
		
		
		
		
		
		System.out.print("感谢食用本程序");
		//in.readLine();
	}
	
	private static Socket getSocket()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String serverHost;
		int serverPort;
		while(true)
		{
			try {
				System.out.print("Please type the server name/IP:");
				serverHost=in.readLine();
				System.out.print("Please type the server port:");
				serverPort=Integer.parseInt(in.readLine());
				return new Socket(serverHost,serverPort);
			} catch(UnknownHostException une){
				System.out.println("UnknownHostException");
			}catch(ConnectException connE){
				System.out.println("Cannot Connect Server!");
			}catch(NumberFormatException nfE){
				System.out.println("NumberFormatException!");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("ERROR!");
				e.printStackTrace();
				//in.readLine()
			}
		}
		
	}
	
	
	
	
	
	
}
