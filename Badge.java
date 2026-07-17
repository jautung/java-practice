class Badge {
    public String print(Integer id, String name, String department) {
        String displayedDepartment = department != null ? department.toUpperCase() : "OWNER";
        if (id != null) {
            return "[%d] - %s - %s".formatted(id, name, displayedDepartment);
        } else {
            return "%s - %s".formatted(name, displayedDepartment);
        }
    }
}
