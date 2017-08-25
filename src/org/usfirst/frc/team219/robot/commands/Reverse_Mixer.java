package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;
import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Reverse_Mixer extends Command {

	
    public Reverse_Mixer()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.agitator);
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.agitator.mixerReverse();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.agitator.chooseDirectionReverse();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.agitator.mixerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}