package rentalManagement;

import rental.*;
import java.util.ArrayList;
import java.util.Scanner;

public final class ManajemenRental implements KendaraanInterface {
    private final ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public ManajemenRental() {
        inisialisasiKendaraan();
    }

    private void inisialisasiKendaraan() {
        daftarKendaraan.add(new Mobil("B 1234 CD", "Toyota", "SUV", 5));
        daftarKendaraan.add(new Mobil("D 5678 EF", "Honda", "Sedan", 4));
        daftarKendaraan.add(new Motor("E 9101 GH", "Suzuki", "Sport", 250));
        daftarKendaraan.add(new Motor("F 2345 IJ", "Yamaha", "Matic", 125));
    }

    @Override
    public void tambahKendaraan() {
        System.out.print("Masukkan Jenis (Mobil/Motor): ");
        String jenisKendaraan = scanner.nextLine();
        System.out.print("Masukkan Nomor Plat: ");
        String nomorPlat = scanner.nextLine();
        System.out.print("Masukkan Merk Kendaraan: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Jenis Kendaraan: ");
        String jenis = scanner.nextLine();
        
        if (jenisKendaraan.equalsIgnoreCase("Mobil")) {
            System.out.print("Masukkan Jumlah Pintu: ");
            int jumlahPintu = scanner.nextInt();
            daftarKendaraan.add(new Mobil(nomorPlat, merk, jenis, jumlahPintu));
        } else if (jenisKendaraan.equalsIgnoreCase("Motor")) {
            System.out.print("Masukkan Kapasitas Mesin (cc): ");
            int kapasitasMesin = scanner.nextInt();
            daftarKendaraan.add(new Motor(nomorPlat, merk, jenis, kapasitasMesin));
        } else {
            System.out.println("Jenis kendaraan tidak valid.");
            return;
        }
        System.out.println("Kendaraan berhasil ditambahkan!");
    }

    @Override
    public void editKendaraan() {
        System.out.print("Masukkan Nomor Plat kendaraan yang ingin diedit: ");
        String nomorPlat = scanner.nextLine();
        
        for (Kendaraan k : daftarKendaraan) {
            if (k.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                System.out.print("Masukkan Merk Baru: ");
                String merkBaru = scanner.nextLine();
                System.out.print("Masukkan Jenis Baru: ");
                String jenisBaru = scanner.nextLine();

                k.setMerk(merkBaru);
                k.setJenis(jenisBaru);

                if (k instanceof Mobil) {
                    System.out.print("Masukkan Jumlah Pintu Baru: ");
                    int jumlahPintuBaru = scanner.nextInt();
                    ((Mobil) k).setJumlahPintu(jumlahPintuBaru);
                } else if (k instanceof Motor) {
                    System.out.print("Masukkan Kapasitas Mesin Baru (cc): ");
                    int kapasitasMesinBaru = scanner.nextInt();
                    ((Motor) k).setKapasitasMesin(kapasitasMesinBaru);
                }

                System.out.println("Kendaraan berhasil diedit!");
                return;
            }
        }
        System.out.println("Kendaraan dengan nomor plat tersebut tidak ditemukan.");
    }

    @Override
    public void hapusKendaraan() {
        System.out.print("Masukkan Nomor Plat kendaraan yang ingin dihapus: ");
        String nomorPlat = scanner.nextLine();

        for (Kendaraan k : daftarKendaraan) {
            if (k.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                daftarKendaraan.remove(k);
                System.out.println("Kendaraan berhasil dihapus!");
                Kendaraan.jumlahKendaraan--;
                return;
            }
        }
        System.out.println("Kendaraan dengan nomor plat tersebut tidak ditemukan.");
    }

    @Override
    public void tampilkanSemuaKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang terdaftar.");
        } else {
            for (Kendaraan k : daftarKendaraan) {
                k.tampilkanDetail();
                System.out.println("-------------------------");
            }
        }
    }

    public void tampilkanMenu() {
        while (true) {
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Edit Kendaraan");
            System.out.println("3. Hapus Kendaraan");
            System.out.println("4. Tampilkan Semua Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1 -> tambahKendaraan();
                case 2 -> editKendaraan();
                case 3 -> hapusKendaraan();
                case 4 -> tampilkanSemuaKendaraan();
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}