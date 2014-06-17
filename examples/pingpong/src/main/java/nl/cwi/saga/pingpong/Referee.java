package nl.cwi.saga.pingpong;

import java.io.*;
import nl.cwi.saga.pingpong.Ping;
import nl.cwi.saga.pingpong.Pong;

public class Referee {
	
	public static void main(String[] args) {
		Ping pl1 = new Ping();
		Pong pl2 = new Pong();

		/* Choose some player to start the ping-pong game */
		pl2.pong(pl1);
	}
}
