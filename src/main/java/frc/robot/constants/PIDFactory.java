package frc.robot.constants;

public class PIDFactory {
    public interface PID {
        public static final double kP = 1.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final int kTolerence = 0;
    }

    public final class LeftDrive implements PID {
        public static final double kP = 1;
    }

}
