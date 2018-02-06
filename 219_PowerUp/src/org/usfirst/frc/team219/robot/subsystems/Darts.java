package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Darts extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX dartL,dartR;
	Potentiometer pot;
	AnalogInput ai;
	
	public DigitalInput hall;
	
	public Darts()
	{
		hall= new DigitalInput(3);
		ai = new AnalogInput(1);
		pot = new AnalogPotentiometer(ai, 360, 30);
		dartL=new TalonSRX(RobotMap.dartLeft);
		dartR= new TalonSRX(RobotMap.dartRight);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void dartsUp()
    {
    	dartL.set(ControlMode.PercentOutput, .5);
    	dartR.set(ControlMode.PercentOutput, .5);
    }
    
    public void dartsDown()
    {	
    	dartL.set(ControlMode.PercentOutput, -.5);
    	dartR.set(ControlMode.PercentOutput, -.5);
    }
    public void dartsStop()
    {	
    	dartL.set(ControlMode.PercentOutput, 0);
    	dartR.set(ControlMode.PercentOutput, 0);
    }

    
    //Jason does this
    public double getPot()
    {
    	
    	return pot.get();
    }
}

