package rental;

public final class Mobil extends Kendaraan {
    private int jumlahPintu;
    
    public Mobil(String nomorPlat, String merk, String jenis, int jumlahPintu) {
        super(nomorPlat, merk, jenis);
        this.jumlahPintu = jumlahPintu;
    }
    
    public int getJumlahPintu() {
        return jumlahPintu;
    }
    
    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }
    
    @Override
    public void tampilkanDetail() {
        System.out.println("Nomor Plat: " + getNomorPlat());
        System.out.println("Merk: " + getMerk());
        System.out.println("Jenis: " + getJenis());
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}

