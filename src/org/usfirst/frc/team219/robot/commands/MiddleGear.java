package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MiddleGear extends CommandGroup {

    public MiddleGear() 
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	double theta=SmartDashboard.getNumber("gearDegreeToMove", 0);
    	double adjacent=SmartDashboard.getNumber("gearDistanceToMove", 0);
    	//addSequential(new AutoAlign(theta*2.0));//what should be here is 2Theta
    	//6.0/Math.cos(Math.toRadians(90 - 20))	
    	//addSequential(new AutonDrive(.3, adjacent/Math.cos(Math.toRadians(90 - (theta*2)))	));
    	//addSequential(new AutoAlign(theta*-2.0));
    	addSequential(new AutonDrive(.2,500));
    	//SmartDashboard.getNumber("gearDistanceToTarget", 0)-100
    
    }
}