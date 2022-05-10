package mode;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void menu() {
        System.out.println(ANSI_BLUE+"--------------------Menu-------------------------");
        System.out.println("1.Thêm Sinh Viên");
        System.out.println("2.Kiểm Tra Rỗng");
        System.out.println("3.Lấy Số Lượng Sinh Viên");
        System.out.println("4.Hiển thị các loại danh sách sinh viên");
        System.out.println("5.Làm Rỗng Danh Sách");
        System.out.println("6.Kiểm Tra Sinh Viên Có Tồn Tại:");
        System.out.println("7.Xóa sinh viên:");
        System.out.println("8.Tìm sinh viên theo mã sv:");
        System.out.println("9.Đọc File:");
        System.out.println("10.Sửa :");
        System.out.println("11.Sắp xếp sinh viên theo điểm:");
        System.out.println("Mời nhập lựa chọn:"+ANSI_RESET);
    }
}
