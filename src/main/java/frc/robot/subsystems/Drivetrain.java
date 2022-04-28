// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;

public class Drivetrain extends SubsystemBase {
  // Only one instance of the drivetrain is needed
  private static final Drivetrain instance = new Drivetrain();

  // Method to obtain drivetrain instance
  public static Drivetrain getInstance() {
    return instance;
  }

  private CANSparkMax leftMotorA, leftMotorB, leftMotorC;
  private CANSparkMax rightMotorA, rightMotorB, rightMotorC;

  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;

  private DifferentialDrive drive;

  // Private constructor to prevent multiple instances
  private Drivetrain() {
    this.leftMotorA = new CANSparkMax(Ports.SparkMax.kLeftDriveA, CANSparkMax.MotorType.kBrushless);
    this.leftMotorB = new CANSparkMax(Ports.SparkMax.kLeftDriveB, CANSparkMax.MotorType.kBrushless);
    this.leftMotorC = new CANSparkMax(Ports.SparkMax.kLeftDriveC, CANSparkMax.MotorType.kBrushless);

    this.rightMotorA = new CANSparkMax(Ports.SparkMax.kRightDriveA, CANSparkMax.MotorType.kBrushless);
    this.rightMotorB = new CANSparkMax(Ports.SparkMax.kRightDriveB, CANSparkMax.MotorType.kBrushless);
    this.rightMotorC = new CANSparkMax(Ports.SparkMax.kRightDriveC, CANSparkMax.MotorType.kBrushless);

    this.leftMotors = new MotorControllerGroup(this.leftMotorA, this.leftMotorB, this.leftMotorC);
    this.rightMotors = new MotorControllerGroup(this.rightMotorA, this.rightMotorB, this.rightMotorC);

    this.drive = new DifferentialDrive(this.leftMotors, this.rightMotors);
  }

  public void setSpeeds(double leftSpeed, double rightSpeed) {
    this.leftMotors.set(leftSpeed);
    this.rightMotors.set(rightSpeed);
  }

  public void arcadeDrive(double speed, double rotation) {
    this.drive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    this.drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
