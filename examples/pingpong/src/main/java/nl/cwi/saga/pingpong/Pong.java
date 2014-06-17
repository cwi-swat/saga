package nl.cwi.saga.pingpong;

import java.io.*;
import nl.cwi.saga.pingpong.Pong;

public class Pong {
	
	void pong(Ping opp) {
		opp.ping(this);
	}
}
