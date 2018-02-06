package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DartUp extends Command {

	double var;
    public DartUp(double x) 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.dart);
    	var=x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dart.dartsUp();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(Robot.dart.getPot()>=var);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dart.dartsStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
