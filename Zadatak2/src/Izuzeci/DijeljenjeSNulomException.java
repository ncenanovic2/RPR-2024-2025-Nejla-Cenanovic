package Izuzeci;

public class DijeljenjeSNulomException extends RuntimeException {
    public DijeljenjeSNulomException(String message) {
        super(message);
    }

    public static class PremladStudentException extends RuntimeException {
        public PremladStudentException(String message) {
            super(message);
        }
    }
}
