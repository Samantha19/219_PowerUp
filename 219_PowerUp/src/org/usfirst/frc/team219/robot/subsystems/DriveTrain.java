package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.Robot;
import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.TeleOpDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//inches
	TalonSRX driveFR,driveFL,driveBR,driveBL;
	@SuppressWarnings("deprecation")
	private RobotDrive driveBase;
	private PIDSourceType pidSourceType = PIDSourceType.kRate;
	private final double circumfrenceINCH = 4 * Math.PI; //subject to change?
	//private PIDSourceType pidSourceType = PIDSourceType.kRate;
	
	public DriveTrain()
	{
		driveFR= new TalonSRX(RobotMap.driveFrontRightPort);
		driveFL= new TalonSRX(RobotMap.driveFrontLeftPort);
		driveBR= new TalonSRX(RobotMap.driveBackRightPort);
		driveBL= new TalonSRX(RobotMap.driveBackLeftPort);
		LiveWindow.addChild(this, driveBase);
	}
	
	boolean turnFinish=false;
	public void driveNTurn( double angle, double time, double speedDif)
	{
		SmartDashboard.putNumber("EncVelL", driveFL.getSensorCollection().getQuadratureVelocity());
		SmartDashboard.putNumber("EncVelR", driveFR.getSensorCollection().getQuadratureVelocity());
		SmartDashboard.putNumber("EncPosL", driveFL.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("EncPosR", driveFR.getSensorCollection().getQuadraturePosition());
		double percent= Math.abs(angle/360);
		double speedDifIn = 135*speedDif;
		if(time<((213.0*percent)/speedDifIn))
		{
			if(angle>0)	
			{
				tankDrive(-.75 + (speedDif*.5),-.75 - (speedDif*.5));
			}
			else
			{
				tankDrive(-.75 - (speedDif*.5),-.75 + (speedDif*.5));	
			}
			
			SmartDashboard.putNumber("Time", time);
			double timeytime= time;
			SmartDashboard.putNumber("TimeyTime", timeytime);
			turnFinish=false;
		}
		else
		{
			turnFinish=true;
		}

	}
	
	public void dimeTurn(double angle, double currenTime)
	{
		double percent = Math.abs(angle/360);
		double speedDifIn = 135;
		if(currenTime < ((213.0*percent)/speedDifIn))
		{
			if (angle>0)
			{
				tankDrive(.5,-.5);
			}
			else
			{
				tankDrive(-.5,.5);
			}
			
			turnFinish=false;
		}
		else
		{
			
			turnFinish=true;
		}
	}
	
	public boolean turnFinished()
	{
		return turnFinish;
	}
	
	public void setPIDSourceType(PIDSourceType pidSource)
	{
		pidSourceType = pidSource;
	}
	
	public PIDSourceType getPIDSourceType()
	{
		return pidSourceType;
	}
	
	public double pidGet()
	{
		return getDistance();
	}
	
	public double getDistance() 
	{
		return (Math.abs(driveFR.getSensorCollection().getQuadraturePosition()/4096.0))*circumfrenceINCH;
	}
	
	public void resetEncoders()
	{
		driveFL.getSensorCollection().setQuadraturePosition(0, 10);
		driveFR.getSensorCollection().setQuadraturePosition(0, 10);
	}

	public void goForward(double var)
	{
		driveFR.set(ControlMode.PercentOutput,var);
    	driveFL.set(ControlMode.PercentOutput, -var);
    	driveBR.set(ControlMode.Follower, RobotMap.driveFrontRightPort);
    	driveBL.set(ControlMode.Follower, RobotMap.driveFrontLeftPort);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new TeleOpDrive());
    	//setDefaultCommand(new TeleOpDrive());
    }
    
    public void tankDrive(double right, double left)
    {
    	driveFR.set(ControlMode.PercentOutput, right);
    	driveFL.set(ControlMode.PercentOutput, -left);
    	driveFR.set(ControlMode.PercentOutput, right);
    	driveFL.set(ControlMode.PercentOutput, -left);
		SmartDashboard.putNumber("EncPosL", driveFL.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("EncPosR", driveFR.getSensorCollection().getQuadraturePosition());
    	driveBR.set(ControlMode.Follower, RobotMap.driveFrontRightPort);
    	driveBL.set(ControlMode.Follower, RobotMap.driveFrontLeftPort);
    	
    } 
    
    public void tankDrive(double xSpeed, double ySpeed, double x2Speed)
    {
    	driveFR.set(ControlMode.PercentOutput, (-ySpeed + xSpeed)/2);
    	driveFL.set(ControlMode.PercentOutput, -(-ySpeed - xSpeed)/2);
    	driveBL.set(ControlMode.PercentOutput, (-ySpeed + xSpeed)/2);
    	driveBR.set(ControlMode.PercentOutput, -(ySpeed + xSpeed)/2);
    	SmartDashboard.putNumber("EncPosL", driveFL.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("EncPosR", driveFR.getSensorCollection().getQuadraturePosition());
		if(x2Speed > .2)
		{
			driveFR.set(ControlMode.PercentOutput, x2Speed/2);
			driveFL.set(ControlMode.PercentOutput, x2Speed/2);
			driveBR.set(ControlMode.PercentOutput, x2Speed/2);
			driveBL.set(ControlMode.PercentOutput, x2Speed/2);
			SmartDashboard.putNumber("EncPosL", driveFL.getSensorCollection().getQuadraturePosition());
			SmartDashboard.putNumber("EncPosR", driveFR.getSensorCollection().getQuadraturePosition());
		}
    }
    
    public void setInvertedStatis(boolean statis)
    {
    	driveFR.setInverted(statis);
    	driveBR.setInverted(statis);
    	driveFL.setInverted(statis);
    	driveBL.setInverted(statis);
    }
    
    
    
}

