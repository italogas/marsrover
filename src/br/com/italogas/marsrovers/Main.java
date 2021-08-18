package br.com.italogas.marsrovers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.italogas.marsrovers.entities.Plateau;
import br.com.italogas.marsrovers.entities.Rover;
import br.com.italogas.marsrovers.util.Logger;
import br.com.italogas.marsrovers.util.Util;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader br;
		
/*		if(args.length > 0) {
			File file = new File(args[0]);
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean firstInput = true;
        boolean roverPositionInput = false;
        
        //int upperRightX, upperRightY, roverX, roverY;
        //upperRightX = upperRightY = roverX = roverY = 0;
        //String roverOrientation = "";
        //List<String> output = new ArrayList<String>(); 
        Plateau pla = new Plateau();
        Rover r = new Rover();
        
        try {
        	// user must type 'end' to finish execution
            while (!(line = br.readLine()).equalsIgnoreCase("end"))
            {
                String[] tokens = line.split("\\s");

                if(firstInput && Util.checkInputTokensValidPlateuDimensions(tokens)) {
                	pla.setWidth(Integer.parseInt(tokens[0]));
                	pla.setHeight(Integer.parseInt(tokens[1]));
                	//upperRightX = ;
                	//upperRightY = Integer.parseInt(tokens[1]);
                	firstInput = false;
                	roverPositionInput = true;
                	//System.out.println("Plateu upper right X: " + upperRightX + ", plateu upper right Y: " + upperRightY);
                	Logger.log("Plateu upper right X: " + pla.getWidth() + ", plateu upper right Y: " + pla.getHeight());
                } else if(roverPositionInput && Util.checkInputTokensValidRoverPosition(tokens)) {
                	System.out.println("pla h: " + pla.getHeight());
                	//r = new Rover();
                	r.setX(Integer.parseInt(tokens[0]));
                	r.setY(Integer.parseInt(tokens[1]));
                	r.setOrientation(tokens[2]);
                	System.out.println("r x: " + r.getX());
                	pla.addRover(r);
                	//roverX = Integer.parseInt(tokens[0]);
                	//roverY = Integer.parseInt(tokens[1]);
                	//roverOrientation = tokens[2];
                	roverPositionInput = false;
                	//System.out.println("Rover X: " + tokens[0] + ", Rover Y: " + tokens[1] + ", Orientation: " + tokens[2]);
                	Logger.log("Rover X: " + r.getX() + ", Rover Y: " + r.getY() + ", Orientation: " + r.getOrientation());
                } else if(!firstInput && !roverPositionInput && Util.checkInputTokensValidDirections(tokens)) {
                	//do calc here
                	System.out.println(Arrays.toString(tokens));
                	String[] directions = tokens[0].split("(?!^)");
                	System.out.println(Arrays.toString(directions));
                	//String roverCurrentOrientation = roverOrientation;
                	r.move(directions);
                	//for (String direction : directions) 
                	/*{ 
                	    if(direction.equalsIgnoreCase("L")) {
                    	    if(roverCurrentOrientation.equalsIgnoreCase("N")) {
                    	    	roverCurrentOrientation = "W";
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("S")) {
                    	    	roverCurrentOrientation = "E";
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("E")) {
                    	    	roverCurrentOrientation = "N";
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("W")) {
                    	    	roverCurrentOrientation = "S";
                    	    } else {
                    	    	System.out.println("Invalid input! ");
                    	    }
                	    } else if(direction.equalsIgnoreCase("R")) {
                    	    if(roverCurrentOrientation.equalsIgnoreCase("N")) {
                    	    	roverCurrentOrientation = "E";
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("S")) {
                    	    	roverCurrentOrientation = "W";
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("E")) {
                    	    	roverCurrentOrientation = "S";
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("W")) {
                    	    	roverCurrentOrientation = "N";
                    	    } else {
                    	    	System.out.println("Invalid input! ");
                    	    }
                	    } else if(direction.equalsIgnoreCase("M")) {
                    	    if(roverCurrentOrientation.equalsIgnoreCase("N")) {
                    	    	roverY+=1;
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("S")) {
                    	    	roverY-=1;
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("E")) {
                    	    	roverX+=1;
                    	    } else if(roverCurrentOrientation.equalsIgnoreCase("W")) {
                    	    	roverX-=1;
                    	    } else {
                    	    	System.out.println("Invalid input! ");
                    	    }
                	    } else {
                	    	System.out.println("Invalid input! ");
                	    }
                	}*/
                	roverPositionInput = true;
/*                	String out;
                	if(Util.checkOutsideBoundaries(roverX, roverY, upperRightX, upperRightY)) {
                		out = "Rover outside boundaries!";
                	} else {
                		out = roverX + " " + roverY + " " + roverCurrentOrientation;
                	}*/
                	//output.add(out);
                	//System.out.println("Rover X: " + roverX + ", Rover Y: " + roverY+ ", Orientation: " + roverCurrentOrientation);
                	Logger.log("Rover X: " + r.getX() + ", Rover Y: " + r.getY() + ", Orientation: " + r.getOrientation());
                } else {
                	System.out.println("Invalid input! ");
                }
            }
/*            for (String out : output) { 
            	System.out.println(out.toString() + "\n");
        	}*/
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}

}
