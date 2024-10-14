package rental;

public final class Motor extends Kendaraan {
    private int kapasitasMesin;
    
    public Motor(String nomorPlat, String merk, String jenis, int kapasitasMesin) {
        super(nomorPlat, merk, jenis);
        this.kapasitasMesin = kapasitasMesin;
    }
    
    public int getKapasitasMesin() {
        return kapasitasMesin;
    }
    
    public void setKapasitasMesin(int kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }
    
    @Override
    public void tampilkanDetail() {
        System.out.println("Nomor Plat: " + getNomorPlat());
        System.out.println("Merk: " + getMerk());
        System.out.println("Jenis: " + getJenis());
        System.out.println("Kapasitas Mesin: " + kapasitasMesin + " cc");
    }
}
