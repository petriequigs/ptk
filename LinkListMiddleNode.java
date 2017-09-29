//==============================================================================
// File..: LinListMiddleNode.java
// Author: Petrie
// Desc..: Find middle element in linked list in one pass and other fun.
//==============================================================================
import java.util.*;

class LinkListMiddleNode {

    public  static void main( String[] args){

	LinkedList<String> TrainCars = new LinkedList<String>();

	//put together the train
	TrainCars.add("locamotive 2");
	TrainCars.add("freight1");
	TrainCars.add("freight2");
	TrainCars.add("passenger");
	TrainCars.add("oil1");
	TrainCars.add("oil2");
	TrainCars.add("oil3");
	TrainCars.add("aggregate1");
	TrainCars.add("aggregate2");
	TrainCars.add("aggregate3");
	TrainCars.add("caboose");


	System.out.println(TrainCars);

	//find middle note in one pass --wrong. this is like a array
	for(int cntr=0; cntr<TrainCars.size(); cntr++){
	    if((cntr*2) > TrainCars.size()){
		break;
	    }

	}

	showTrainCars(TrainCars);

	//add a car if one does not exist.
	if(!TrainCars.contains("locamotive 1")){
	    System.out.println("----Adding another locamotive to front---");
	    TrainCars.addFirst("locamotive 1");
	}

	showTrainCars(TrainCars);


	//at which position is the second oil tanker
	System.out.println("-----------Looking for oil2--------------");
	Iterator TrainCarsIt = TrainCars.listIterator();

	int index = 0;
	while(TrainCarsIt.hasNext()){
	    String thisCar = (String)TrainCarsIt.next();
	    System.out.println(thisCar);
	    if(thisCar.equals("oil2")){
		System.out.println("   " + "Found oil2 - At position " + index);
	    }
	    index++;
	}

	showTrainCars(TrainCars);


	//where is the middle car, do it in one pass
	//idea here is to use two pointers. Move the second in two steps
	System.out.println("----Looking for middle-car in one pass---");
	Iterator TrainCarsItM1 = TrainCars.listIterator();
	Iterator TrainCarsItM2 = TrainCars.listIterator();
	while(TrainCarsItM1.hasNext()){
	    String thisCar = (String)TrainCarsItM1.next();

	    //advance the second iterator pointer by two
	    if(TrainCarsItM2.hasNext()){
		TrainCarsItM2.next();
		if(TrainCarsItM2.hasNext()){
		    		TrainCarsItM2.next();
		}
		else{
		    System.out.println("Middle Car is " + thisCar);
		    break;
		}
	    }
	    else{
		System.out.println("Middle Car is " + thisCar);
		    break;
	    }

	    index++;
	}

    }

    //--------------------------------------------------------------------------
    // Subroutine.: showTrainCars
    // Desc.......: Prints the cars in the train using a linked list iterator
    //--------------------------------------------------------------------------
    static void showTrainCars(LinkedList<String> trainLkList){
	
	Iterator trainLkListIt = trainLkList.listIterator();

	System.out.println("-----------List of Train Cars------------");
	
	while(trainLkListIt.hasNext()){
	    System.out.println(trainLkListIt.next());
	}
    }    
}


