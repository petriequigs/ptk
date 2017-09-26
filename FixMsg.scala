//==============================================================================
// File...: FixMsg
// Author.: Petrie
// Desc...: The parts which make up a fix message.
//          **WORK-IN-PROGRESS**
//==============================================================================

package FixParts;

import scala.collection._;


//------------------------------------------------------------------------------
// Class..: FixSkel
// Desc...: Composite class to combine body parts
//------------------------------------------------------------------------------
class FixSkel{
    
    val hdr = new FixHdr();
    val body = new FixBody();
    val tail = new FixTail();

    //    var tags:Map[String, String] = new Map();

}

//------------------------------------------------------------------------------
// Class..: FixHdr
// Desc...: Header of message
//------------------------------------------------------------------------------
class FixHdr {
    val numTags=1;

    var SenderCompID = "";         //Tag 49
    var TargetCompID = "";         //Tag 56
    var BeginString  = "FIX.4.2";  //Tag 8
    var MsgType      = ""          //Tag 35 
    var MsgSeqNum    = 1           //Tag 34

    def SetSender (SndrCompID : String){
	SenderCompID = SndrCompID;
    }
    def SetTarget (TargCompID : String){
	TargetCompID = TargCompID;
    }
    def SetType (MsgTypeStr : String){
	MsgType = MsgTypeStr;
    }
    def nextSeqNum(){
	MsgSeqNum = MsgSeqNum+1;

    }

    def getTagsStrg () : String = {
	    var hdr_part = "";


	    hdr_part = hdr_part.concat("|" + "35=" + MsgType); 
	    hdr_part = hdr_part.concat("|" + "56=" + TargetCompID); 
	    hdr_part = hdr_part.concat("|" + "49=" + SenderCompID); 
	    hdr_part = hdr_part.concat("|" + "34=" + MsgSeqNum); 
	    hdr_part = hdr_part.concat("|" + "52=9/7/17"); 
	    hdr_part = hdr_part.concat("|" + "98=0"); 
	    hdr_part = hdr_part.concat("|" + "108=30");        
	    hdr_part = hdr_part.concat("|" + "141=Y"); 

	println("incrementing: "+MsgSeqNum+ "--" + hdr_part);
	    return hdr_part;
    }


}
//------------------------------------------------------------------------------
// Class..: FixTail
// Desc...: Trailer of message
//------------------------------------------------------------------------------
class FixTail {

    val numTags=1;

    def getTagsStrg () : String = {
	    var tail_part = "";

	    return tail_part;
    }

}

//------------------------------------------------------------------------------
// Class..: FixBody
// Desc...: Body of the message
//------------------------------------------------------------------------------
class FixBody {

    val numTags=1;

    def getTagsStrg () : String = {
	    var body_part = "";

	    return body_part;
    }

}

//------------------------------------------------------------------------------
// Class..: FixMsg
// Desc...: Final implementation of the message
//------------------------------------------------------------------------------
class FixMsg extends FixSkel{

    var SeqNum=0;

    override def toString : String = hdr.SenderCompID;

    def SetSenderCompID (SndrCompID : String){
	hdr.SetSender(SndrCompID);
    }
    def SetTargetCompID (TargCompID : String){
	hdr.SetTarget(TargCompID);
    }
    def SetMsgType (MsgType : String){
    println("hitting 2");
	hdr.SetType(MsgType);
    }
    def getFixStrg () : String = {

	var fix_strg = "";

	var hdr_part  = hdr.getTagsStrg();
	var body_part = body.getTagsStrg();
	var tail_part = tail.getTagsStrg();
	
	fix_strg = fix_strg.concat(hdr_part + body_part + tail_part); 
	
	hdr.nextSeqNum();

	return fix_strg;
    }

    

}


class HeartBeat extends FixMsg {
    println("hitting 1");  //ptk -- not running?
    this.SetMsgType("A");
}


















//                                                          31-6-40-3-128-1-6
//                                                          32-11-15-4-26-9-19-64
//                                                          33-4-6-88-4-4-9-22
