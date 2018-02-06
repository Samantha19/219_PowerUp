/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team219.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
//dart talon 4 - current stuff negate to go up
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static int driveFrontRightPort= 0;
	public static int driveBackRightPort= 0;
	public static int driveFrontLeftPort= 0;
	public static int driveBackLeftPort= 0;
	
	public static int shooterFrontLeft= 4;
	public static int shooterFrontRight= 5;
	public static int shooterBackRight= 6;
	public static int shooterBackLeft= 2;
	public static int shooterMidRight= 3;
	public static int shooterMidLeft= 1;
	
	public static int dartLeft=0;
	public static int dartRight=0;
}
