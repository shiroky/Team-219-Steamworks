package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *This command toggles the ball shooter, which runs off of PID.
 */
public class ToggleShooter extends Command implements PIDOutput
{
	private double kP = 0.0025;
	private double kI = 0.1;
	private double kD = 0.025;//.025
	private double speedUp = 0;
	private PIDController shooterController;

	//.00125
	//.0
	//.055
	//13.6
	public ToggleShooter() 
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() 
	{
		shooterController = new PIDController(kP, kI, kD, Robot.shooter, this);
		shooterController.setSetpoint(-15);//14.6
		shooterController.setInputRange(-20.0,20.0);
		shooterController.setPercentTolerance(.1);
		shooterController.setOutputRange(-1,1);
		shooterController.setContinuous();
		shooterController.enable();

		SmartDashboard.putData("PID Control", shooterController);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() 
	{
		//Robot.shooter.setMotorSpeed(speedUp);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() 
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		shooterController.disable();
		Robot.shooter.setMotorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() 
	{
		end();

	}

	@Override
	public void pidWrite(double output)
	{
		Robot.shooter.setMotorSpeed(output);
		SmartDashboard.putNumber("Current Velocity", Robot.shooter.getRotationRate());
		SmartDashboard.putNumber("PID_DRIVE INPUT",Robot.shooter.pidGet());
		SmartDashboard.putNumber("PID_DRIVE Voltage",Robot.shooter.getShooterMotor().get());
		SmartDashboard.putNumber("speedUp", output);
	}

}