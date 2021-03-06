package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The harvester subsystem of Team 219's 2017 robot.
 */
public class Harvester extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon collectorMotor;
	private CANTalon collectorMotor2;
	
	public Harvester()
	{
		collectorMotor = new CANTalon(RobotMap.COLLECTORMOTOR_PORT);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	/**
	 * Turns on the collector motor at a speed of 1.
	 */
	public void startRoller() {
		collectorMotor.set(1);
		collectorMotor2.set(.5);
		SmartDashboard.putString("Roller", "On");			
	}	
	/**
	 * Turns off the collector motor.
	 */
	public void stopRoller() {
		collectorMotor.set(0);
		SmartDashboard.putString("Roller", "Off");
	}

}

