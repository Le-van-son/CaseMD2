package filedocghi;

import mode.DangNhap;
import mode.SinhVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class FileDocGhiDangNhap{
        public static void WriteToFileDangNhap(List<DangNhap> dangNhapList) throws FileNotFoundException {
            File file3 = new File("E:\\HocCodegym\\CaseModlue2\\Ghifiledangnhap.csv");
            PrintWriter printWriter = new PrintWriter(file3);
            printWriter.print("name,pass\n");
            for ( int i=0; i< dangNhapList.size(); i++) {
                printWriter.print(dangNhapList.get(i));
            }
            printWriter.close();
        }

        public static List<DangNhap> readFromFileDangNhap(List<DangNhap> dangNhapList) throws FileNotFoundException {
            File file4 = new File("E:\\HocCodegym\\CaseModlue2\\Ghifiledangnhap.csv");
            Scanner scanner = new Scanner(file4);
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                    break;
                } else {
                    String arr[] = line.split(",");
                    DangNhap user = new DangNhap(arr[0], arr[1]);
                    dangNhapList.add(user);
                }
            }
            return dangNhapList;
        }
    }


