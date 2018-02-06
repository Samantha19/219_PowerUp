package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ThoseFunkyWheels extends Subsystem implements PIDSource {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX shootFR,shootFL;
	public TalonSRX shootBR;
	TalonSRX shootBL;
	TalonSRX shootML;
	public TalonSRX shootMR;
	private PIDSourceType pidSourceType = PIDSourceType.kRate;
	

	public ThoseFunkyWheels()
	{
		shootFR=new TalonSRX(RobotMap.shooterFrontRight);
		shootFL=new TalonSRX(RobotMap.shooterFrontLeft);
		shootBR=new TalonSRX(RobotMap.shooterBackRight);
		shootBL=new TalonSRX(RobotMap.shooterBackLeft);
		shootML=new TalonSRX(RobotMap.shooterMidLeft);
		shootMR=new TalonSRX(RobotMap.shooterMidRight);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		pidSourceType = pidSource;
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return pidSourceType;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getVelocity() //TODO: unknown units atm
	{
		return (shootFR.getSensorCollection().getQuadraturePosition()/4096.0);
	}
	public void resetEncoders()
	{
		//getSensorCollection().setQuadraturePosition(0, 10);
	}
	public void stopMoving()
	{
		shootFR.set(ControlMode.PercentOutput, 0);
		shootBR.set(ControlMode.PercentOutput, 0);
		shootFL.set(ControlMode.PercentOutput, 0);
		shootBL.set(ControlMode.PercentOutput, 0);
		shootML.set(ControlMode.PercentOutput, 0);
		shootMR.set(ControlMode.PercentOutput, 0);
	}
	public void harvestPerp()
	{
		shootFR.set(ControlMode.PercentOutput, .5);
		shootMR.set(ControlMode.PercentOutput, .5);
		shootFL.set(ControlMode.PercentOutput, .5);
		shootML.set(ControlMode.PercentOutput, .5);
	}
	
	public void harvestR()
	{
		shootBR.set(ControlMode.PercentOutput, .5);
		shootMR.set(ControlMode.PercentOutput, .5);
		shootBL.set(ControlMode.PercentOutput, .5);
		shootML.set(ControlMode.PercentOutput, .5);
	}
	
	
	public void FrontOnes()
	{
		shootFR.set(ControlMode.PercentOutput, 1);
		shootMR.set(ControlMode.PercentOutput, 1);
		shootFL.set(ControlMode.PercentOutput, 1);
		shootML.set(ControlMode.PercentOutput, -1);
	}
	
	public void Dealyed()
	{
		shootBL.set(ControlMode.PercentOutput, 1);
		shootBR.set(ControlMode.PercentOutput, 1);
	}
	
	
	public void shootTest()
	{
		double FL= SmartDashboard.getNumber("FL", 0);
		double FR = SmartDashboard.getNumber("FR", 0);
		double ML= SmartDashboard.getNumber("ML", 0);
		double MR = SmartDashboard.getNumber("MR", 0);
		double BR = SmartDashboard.getNumber("BR", 0);
		double BL = SmartDashboard.getNumber("BL", 0);
		shootFL.set(ControlMode.PercentOutput, -FL);//.2
		shootFR.set(ControlMode.PercentOutput, -FR);//.8
		shootML.set(ControlMode.PercentOutput,  ML);
		shootMR.set(ControlMode.PercentOutput, -MR);
		shootBR.set(ControlMode.PercentOutput, -BR);
		shootBL.set(ControlMode.PercentOutput, -BL);//didn't really matter
		
	}
	//7 7 4 4 4 4
	
	
}

