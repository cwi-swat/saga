package nl.cwi.saga.pingpong;

import java.io.*;
import nl.cwi.saga.pingpong.Pong;

public class Ping {
	
	void ping(Pong opp) {
		opp.pong(this);
	}
}
