package rental;

public class Kendaraan {
    private final String nomorPlat;
    private String merk;
    private String jenis;
      
    public static int jumlahKendaraan = 0;
    
    public Kendaraan(String nomorPlat, String merk, String jenis) {
        this.nomorPlat = nomorPlat;
        this.merk = merk;
        this.jenis = jenis;
        jumlahKendaraan++;
    }
     
    public String getNomorPlat() {
        return nomorPlat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public void tampilkanDetail() {
        System.out.println("Nomor Plat: " + nomorPlat);
        System.out.println("Merk: " + merk);
        System.out.println("Jenis: " + jenis);
    }
}
