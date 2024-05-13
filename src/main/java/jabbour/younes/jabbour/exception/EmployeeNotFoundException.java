package jabbour.younes.jabbour.exception;


public class EmployeeNotFoundException extends NotFoundException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
    public EmployeeNotFoundException() {
        super("Employee not found.");
    }
}
