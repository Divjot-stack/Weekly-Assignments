class AttendanceSheet {
private final String[] students;
private int count;

public AttendanceSheet(int capacity) {
    students = new String[capacity];
    count = 0;
}

public void markPresent(String name) {
    if (isPresent(name)) {
        return;
    }

    if (count < students.length) {
        students[count] = name;
        count++;
    }
}

public int getPresentCount() {
    return count;
}

public boolean isPresent(String name) {
    for (int i = 0; i < count; i++) {
        if (students[i].equals(name)) {
            return true;
        }
    }
    return false;
}

}

public class AttendanceSheetMain {
public static void main(String[] args) {
AttendanceSheet sheet = new AttendanceSheet(30);

    sheet.markPresent("Ana");
    sheet.markPresent("Ben");
    sheet.markPresent("Ana");

    System.out.println("Present Count: " + sheet.getPresentCount());
    System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
    System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
}

}
