package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	double sped;
	Timer time;
    public DriveForward(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	sped=speed;
    	time=new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.goForward(sped);
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(time.get()>=5)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
