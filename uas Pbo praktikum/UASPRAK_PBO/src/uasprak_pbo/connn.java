
package uasprak_pbo;

import java.sql.*;
 import java.util.Scanner;

public class connn {

    private static String url = "jdbc:mysql://localhost/uaspboprak"; // Ganti nama_database dengan nama database Anda
    private static String username = "root"; // Ganti dengan username database Anda
    private static String password = ""; // Ganti dengan password database Anda

    public static void main(String[] args) {

        UASPRAK_PBO connection = new UASPRAK_PBO(url, username, password);

        // Menampilkan data dari tabel
      

        // Mengambil input pilihan
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Toko sevis hp:");
            System.out.println("1. Tampilkan Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Data:");
                    connection.displaydata();
                    break;
                case 2:
                    // Mengambil input data baru
                    System.out.print("Masukkan ID                    : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Membuang newline character setelah membaca integer
                    System.out.print("Masukkan aktivitas             : ");
                    String  todo = scanner.nextLine();
                    System.out.print("Masukkan kategori kerusakan    : ");
                    String kategori = scanner.nextLine();
                    System.out.print("Masukkan tanggal-selesai       : ");
                    String tanggal = scanner.nextLine();
                    System.out.print("Masukkan Status                : ");
                    String status = scanner.nextLine();

                    // Menambahkan data baru
                    
                    connection.createData(id, todo, kategori, tanggal, status);
                    System.out.println("Data berhasil ditambahkan.");
                    break;
                case 3:
                    // Mengambil input data yang akan diupdate
                    System.out.print("Masukkan ID yang ingin diupdate: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Membuang newline character setelah membaca integer
                    System.out.print("Masukkan aktivitas baru         : ");
                    String newtodo = scanner.nextLine();
                    System.out.print("Masukkan kategori baru          : ");
                    String newkategori = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Masukkan tanggal baru           : ");
                    String newtanggal = scanner.nextLine();
                    System.out.print("Masukkan status baru            :    ");
                    String newstatus = scanner.nextLine();

                    // Mengupdate data
                    
                    connection.updateData(idToUpdate, newtodo, newkategori, newtanggal,newstatus);
                    System.out.println("Data berhasil diupdate.");
                    break;
                case 4:
                    // Mengambil input data yang akan dihapus
                    System.out.print("Masukkan ID yang ingin dihapus: ");
                    int idToDelete = scanner.nextInt();

                    // Menghapus data
        
                    connection.deleteData(idToDelete);
                    System.out.println("Data berhasil dihapus.");
                    break;
                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu (1-5).");
                    break;
            }

            System.out.println();
            System.out.println();
        }
 
         
        scanner.close(); 
    }
}
    



