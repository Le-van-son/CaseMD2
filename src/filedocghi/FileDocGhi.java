package filedocghi;

import mode.SinhVien;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileDocGhi{
    public static void WriteToFile(List<SinhVien> sinhViens) throws IOException {
        File file1 = new File("E:\\HocCodegym\\CaseModlue2\\Ghifile.csv");
        FileWriter pw = new FileWriter(file1);
        BufferedWriter bw = new BufferedWriter(pw);
        String str = "";
        for (SinhVien i: sinhViens) {
            str +=  i.getMaSinhVien() +","+i.getHoTen()+"," +i.getNamSinh()+","+ i.getDiemTrungBinh() +"\n";
        }
        bw.write(str);
        bw.flush();
        bw.close();
    }
    public static List<SinhVien> ReadFromFile(List<SinhVien> sinhVienList) throws FileNotFoundException {
        File file2 = new File("E:\\HocCodegym\\CaseModlue2\\Ghifile.csv");
        Scanner sc = new Scanner(file2);
        String line = null;
        while (sc.hasNext()){
            line = sc.nextLine();
            String[] arr = line.split(",");
            sinhVienList.add(new SinhVien(arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3])));
//            System.out.println(line);
        }
        sc.close();
        return sinhVienList;
    }
}
