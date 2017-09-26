
//==============================================================================
// File...: FixDummyClient
// Author.: Petrie
// Desc...: A simpleFIX client that can connect to a server.
//          The purposes are to check heartbeat, new order, execution report, 
//          DFD. Mostly for connectivty and session functioning for simple
//          order files
//==============================================================================
import java.net._;
import java.io._;
import scala.io._;
import FixParts._;

class heartbeat {

    private var body_part = "";

    concat_body("|" + "35=A"); 
    concat_body("|" + "56=DUM_SRVR"); 
    concat_body("|" + "34=1"); 
    concat_body("|" + "52=9/7/17"); 
    concat_body("|" + "98=0"); 
    concat_body("|" + "108=30");        
    concat_body("|" + "141=Y"); 
    concat_body("|" + "49=DUM_CLIENT"); 


    def get_msg() : String = {
	 val ret_val = body_part;
	 return ret_val;
     }

    def concat_body(strg : String){
	body_part = body_part.concat(strg)
    }

}

//------------------------------------------------------------------------------
// Obj...: DummyFixClient
// Desc..: Static object to run main
//------------------------------------------------------------------------------
object DummyFixClient {

    val hb_interval = 3;

    def main(args : Array[String]){

	val hb_msg = new HeartBeat(); //new class. Put heartbeat in here

	hb_msg.SetSenderCompID("ZDMY_CLIENT");
	hb_msg.SetTargetCompID("ZDM_SRVR");
	

	val hb = new heartbeat();
		
	val s = new Socket(InetAddress.getByName("localhost"), 5000);

	lazy val in = new BufferedSource(s.getInputStream()).getLines();
	val out = new PrintStream(s.getOutputStream());
    

	while(1>0){
	    println("Sending Message");
	    out.println(hb_msg.getFixStrg());
	    out.flush();             
	    Thread.sleep(5000);
	    //println("Received: " + in.next());
	}

	s.close();
    }
}



















//                                                          31-6-40-3-128-1-6
//                                                          32-11-15-4-26-9-19-64
//                                                          33-4-6-88-4-4-9-22
