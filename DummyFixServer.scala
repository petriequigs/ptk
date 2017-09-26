//==============================================================================
// File...: FixDummyServer
// Author.: Petrie
// Desc...: A FIX server with only purpose to verify FIX connectivity, logon,
//          heartbeat, new order, execution report, DFD.
//==============================================================================
import java._;
import java.net._;
import java.io._;
import scala.io._;
import java.util._;
import akka.actor._;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

//------------------------------------------------------------------------------
// Obj...: DummyFixServer
// Desc..: Static object to run main
//------------------------------------------------------------------------------
object DummyFixServer {
    
    def main(args : Array[String]){

	val server = new ServerSocket(5000);

	println("**Starting Server");

	while(true){
	    
	    //	val server = new ServerSocket(5000);
	    //	val s = server.accept();
	    
	    (new Thread(new ConnectThread(server))).run();
	}

	println("**Closing Server");
    }
}

//------------------------------------------------------------------------------
// Class.: ConnectThread
// Desc..: Thread to connect to clients [TBC: multi-thread]
//------------------------------------------------------------------------------
class ConnectThread(server : ServerSocket) extends Runnable {

    def run(){

	while(true){
	    val s = server.accept();
	    println("*Listening on Socket (" + s + ")");
	    (new Thread(new ReadMsg(s))).run();
	    s.close();
	    println("   Closed socket");
	}


    }
}
//------------------------------------------------------------------------------
// Class.: ReadMsg
// Desc..: Reads data from client
//------------------------------------------------------------------------------
class ReadMsg(s : Socket) extends Runnable {

    def run(){
	println("     Message Recieved:");

	    val in = new BufferedSource(s.getInputStream()).getLines();
	    val out = new PrintStream(s.getOutputStream());
	    
	    var out_line = new String();

	    println(out_line);
	    while(in.hasNext){
		out_line=in.next();
		println("      "+ s + " : " + out_line);
	    }
    }
}	


















//                                                          31-6-40-3-128-1-6
//                                                          32-11-15-4-26-9-19-64
//                                                          33-4-6-88-4-4-9-22
