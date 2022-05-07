package quanlisinhvien;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileDocGhi{
    public static void WriteToFile(List<SinhVien> sinhViens) throws IOException {
        File file1 = new File("E:\\HocCodegym\\CaseModlue2\\Ghifile.csv");
        if (file1.exists()){
            System.out.println("ok");
        }else {
            file1.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file1);
        String str = "";
        for (SinhVien i: sinhViens) {
            str += i.getHoTen() +","+i.getMaSinhVien()+"," + i.getDiemTrungBinh()+"," +"\n";
        }
        pw.println(str);
        pw.flush();
        pw.close();
    }
    public static void ReadFromFile(List<SinhVien> sinhVienList) throws FileNotFoundException {
        File file2 = new File("E:\\HocCodegym\\CaseModlue2\\Ghifile.csv");
        Scanner sc = new Scanner(file2);
        String line = null;
        while (sc.hasNext()){
            line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();
    }
}
