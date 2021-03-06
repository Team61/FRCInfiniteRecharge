package frc.robot.commands.Shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.PhysicConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

import java.util.function.DoubleSupplier;

public class AutoShoot extends CommandBase {
    private ShooterSubsystem m_shooterSubsystem;

    private DoubleSupplier m_distance;

    public AutoShoot(ShooterSubsystem shooterSubsystem, DoubleSupplier distance) {
        m_shooterSubsystem = shooterSubsystem;
        m_distance = distance;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {

        double voltage = m_distance.getAsDouble() * ShooterConstants.kVoltagePerDistance;
        m_shooterSubsystem.setVoltage(voltage);

    }

    @Override
    public void end(boolean interrupted) {
        m_shooterSubsystem.stop();
    }
}
