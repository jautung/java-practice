import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime now = LocalDateTime.now();
        return appointmentDate.isBefore(now);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalDateTime noon = appointmentDate.withHour(12).withMinute(0).withSecond(0);
        LocalDateTime sixPm = appointmentDate.withHour(18).withMinute(0).withSecond(0);
        return (appointmentDate.isAfter(noon) || appointmentDate.isEqual(noon)) && appointmentDate.isBefore(sixPm);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter datePrinter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        DateTimeFormatter timePrinter = DateTimeFormatter.ofPattern("h:mm a");
        return "You have an appointment on %s, at %s.".formatted(datePrinter.format(appointmentDate), timePrinter.format(appointmentDate));
    }

    public LocalDate getAnniversaryDate() {
        LocalDateTime now = LocalDateTime.now();
        return LocalDate.of(now.getYear(), 9, 15);
    }
}
